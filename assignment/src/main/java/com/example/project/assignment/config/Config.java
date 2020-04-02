package com.example.project.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.project.assignment.service.UserService;


@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	@Autowired
    private UserService userService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;
		
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        System.out.println("-----------------> In authenticationManager");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("------------------> In httpsecurity");
		http.authorizeRequests()
			.antMatchers("/home/profile").hasAnyRole("STUDENT","ADMIN")
			.antMatchers("/student/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/login/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.successHandler(customAuthenticationSuccessHandler)
				.permitAll()
			.and()
			.logout().logoutSuccessHandler(customLogoutSuccessHandler).permitAll()
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
		System.out.println("-------------> In dap authentication provider");
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}
}






