/**
 * 
 */
package pk.torcia.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author inayat
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("--------->>>>> config  ");	
		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
		.and().authorizeRequests().antMatchers( "/reDirectStudent**").access("hasRole('Information_Role')")
		.and().authorizeRequests().antMatchers("/studentHome/**","/deleteStudent","/sessionHome**","/reDirectShift**","/reDirectStudent**","/reDirectClass**","/reDirectAdmin**").hasRole("ADMIN")
		.and().authorizeRequests().antMatchers("/searchStudentDetail/**").access("hasRole('Deo')")
		.and().formLogin().loginPage("/login").successHandler(customSuccessHandler).loginProcessingUrl("/login").usernameParameter("ssoId")
		.passwordParameter("password").and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}
