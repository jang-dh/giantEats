package eats.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eats.dao.FoodReviewDAO;
import eats.dao.FoodReviewDAOImpl;
import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;

public class FoodReviewServiceImpl implements FoodReviewService {

	FoodReviewDAO dao = new FoodReviewDAOImpl();
				
	@Override
	public List<RestaurantDTO> selectRestaurantByAddr(String addr) throws SQLException {
		List<RestaurantDTO> list = dao.selectRestaurantByAddr(addr);
		
		if(list == null || list.isEmpty()) {
			throw new SQLException("주소에 해당하는 음식점이 없습니다.");
		}
	
		return list;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByFoodType(String foodType) throws SQLException {

		List<RestaurantDTO> list = dao.selectRestaurantByFoodType(foodType);
		
		if(list == null || list.isEmpty()) {
			throw new SQLException("해당하는 음식종류가 없습니다.");
		}
		return list;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByAddrFoodType(String addr, String foodType) throws SQLException {
		
		List<RestaurantDTO> list = dao.selectRestaurantByAddrFoodType(addr, foodType);
		
		if(list == null || list.isEmpty()) {
			throw new SQLException("해당하는 지역/음식종류가 없습니다.");
		}
		return list;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByName(String name) throws SQLException {
		
		List<RestaurantDTO> list = dao.selectRestaurantByName(name);
		
		if(list == null || list.isEmpty()) {
			throw new SQLException("해당하는 음식점을 찾을 수 없습니다.");
		}
		return list;
	}

	@Override
	public RestaurantDTO selectRestaurantByNo(int restaurantNo, List<RestaurantDTO> list) throws SQLException {
		
		RestaurantDTO result = dao.selectRestaurantByNo(restaurantNo);
		
		if(result == null) {
			throw new SQLException("코드에 해당하는 음식점을 찾을 수 없습니다.");
		}else {
			for(RestaurantDTO restaurantDTO : list) {
				if(restaurantNo == restaurantDTO.getRestaurantNo())
					return result;
			}
			throw new SQLException("목록에 없는 음식점입니다.");
		}
	}

	@Override
	public int insertReview(ReviewDTO reviewDTO) throws SQLException {
		
		int result = dao.insertReview(reviewDTO);
		
		if(result == 0) {
			throw new SQLException("리뷰가 등록되지 않았습니다.");
		}
		return result;
	}

	@Override
	public int updateReview(ReviewDTO reviewDTO) throws SQLException {
		
		int result = dao.updateReview(reviewDTO);
		
		if(result == 0) {
			throw new SQLException("리뷰가 수정되지 않았습니다.");
		}
		return result;
	}

	@Override
	public int deleteReview(int reviewNo) throws SQLException {
		
		int result = dao.deleteReview(reviewNo);
		
		if(result == 0) {
			throw new SQLException("리뷰가 삭제되지 않았습니다.");
		}
		return result;
	}

	@Override
	public ReviewDTO selectReviewByNo(int reviewNo) throws SQLException {
		
		ReviewDTO result = dao.selectReviewByNo(reviewNo);
		
		if(result == null) {
			throw new SQLException("리뷰를 찾을 수 없습니다.");
		}
		return result;
	}

	@Override
	public List<ReviewDTO> selectReviewByRestaurantNo(int restaurantNo) throws SQLException {
		List<ReviewDTO> result = dao.selectReviewByRestaurantNo(restaurantNo);
		
		if(result == null) {
			throw new SQLException("등록된 리뷰가 없습니다. 리뷰를 작성해주세요.");
		}
		return result;
	}
}

