package Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.LoginUserResponse;
import DAO.SaveUserResponse;

public class UserRepository {
	
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public static void save(SaveUserResponse response) throws SQLException {
		try {
			pstmt = JdbcConnect.conn.prepareStatement(
					"insert into user (user_name, user_phone_num, user_email"
					+ ", user_username, user_pwd, user_admin)"
					+ " values(?, ?, ?, ?, ?, ?);");
			
			pstmt.setString(1, response.name());
			pstmt.setString(2, response.phoneNum());
			pstmt.setString(3, response.email());
			pstmt.setString(4, response.username());
			pstmt.setString(5, response.password());
			pstmt.setInt(6, 0);
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static boolean findByUsernameAndPwd(LoginUserResponse response) throws SQLException {
		pstmt = JdbcConnect.conn.prepareStatement(
				"select * from user "
				+ "where user_username = ? and user_pwd = ? and user_admin = ?");
		
		pstmt.setString(1, response.username());
		pstmt.setString(2, response.password());
		pstmt.setInt(3, response.isAdmin());
		
		rs = pstmt.executeQuery();
		
		if(!rs.next()) {
			throw new SQLException("쿼리가 잘못 되었습니다.");
		}
		return true;
	}
}
