package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		return reviewDAO.selectReview(id);
	}
	
	// insert는 void, int로 return 가능
	// return int : 인서트가 성공한 행의 개수
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}
	
	// addReviewAsField(4, "스노윙치킨", "연주", 4.5, "오랜만에 먹었는데 맛있네요~")
	public int addReviewAsField(int storeId, String menu,
			String userName, Double point, String review) {
		
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	public int updateReviewById(int id, String review) {
		return reviewDAO.updateReviewById(id, review);
	}
	
	// input : 삭제할 db
	// output : X
	public void deleteReviewById(int id) {
		reviewDAO.deleteReviewById(id);
	}
}