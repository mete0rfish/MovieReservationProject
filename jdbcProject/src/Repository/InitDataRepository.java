package Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sql.MovieScheduleSeatSql;
import sql.MovieScheduleSql;
import sql.SeatSql;

import static sql.SeatSql.*;
import static sql.movieSql.*;
import static sql.TheaterSql.*;
import static sql.UserSql.*;
import static sql.MovieScheduleSql.*;
import static sql.TicketSql.*;
import static sql.ReservationSql.*;


public class InitDataRepository {
	
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public static void initMovieData() throws SQLException {
		stmt = JdbcConnect.conn.createStatement();
		stmt.execute(movie1Sql);
		stmt.execute(movie2Sql);
		stmt.execute(movie3Sql);
		stmt.execute(movie4Sql);
		stmt.execute(movie5Sql);
		stmt.execute(movie6Sql);
		stmt.execute(movie7Sql);
		stmt.execute(movie8Sql);
		stmt.execute(movie9Sql);
		stmt.execute(movie10Sql);
		stmt.execute(movie11Sql);
		stmt.execute(movie12Sql);
	}
	
	public static void initTheatherData() throws SQLException {
		stmt = JdbcConnect.conn.createStatement();
		stmt.execute(theater1Sql);
		stmt.execute(theater2Sql);
		stmt.execute(theater3Sql);
		stmt.execute(theater4Sql);
		stmt.execute(theater5Sql);
		stmt.execute(theater6Sql);
		stmt.execute(theater7Sql);
		stmt.execute(theater8Sql);
		stmt.execute(theater9Sql);
		stmt.execute(theater10Sql);
		stmt.execute(theater11Sql);
		stmt.execute(theater12Sql);
	}
	
	public static void initSeatData() throws SQLException {
		SeatSql.initSeatSql();
		stmt = JdbcConnect.conn.createStatement();

		for(int i=0;i<12;i++) {
			for(int j=0;j<10;j++) {
				stmt.execute(seatSqlArr[i][j]);
			}
		}
	}
	
	public static void initUserData() throws SQLException {
		stmt = JdbcConnect.conn.createStatement();
		stmt.execute(user1Sql);
		stmt.execute(user2Sql);
		stmt.execute(user3Sql);
		stmt.execute(user4Sql);
		stmt.execute(user5Sql);
		stmt.execute(user6Sql);
		stmt.execute(user7Sql);
		stmt.execute(user8Sql);
		stmt.execute(user9Sql);
		stmt.execute(user10Sql);
		stmt.execute(user11Sql);
		stmt.execute(user12Sql);
	}
	
	public static void initMovieScheduleData() throws SQLException {
		stmt = JdbcConnect.conn.createStatement();
		initMovieScheduleArr();
		for(int i=0;i<MovieScheduleSql.MAX; i++) {
			stmt.execute(movieScheduleArr[i]);
		}
	}
	
	public static void initTicketData() throws SQLException {
		stmt = JdbcConnect.conn.createStatement();
		stmt.execute(Ticket1Sql);
		stmt.execute(Ticket2Sql);
		stmt.execute(Ticket3Sql);
		stmt.execute(Ticket4Sql);
		stmt.execute(Ticket5Sql);
		stmt.execute(Ticket6Sql);
		stmt.execute(Ticket7Sql);
		stmt.execute(Ticket8Sql);
		stmt.execute(Ticket9Sql);
		stmt.execute(Ticket10Sql);
		stmt.execute(Ticket11Sql);
		stmt.execute(Ticket12Sql);
	}
	
	public static void initMovieScheduleSeatData() throws SQLException{
		stmt = JdbcConnect.conn.createStatement();
		MovieScheduleSeatSql.initMovieScheduleSeatSql();
		for(int i=0;i<MovieScheduleSeatSql.maxIdx;i++) {
			stmt.execute(MovieScheduleSeatSql.mssArr[i]);
		}
	}
	
	public static void initReservationData() throws SQLException{
		stmt = JdbcConnect.conn.createStatement();
		
		stmt.execute(reservation1Sql);
		stmt.execute(reservation2Sql);
		stmt.execute(reservation3Sql);
		stmt.execute(reservation4Sql);
		stmt.execute(reservation5Sql);
		stmt.execute(reservation6Sql);
		stmt.execute(reservation7Sql);
		stmt.execute(reservation8Sql);
		stmt.execute(reservation9Sql);
		stmt.execute(reservation10Sql);
		stmt.execute(reservation11Sql);
		stmt.execute(reservation12Sql);
	}
}
