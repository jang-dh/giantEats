package eats.dao;

import java.sql.SQLException;
import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;


public interface FoodReviewDAO {

	/**
	 * 특정 문자열이 포함된 레코드 검색 -- 주소 검색
	 * select * from board where subject like ?
	 */
	List<RestaurantDTO> SelectByaddr(String addr) throws SQLException;

	/**
	 * 특정 문자열이 포함된 레코드 검색 -- 업소명 검색
	 * select * from board where subject like ? 
	 */
	List<RestaurantDTO> SelectByName(String Name) throws SQLException;

	/**
	 * 특정 문자열이 포함된 레코드 검색 -- 음식 분류 검색
	 * select * from board where subject like ? 
	 */
	List<RestaurantDTO> SelectByType(String foodType) throws SQLException;

	/**
	 * 리뷰 등록하기
	 * insert into board (board_no, subject, writer, content, board_date) 
	 * values (board_seq.nextval, ?, ?, ?, sysdate)
	 */
	int reviewInsert(ReviewDTO reviewDTO) throws SQLException;

	/**
	 * 리뷰 번호에 해당하는 게시물 내용 수정하기
	 * update board set content = ? where board_no = ?
	 */
	int reviewUpdate(ReviewDTO reviewDTO) throws SQLException;

	/**
	 * 리뷰 번호에 해당하는 레코드 삭제
	 * delete from board where board_no = ?
	 */
	int reviewDelete(int reviewNo) throws SQLException;

}