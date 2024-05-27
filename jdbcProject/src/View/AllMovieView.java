package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Repository.MovieRepository;

/*
 * TODO
 * 1. 내예약 눌르면 이동 (대기)
 * 2. 전체 영화 리스트 띄우기 (완, 테스트 필요)
 * 3. 영화명으로 검색하여 리스트 띄우기
 * 4. 감독명으로 검색하여 리스트 띄우기
 * 5. 배우명으로 검색하여 리스트 띄우기
 * 6. 장르으로 검색하여 리스트 띄우기
 */

public class AllMovieView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public AllMovieView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(12, 98, 762, 455);
		contentPane.add(panel);
		
		String header[] = {"영화명", "감독명", "장르", "상영시간","상영등급", "개봉일","배우명","영화정보","평점"};
		String contents[][] = MovieRepository.findAll();
		
		JTable table = new JTable();
		JScrollPane scrollpane = new JScrollPane(table);
		panel.add(scrollpane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 20, 268, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnAllMovie = new JButton("모든 영화 ");
		btnAllMovie.setBackground(new Color(92, 92, 92));
		panel_1.add(btnAllMovie);
		
		JButton btnMyRes = new JButton("내 예약");
		btnMyRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 내예약으로 이동하기
				MyReservationView myRes;
				try {
					myRes = new MyReservationView();
					myRes.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		panel_1.add(btnMyRes);
		
		textField = new JTextField();
		textField.setBounds(392, 39, 299, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(691, 39, 67, 38);
		contentPane.add(btnSearch);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"영화명", "감독명", "배우명", "장르"}));
		comboBox.setBounds(295, 39, 95, 38);
		contentPane.add(comboBox);
		
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from movie where ";
				String searchText = textField.getText();
				String selectedItem = (String) comboBox.getSelectedItem();
				switch(selectedItem) {
				case "영화명":
					sql += "영화명 = '%" + searchText + "%';";
					break;
				case "감독명":
					sql += "감독명 = '%" + searchText + "%';";
					break;
				case "배우명":
					sql += "배우명 = '%" + searchText + "%';";
					break;
				case "장르":
					sql += "장르 = '%" + searchText + "%';";
					break;
				default:
					break;
				}
				// TODO  sql문으로 영화 리스트 받아오기
				
			}
			
		});
	}
}
