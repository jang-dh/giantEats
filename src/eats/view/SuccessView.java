package eats.view;

import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;

public class SuccessView {
	public static void printSearchBySth(List<RestaurantDTO> list) {
		System.out.printf("%s  |  %-10s  |  %-28s  |  %-8s  |  %s\n", "음식점코드", "이름", "주소", "전화번호", "음식종류");
		for(int index = 0 ; index < list.size() ; index++)
			System.out.println(list.get(index));
	}
	
	public static void printReview(List<ReviewDTO> list) {
		System.out.println("-----리뷰 목록-----");
		for(ReviewDTO reviewDTO : list)
			System.out.printf("리뷰 번호 %d | %-6s | %s | 작성자 : %s | 내용 : %s\n", reviewDTO.getReviewNo(), printStar(reviewDTO.getScore()), reviewDTO.getRegdate(), reviewDTO.getWriter(), reviewDTO.getContent());
	}
	
	public static void printReview(ReviewDTO reviewDTO) {
		System.out.printf("리뷰 번호 %d | %-6s | %s | 작성자 : %s | 내용 : %s\n", reviewDTO.getReviewNo(), printStar(reviewDTO.getScore()), reviewDTO.getRegdate(), reviewDTO.getWriter(), reviewDTO.getContent());
	}
	
	
	public static void printRestaurant(RestaurantDTO restaurantDTO) {
		System.out.println();
		System.out.println("----------음식점 정보----------");
		System.out.printf("이름 : %s\n", restaurantDTO.getRestaurantName());
		System.out.printf("주소 : %s\n", restaurantDTO.getAddr());
		System.out.printf("전화번호 : %s\n", restaurantDTO.getTel());
		System.out.printf("종류 : %s\n", restaurantDTO.getFoodType());
		System.out.printf("주 메뉴 : %s\n", restaurantDTO.getMainMenu());
		printReview(restaurantDTO.getList());
	}
	
	
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static String printStar(int score) {
		StringBuilder star = new StringBuilder();
		for(int i = 0 ; i < score; i++) 
			star.append("★");
		return star.toString();
	}
	
}
