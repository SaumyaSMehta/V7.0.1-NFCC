//package com.codingfreaks.NiagaraFallsCurlingClub.Security;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//					.withUser("usertest")
//					.password("usertest")
//					.roles("USER")
//					.and()
//					.withUser("admintest")
//					.password("admintest")
//					.roles("ADMIN");
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/admin").hasRole("ADMIN")
//				.antMatchers("/user").hasRole("USER")
//				.antMatchers("/").permitAll()
//				.and().formLogin();
//	}
//	
//
//<dependency>
//			<groupId>org.springframework.boot</groupId>
//			<artifactId>spring-boot-starter-security</artifactId>
//		</dependency>
//	 
//}
