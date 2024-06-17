package com.multi.adoptMeow.config;


import com.multi.adoptMeow.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
	
	private final AuthenticationService authenticationService;
	
	@Autowired
	public SpringSecurityConfiguration(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	WebSecurityCustomizer configure() {
		
		return (web) -> web
				.ignoring()
				.requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		Map<String, List<String>> permitUrlListMap = authenticationService.getPermitUrlListMap();
		
		List<String> adminPermitUrlList = permitUrlListMap.get("adminPermitUrlList");
		List<String> usersPermitUrlList = permitUrlListMap.get("usersPermitUrlList");
		
		adminPermitUrlList.forEach(url -> System.out.println("admin permint list : " + url));
		usersPermitUrlList.forEach(url -> System.out.println("general users permint list : " + url));
		
		
		httpSecurity.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
						.requestMatchers(usersPermitUrlList.toArray(new String[usersPermitUrlList.size()])).hasAnyRole("USERS", "ADMIN")
						.requestMatchers(adminPermitUrlList.toArray(new String[adminPermitUrlList.size()])).hasRole("ADMIN")
						.anyRequest().permitAll()
				
				)
				.formLogin(form -> form
						.loginPage("/users/login").usernameParameter("username").passwordParameter("password")
						.defaultSuccessUrl("/", true)
						.failureForwardUrl("/common/loginError")
				)
				.logout(logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
						.logoutSuccessUrl("/"))
				
				.exceptionHandling((exception) -> exception.accessDeniedPage("/common/accessDenied"));
		
		
		return httpSecurity.build();
		
		
	}
	
}
