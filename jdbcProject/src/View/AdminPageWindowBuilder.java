package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AdminPageWindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPageWindowBuilder frame = new AdminPageWindowBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPageWindowBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 23));
		lblNewLabel.setBounds(37, 145, 79, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("회원가입");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 48));
		lblNewLabel_1.setBounds(172, 10, 239, 116);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(37, 270, 102, 52);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 23));
		lblNewLabel_3.setBounds(37, 375, 79, 52);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("전화번호");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(37, 477, 102, 52);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 23));
		lblNewLabel_5.setBounds(37, 588, 79, 52);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(161, 157, 210, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 275, 210, 36);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(161, 375, 210, 36);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(161, 477, 210, 36);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(161, 593, 210, 36);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("완료");
		btnNewButton.setBounds(37, 656, 169, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(274, 656, 169, 45);
		contentPane.add(btnNewButton_1);
	}
}
