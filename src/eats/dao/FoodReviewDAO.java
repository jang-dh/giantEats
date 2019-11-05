package eats.dao;

import java.sql.SQLException;
import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;


public interface FoodReviewDAO {

	/**
	 * �듅�젙 臾몄옄�뿴�씠 �룷�븿�맂 �젅肄붾뱶 寃��깋 -- 二쇱냼 寃��깋
	 * select * from board where subject like ?
	 */	
	List<RestaurantDTO> SelectByAddr(String addr) throws SQLException;

	/**
	 * �듅�젙 臾몄옄�뿴�씠 �룷�븿�맂 �젅肄붾뱶 寃��깋 -- �뾽�냼紐� 寃��깋
	 * select * from board where subject like ? 
	 */
	List<RestaurantDTO> SelectByName(String Name) throws SQLException;
	
	/**
	 * �듅�젙 臾몄옄�뿴�씠 �룷�븿�맂 �젅肄붾뱶 寃��깋 -- �쓬�떇 遺꾨쪟 寃��깋
	 * select * from board where subject like ? 
	 */
	List<RestaurantDTO> SelectByType(String foodType) throws SQLException;
	
	/**
	 * 由щ럭 �벑濡앺븯湲�
	 * insert into board (board_no, subject, writer, content, board_date) 
	 * values (board_seq.nextval, ?, ?, ?, sysdate)
	 */
	int reviewInsert(ReviewDTO reviewDTO) throws SQLException;
	
	/**
	 * 由щ럭 踰덊샇�뿉 �빐�떦�븯�뒗 寃뚯떆臾� �궡�슜 �닔�젙�븯湲�
	 * update board set content = ? where board_no = ?
	 */
	int reviewUpdate(ReviewDTO reviewDTO) throws SQLException;
	
	/**
	 * 由щ럭 踰덊샇�뿉 �빐�떦�븯�뒗 �젅肄붾뱶 �궘�젣
	 * delete from board where board_no = ?
	 */
	int reviewDelete(int reviewNo) throws SQLException;
	
}
