package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //@Controller 어노테이션은 해당 클래스가 컨트롤러 기능을 하는 클래스임을 알려주는 의미이다
public class HelloController {
	@GetMapping("/hello")	//도메인 or IP/hello 로 HTTP GET Request가 올 경우 hello() 메서드가 실행되도록 한다
	@ResponseBody	//Response가 문자열 자체임을 나타낸다
	public String hello() {
		return "Hello Spring Boot Test!";
	}
	

}
