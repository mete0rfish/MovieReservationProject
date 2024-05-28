package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;

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
import javax.swing.table.DefaultTableModel;

import Repository.AdminPageRepository;
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
	private JTextField searchField;
	private JComboBox comboBox;
	private JButton searchButton;
	private JPanel viewPanel;
	private JPanel buttonPanel;
	private JTable table;

	public AllMovieView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		viewPanel = new JPanel();
		viewPanel.setBackground(new Color(128, 128, 128));
		viewPanel.setBounds(12, 98, 762, 455);
		contentPane.add(viewPanel);
		
		allMovieButton();
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 20, 268, 57);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("모든 영화 ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allMovieButton();
			}
		});
		btnNewButton.setBackground(new Color(92, 92, 92));
		buttonPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("내 예약");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyReservationView myRes;
				try {
					myRes = new MyReservationView();
					myRes.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonPanel.add(btnNewButton_1);
		
		searchField = new JTextField();
		searchField.setBounds(392, 39, 299, 38);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("검색");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMovieButton();
			}
		});
		searchButton.setBounds(691, 39, 67, 38);
		contentPane.add(searchButton);
	
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"영화명", "감독명", "배우명", "장르"}));
		comboBox.setBounds(295, 39, 95, 38);
		contentPane.add(comboBox);
	}
	
	
	
private DefaultTableModel initTable(String tableName) throws SQLException {
		
		ArrayList<HashMap<String, Object>> res = AdminPageRepository.findAllByName(tableName);
		
		if(res.size() <= 0)
			return null;
		// 칼럼 명과 첫번째 HashMap 추출
		HashMap<String, Object> firstRow = res.get(0);
		String[] columnNames = firstRow.keySet().toArray(new String[0]);
		
		//System.out.println(firstRow.toString());
		
		// table 모델 생성
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		// 테이블 모델에 투플 추가
		for (HashMap<String, Object> rowMap : res) {
            Object[] rowData = new Object[columnNames.length];
            for (int i = 0; i < columnNames.length; i++) {
                rowData[i] = rowMap.get(columnNames[i]);
            }
            tableModel.addRow(rowData);
        }
		return tableModel;
	}
	
	private DefaultTableModel findMovieTable(String name,String keyword) throws SQLException {
		
		ArrayList<HashMap<String, Object>> res = AdminPageRepository.findMovieByName(name,keyword);
		
		if(res.size() <= 0)
			return null;
		// 칼럼 명과 첫번째 HashMap 추출
		HashMap<String, Object> firstRow = res.get(0);
		String[] columnNames = firstRow.keySet().toArray(new String[0]);
		
		System.out.println(firstRow.toString());
		
		// table 모델 생성
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		// 테이블 모델에 투플 추가
		for (HashMap<String, Object> rowMap : res) {
            Object[] rowData = new Object[columnNames.length];
            for (int i = 0; i < columnNames.length; i++) {
                rowData[i] = rowMap.get(columnNames[i]);
            }
            tableModel.addRow(rowData);
        }
		return tableModel;
	}
	private void searchMovieButton() {
		try {
			String comboBoxName = (String)comboBox.getSelectedItem();
			String name;
			switch(comboBoxName) {
			case"영화명":
				name = "m_name";
				break;
			case"감독명":
				name = "m_director";
				break;
			case"배우명":
				name = "m_actor";
				break;
			case"장르":
				name = "m_genre";
				break;
			default:
				name = "m_name";
				break;
			}
			
			DefaultTableModel tableModel = findMovieTable(name,searchField.getText());
			table = new JTable(tableModel);
			table.setBounds(22, 105, 741, 448);
			viewPanel.removeAll();
			viewPanel.add(table);
			viewPanel.revalidate();
			viewPanel.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void allMovieButton() {
		DefaultTableModel tableModel = null;
		try {
			tableModel = initTable("movie");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable(tableModel);
		table.setBounds(22, 105, 741, 448);
		viewPanel.removeAll();
		viewPanel.add(table);
		viewPanel.revalidate();
		viewPanel.repaint();
	}
}
