package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	@Autowired
	JWTRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(auth);
		auth.userDetailsService(userDetailsService);
		}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/pharmacy/**").hasRole("PHARMACY")
			.antMatchers("/mobile/**").hasRole("PATIENT")
			.antMatchers("/").permitAll()
			.antMatchers("/covid19/**").permitAll()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
	    DefaultHttpFirewall firewall = new DefaultHttpFirewall();
	    firewall.setAllowUrlEncodedSlash(true);
	    return firewall;
	}
	
	@Override
	public void configure(WebSecurity web) {
	  super.configure(web);
	  // @formatter:off
	  web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	}

}
