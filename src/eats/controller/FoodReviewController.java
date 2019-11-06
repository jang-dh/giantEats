package eats.controller;

import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;
import eats.service.FoodReviewService;
import eats.service.FoodReviewServiceImpl;
import eats.view.FailView;
import eats.view.SuccessView;

public class FoodReviewController {
	private static FoodReviewService service = new FoodReviewServiceImpl();
	
	public static List<RestaurantDTO> searchRestaurantByAddr(String addr) {
		List<RestaurantDTO> list = null;
		try {
			list = service.selectRestaurantByAddr(addr);
			if(list != null | !list.isEmpty())
				SuccessView.printSearchBySth(list);;
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return list;
	}
	
	public static void searchRestaurantByFoodType(String foodType) {
		try {
			List<RestaurantDTO> list = service.selectRestaurantByFoodType(foodType);
			if(list != null | !list.isEmpty())
				SuccessView.printSearchBySth(list);;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	public static void searchRestaurantByAddrFoodType(String addr, String foodType) {
		try {
			List<RestaurantDTO> list = service.selectRestaurantByFoodType(foodType);
			if(list != null | !list.isEmpty())
				SuccessView.printSearchBySth(list);;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void searchRestaurantByName(String name) {
		try {
			List<RestaurantDTO> list = service.selectRestaurantByName(name);
			if(list != null | !list.isEmpty())
				SuccessView.printSearchBySth(list);;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static RestaurantDTO searchRestaurantByNo(int no) {
		RestaurantDTO restaurantDTO = null;
		try {
			restaurantDTO = service.selectRestaurantByNo(no);
			if(restaurantDTO != null) {
				SuccessView.printRestaurant(restaurantDTO);
			}
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return restaurantDTO;
	}
	
	public static void insertReview(ReviewDTO reviewDTO) {
		try {
			service.insertReview(reviewDTO);
			SuccessView.printMessage("리뷰가 등록되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void updateReview(ReviewDTO reviewDTO) {
		try {
			service.updateReview(reviewDTO);
			SuccessView.printMessage("리뷰가 수정되었습니다.");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());		}
	}
	public static void deleteReview(int no) {
		try {
			service.deleteReview(no);
			SuccessView.printMessage("리뷰가 삭제되었습니다.");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static ReviewDTO selectReviewByNo(int no) {
		ReviewDTO result = null;
		try {
			result = service.selectReviewByNo(no);
			//SuccessView.
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}
	
}
