package sql;

public class MovieScheduleSql {
 // 앞: movie, 뒤: theater
	public static String[] movieScheduleArr = new String[40];
	public static int MAX = 36;
	
	public static void initMovieScheduleArr() {
		movieScheduleArr[0] = "insert into movie_schedule values"
				+ "	(1,'2023-06-01','목요일','1','07:00:00',1,1);";
		movieScheduleArr[1] = "insert into movie_schedule values\r\n"
				+ "	(2,'2023-06-01','목요일','2','10:00:00',2,1);";
		movieScheduleArr[2] = "insert into movie_schedule values\r\n"
				+ "	(3,'2023-06-01','목요일','3','13:00:00',3,1);";
		
		movieScheduleArr[3] = "insert into movie_schedule values\r\n"
				+ "	(4,'2023-06-01','목요일','1','07:00:00',1,2);";
		movieScheduleArr[4] = "insert into movie_schedule values\r\n"
				+ "	(5,'2023-06-01','목요일','2','10:00:00',2,2);";
		movieScheduleArr[5] = "insert into movie_schedule values\r\n"
				+ "	(6,'2023-06-01','목요일','3','13:00:00',3,2);";
		
		movieScheduleArr[6] = "insert into movie_schedule values\r\n"
				+ "	(7,'2023-06-01','목요일','1','07:00:00',1,3);";
		movieScheduleArr[7] = "insert into movie_schedule values\r\n"
				+ "	(8,'2023-06-01','목요일','2','10:00:00',2,3);";
		movieScheduleArr[8] = "insert into movie_schedule values\r\n"
				+ "	(9,'2023-06-01','목요일','3','13:00:00',3,3);";
		
		movieScheduleArr[9] = "insert into movie_schedule values\r\n"
				+ "	(10,'2023-06-02','금요일','1','07:00:00',4,4);";
		movieScheduleArr[10] = "insert into movie_schedule values\r\n"
				+ "	(11,'2023-06-02','금요일','2','10:00:00',5,4);";
		movieScheduleArr[11] = "insert into movie_schedule values\r\n"
				+ "	(12,'2023-06-02','금요일','1','07:00:00',4,5);";
		
		movieScheduleArr[12] = "insert into movie_schedule values\r\n"
				+ "	(13,'2023-06-02','금요일','2','10:00:00',5,5);";
		movieScheduleArr[13] = "insert into movie_schedule values\r\n"
				+ "	(14,'2023-06-02','금요일','1','07:00:00',4,6);";
		movieScheduleArr[14] = "insert into movie_schedule values\r\n"
				+ "	(15,'2023-06-02','금요일','2','10:00:00',5,6);";
		
		movieScheduleArr[15] = "insert into movie_schedule values\r\n"
				+ "	(16,'2023-06-14','수요일','1','07:00:00',6,11);";
		movieScheduleArr[16] = "insert into movie_schedule values\r\n"
				+ "	(17,'2023-06-14','수요일','2','10:00:00',6,11);";
		movieScheduleArr[17] = "insert into movie_schedule values\r\n"
				+ "	(18,'2023-06-14','수요일','3','13:00:00',6,11);";
		
		movieScheduleArr[18] = "insert into movie_schedule values\r\n"
				+ "	(19,'2023-07-26','수요일','1','07:00:00',7,7);";
		movieScheduleArr[19] = "insert into movie_schedule values\r\n"
				+ "	(20,'2023-07-26','수요일','2','10:00:00',7,7);";
		movieScheduleArr[20] = "insert into movie_schedule values\r\n"
				+ "	(21,'2023-07-26','수요일','3','13:00:00',7,7);";
		
		movieScheduleArr[21] = "insert into movie_schedule values\r\n"
				+ "	(22,'2023-08-09','수요일','1','07:00:00',8,8);";
		movieScheduleArr[22] = "insert into movie_schedule values\r\n"
				+ "	(23,'2023-08-09','수요일','2','10:00:00',8,8);";
		movieScheduleArr[23] = "insert into movie_schedule values\r\n"
				+ "	(24,'2023-08-09','수요일','3','13:00:00',8,8);";
		
		movieScheduleArr[24] = "insert into movie_schedule values\r\n"
				+ "	(25,'2023-09-06','수요일','1','07:00:00',9,9);";
		movieScheduleArr[25] = "insert into movie_schedule values\r\n"
				+ "	(26,'2023-09-06','수요일','2','10:00:00',9,9);";
		movieScheduleArr[26] = "insert into movie_schedule values\r\n"
				+ "	(27,'2023-09-06','수요일','3','13:00:00',9,9);";
		
		movieScheduleArr[27] = "insert into movie_schedule values\r\n"
				+ "	(28,'2023-10-03','화요일','1','07:00:00',10,10);";
		movieScheduleArr[28] = "insert into movie_schedule values\r\n"
				+ "	(29,'2023-10-03','화요일','2','10:00:00',10,10);";
		movieScheduleArr[29] = "insert into movie_schedule values\r\n"
				+ "	(30,'2023-10-03','화요일','3','13:00:00',10,10);";
		
		movieScheduleArr[30] = "insert into movie_schedule values\r\n"
				+ "	(31,'2023-11-29','수요일','1','07:00:00',11,11);";
		movieScheduleArr[31] = "insert into movie_schedule values\r\n"
				+ "	(32,'2023-11-29','수요일','2','10:00:00',11,11);";
		movieScheduleArr[32] = "insert into movie_schedule values\r\n"
				+ "	(33,'2023-11-29','수요일','3','13:00:00',11,11);";
		
		movieScheduleArr[33] = "insert into movie_schedule values\r\n"
				+ "	(34,'2023-12-06','수요일','1','07:00:00',12,12);";
		movieScheduleArr[34] = "insert into movie_schedule values\r\n"
				+ "	(35,'2023-12-06','수요일','2','10:00:00',12,12);";
		movieScheduleArr[35] = "insert into movie_schedule values\r\n"
				+ "	(36,'2023-12-06','수요일','3','13:00:00',12,12);";
	}
}
