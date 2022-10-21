package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
		private int id;
		private String name;
		private String email;
		
	
		 @Override 
		 public String toString() { 
			 return "Student [id=" + id + ", name=" +name + ", email="+ email +"]"; 
		 }
		 
	
}


