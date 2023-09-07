package com.example.demo.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	// JpaRepository를 상속받을 때 제네릭 타입으로 대상이 되는 엔티티의 타입과 해당 엔티티의 primary key 타입을 지정해야한다
	Question findBySubject(String subject);	// 사용자 정의 함수를 정의할 수 있다. findBy + Entity의 속성 명(column명)으로 정의할 경우 JPA측에서 해당 메서드 명을 분석하여 쿼리를 만들어 실행한다.
	Question findBySubjectAndContent(String subject, String content); //And를 메서드명에 포함하여 두개 이상의 컬럼을 SQL문에 and로 추가해서 검색할 수 있다
	List<Question> findBySubjectLike(String subject); //특정 문자열이 포함된 데이터를 조회할 경우 findBy~Like로 메서드 이름을 만들어야한다.
}
