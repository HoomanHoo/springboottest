package com.example.demo.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service	//스프링부트에서 서비스로 인식시키기 위함
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		}
		else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	
	public Page<Question> getList(int page){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.questionRepository.findAll(pageable);
	}
}
/*
 * 서비스를 사용하는 이유
 * 1. DB에 액세스 하는 메서드들을 모듈화 하기 위해서
 * 2. 레포지터리를 서비스를 거쳐서 접근해야하기 때문에 제 3자가 컨트롤러의 제어권을 얻더라도 레포지터리에 직접 접근할 수 없게 하기 위해서
 * 
 * Entity 클래스는 DB에 매핑되어있는 클래스들이기 때문에 비즈니스 로직에서 직접 사용하는 경우 속성이 변경되어 DB에까지 영향을 주기 때문에 비즈니스 로직이 있는 컨트롤러 클래스에서 사용할 수 없도록 해야한다
 * Entity 클래스를 컨트롤러에서 사용하지 못하도록 하는 대신 DTO 클래스를 만들어줘야한다. 그리고 Entity 객체를 DTO 객체로 변환해주는 작업도 필요하다
 * 이 때 Entity 객체를 DTO 클래스로 바꿔주는 곳이 Service 클래스이다. 컨트롤러와 레포지터리의 중간 지점에서 엔티티 객체와 DTO 객체를 서로 변환하여 전달해주는 역할을 한다.
 */
