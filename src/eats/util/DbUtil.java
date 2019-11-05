package eats.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
<<<<<<< HEAD
 * DB ������ ���� �ε�, ����, ����
=======
 * DB 연동을 위한 로드, 연결, 실행
>>>>>>> branch 'master' of https://github.com/jang-dh/giantEats.git
 * */
public class DbUtil {
	private static Properties proFile = new Properties();
	/**
<<<<<<< HEAD
	 * �ε�
=======
	 * 로드
>>>>>>> branch 'master' of https://github.com/jang-dh/giantEats.git
	 * */
	static {
		try{
			proFile.load(new FileInputStream("src/eats/util/dbInfo.properties"));
			Class.forName(DbProperty.DRIVER_NAME);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Properties getProFile() {
		return proFile;
	}
	
	/**
<<<<<<< HEAD
	 * ����
=======
	 * 연결
>>>>>>> branch 'master' of https://github.com/jang-dh/giantEats.git
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				DbProperty.URL, 
				DbProperty.USER, 
				DbProperty.PASSWORD);
	}
	
	
	/**
<<<<<<< HEAD
	 * �ݱ�(DB���� ���� ��ü�� close()�Ѵ�)
	 * (INSERT, UPDATE, DELETE�� ���)
=======
	 * 닫기(DB관련 사용된 객체를 close()한다)
	 * (INSERT, UPDATE, DELETE인 경우)
>>>>>>> branch 'master' of https://github.com/jang-dh/giantEats.git
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
<<<<<<< HEAD
	 * �ݱ�(DB���� ���� ��ü�� close()�Ѵ�)
	 * (SELECT�� ���)
=======
	 * 닫기(DB관련 사용된 객체를 close()한다)
	 * (SELECT인 경우)
>>>>>>> branch 'master' of https://github.com/jang-dh/giantEats.git
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
