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

import DAO.LoginUserResponse;
import Repository.UserRepository;

public class LoginView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(129, 239, 328, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 335, 328, 52);
		contentPane.add(textField_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("관리자 모드");
		rdbtnNewRadioButton.setFont(new Font("굴림", Font.PLAIN, 23));
		rdbtnNewRadioButton.setBounds(522, 235, 180, 38);
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("회원 모드");
		rdbtnNewRadioButton_1.setFont(new Font("굴림", Font.PLAIN, 23));
		rdbtnNewRadioButton_1.setBounds(522, 275, 180, 38);
		
		ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(rdbtnNewRadioButton);
        radioGroup.add(rdbtnNewRadioButton_1);
        contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 23));
		btnNewButton.setBounds(477, 314, 123, 73);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원\r\n가입");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 23));
		btnNewButton_1.setBounds(622, 314, 141, 73);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("세종시네마");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 48));
		lblNewLabel.setBounds(266, 76, 260, 85);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(26, 245, 73, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_1_1.setBounds(26, 353, 83, 34);
		contentPane.add(lblNewLabel_1_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int isAdmin = rdbtnNewRadioButton.isSelected()==true ? 1 : 0 ;
				LoginUserResponse response = new LoginUserResponse(textField.getText(), textField_1.getText(), isAdmin);
				boolean isLoggedin = false;
				try {
					isLoggedin = UserRepository.findByUsernameAndPwd(response);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if(isLoggedin) {
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요!", "Message",JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignUpView signUpView = new SignUpView();
				signUpView.setVisible(true);
			}
		});
	}
}
