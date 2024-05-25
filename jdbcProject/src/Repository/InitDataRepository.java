package Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDataRepository {
	
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	private static String movie1Sql = "INSERT INTO movie VALUES\r\n"
			+ "    (1,'유령', '이해영', '액션', 133, '15세 관람가', '2023-01-18' , '설경구,이하늬,박소담', \r\n"
			+ "'유령에게 고함. 작전을 시작한다” 1933년, 일제강점기 경성. 항일조직 ‘흑색단’의 스파이인 ‘유령’이 비밀리에 활약하고 있다. 새로 부임한 경호대장 카이토는 ‘흑색단’의 총독 암살 시도를 막기 위해 조선총독부 내의 ‘유령’을 잡으려는 덫을 친다. 영문도 모른 채, ‘유령’으로 의심받고 벼랑 끝 외딴 호텔에 갇힌 용의자들. 총독부 통신과 감독관 쥰지, 암호문 기록 담당 차경, 정무총감 비서 유리코, 암호 해독 담당 천계장, 통신과 직원 백호. 이들에게 주어진 시간은 단 하루 뿐. 기필코 살아나가 동지들을 구하고 총독 암살 작전을 성공시켜야 하는 ‘유령’과 무사히 집으로 돌아가고 싶은 이들 사이, 의심과 경계는 점점 짙어지는데… 과연 ‘유령’은 작전에 성공할 수 있을 것인가? “성공할 때까지 멈춰서는 안 된다',6.8);";
	
	public static void initMovieData() throws SQLException {
		stmt = JdbcConnect.conn.createStatement();
		stmt.execute(movie1Sql);
	}
}
