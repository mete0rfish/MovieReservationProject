import java.sql.Connection;
import java.sql.Statement;

import Repository.JdbcConnect;
import View.LoginView;

public class JdbcProject {

	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.setVisible(true);
	}
}
