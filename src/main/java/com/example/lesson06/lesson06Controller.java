package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class lesson06Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 유저 추가 화면
	// 요청 URL: http://localhost/lesson06/ex01/add_user_view
	@RequestMapping("/add_user_view")
	public String ex01() {
		return "lesson06/addUser";
	}
	
	// 유저 추가
	// 요청 URL: http://localhost/lesson06/ex01/add_user
	@PostMapping("/add_user")
	@ResponseBody
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "introduce", required=false) String introduce) {
		
		userBO.addUser(name, yyyymmdd, email, introduce);
		return "success";
	}
	
	// 추가된 유저 정보 화면
	// 요청 URL: http://localhost/lesson06/ex01/get_user
	@RequestMapping("/get_user")
	public String getUser() {
		return "lesson06/getUser";
	}
}