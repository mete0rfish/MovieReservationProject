package Repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class ReservationRepository {
	private static Statement stmt;
	private static ResultSet rs;
	
	@SuppressWarnings("null")
	public static ArrayList<HashMap<String, Object>> findAllWithMSAndTicket() {
		String sql = "select ms.ms_date, ms.ms_day_of_week, ms.ms_shedule_cnt, ms.ms_time\r\n"
				+ ", Theater_thtr_id, t.tckt_availability, t.tckt_standard_price\r\n"
				+ ", t.tckt_selling_price, seat_seat_id\r\n"
				+ "from movie_schedule as ms, ticket as t, reservation as r\r\n"
				+ "where r.movie_schedule_ms_id = ms.ms_id\r\n"
				+ "and ms.ms_id = t.movie_schedule_ms_id;";
		try {
			
			stmt = JdbcConnect.conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		
			while(rs.next()) {
				HashMap<String, Object> row = new HashMap<>(columns);
				for(int i=1;i<=columns;i++) {
					row.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(row);
			}
			return list;
			
			/*
			 * int idx = 0; while(!rs.next()) { String[] strArr = null; SimpleDateFormat
			 * dateFormat = new SimpleDateFormat("yyyy-MM-dd"); strArr[0] =
			 * dateFormat.format(rs.getString("ms_date")); strArr[1] =
			 * rs.getString("ms_day_of_week"); strArr[2] =
			 * Integer.toString(rs.getInt("ms_schedule_cnt")); SimpleDateFormat timeFormat =
			 * new SimpleDateFormat("HH:mm"); strArr[3] =
			 * timeFormat.format(rs.getDate("ms_time")); strArr[4] =
			 * Integer.toString(rs.getInt("Theater_thtr_id")); strArr[5] =
			 * Boolean.toString(rs.getBoolean("tckt_availability")); strArr[6] =
			 * Integer.toString(rs.getInt("tckt_standard_price")); strArr[7] =
			 * Integer.toString(rs.getInt("tckt_selling_price")); strArr[8] =
			 * Integer.toString(rs.getInt("seat_seat_id")); contents[idx++] = strArr; }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
