package com.example.demo.answer;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.question.Question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	@ManyToOne	//Question과의 N:1 관계임을 나타내기 위해 ManyToOne어노테이션을 사용한다 - 실제로 DB에서는 Question의 id 컬럼을 primary key, Answer의 question 컬럼을 Foreign key 로 하는 관계가 생성된다
	private Question question;

}
