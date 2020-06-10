package com.rev.quiz.controllers;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rev.quiz.beans.Admin;
import com.rev.quiz.beans.Answer;
import com.rev.quiz.beans.Exam;
import com.rev.quiz.beans.Question;
import com.rev.quiz.beans.Student;
import com.rev.quiz.dao.AnswerDao;
import com.rev.quiz.dao.QuestionDao;
import com.rev.quiz.dao.StudentDao;

@Controller
public class ExamController {
	
	@Autowired
	StudentDao sdao;
	@Autowired
	QuestionDao qdao;
	@Autowired
	AnswerDao adao;
	
	 @RequestMapping("/studentregister")  
	    public String studentregister(Model m){  
	    	m.addAttribute("student", new Student());
	    	return "studentregister"; 
	    } 
	 
	 @PostMapping(value="/register")  
	    public String register(@Valid @ModelAttribute("student") Student student,BindingResult br){
		 
		 List<Student> l=sdao.getStudents();
		    	for(Student i : l) {
		    		if(student.getId()==i.getId()) {
		    			br.rejectValue("id", "error.id in use", "id is already taken");
		    			return "studentregister";
		    		}
		    		if(student.getMail().equalsIgnoreCase(i.getMail())) {
		    			br.rejectValue("mail", "error.mail id in use", "user with this id was already registered");
		    			return "studentregister";
		    		}
		    	}
		    	if(!student.getPassword().contentEquals(student.getConfirm_password())) {
		    		br.rejectValue("confirm_password", "error.confirm_password", "does not match with your password");
		    	}
		 if(br.hasErrors()) {
			 return "studentregister";
			 }
		 else {
			 sdao.save(student);
			 return "registersuccess";
			 }
		 } 
	 
	 
	 @RequestMapping("/userlogin/{id}")  
	    public String userloginreg(@PathVariable int id,Model m){  
	    	m.addAttribute("student", sdao.getStudentById(id));
	    	return "userlogin"; 
	    } 
	 @PostMapping("/userlogin/re-login") 
	    public String loginreg(@Valid @ModelAttribute("student") Student student,BindingResult br,Model m){

		 System.out.println("logged in");
		 List<Student> l=sdao.getStudents();
			int size=l.size(),ii=0;
		    	for(Student i : l) {
		    		if (student.getMail().equalsIgnoreCase(i.getMail())) {
		    			if(!student.getPassword().equals(i.getPassword())) {
		    				br.rejectValue("password", "error.password", "password miss match please enter a valid password");
		    				return "userlogin";
		    				}
		    			}
		    		else
		    			ii++;
		    		}
		    	if(ii>=size) {
		    		br.rejectValue("mail", "error.mail in use", "please enter a valid mail id");
		    		return "userlogin";
		    		}
		    	
		    		
		    	else {
		    		System.out.println(br);
		    		System.out.println("getting into welcome");
		    		List<Question> questions=qdao.getQuestions();
		    		Exam exam=new Exam();
		    		student=sdao.getStudentByMail(student.getMail());
		    		exam.setQuestion(questions);
		    		m.addAttribute("exam", exam);
		    		exam.setStudent(student);
		    		m.addAttribute("exam", exam);
		    		return "welcomestudent";	
		    		}
		    	} 
	 
	 @RequestMapping(value="/userlogin/examdone",method = RequestMethod.POST)
	    public String examdone2(@ModelAttribute("exam") Exam exam){ 
			List<Question> question=exam.getQuestion();
			Student student = sdao.getStudentById(exam.getStudent().getId());
			int score=0;
			for(Question q:question) {
				Answer answer=adao.getAnswerByQuestion(q.getQuestion());
				System.out.println(answer);
				System.out.println(q);
				if(answer.getAnswer().replaceAll("\\s+","").equalsIgnoreCase(q.getAnswer().replaceAll("\\s+","")))
				score++;
				
			
			}
			
			exam.setScore(score);
			student.setMarks(score);
			sdao.updateScore(student);
			
	    	return "examdone"; 
	    }
	 
	 @RequestMapping("/userlogin")  
	    public String userlogin(Model m){  
	    	m.addAttribute("student", new Student());
	    	return "userlogin"; 
	    }
	 
	@PostMapping("/re-login") 
	    public String login(@Valid @ModelAttribute("student") Student student,BindingResult br,Model m){
		
		
		if (student.getMail().equalsIgnoreCase("admin@gmail.com") && student.getPassword().equals("admin123")){
			return "redirect:/adminactions";
		}
		 
		List<Student> l=sdao.getStudents();
		int size=l.size(),ii=0;
	    	for(Student i : l) {
	    		if (student.getMail().equalsIgnoreCase(i.getMail())) {
	    			if(!student.getPassword().equals(i.getPassword())) {
	    				br.rejectValue("password", "error.password", "password miss match please enter a valid password");
	    				return "userlogin";
	    				}
	    			}
	    		else
	    			ii++;
	    		}
	    	if(ii>=size) {
	    		br.rejectValue("mail", "error.mail in use", "please enter a valid mail id");
	    		return "userlogin";
	    		}
	    	
	    	else {	
	    		System.out.println("getting into welcome");
	    		
	    		List<Question> questions=qdao.getQuestions();
	    		Exam exam=new Exam();
	    		student=sdao.getStudentByMail(student.getMail());
	    		exam.setQuestion(questions);
	    		m.addAttribute("exam", exam);
	    		exam.setStudent(student);
	    		m.addAttribute("exam", exam);
	    		
	    		return "welcomestudent";	}
	    	} 
	
