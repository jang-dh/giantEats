package eats.service;

import java.sql.SQLException;
import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;

public interface FoodReviewService {

	List<RestaurantDTO> selectRestaurantByAddr(String addr) throws SQLException;
	
	
	List<RestaurantDTO> selectRestaurantByFoodType(String foodType) throws SQLException;
	
	
	List<RestaurantDTO> selectRestaurantByAddrFoodType(String addr, String foodType) throws SQLException;
	
	
	List<RestaurantDTO> selectRestaurantByName(String name) throws SQLException;
	
	
	RestaurantDTO selectRestaurantByNo(int restaurantNo, List<RestaurantDTO> list) throws SQLException;
	
	
	int insertReview(ReviewDTO reviewDTO) throws SQLException;

	
	int updateReview(ReviewDTO reviewDTO) throws SQLException;
	
	
	int deleteReview(int reviewNo) throws SQLException;
	
	
	ReviewDTO selectReviewByNo(int reviewNo) throws SQLException;
	
	List<ReviewDTO> selectReviewByRestaurantNo(int restaurantNo) throws SQLException;
}