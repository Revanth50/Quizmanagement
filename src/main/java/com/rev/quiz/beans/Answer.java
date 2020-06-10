package com.rev.quiz.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Value;

public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	private String question;
	@NotEmpty
	private String answer;
	@Value("false")
	private boolean correct;
	
	
	@Override
	public String toString() {
		return "Answer [id=" + id + ", question=" + question + ", answer=" + answer + ", correct=" + correct + "]";
	}


	public Answer() {
		super();
	}


	public Answer(String question, String answer, boolean correct) {
		super();
		this.question = question;
		this.answer = answer;
		this.correct = correct;
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


	


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public boolean isCorrect() {
		return correct;
	}


	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	
	
	
}
