package Repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import static sql.ReservationSql.deleteReservationByIdSql;

public class ReservationRepository {
	private static Statement stmt;
	private static ResultSet rs;
	
	public static void deleteReservationById(int id) throws SQLException {
		stmt = JdbcConnect.conn.createStatement();
		String sql = deleteReservationByIdSql + id;
		stmt.executeUpdate(sql);
	}
	
	public static ArrayList<HashMap<String, Object>> findAll(){
		// TODO ms_id
		String sql = "select r_id, m_name, ms_date, Theater_thtr_id, seat_seat_id, tckt_selling_price, ms_id\r\n"
				+ "from movie, movie_schedule as ms, ticket as t, reservation as r\r\n"
				+ "where movie_m_id = m_id\r\n"
				+ "and t.movie_schedule_ms_id = ms_id\r\n"
				+ "and r.movie_schedule_ms_id = ms_id\r\n"
				+ "and tckt_id = Ticket_tckt_id;\r\n";
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	@SuppressWarnings("null")
	public static ArrayList<HashMap<String, Object>> findById(int id) {
		String sql = "select distinct ms.ms_date, ms.ms_day_of_week, ms.ms_shedule_cnt, ms.ms_time\r\n"
				+ ",Theater_thtr_id, t.tckt_availability, t.tckt_standard_price\r\n"
				+ ", t.tckt_selling_price, seat_seat_id\r\n"
				+ "from movie_schedule as ms, ticket as t, reservation as r\r\n"
				+ "where ms.ms_id = t.movie_schedule_ms_id\r\n"
				+ "and ms.ms_id = r.movie_schedule_ms_id\r\n"
				+ "and r_id = "+ id + ";";
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
