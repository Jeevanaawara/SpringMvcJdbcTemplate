package pk.torcia.spring.config;

import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pk.torcia.spring.dao.AdminDAO;
import pk.torcia.spring.dao.AdminDAOImpl;
import pk.torcia.spring.dao.BatchClassDAO;
import pk.torcia.spring.dao.BatchClassDAOImpl;
import pk.torcia.spring.dao.ClassCategoryDAO;
import pk.torcia.spring.dao.ContactDAO;
import pk.torcia.spring.dao.ContactDAOImpl;
import pk.torcia.spring.dao.FeesDAO;
import pk.torcia.spring.dao.FeesDaoImpl;
import pk.torcia.spring.dao.SessionDAO;
import pk.torcia.spring.dao.SessionDAOImpl;
import pk.torcia.spring.dao.ShiftDAO;
import pk.torcia.spring.dao.ShiftDAOImpl;
import pk.torcia.spring.dao.StudentDAO;
import pk.torcia.spring.dao.StudentDAOImpl;
import pk.torcia.spring.dao.StudentEduInfoDAO;
import pk.torcia.spring.dao.StudentEduInfoDAOImpl;
import pk.torcia.spring.dao.StudentOtherInfoDAO;
import pk.torcia.spring.dao.StudentOtherInfoDAOImpl;
import pk.torcia.spring.dao.StudentProgressDAO;
import pk.torcia.spring.dao.StudentProgressDAOImpl;
import pk.torcia.spring.dao.UserRoleDAO;
import pk.torcia.spring.dao.UserRoleDAOImpl;
import pk.torcia.spring.dao.classCategoryDAOImpl;

@Configuration
@ComponentScan(basePackages = "pk.torcia.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	static Logger log = Logger.getLogger(MvcConfiguration.class.getName());

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		// http
		@SuppressWarnings("rawtypes")
		HttpMessageConverter converter = new StringHttpMessageConverter();
		converters.add(converter);
		log.info("HttpMessageConverter added");

		// string
		converter = new FormHttpMessageConverter();
		converters.add(converter);
		log.info("FormHttpMessageConverter added");

		// json
		converter = new MappingJackson2HttpMessageConverter();
		converters.add(converter);
		log.info("MappingJackson2HttpMessageConverter added");

	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;
	}

	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}

	@Bean
	public SessionDAO getSectionDAO() {
		return new SessionDAOImpl(getDataSource());
	}

	@Bean
	public AdminDAO getAdminDAO() {
		return new AdminDAOImpl(getDataSource());
	}

	@Bean
	public ShiftDAO getShiftDAO() {
		return new ShiftDAOImpl(getDataSource());
	}

	@Bean
	public BatchClassDAO getBatchClassDAO() {
		return new BatchClassDAOImpl(getDataSource());
	}

	@Bean
	public StudentDAO getStudentDAO() {
		return new StudentDAOImpl(getDataSource());
	}

	@Bean
	public FeesDAO getFeeDAO() {
		return new FeesDaoImpl(getDataSource());
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}

	@Bean
	public StudentEduInfoDAO getStudentEduInfoDAO() {
		return new StudentEduInfoDAOImpl(getDataSource());
	}

	@Bean
	public StudentOtherInfoDAO getStudentOtherInfoDAO() {
		return new StudentOtherInfoDAOImpl(getDataSource());
	}

	@Bean
	public UserRoleDAO getUserRoleDAO() {
		return new UserRoleDAOImpl(getDataSource());
	}

	@Bean
	public ClassCategoryDAO getClassCategoryDAO() {
		return new classCategoryDAOImpl(getDataSource());
	}

	@Bean
	public StudentProgressDAO getStudentProgressDAO() {
		return new StudentProgressDAOImpl(getDataSource());
	}
}
