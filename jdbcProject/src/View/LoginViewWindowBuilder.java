package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

public class LoginViewWindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginViewWindowBuilder frame = new LoginViewWindowBuilder();
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
	public LoginViewWindowBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("관리자");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 23));
		btnNewButton.setBounds(118, 314, 266, 151);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 23));
		btnNewButton_1.setBounds(423, 314, 273, 151);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("세종시네마");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 48));
		lblNewLabel.setBounds(266, 76, 260, 85);
		contentPane.add(lblNewLabel);
	}
}
