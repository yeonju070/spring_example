package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(@Param("id") int id); // 특정 id에 해당하는 row 가져오기
	
	public int insertReview(Review review);		// review 객체의 내용을 row(행, record)로 추가
	
	public int insertReviewAsField(
			@Param("storeId") int storeId,
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") Double point,
			@Param("review") String review);		// 여러 파라미터들을 row로 추가
	
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
	
	public void deleteReviewById(int id);
}