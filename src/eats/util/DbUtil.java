package eats.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB ������ ���� �ε�, ����, ����
 * */
public class DbUtil {
	private static Properties proFile = new Properties();
	/**
	 * �ε�
	 * */
	static {
		try{
			proFile.load(new FileInputStream("src/util/dbInfo.properties"));
			Class.forName(DbProperty.DRIVER_NAME);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Properties getProFile() {
		return proFile;
	}
	
	/**
	 * ����
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				DbProperty.URL, 
				DbProperty.USER, 
				DbProperty.PASSWORD);
	}
	
	
	/**
	 * �ݱ�(DB���� ���� ��ü�� close()�Ѵ�)
	 * (INSERT, UPDATE, DELETE�� ���)
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
	 * �ݱ�(DB���� ���� ��ü�� close()�Ѵ�)
	 * (SELECT�� ���)
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
