package com.example.demo.question;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.answer.Answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity	//Entity 어노테이션을 적용해야 JPA가 엔티티로 인식한다
public class Question {
	@Id	//pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//해당 컬럼에 대한 시퀸스를 설정하여 번호를 증가시킨다
	private Integer id;
	
	@Column(length=200)	//테이블의 컬럼에 대응한다 length는 컬럼의 데이터가 가질 수 있는 최대 길이를 지정한다
	private String subject;
	
	@Column(columnDefinition = "TEXT") //columnDefinition은 컬럼의 속성을 정의하며 TEXT는 클자 수를 제한할 수 없는 경우에 사용한다
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade= CascadeType.REMOVE) // 1:N 관계를 표현하기 위해 OneToMany 어노테이션을 사용한다 - mappedBy에 참조하는 엔티티를 기술해야한다
	private List<Answer> answerList;
	

}
