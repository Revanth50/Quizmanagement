package com.rev.quiz.beans;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Admin {

	@NotEmpty
	@Email
	String mail;
	@Size(min = 4, max = 15)
	String password;

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
	
	
	
	public Admin() {
		super();
	}
	public Admin(int id, String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [mail=" + mail + ", password=" + password + "]";
	}
	
	
	
}
