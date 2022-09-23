package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class lesson03Ex03RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 요청 url : http://localhost/lesson03/ex03?id=10&review=오랜만에 먹어도 맛있네요~
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam(value="id") int id,
			@RequestParam("review") String review) {
		int row = reviewBO.updateReviewById(id, review);
		return "변경 완료 : " + row;
	}
}
