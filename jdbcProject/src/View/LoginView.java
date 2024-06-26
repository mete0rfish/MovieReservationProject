package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import Repository.JdbcConnect;


public class LoginView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmin = new JButton("관리자");
		btnAdmin.setFont(new Font("굴림", Font.PLAIN, 23));
		btnAdmin.setBounds(118, 314, 266, 151);
		contentPane.add(btnAdmin);
		
		JButton btnUser = new JButton("회원");
		btnUser.setFont(new Font("굴림", Font.PLAIN, 23));
		btnUser.setBounds(423, 314, 273, 151);
		contentPane.add(btnUser);
		
		JLabel lblNewLabel = new JLabel("세종시네마");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 48));
		lblNewLabel.setBounds(266, 76, 260, 85);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("현재 날짜 : 2023/06/01");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(276, 165, 307, 67);
		contentPane.add(lblNewLabel_1);
		
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JdbcConnect.adminJdbcConnect();
				AdminPage adminPage = new AdminPage();
				adminPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				adminPage.setVisible(true);
				//dispose();
			}
		});
		
		btnUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JdbcConnect.userJdbcConnect();
				AllMovieView allMovieView = new AllMovieView();
				allMovieView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				allMovieView.setVisible(true);
				//dispose();
			}
		});
	}
}
