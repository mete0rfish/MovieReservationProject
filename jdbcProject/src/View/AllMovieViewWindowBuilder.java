package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repository.JdbcConnect;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class AllMovieViewWindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JdbcConnect.userJdbcConnect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllMovieViewWindowBuilder frame = new AllMovieViewWindowBuilder();
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
	public AllMovieViewWindowBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel viewPanel = new JPanel();
		viewPanel.setBackground(new Color(128, 128, 128));
		viewPanel.setBounds(12, 98, 762, 455);
		contentPane.add(viewPanel);
		
		table = new JTable();
		viewPanel.add(table);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 20, 268, 57);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("모든 영화 ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableContentView tableContentView;
				try {
					tableContentView = new TableContentView("movie");
					tableContentView.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBackground(new Color(92, 92, 92));
		buttonPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("내 예약");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		buttonPanel.add(btnNewButton_1);
		
		searchField = new JTextField();
		searchField.setBounds(392, 39, 299, 38);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("검색");
		searchButton.setBounds(691, 39, 67, 38);
		contentPane.add(searchButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"영화명", "감독명", "배우명", "장르"}));
		comboBox.setBounds(295, 39, 95, 38);
		contentPane.add(comboBox);
	}
}
