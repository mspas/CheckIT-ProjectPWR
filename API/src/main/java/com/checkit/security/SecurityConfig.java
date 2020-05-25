package com.checkit.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/").permitAll();
	}

//	@Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//    }

//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception
//	{
//	     http
//	    .csrf().disable()
//	    .authorizeRequests()
//	      .antMatchers(HttpMethod.OPTIONS,"/path/to/allow").permitAll()//allow CORS option calls
//	      .antMatchers("/resources/**").permitAll()
//	      .anyRequest().authenticated()
//	    .and()
//	    .formLogin()
//	    .and()
//	    .httpBasic();
//	}

}
