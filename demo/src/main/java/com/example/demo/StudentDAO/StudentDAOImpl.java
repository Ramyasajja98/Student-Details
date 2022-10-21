package com.example.demo.StudentDAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired 
	JdbcTemplate jt;

	@Override
	public List<Student> getAll() {
		return jt.query("SELECT * FROM student", new BeanPropertyRowMapper<Student>(Student.class));
	}

	@Override
	public int saveStudent(Student student) {
		// TODO Auto-generated method stub
		return jt.update("INSERT INTO student (name,email) VALUES (?,?)",new Object [] {student.getName(),student.getEmail()});
	}

	@Override
	public int updateStudent(Student student, int id) {
		// TODO Auto-generated method stub
		return jt.update("UPDATE student SET name=?,email=? WHERE id=?", new Object [] {student.getName(),student.getEmail(),id});
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		return jt.update("DELETE FROM student WHERE id=?",id);
	}
	
	

}
