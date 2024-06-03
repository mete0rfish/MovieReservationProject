package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repository.AdminPageRepository;
import Repository.JdbcConnect;

import java.awt.Panel;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class SeatSelectView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton selectedButton = null;
	private JButton seat_1 ,seat_2,seat_3 ,seat_4,seat_5,seat_6,seat_7,seat_8,seat_9,seat_10;
	private JLabel lblNewLabel_2;
	private int id;
	private int thtr_num;
	
	private static Statement stmt;
	private static ResultSet rs;

	public SeatSelectView(int s_id, String s_time, String s_date, String s_thtr, String s_day, String name) {
		id = s_id;
		thtr_num = Integer.parseInt(s_thtr);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(111, 73, 354, 251);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel Screen = new JPanel();
		Screen.setToolTipText("Screen");
		Screen.setBounds(24, 10, 301, 26);
		panel.add(Screen);
		JLabel lblNewLabel = new JLabel("SCREEN");
		Screen.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		
		
		
		seat_1 = new JButton("1");
		seat_1.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 1)) 
			seat_1.setBackground(Color.black);
		seat_1.setBounds(24, 83, 50, 50);
		seat_1.addActionListener(new SeatButtonListener());
		panel.add(seat_1);
		
		seat_2 = new JButton("2");
		seat_2.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 2)) 
			seat_2.setBackground(Color.black);
		seat_2.setBounds(86, 83, 50, 50);
		seat_2.addActionListener(new SeatButtonListener());
		panel.add(seat_2);
		
		seat_3 = new JButton("3");
		seat_3.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 3)) 
			seat_3.setBackground(Color.black);
		seat_3.setBounds(151, 83, 50, 50);
		seat_3.addActionListener(new SeatButtonListener());
		panel.add(seat_3);
		
		seat_4 = new JButton("4");
		seat_4.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 4)) 
			seat_4.setBackground(Color.black);
		seat_4.setBounds(213, 83, 50, 50);
		seat_4.addActionListener(new SeatButtonListener());
		panel.add(seat_4);
		
		seat_5 = new JButton("5");
		seat_5.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 5)) 
			seat_5.setBackground(Color.black);
		seat_5.setBounds(275, 83, 50, 50);
		seat_5.addActionListener(new SeatButtonListener());
		panel.add(seat_5);
		
		seat_6 = new JButton("6");
		seat_6.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 6)) 
			seat_6.setBackground(Color.black);
		seat_6.setBounds(24, 154, 50, 50);
		seat_6.addActionListener(new SeatButtonListener());
		panel.add(seat_6);
		
		seat_7 = new JButton("7");
		seat_7.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 7)) 
			seat_7.setBackground(Color.black);
		seat_7.setBounds(86, 154, 50, 50);
		seat_7.addActionListener(new SeatButtonListener());
		panel.add(seat_7);
		
		seat_8 = new JButton("8");
		seat_8.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 8)) 
			seat_8.setBackground(Color.black);
		seat_8.setBounds(151, 154, 50, 50);
		seat_8.addActionListener(new SeatButtonListener());
		panel.add(seat_8);
		

		seat_9 = new JButton("9");
		seat_9.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 9)) 
			seat_9.setBackground(Color.black);
		seat_9.setBounds(213, 154, 50, 50);
		seat_9.addActionListener(new SeatButtonListener());
		panel.add(seat_9);
		
		seat_10 = new JButton("10");
		seat_10.setBackground(new Color(221, 160, 221));
		if(!canReserveSeat((thtr_num-1)*10 + 10)) 
			seat_10.setBackground(Color.black);
		seat_10.setBounds(275, 154, 50, 50);
		seat_10.addActionListener(new SeatButtonListener());
		panel.add(seat_10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 347, 526, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton kakaoPay = new JButton("카카오페이");
		kakaoPay.setBounds(12, 10, 112, 39);
		kakaoPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				payButton(kakaoPay.getText(),"완료");
			}
		});
		panel_1.add(kakaoPay);
		
		JButton applePay = new JButton("에플페이");
		applePay.setBounds(136, 10, 112, 39);
		applePay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				payButton(applePay.getText(),"완료");
			}
		});
		panel_1.add(applePay);
		
		JButton naverPay = new JButton("네이버페이");
		naverPay.setBounds(260, 10, 112, 39);
		naverPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				payButton(naverPay.getText(),"완료");
			}
		});
		panel_1.add(naverPay);
		
		JButton cash = new JButton("현금");
		cash.setBounds(384, 10, 112, 39);
		cash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				payButton(cash.getText(),"미완료");
			}
		});
		panel_1.add(cash);
		
		JLabel lblNewLabel_1 = new JLabel(s_date+" "+s_day+" "+s_time+"  ["+name +"] "+s_thtr+"관");
		
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(60, 0, 514, 86);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("가격 : 16,000원");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(234, 417, 158, 36);
		contentPane.add(lblNewLabel_2);
	}
	
	
	private class SeatButtonListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JButton button = (JButton) e.getSource();
	        if(!canReserveSeat((thtr_num-1)*10 + Integer.parseInt(button.getText()))) {
	        	JOptionPane.showMessageDialog(null, "이미 예매된 좌석입니다", "이미 예매된 좌석", JOptionPane.WARNING_MESSAGE);
				return;
	        }
	        // 이전에 선택된 버튼이 있다면 색상을 원래대로 되돌림
	        if (selectedButton != null) {
	        	Color color = new Color(221,160,221);
	            selectedButton.setBackground(color);
	        }

	        // 선택된 버튼을 빨간색으로 변경
	        button.setBackground(Color.GRAY);
	        selectedButton = button; // 현재 선택된 버튼을 업데이트
	    }
	}
	
	private void payButton(String type, String state) {
		if(selectedButton == null) {
			JOptionPane.showMessageDialog(null, "좌석을 선택해주세요", "좌석 선택 안함", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int response = JOptionPane.showConfirmDialog(null,
                "정말로 결제하시겠습니까?",
                "결제창",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
		
		if (response == JOptionPane.YES_OPTION) {
			updateMSS();
			addReservation(type,state);
			addTicket();
			
			selectedButton.setBackground(Color.black);
			selectedButton = null;
			
        }
	}

	private void updateMSS() {
		int seat_id = (thtr_num-1)*10 +Integer.parseInt(selectedButton.getText());
		String sql = "update movie_schedule_seat set mss_seat_available = 0 where movie_schedule_ms_id = "+id+" and seat_seat_id = "+seat_id+";";
		System.out.println("id ="+id +"ssid = " +seat_id);
		System.out.println(sql);
		AdminPageRepository.executeQuery(sql);
	}
	private void addReservation(String type, String state) {
		//티켓의 PK 알아오기
		String sql = "SELECT MAX(tckt_id) as tckt_id FROM ticket;";
		int tcktId = -1;
		try {
			stmt = JdbcConnect.conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			tcktId = rs.getInt("tckt_id");
			System.out.println(tcktId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String pay = type;
		String payState = state;
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // 현재 시간을 "HH:mm:ss" 형식의 문자열로 포맷팅
        String formattedTime = currentTime.format(formatter);
		
		sql = "insert into reservation (r_payment,r_pay_status,r_pay_amount,r_pay_date,User_user_id,movie_schedule_ms_id,Ticket_tckt_id) values ('"+
		pay+"','"+payState+"',14000,'2023-06-01 "+formattedTime+"',1,"+id+","+tcktId+");";
		System.out.println(sql);
		AdminPageRepository.executeQuery(sql);
	}
	
	private void addTicket() {
		int seat_id = (thtr_num-1)*10 +Integer.parseInt(selectedButton.getText());
		
		String sql = "insert into Ticket (tckt_availability,tckt_standard_price,tckt_selling_price,seat_seat_id,movie_schedule_ms_id) "
				+ "values (0,16000,16000,"+seat_id+","+id+");";
				
		System.out.println(sql);
		AdminPageRepository.executeQuery(sql);
		
	}
	
	private boolean canReserveSeat(int seat_id) {
		String sql = "select mss_seat_available from movie_schedule_seat where movie_schedule_ms_id ="+id+" and seat_seat_id = "+seat_id+";";
		System.out.println(sql);
		try {
			stmt = JdbcConnect.conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println(rs.getInt("mss_seat_available"));
			if(rs.getInt("mss_seat_available") == 1)
				return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
