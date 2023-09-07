package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public DataNotFoundException(String message) {
		super(message);
	}

}
/*
 * RuntimeException을 상속하여 DataNotFoundException을 만들었다.
 * HttpStatus NOT_FOUND는 404와 같은 의미로 이 익셉션이 발생할 경우 404에러와 함께 매개변수로 받은 message가 화면에 출력된다
 */
