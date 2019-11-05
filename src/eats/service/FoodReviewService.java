package eats.service;

import java.sql.SQLException;
import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;

public interface FoodReviewService {

	/**
	 * 특정 문자열이 포함된 레코드 검색 -- 주소 검색
	 */
	List<RestaurantDTO> SelectByAddr(String addr) throws SQLException;
	
	/**
	 * 특정 문자열이 포함된 레코드 검색 -- 업소명 검색
	 */
	List<RestaurantDTO> SelectByName(String name) throws SQLException;
	
	/**
	 * 특정 문자열이 포함된 레코드 검색 -- 음식 분류 검색
	 */
	List<RestaurantDTO> SelectByType(String foodType) throws SQLException;
	
	/**
	 * 모든 리뷰 검색
	 */
	List<ReviewDTO> SelectAll() throws SQLException;

	/**
	 * 리뷰 등록 (등록하기 전에, 글번호 중복체크 - SelectByNo(int reviewNo))
	 */
	void reviewInsert(ReviewDTO reviewDTO) throws SQLException;

	/**
	 * 리뷰 수정
	 */
	void reviewUpdate(ReviewDTO reviewDTO) throws SQLException;

	/**
	 * 리뷰 삭제
	 */

}