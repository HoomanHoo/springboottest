package com.example.demo.user;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signup")
	public String singup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "signup_form";
		}
		
		if(!userCreateForm.getPasswd().equals(userCreateForm.getPasswd2())) {
			bindingResult.rejectValue("passwd2", "passwordIncorrect", "2개의 패스워드가 일치하지 않습니다.");
			return "signup_form";
		}
		try {
			userService.create(userCreateForm.getUserName(),
					userCreateForm.getEmail(), userCreateForm.getPasswd());
		}
		catch(DataIntegrityViolationException e) {	//DataIntegrityViolationException는 동일한 데이터가 존재할 경우 발생하는 Exception이다
			e.printStackTrace();
			bindingResult.reject("signupFaild", "이미 등록된 사용자 입니다");	//bindingResult.reject(오류코드, 오류 메세지)는 일반적인 에러를 등록할 때 사용한다
			return "signup_form";
		}
		catch(Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFaild", e.getMessage());
			return "signup_form";
		}

		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login_form";	//@PostMapping의 경우 Spring Security에서 처리하기 때문에 구현할 필요가 없다(어떻게?)
	}

}
