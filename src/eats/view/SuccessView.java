package eats.view;

import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;

public class SuccessView {
	public static void printSearchBySth(List<RestaurantDTO> list) {
		for(int index = 0 ; index < list.size() ; index++)
		System.out.println(list.get(index));
	}
	
	public static void printReview(List<ReviewDTO> list) {
		for(int index = 0 ; index < list.size() ; index++)
			System.out.println(list.get(index) + " " + printStar(list.get(index).getScore()));
	}
	
	public static void printRestaurant(RestaurantDTO restaurantDTO) {
		System.out.println(restaurantDTO);
	}
	
	public static void printReview(ReviewDTO reviewDTO) {
		System.out.println(reviewDTO + " " + printStar(reviewDTO.getScore()));
	}
	
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static String printStar(int score) {
		String star = null;
		for(int i = 0 ; i < score; i ++) star += "★";
		return star;
	}
	
}
