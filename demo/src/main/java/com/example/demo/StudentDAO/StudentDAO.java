package com.example.demo.StudentDAO;

import java.util.List;
import com.example.demo.model.Student;

public interface StudentDAO {
	
	int saveStudent(Student student);	
	int updateStudent(Student student, int id);
	int deleteStudent(int id);
	List<Student> getAll();

}


