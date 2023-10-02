/*package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.answer.Answer;
import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class TestApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Transactional
	@Test
	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("springboot가 뭐나요");
//		q1.setContent("springboot에 대해서 배우고 싶어요");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);	// 객체에 저장된 데이터를 매핑된 DB에 저장한다
//		
//		Question q2 = new Question();
//		q2.setSubject("spring boooot?");
//		q2.setContent("What is spring boot? It is still Winter!");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
		
//		List<Question> all = this.questionRepository.findAll(); //Question에 저장된 모든 데이터를 불러온다
//		assertEquals(2, all.size());	//assertEquals(기대하는 값, 비교하고자 하는 값)
//		
//		Question q = all.get(0);
//		assertEquals("springboot가 뭐나요", q.getSubject());
		
//		Optional<Question> optionalQuestion = this.questionRepository.findById(1);	// id값으로 데이터를 조회하기 위해서는 findById 메서드를 사용한다
//		if(optionalQuestion.isPresent()) {	//findById의 리턴 타입은 Optional로, null 처리를 원활히 하고자 사용한다
//			Question q = optionalQuestion.get();	//isPresent로 null인지 아닍를 확인한 후 get()을 통해 실제 Question 객체 데이터 값을 얻어야 한다
//			assertEquals("springboot가 뭐나요", q.getSubject());	// Optional은 NullPointException 예외를 회피할 수 있다 isPresent 메서드가 Optional 객체가 값을 가지고 있을 경우 true를, 값을 가지고 있지 않을 때 - null일 때 false를 리턴하기 때문이다.
//		}
//		Question q = this.questionRepository.findBySubject("springboot가 뭐나요");
//		assertEquals(1, q.getId());
//		Question q = this.questionRepository.findBySubjectAndContent("springboot가 뭐나요", "springboot에 대해서 배우고 싶어요");
//		assertEquals(1, q.getId());
		
//		List<Question> qList = this.questionRepository.findBySubjectLike("springboot%");	//문자열% - '문자열'로 시작하는 문자열
//		Question q = qList.get(0);															//%문자열 - '문자열'로 끝나는 문자열
//		assertEquals("springboot가 뭐나요", q.getSubject());									//%문자열% - '문자열'을 포함하는 문자열
		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());	//assertTrue는 값이 true인지를 테스트한다
//		Question q = oq.get();
//		q.setSubject("제목 수정");
//		this.questionRepository.save(q);	//Entity 객체를 얻어오고 setter로 데이터를 변경한 후 save 하면 데이터 수정을 할 수 있다.
		
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);	//delete 메서드는 데이터를 삭제할 때 사용한다
//		assertEquals(1, this.questionRepository.count());
		
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다");
//		a.setQuestion(q);	//답변이 달릴 글의 정보가 필요하기 때문에 위에서 Question 객체 하나를 구했다.
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
		
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());	//답변 id값이 1인 Answer를 조회하고, 그 Answer의 질문 id가 2인지 테스트한다
//		
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		List<Answer> answerList = q.getAnswerList();	//findById()에서 DB세션이 종료되기 때문에 @Transaction 어노테이션을 붙여서 두개의 ORM문을 하나의 트랜잭션으로 묶어줘야한다
	
		assertEquals(3, answerList.size());
		assertEquals("네 자동으로 생성됩니다", answerList.get(0).getContent());

		
	}

}
*/
