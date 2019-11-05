package eats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;
import eats.util.DbUtil;

public class FoodReviewDAOImpl implements FoodReviewDAO {
	private Properties proFile = DbUtil.getProFile();
	
	@Override
	public List<RestaurantDTO> selectRestaurantByAddr(String addr) throws SQLException {
		List<RestaurantDTO> list = new ArrayList<RestaurantDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("restaurant.selectByAddr");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+addr+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				int restaurantNo = rs.getInt(1);
				String restaurantName = rs.getString(2);
				String seachAddr = rs.getString(3);
				String tel = rs.getString(4);
				String foodType = rs.getString(5);
				String mainMenu = rs.getString(6);
				
				RestaurantDTO restaurantDTO = new RestaurantDTO(restaurantNo, restaurantName, 
													seachAddr, tel, foodType, mainMenu);
				list.add(restaurantDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByFoodType(String foodType) throws SQLException {
		List<RestaurantDTO> list = new ArrayList<RestaurantDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("restaurant.selectByFoodType");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, foodType);
			rs = ps.executeQuery();
			while(rs.next()) {
				int restaurantNo = rs.getInt(1);
				String restaurantName = rs.getString(2);
				String Addr = rs.getString(3);
				String tel = rs.getString(4);
				String searchFoodType = rs.getString(5);
				String mainMenu = rs.getString(6);
				
				RestaurantDTO restaurantDTO = new RestaurantDTO(restaurantNo, restaurantName, 
													Addr, tel, searchFoodType, mainMenu);
				list.add(restaurantDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByAddrFoodType(String addr, String foodType) throws SQLException {
		List<RestaurantDTO> list = new ArrayList<RestaurantDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("restaurant.selectByAddrFoodType");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+addr+"%");
			ps.setString(2, foodType);
			rs = ps.executeQuery();
			while(rs.next()) {
				int restaurantNo = rs.getInt(1);
				String restaurantName = rs.getString(2);
				String seachAddr = rs.getString(3);
				String tel = rs.getString(4);
				String searchFoodType = rs.getString(5);
				String mainMenu = rs.getString(6);
				
				RestaurantDTO restaurantDTO = new RestaurantDTO(restaurantNo, restaurantName, 
													seachAddr, tel, searchFoodType, mainMenu);
				list.add(restaurantDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<RestaurantDTO> selectRestaurantByName(String name) throws SQLException {
		List<RestaurantDTO> list = new ArrayList<RestaurantDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("restaurant.selectByName");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				int restaurantNo = rs.getInt(1);
				String restaurantName = rs.getString(2);
				String Addr = rs.getString(3);
				String tel = rs.getString(4);
				String searchFoodType = rs.getString(5);
				String mainMenu = rs.getString(6);
				
				RestaurantDTO restaurantDTO = new RestaurantDTO(restaurantNo, restaurantName, 
													Addr, tel, searchFoodType, mainMenu);
				list.add(restaurantDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public RestaurantDTO selectRestaurantByNo(String restaurantNo) throws SQLException {
		RestaurantDTO restaurantDTO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("restaurant.selectByNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, restaurantNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				int seachRestaurantNo = rs.getInt(1);
				String restaurantName = rs.getString(2);
				String Addr = rs.getString(3);
				String tel = rs.getString(4);
				String searchFoodType = rs.getString(5);
				String mainMenu = rs.getString(6);
				
				restaurantDTO = new RestaurantDTO(seachRestaurantNo, restaurantName, 
													Addr, tel, searchFoodType, mainMenu);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return restaurantDTO;
	}

	@Override
	public int insertReview(ReviewDTO reviewDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("review.insert");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewDTO.getRestaurantNo());
			ps.setString(2, reviewDTO.getWriter());
			ps.setInt(3, reviewDTO.getScore());
			ps.setString(4, reviewDTO.getContent());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int updateReview(ReviewDTO reviewDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("review.update");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewDTO.getScore());
			ps.setString(2, reviewDTO.getContent());
			ps.setInt(3, reviewDTO.getReviewNo());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int deleteReview(int reviewNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("review.delete");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public ReviewDTO selectReviewByNo(int reviewNo) throws SQLException {
		ReviewDTO reviewDTO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("review.selectByRestaurantNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				int restaurantNo = rs.getInt(1);
				int restaurantName = rs.getInt(2);
				int score = rs.getInt(3);
				String regdate = rs.getString(4);
				String writer = rs.getString(5);
				String content = rs.getString(6);
				
				reviewDTO = new ReviewDTO(restaurantNo, restaurantName, 
						score, regdate, writer, content);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return reviewDTO;
	}

}
