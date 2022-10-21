package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentDAO.StudentDAO;
import com.example.demo.model.Student;

@RestController
@RequestMapping("/user")
public class TestDataController{
	
	@Autowired
	private StudentDAO sDAO;
	
	@GetMapping("/student")
	public String test() {
		return "testing";
	}
	@GetMapping("/students")
	public List<Student> getStudent(){
		return sDAO.getAll();
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		return sDAO.saveStudent(student)+"No of rows saved";
	}
	
	@PutMapping("/update/{id}")
	public String updateStudent(@RequestBody Student student,@PathVariable int id) {
		return sDAO.updateStudent(student, id)+"no of rows updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return sDAO.deleteStudent(id)+"No of rows deleted";
		
	}
}
