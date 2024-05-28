package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Repository.JdbcConnect;

public class reservationTest {

	@Test
	@DisplayName("내예약을 불러와서 제대로 user id가 2인 예약 중 일부를 삭제한다.")
	public void test() {
		JdbcConnect.userJdbcConnect();
		
	}
}
