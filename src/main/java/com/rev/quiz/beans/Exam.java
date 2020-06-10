package com.rev.quiz.beans;

import java.util.List;

public class Exam {
	
	private Student student;
	
	
	private List<Question> question;
	
	private int score;
	
	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Exam [student=" + student + ", question=" + question + ", score=" + score + "]";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam(Student student, List<Question> question, int score) {
		super();
		this.student = student;
		this.question = question;
		this.score = score;
	}

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
