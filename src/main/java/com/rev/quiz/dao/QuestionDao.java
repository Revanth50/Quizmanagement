package com.rev.quiz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rev.quiz.beans.Question;


public class QuestionDao {  
		JdbcTemplate template;  
		  
		public void setTemplate(JdbcTemplate template) {  
		    this.template = template;  
		}  
		public int save(Question q){  
		    String sql="insert into question(question,answer1,answer2,answer3,answer4) values('"+q.getQuestion()+"','"+q.getAnswer1()+"','"+q.getAnswer2()+"','"+q.getAnswer3()+"','"+q.getAnswer4()+"')";  
		    return template.update(sql);  
		}  
		public int update(Question q){  
		    String sql="update question set question="+q.getQuestion()+",answer1='"+q.getAnswer1()+"',answer2='"+q.getAnswer2()+"',answer3='"+q.getAnswer3()+"',answer4='"+q.getAnswer4()+"' where id="+q.getId()+""; 
		    return template.update(sql);  
		}  
		
		public Question getQuestionById(int id){  
		    String sql="select * from question where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Question>(Question.class));  
		}
		public Question getQuestionByQuestion(String question)
		{
			String sql="select * from question where question=?";
			return template.queryForObject(sql, new Object[] {question},new BeanPropertyRowMapper<Question>(Question.class));
		}
		
		
		 

		public List<Question> getQuestions(){  
		    return template.query("select * from question",new RowMapper<Question>(){  
		        public Question mapRow(ResultSet rs, int row) throws SQLException {  
		            Question question=new Question();		           
		            question.setId(rs.getInt(6));  
		            question.setQuestion(rs.getString(1));  
		            question.setAnswer1(rs.getString(2));
		            question.setAnswer2(rs.getString(3));
		            question.setAnswer3(rs.getString(4));
		            question.setAnswer4(rs.getString(5));
		            return question;  
		        }  
		    });  
		}  


}
