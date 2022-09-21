package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	// input : id
	// output : Review
	public Review getReviewById(int id) {	// where절이 있을때는 by를 붙인다.
		return reviewDAO.selectReviewById(id);
	}
}
