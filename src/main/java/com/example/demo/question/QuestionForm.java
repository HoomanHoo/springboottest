package com.example.demo.question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
	@NotEmpty(message="제목은 필수 항목 입니다")
	@Size(max=200)
	private String subject;
	
	@NotEmpty(message="내용은 필수 항목 입니다")
	private String content;

}
/*
 *  폼 클래스는 입력 값에 대한 검증도 실시하지만, 클라이언트가 전달한 입력 값을 바인딩 할 때도 사용한다.
 *  NotEmpty 어노테이션은 Null, 빈 문자열("")을 허용하지 않음을 의미한다. message 요소는 검증이 실패했을 때(조건에 맞지 않을 때) 화면에 표시되는 메세지이다
 *  Size 어노테이션은 입력값의 최대 길이를 정의하며, 단위는 byte이다
 */
