package com.example.SpringBootApplication.SpringBootStudent.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.SpringBootApplication.SpringBootStudent.Service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	protected DaoAuthenticationProvider daoAuthenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(byBCryptPasswordEncoder());
		return authenticationProvider;
	}

	@Bean
	protected UserDetailsService userDetailsService() {

		return new UserServiceImpl();
	}

	@Bean
	protected BCryptPasswordEncoder byBCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/h2-console/**").permitAll().and().authorizeRequests()
				.antMatchers("/", "/Stduents/List/**", "/Stduents/save/**", "/Stduents/Studentform/**",
						"/Stduents/Error/**")
				.hasAnyRole("Employee", "Admin").antMatchers("/Stduents/Update/**", "/Stduents/Delete/**")
				.hasRole("Admin").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/Stduents/List").and().logout().logoutSuccessUrl("/login").permitAll().and()
				.exceptionHandling().accessDeniedPage("/Stduents/Error").and().cors().and().csrf().disable();

	}

}
