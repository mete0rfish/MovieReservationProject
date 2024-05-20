package Repository;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class MovieRepository {
	private static Statement stmt;
	private static ResultSet rs;
	
	@SuppressWarnings("null")
	public static String[][] findAll() {
		String[][] contents = null;
		try {
			stmt = JdbcConnect.conn.createStatement();
			rs = stmt.executeQuery("select * from movie;");
			
			int idx = 0;
			while(!rs.next()) {
				String[] strArr = null;
				strArr[0] = rs.getString("m_name");
				strArr[1] = rs.getString("m_director");
				strArr[2] = rs.getString("m_genre");
				strArr[3] = Integer.toString(rs.getInt("m_running_time"));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				strArr[4] = format.format(rs.getDate("m_release_date"));
				strArr[5] = rs.getString("m_actor");
				strArr[6] = rs.getString("m_info");
				strArr[7] = Double.toString(rs.getDouble("m_grade"));
				contents[idx++] = strArr; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contents;	
	}
	
//	public static String[][] findByDirector(String sql) {
//		
//	}
}