	@RequestMapping(value="/examdone",method = RequestMethod.POST)
    public String examdone1(@ModelAttribute("exam") Exam exam,Model m){ 
		List<Question> question=exam.getQuestion(); 
		Student student = sdao.getStudentById(exam.getStudent().getId());
		int score=0;
		for(Question q:question) {
			Answer answer=adao.getAnswerByQuestion(q.getQuestion());
			System.out.println(answer);
			System.out.println(q);
			if(q.getAnswer()!=null && answer.getAnswer()!=null) {
				if((q.getAnswer().replaceAll("\\s+","")).equalsIgnoreCase(answer.getAnswer().replaceAll("\\s+","")))
					score++;
			
			}
		}
		System.out.println(score);
		exam.setScore(score);
		student.setMarks(score);
		sdao.updateScore(student);

		
    	return "examdone"; 
    }
	
	@GetMapping("/examact")
	public String examdone(@Valid @ModelAttribute("score") Exam exam,BindingResult br,Model m){
		
		
		return "examdone";
		
	}
	
	
	
	
	
	@RequestMapping("/adminlogin")  
    public String adminlogin(Model m){  
    	m.addAttribute("admin", new Admin());
    	return "adminlogin"; 
    }
	@PostMapping("/adminlogin") 
    public String adminlogin(@Valid @ModelAttribute("admin") Admin admin, BindingResult br){
		
		if (admin.getMail().equalsIgnoreCase("admin@gmail.com") ){
				if(!(admin.getPassword().equals("admin123"))) {
				br.rejectValue("password", "error.password", "password miss match please enter a valid password");
				return "adminlogin";
				}	
		}else {
			br.rejectValue("mail", "error.mail", "mail id miss match please enter a valid mail id");
			return "adminlogin";
		}
		if(br.hasErrors()) {	return "adminlogin";	}
		else {	return "redirect:/adminactions";	}
		}
	
	
	
	 
	@RequestMapping("/adminactions")  
    public String adminaction(Model m){  
    	m.addAttribute("question", new Question());
    	return "adminactions"; 
    }
	
	@PostMapping("/adminaction")
	public String adminaction(@Valid @ModelAttribute("question") Question question, BindingResult br){
		
		
		List<Question> l=qdao.getQuestions();
    	for(Question i : l) {
    		if (question.getQuestion().replaceAll("\\s+","").equalsIgnoreCase(i.getQuestion().replaceAll("\\s+",""))) {
    			
    			System.out.println("inside check");
    				br.rejectValue("question", "error.question", "question is already present");
    				return "adminactions";
    				
    			}
    	}
		if(br.hasErrors()) {	
			return "adminactions";	
			}
		else {	
			qdao.save(question);
			Question ques=qdao.getQuestionByQuestion(question.getQuestion());
			return "redirect:/answers/"+ques.getId();
		}        
		
	}
	
	@RequestMapping("/answers/{id}")  
    public String adminanswer(@PathVariable int id,Model m){  
    	m.addAttribute("answer", adao.getAnswerById(id));
    	return "answers"; 
    }
	
	@PostMapping("answers/answers")
	public String adminanswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult br){
		
		
		
		if(br.hasErrors()) {	
			return "adminactions";	
			}
		else {	
			adao.save(answer);
			return "questionsuccess";
		}
		
	}
	
	
	
	@RequestMapping("/answers/adminactions")  
    public String adminquestionadd(Model m){  
    	m.addAttribute("question", new Question());
    	return "adminactions"; 
    }
	
	@PostMapping("/answers/adminaction")
	public String adminaction1(@Valid @ModelAttribute("question") Question question, BindingResult br){
		
		List<Question> l=qdao.getQuestions();
	    	for(Question i : l) {
	    		if (question.getQuestion().replaceAll("\\s+","").equalsIgnoreCase(i.getQuestion().replaceAll("\\s+",""))) {
	    			
	    				br.rejectValue("question", "error.question", "question is already present");
	    				return "adminactions";
	    				
	    			}
	    	}
	    	
		
		if(br.hasErrors()) {	
			return "adminlogin";	
			}
		else {	
			qdao.save(question);
			Question ques=qdao.getQuestionByQuestion(question.getQuestion());
			return "redirect:/answers/"+ques.getId();
		}        
		
	}
	
	
	
	@RequestMapping("/viewstudents")  
    public String viewstudents(Model m){ 
		
    	m.addAttribute("list",sdao.getStudents() );
    	return "viewstudents"; 
    } 
	
	
	  
	
	
	}
