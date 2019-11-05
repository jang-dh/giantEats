package eats.view;

import java.util.Scanner;

import eats.controller.FoodReviewController;
import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;

public class PrintMenu {
	Scanner sc = new Scanner(System.in);
	
	void printMainMenu() {
		while(true) {
			System.out.println("----------GiantEats!----------");
			System.out.println("1.음식점 찾기\t 2.리뷰 등록\n\nx.프로그램 종료");
			System.out.println("------------------------------");
			System.out.print("메뉴 선택 > ");
			
			String menu = sc.next();
			
			switch(menu) {
				case "1":
					searchStore();
					break;
				case "2":
					menuInsertReview();
					break;
				case "x":
				case "X":
					System.out.println("--프로그램 종료");
					System.exit(0);
					break;
				default :
					System.out.println("--다시 입력하세요.");
			}
		}
	}
	
	void searchStore() {
		System.out.println();
		System.out.println("----------음식점 찾기----------");
		System.out.println("1.지역    2.음식종류    3.지역/음식종류    4.이름");
		System.out.println("------------------------------");
		System.out.print("메뉴 선택 > ");
		
		String menu = sc.next();
		
		switch(menu) {
			case "1":
				searchStoreByAddr();
				break;
			case "2":
				searchStoreByFoodType();
				break;
			case "3":
				searchStoreByAddrFoodType();
				break;
			case "4":
				searchStoreByName();
				break;
			default :
				System.out.println();
				System.out.println("메인 메뉴로 돌아갑니다.");
				break;
		}
		System.out.println();
	}
	
	void menuInsertReview() {
		searchStore();
	}
	
	String selectAddrToSearch() {
		System.out.println();
		System.out.println("----------지역으로 음식점 찾기----------");
		System.out.println("1.교동      2.금호동    3.노학동    4.대포동");
		System.out.println("5.도문동    6.동명동    7.설악동    8.영랑동");
		System.out.println("9.장사동    10.조양동   11.중앙동   12.청호동");
		System.out.println("------------------------------");
		System.out.print("지역 선택 > ");
		
		String menu = sc.next();
		String addr = null;
		
		switch(menu) {
			case "1":
				addr = "교동";
				break;
			case "2":
				addr = "금호동";
				break;
			case "3":
				addr = "노학동";
				break;
			case "4":
				addr = "대포동";
				break;
			case "5":
				addr = "도문동";
				break;
			case "6":
				addr = "동명동";
				break;
			case "7":
				addr = "설악동";
				break;
			case "8":
				addr = "영랑동";
				break;
			case "9":
				addr = "장사동";
				break;
			case "10":
				addr = "조양동";
				break;
			case "11":
				addr = "중앙동";
				break;
			case "12":
				addr = "청호동";
				break;
			default :
				System.out.println("메인으로 돌아갑니다.");
				break;
		}
		return addr;
	}
	
	void searchStoreByAddr() {
		String addr = selectAddrToSearch();
		FoodReviewController.searchStoreByAddr(addr);
		searchStoreByNo();
	}
	
	String selectFoodTypeToSearch() {
		System.out.println();
		System.out.println("----------음식 종류로 음식점 찾기----------");
		System.out.println("1.한식    2.중식    3.양식    4.일식    5.뷔페");
		System.out.print("종류 선택 > ");
		String menu = sc.next();
		String foodType = null;
		
		switch(menu) {
			case "1":
				foodType = "교동";
				break;
			case "2":
				foodType = "금호동";
				break;
			case "3":
				foodType = "노학동";
				break;
			case "4":
				foodType = "대포동";
				break;
			case "5":
				foodType = "도문동";
				break;
		}
		return foodType; 
	}
	
	void searchStoreByFoodType() {
		String foodType = selectFoodTypeToSearch();
		FoodReviewController.searchStoreByFoodType(foodType);
		searchStoreByNo();
		
	}
	
	void searchStoreByAddrFoodType() {
		String addr = selectAddrToSearch();
		String foodType = selectFoodTypeToSearch();
		FoodReviewController.searchStoreByAddrFoodType(addr, foodType);
		searchStoreByNo();
	}
	
