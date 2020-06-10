package com.rev.quiz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rev.quiz.beans.Student;	
	
	public class StudentDao {  
		JdbcTemplate template;  
		  
		public void setTemplate(JdbcTemplate template) {  
		    this.template = template;  
		}  
		public int save(Student s){  
		    String sql="insert into student(id,mail,password,confirm_password,userName,marks) values('"+s.getId()+"','"+s.getMail()+"','"+s.getPassword()+"','"+s.getConfirm_password()+"','"+s.getUserName()+"','"+s.getMarks()+"')";  
		    return template.update(sql);  
		}  
		public int update(Student s){  
		    String sql="update student set id='"+s.getId()+"', mail="+s.getMail()+",password='"+s.getPassword()+"',confirm_password='"+s.getConfirm_password()+"',userName='"+s.getUserName()+"' ,marks='"+s.getMarks()+"' where id="+s.getId()+""; 
		    return template.update(sql);  
		}  
		
		public Student getStudentById(int id){  
		    String sql="select * from student where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
		}  
		public Student getStudentByMail(String mail){  
		    String sql="select * from student where mail=?";  
		    return template.queryForObject(sql, new Object[]{mail},new BeanPropertyRowMapper<Student>(Student.class));  
		} 
		
		public Student getStudentByPassword(String password){  
		    String sql="select * from student where password=?";  
		    return template.queryForObject(sql, new Object[]{password},new BeanPropertyRowMapper<Student>(Student.class));  
		}  
		
		public int updateScore(Student s){  
		    String sql="update student set marks='"+s.getMarks()+"' where id="+s.getId()+""; 
		    return template.update(sql);  
		}  

		 

		public List<Student> getStudents(){  
		    return template.query("select * from student",new RowMapper<Student>(){  
		        public Student mapRow(ResultSet rs, int row) throws SQLException {  
		            Student student=new Student();  
		            student.setId(rs.getInt(1));  
		            student.setMail(rs.getString(2));  
		            student.setPassword(rs.getString(3));  
		            student.setConfirm_password(rs.getString(4));
		            student.setUserName(rs.getString(5));
		            student.setMarks(rs.getInt(6));
		              
		            return student;  
		        }  
		    });  
		}  

}
