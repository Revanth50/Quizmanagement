package com.rev.quiz.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;



public class Question  {


	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "content should not be null")
	private String question;
	@NotEmpty
	private String answer1;
	@NotEmpty
	private String answer2;
	@NotEmpty
	private String answer3;
	@NotEmpty
	private String answer4;
	private String answer;
	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public Question() {
		super();
	}
	
	
	public Question(String question) {
		super();
		this.question = question;
	}

	

	
	public Question(Integer id, String question, String answer1, String answer2, String answer3, String answer4,String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer=answer;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
				+ ", answer3=" + answer3 + ", answer4=" + answer4 + ", answer=" + answer + "]";
	}
	
		
	
}
