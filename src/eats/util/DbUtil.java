package eats.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB 연동을 위한 로드, 연결, 실행
 * */
public class DbUtil {

	private static Properties proFile = new Properties();
	/**
	 * 로드
	 * */
	static {
		try{
			proFile.load(new FileInputStream("src/eats/util/dbInfo.properties"));
			proFile.load(new FileInputStream("src/eats/util/eats.properties"));
			
			Class.forName(proFile.getProperty("driverName"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Properties getProFile() {
		return proFile;
	}
	
	/**
	 * 연결
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName")
				, proFile.getProperty("userPass"));
	}
	
	
	/**
	 * 닫기(DB관련 사용된 객체를 close()한다)
	 * (INSERT, UPDATE, DELETE인 경우)
	 * */
	public static void dbClose(Connection con, Statement stmt){
		try{
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기(DB관련 사용된 객체를 close()한다)
	 * (SELECT인 경우)
	 * */
	public static void dbClose(Connection con, Statement stmt, ResultSet rs){
		try{
			if(rs != null) rs.close();
			dbClose(con, stmt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
