package eats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import eats.dto.RestaurantDTO;
import eats.dto.ReviewDTO;
import eats.service.FoodReviewService;
import eats.util.DbUtil;

public class FoodReviewDAOImpl implements FoodReviewDAO {

	@Override
	public List<RestaurantDTO> SelectByAddr(String addr) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDTO> SelectByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDTO> SelectByType(String foodType) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewDTO> SelectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int reviewInsert(ReviewDTO reviewDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reviewUpdate(ReviewDTO reviewDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reviewDelete(int reviewNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
