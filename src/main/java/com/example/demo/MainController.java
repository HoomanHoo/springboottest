package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/spring")
	public String spring() {
		return "index";
	}
	
	@GetMapping("/")
	public String index() {
		System.out.println("index");
		return "redirect:/question/list";
		/*
		 * redirect:url - url로 리다이렉트(Get 요청이 진행된다)
		 * forward:url - url로 포워드(url이 전환되지 않는다)
		 */
	}

}
