package com.rev.quiz.beans;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Student {

	@Id
	int id;
	@NotEmpty(message = "mail id is required")
	@Email
	String mail; 
	@NotEmpty
	String userName;
	@Size(min = 4, max = 15)
	String password;
	@Size(min = 4, max = 15)
	String confirm_password;
	
	int marks;
	
	
	
	
	
	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Student() {
		super();
	}
	public Student(int id, String mail, String userName, String password, String confirm_password, int marks) {
		super();
		this.id = id;
		this.mail = mail;
		this.userName = userName;
		this.password = password;
		this.confirm_password = confirm_password;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", mail=" + mail + ", userName=" + userName + ", password=" + password
				+ ", confirm_password=" + confirm_password + ", marks=" + marks + "]";
	}
	
	
	
}
