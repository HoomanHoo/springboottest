package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //생성자를 자동으로 만들어주는 어노테이션이다. 초기화 되지 않은 final 필드, @NonNull이 붙은 필드에 대해 생성자를 생성해준다.
@Getter
//@Setter	//@Getter, Setter 어노테이션은 getter, setter 메서드를 자동으로 만들어주는 어노테이션이다.
public class HelloLombok {
	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("할루", 5);
//		helloLombok.setHello("할루");
//		helloLombok.setLombok(5);
//		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}

}
