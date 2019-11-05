package eats.dto;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {
	private int restaurantNo;
	private String restaurantName;
	private String addr;
	private String tel;
	private String foodType;
	private String mainMenu;
	
	List<ReviewDTO> list = new ArrayList<ReviewDTO>();
	
	public RestaurantDTO() {}
	public RestaurantDTO(int restaurantNo, String restaurantName, String addr, String tel, String foodType,
			String mainMenu) {
		this.restaurantNo = restaurantNo;
		this.restaurantName = restaurantName;
		this.addr = addr;
		this.tel = tel;
		this.foodType = foodType;
		this.mainMenu = mainMenu;
	}
	
	public int getRestaurantNo() {
		return restaurantNo;
	}
	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("번호 = ");
		builder.append(restaurantNo);
		builder.append(" | 음식점 = ");
		builder.append(restaurantName);
		builder.append(" | 주소 = ");
		builder.append(addr);
		builder.append(" | 전화번호 = ");
		builder.append(tel);
		builder.append(" | 음식종류 = ");
		builder.append(foodType);
		builder.append(" | 메인메뉴 = ");
		builder.append(mainMenu);

		return  builder.toString();
	}
	
}
