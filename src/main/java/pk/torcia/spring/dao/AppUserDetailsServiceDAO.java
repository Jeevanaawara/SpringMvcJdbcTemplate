/**
 * 
 */
package pk.torcia.spring.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author inayat
 *
 */
public class AppUserDetailsServiceDAO  implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("  loadUserByUsername--------->>>>>  ");
		return null;
	}

}
