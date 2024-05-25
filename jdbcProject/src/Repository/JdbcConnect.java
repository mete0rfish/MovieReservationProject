package Repository;

import java.sql.*;

public class JdbcConnect {
	
	public static Connection conn;
	public static Statement stmt;
	
	public static void adminJdbcConnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1"
					, "root", "1234");
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();
			
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch(SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
	
	public static void userJdbcConnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1"
					, "user", "user1");
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();
			
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch(SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
	
	public static void jdbcClose() throws SQLException {
		conn.close();
	}
}