	void searchStoreByName() {
		System.out.println("----------음식점 이름으로 찾기----------");
		System.out.print("입력 > ");
		
		String name = sc.next();
		
		FoodReviewController.searchStoreByName(name);
		searchStoreByNo();
	}
	
	void searchStoreByNo() {
		System.out.println();
		System.out.println("-----음식점 코드로 찾기(Y/N)-----");
		System.out.print("입력 > ");
		
		String menu = sc.next();
		
		switch(menu) {
			case "Y":
			case "y":
				System.out.print("찾을 음식점 코드 > ");
				String code = sc.next();
				
				try {
					Integer.parseInt(code);
				}catch(NumberFormatException e) {
					//FailView.errorMessage(e.getMessage());
				}
				RestaurantDTO searched = FoodReviewController.searchStoreByNo(code);
				selectPrintReviewMenu(searched);
				break;
			case "N":
			case "n":
				break;
			default :
				break;
		}
	}
	
	void selectPrintReviewMenu(RestaurantDTO restaurantDTO) {
		System.out.println("----메뉴 더보기(Y/N)");
		System.out.print("입력 > ");
		
		String menu = sc.next();
		
		switch(menu) {
			case "Y":
			case "y":
				printReviewMenu(restaurantDTO);
				break;
			case "N":
			case "n":
				break;
			default :
				break;
		}
	}
	
	void printReviewMenu(RestaurantDTO restaurantDTO) {
		System.out.println("----------메뉴----------");		
		System.out.println("1.리뷰 등록    2.리뷰 수정    3.리뷰 삭제");
		System.out.println("X : 나가기");
		System.out.print("메뉴 입력 > ");
		
		String menu = sc.next();
		
		switch(menu) {
			case "1":
				insertReview(restaurantDTO);
				break;
			case "2":
				updateReview();
				break;
			case "3":
				deleteReview();
				break;
			default :
				break;
		}
	}
	
	void insertReview(RestaurantDTO restaurantDTO) {
		System.out.println("----------리뷰 등록----------");		
		System.out.print("작성자 > ");
		String writer = sc.next();
		System.out.print("별점 > ");
		String score = sc.next();
		try {
			Integer.parseInt(score);
		}catch (NumberFormatException e) {
			FailView.erroMessage("숫자로 입력해주세요.");
		}
		System.out.println("내용 > ");
		String content = sc.next();
		
		ReviewDTO review = new ReviewDTO(restaurantDTO.getRestaurantNo(), 0, Integer.parseInt(score), null, writer, content);
		FoodReviewController.insertReview(review);
		}
	
	void updateReview() {
		System.out.println("----------리뷰 수정----------");
		System.out.println("수정할 리뷰 > ");
		String reviewNo = sc.next();
		try {
			Integer.parseInt(reviewNo);
		}catch (NumberFormatException e) {
			FailView.erroMessage("숫자로 입력해주세요.");
		}

		ReviewDTO updated = FoodReviewController.selectReviewByNo(Integer.parseInt(reviewNo));
		
		System.out.print("별점 > ");
		String score = sc.next();
		try {
			Integer.parseInt(score);
		}catch (NumberFormatException e) {
			FailView.erroMessage("숫자로 입력해주세요.");
		}
		System.out.println("내용 > ");
		String content = sc.next();
		
		updated.setScore(Integer.parseInt(score));
		updated.setContent(content);
		FoodReviewController.updateReview(updated);
	}
	
	void deleteReview() {
		System.out.println("삭제할 리뷰 > ");
		String reviewNo = sc.next();
		try {
			Integer.parseInt(reviewNo);
		}catch (NumberFormatException e) {
			FailView.erroMessage("숫자로 입력해주세요.");
		}
		
		ReviewDTO deleted = FoodReviewController.selectReviewByNo(Integer.parseInt(reviewNo));
		FoodReviewController.deleteReview(deleted.getReviewNo());
	}
}