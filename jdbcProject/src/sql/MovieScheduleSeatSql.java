package sql;

public class MovieScheduleSeatSql {
	public static int maxIdx = 360;
	public static String mssArr[] = new String[maxIdx];
	
	public static void initMovieScheduleSeatSql() {
		int id= 1, sid= 1;
        for (int msid = 1; msid <= 36; msid++) {

            if (msid <= 3)
                sid = 1;
            else if (msid <= 6)
                sid = 2;
            else if (msid <= 9)
            	sid = 3;
	        else if (msid <= 11)
	            sid = 4;
	        else if (msid <= 13)
	            sid = 5;
	        else if (msid <= 15)
	            sid = 6;
	        else if (msid <= 18)
	            sid = 11;
	        else if (msid <= 21)
	            sid = 7;
	        else if (msid <= 24)
	            sid = 8;
	        else if (msid <= 27)
	            sid = 9;
	        else if (msid <= 30)
	            sid = 10;
	        else if (msid <= 33)
	            sid = 11;
	        else if (msid <= 36)
	            sid = 12;

            for(int i = 1; i <=10; i ++){
            	System.out.println("msid:" + msid + ", sid: " + sid);
            	int seat_id = (sid-1)*10+i;
            	mssArr[id-1] = "insert into movie_schedule_seat values\n" 
                    + "(" + id + "," + "1," + msid + "," + seat_id + ");";
            	id++;    
            }
            mssArr[4] = "insert into movie_schedule_seat values "
            		+ "(5,0,1,5);";
            mssArr[25] = "insert into movie_schedule_seat values"
            		+ "(26,0,3,6);";
            mssArr[40] = "insert into movie_schedule_seat values\r\n"
            		+ "(41,0,5,11);";
            mssArr[60] = "insert into movie_schedule_seat values\r\n"
            		+ "(61,0,7,21);";
            mssArr[84] = "insert into movie_schedule_seat values\r\n"
            		+ "(85,0,9,25);";
            mssArr[104] = "insert into movie_schedule_seat values\r\n"
            		+ "(105,0,11,35);";
            mssArr[123] = "insert into movie_schedule_seat values\r\n"
            		+ "(124,0,13,44);";
            mssArr[145] = "insert into movie_schedule_seat values\r\n"
            		+ "(146,0,15,56);";
            mssArr[164] = "insert into movie_schedule_seat values\r\n"
            		+ "(165,0,17,105);";
            mssArr[181] = "insert into movie_schedule_seat values\r\n"
            		+ "(182,0,19,62);";
            mssArr[205] = "insert into movie_schedule_seat values\r\n"
            		+ "(206,0,21,66);";
            mssArr[226] = "insert into movie_schedule_seat values\r\n"
            		+ "(227,0,23,77);";
		}
	}
}
