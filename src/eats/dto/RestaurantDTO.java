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
	public RestaurantDTO(int restaurantNo, String restaurantName, String addr, String tel, String foodType,
			String mainMenu, List<ReviewDTO> list) {
		this(restaurantNo, restaurantName, addr, tel, foodType, mainMenu);
		this.list = list;
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
	
	public void setList(List<ReviewDTO> list) {
		this.list = list;
	}
	
	public List<ReviewDTO> getList(){
		return list;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();;
		builder.append(String.format("%10d  |  %s  |  ", restaurantNo, restaurantName));
		builder.append(String.format("%s  |  %s  |  ", addr, tel));
		builder.append(String.format("%s", foodType));
		return  builder.toString();
	}
	
}
