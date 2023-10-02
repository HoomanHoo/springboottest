package com.example.demo.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	
	@Size(min = 3, max = 25)
	@NotEmpty(message = "사용자 ID는 필수 항목입니다.")
	private String userName;
	
	@NotEmpty(message = "비밀번호는 필수 항목입니다.")
	private String passwd;
	
	@NotEmpty(message = "비밀번호 체크는 필수 항목입니다.")
	private String passwd2;
	
	@NotEmpty(message = "이메일은 필수 항목입니다.")
	@Email
	private String email;

}
