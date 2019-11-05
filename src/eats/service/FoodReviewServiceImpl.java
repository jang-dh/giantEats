package eats.service;

import java.sql.SQLException;
import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;

public class FoodReviewServiceImpl implements FoodReviewService {

	@Override
	public List<RestaurantDTO> selectRestaurantByAddr(String addr) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByFoodType(String foodType) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByAddrFoodType(String addr, String foodType) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO selectRestaurantByNo(String restaurantNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReview(ReviewDTO reviewDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReview(ReviewDTO reviewDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReview(int reviewNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReviewDTO selectReviewByNo(int reviewNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
