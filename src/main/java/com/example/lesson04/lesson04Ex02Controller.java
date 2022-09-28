package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 요청 url : http://localhost/lesson04/ex02/add_student_view
	@RequestMapping("/add_student_view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute Student student,	// name(request param)과 일치하는 필드에 값이 들어간다.
			Model model) {
		
		// DB insert
		studentBO.addStudent(student);
		
		// DB select
		// System.out.println("!!!!!!!111" + student.getId());
		Student currentStudent = studentBO.getStudentById(student.getId());
		
		// model에 담는다.
		model.addAttribute("student", currentStudent);
		model.addAttribute("subject", "학생 정보");
		
		// jsp 경로 리턴
		return "lesson04/afterAddStudent";
	}
}