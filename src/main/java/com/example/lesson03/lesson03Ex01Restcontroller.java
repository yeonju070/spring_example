package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class lesson03Ex01Restcontroller {
	
	@Autowired
	private ReviewBO reviewbo;
	
	// 요청 url : http://localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01() {
		return reviewbo.getReviewById(3);
	}
}