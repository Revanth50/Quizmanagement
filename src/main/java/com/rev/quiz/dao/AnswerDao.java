package com.rev.quiz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rev.quiz.beans.Answer;

public class AnswerDao { 
		JdbcTemplate template;  
		  
		public void setTemplate(JdbcTemplate template) {  
		    this.template = template;  
		}  
		public int save(Answer a){  
		    String sql="insert into answer(question,answer) values('"+a.getQuestion()+"','"+a.getAnswer()+"')";  
		    return template.update(sql);  
		}  
		public int update(Answer a){  
		    String sql="update answer set question="+a.getQuestion()+",answer='"+a.getAnswer()+"' where id="+a.getId()+""; 
		    return template.update(sql);  
		}  
		
		public Answer getAnswerById(int id){  
		    String sql="select * from question where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Answer>(Answer.class));  
		}  
		

		

		public List<Answer> getAnswers(){  
		    return template.query("select * from answer",new RowMapper<Answer>(){  
		        public Answer mapRow(ResultSet rs, int row) throws SQLException {  
		            Answer answer=new Answer();
		            answer.setId(rs.getInt(4));  
		            answer.setQuestion(rs.getString(1));  
		            answer.setAnswer(rs.getString(2));  
		            answer.setCorrect(rs.getBoolean(3));
		          
		          
		           return answer;
		            		         
		        }  
		    });  
		}
		public Answer getAnswerByQuestion(String question) {
			
			  String sql="select * from answer where question=?";  
			    return template.queryForObject(sql, new Object[]{question},new BeanPropertyRowMapper<Answer>(Answer.class));  
		}  


}
