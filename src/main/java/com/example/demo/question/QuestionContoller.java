package com.example.demo.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")	//클래스단위의 URL 매핑도 가능하다 클래스 내부 메서드들에 대한 URL 매핑은 공통적으로 /question으로 시작하게 된다
@RequiredArgsConstructor	//final 속성의 멤버를 포함하는 생성자를 자동으로 생성해준다
// 스프링의 의존성 주입은 3가지가 있으며 각각 @Autowired 어노테이션, 생성자, setter 이다 @RequiredArgsConstuctor는 생성자를 생성해주는 어노테이션으로 스프링의 의존성 주입에 사용된다
@Controller
public class QuestionContoller {
	
	private final QuestionService questionService;
	
//	@GetMapping("/question/list")
	@GetMapping("/list")
	public String list(Model model) {	//Model 객체는 자바 클래스와 템플릿간의 연결 고리 역할을 한다. 컨트롤러 메서드의 매개변수로 지정해두기만 하면 스프링부트에서 자동으로 Model 객체를 생성해준다.
		System.out.println("questionList");
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
//	@GetMapping(value = "question/detail/{id}")
	@GetMapping(value = "detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		System.out.println(question);
		System.out.println("git commit test");
		model.addAttribute("question", question);
		return "question_detail";
		/*
		 * path variable을 사용하는 경우 변수로 사용하고자 하는 url path를 {}로 감싸주고 메서드에서 매개변수로 받을 때 앞에 PathVariable 어노테이션을 붙여줘야한다 두 이름이 동일해야한다
		 */
	}

}
