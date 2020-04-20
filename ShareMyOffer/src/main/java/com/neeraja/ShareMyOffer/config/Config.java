package com.neeraja.ShareMyOffer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.neeraja.ShareMyOffer.services.AuthService;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

private static Logger logger = LoggerFactory.getLogger(Config.class);
	
	// add a reference to our security data source
	@Autowired
    private AuthService authService;
		
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        logger.info("-----------------> In authenticationManager");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		logger.info("------------------> In httpsecurity");
		http.authorizeRequests()
			.antMatchers("/home").hasRole("USER")
			.antMatchers("/signup/showMySignUpPage").permitAll()
//			.anyRequest().fullyAuthenticated()
			.and()
			.formLogin()
				.loginPage("/login/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/login/access-denied");
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		logger.info("-------------> In dap authentication provider");
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(authService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}
	
}
