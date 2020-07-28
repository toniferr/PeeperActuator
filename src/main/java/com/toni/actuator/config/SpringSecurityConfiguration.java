package com.toni.actuator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{

	    @Autowired
	    PasswordEncoder passwordEncoder;
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	        .passwordEncoder(passwordEncoder)
	        .withUser("user").password(passwordEncoder.encode("user")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN");
	    }
	 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    	    

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().antMatchers("/", "/index", "/project/**", "/checkout", "/docheckout").permitAll()
	                .and().authorizeRequests().antMatchers("/login","logout").permitAll()
	                .and().authorizeRequests().antMatchers("/css/**","/js/**", "/images/**", "/favicon.ico").permitAll()
	                .and().authorizeRequests().antMatchers("/h2/**").permitAll()
	                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
	                .and().logout()
	                        .deleteCookies("remove")
	                        .invalidateHttpSession(true)
	                        .logoutUrl("/logout")
	                        .logoutSuccessUrl("/logout-success")
	                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	               ;
	        http.csrf().disable();
	        http.headers().frameOptions().disable();
	    }
	}