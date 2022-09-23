package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RequestMapping("/lesson03/ex02")
@RestController
public class lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 요청 url : http://localhost/lesson03/ex02/1
	@RequestMapping("/1")
	public String ex02_1() {
		Review review = new Review();	// java bean
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("강정빈");
		review.setPoint(4.5);
		review.setReview("배송이 빠르고 혼자 먹기 적당해요 !");
		
		// insert
		int row = reviewBO.addReview(review);		// insert 된 row 수를 return 받는다.
		
		// return string
		return "success row count : " + row;
	}
	
	@RequestMapping("/2")
	public String ex02_2() {
		int row = reviewBO.addReviewAsField(4, "스노윙치킨", "연주", 4.5, "오랜만에 먹었는데 맛있네요~");
		return "success row count : " + row;
	}
}
