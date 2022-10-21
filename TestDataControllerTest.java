package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.example.demo.StudentDAO.StudentDAO;
import com.example.demo.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestDataControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StudentDAO sDAO;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void test() throws Exception {

		mockMvc.perform(get("/user/student")).andExpect(status().isOk());
	}

	@Test
	void getStudents() throws Exception {
		List<Student> student = new ArrayList<>(Arrays.asList(new Student(1, "Ram", "ramya.sajja@gmail.com"),
				new Student(2, "Rany", "ravi@gmail.com"), new Student(3, "Priya", "priyal@gmail.com ")));
		when(sDAO.getAll()).thenReturn(student);
		System.out.println("student details" + student);
		mockMvc.perform(get("/user/students")).andExpect(status().isOk());
	}

	@Test
	void saveStudent() throws Exception {
		Student student = new Student();
		student.setId(4);
		student.setName("Divya");
		student.setEmail("Divya@gmail.com");
		mockMvc.perform(post("/user/save").content(objectMapper.writeValueAsString(student))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void updateStudent() throws Exception {
		int id = 1;
		Student student = new Student();
		student.setId(1);
		student.setName("ramyas");
		student.setEmail("ramya.sajja347@gmail.com");
		mockMvc.perform(put("/user/update/" + id).content(objectMapper.writeValueAsString(student))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void deleteStudent() throws Exception {
		int id = 1;
		mockMvc.perform(delete("/user/delete/" + id)).andExpect(status().isOk());
	}

}
