package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration	//스프링 환경설정 파일임을 의미하는 어노테이션이다
@EnableWebSecurity	//모든 요청 url이 스프링 시큐리티의 제어를 받도록 만드는 어노테이션이다
public class SecureConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{	//SecururityFilterChain Bean을 생성하여 세부 설정을 할 수 있다.
		http.authorizeHttpRequests((authorizeHttpRequests) -> 
			authorizeHttpRequests.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		.csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))	// /h2-console/ 이 포함된 url은 CSRF의 예외로 지정하였다
		.headers((headers) -> headers.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
		.formLogin((formLogin) -> formLogin.loginPage("/user/login").defaultSuccessUrl("/"));	
		return http.build(); //람다식 사용함 람다식에 대해서는 더 공부할 것
	}
	
	@Bean
	PasswordEncoder passwdEncoder() {
		return new BCryptPasswordEncoder();
	}

}
/*
 *  스프링 시큐리티를 사용하면 CSRF 기능이 활성화 된다 - CSRF 토큰 자동 생성됨 - 
 *  H2 콘솔은 스프링과 상관 없는 일반 어플리케이션이기 때문에 CSRF 토큰이 자동으로 생성되지 않는다 때문에 CSRF에 대한 예외로 정의해주어야한다
 *  
 *  HTTP Request의 X-Frame-Option을 sameorigin으로 설정하여 <frame>, <iframe>, <object> 태그를 사용할 수 있도록 한다
 */
