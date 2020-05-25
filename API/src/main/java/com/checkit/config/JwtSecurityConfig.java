package com.checkit.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.checkit.security.JwtAuthenticationEntryPoint;
import com.checkit.security.JwtAuthenticationProvider;
import com.checkit.security.JwtAuthenticationTokenFilter;
import com.checkit.security.JwtSuccessHandler;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration

public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationProvider authenticationProvider;
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	@Bean
	public AuthenticationManager authenticationManager() {

		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilter() {

		JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());

		return filter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "**").permitAll()
				.antMatchers("**/api/**").authenticated().and().exceptionHandling().authenticationEntryPoint(entryPoint)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

	}

}
