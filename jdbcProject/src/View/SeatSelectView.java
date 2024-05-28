package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeatSelectView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public SeatSelectView(int schedule_id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(111, 73, 354, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel Screen = new JPanel();
		Screen.setToolTipText("Screen");
		Screen.setBounds(24, 10, 301, 26);
		panel.add(Screen);
		JLabel lblNewLabel = new JLabel("SCREEN");
		Screen.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		
		JButton seat_1 = new JButton("1");
		seat_1.setBounds(24, 83, 50, 50);
		panel.add(seat_1);
		
		JButton seat_2 = new JButton("2");
		seat_2.setBounds(86, 83, 50, 50);
		panel.add(seat_2);
		
		JButton seat_3 = new JButton("3");
		seat_3.setBounds(151, 83, 50, 50);
		panel.add(seat_3);
		
		JButton seat_4 = new JButton("4");
		seat_4.setBounds(213, 83, 50, 50);
		panel.add(seat_4);
		
		JButton seat_5 = new JButton("5");
		seat_5.setBounds(275, 83, 50, 50);
		panel.add(seat_5);
		
		JButton seat_6 = new JButton("6");
		seat_6.setBounds(24, 154, 50, 50);
		panel.add(seat_6);
		
		JButton seat_7 = new JButton("7");
		seat_7.setBounds(86, 154, 50, 50);
		panel.add(seat_7);
		
		JButton seat_8 = new JButton("8");
		seat_8.setBounds(151, 154, 50, 50);
		panel.add(seat_8);
		

		JButton seat_9 = new JButton("9");
		seat_9.setBounds(213, 154, 50, 50);
		panel.add(seat_9);
		
		JButton seat_10 = new JButton("10");
		seat_10.setBounds(275, 154, 50, 50);
		panel.add(seat_10);
		
		
		
		
	
	}
}
