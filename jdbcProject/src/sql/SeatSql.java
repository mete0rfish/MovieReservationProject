package sql;

public class SeatSql {
	
	public static String[][] seatSqlArr = new String[13][11];
	private static int idx = 1;

	
	public static void initSeatSql() {
		for(int i=0; i<12;i++) {
			for(int j = 0;j < 10;j++) {
				seatSqlArr[i][j] = "insert into seat values\r\n"
						+ "	(" + idx +"," + (i+1) + "," + (j+1) + ");";
				idx++;
			}
		}	
	}
}
