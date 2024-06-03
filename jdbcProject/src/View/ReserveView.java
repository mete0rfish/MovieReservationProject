package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Repository.MovieScheduleRepository;
import Repository.ReservationRepository;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReserveView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private String mName;
	private JButton reserveButton;
	private JLabel lblNewLabel;

	public ReserveView(String movieName) throws SQLException {
		mName = movieName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(35, 98, 577, 410);
		contentPane.add(panel);
		
		
		
		
		JLabel movieNameLabel = new JLabel("["+movieName +"]의 상영시간표");
		movieNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 31));
		movieNameLabel.setBounds(208, 21, 468, 67);
		contentPane.add(movieNameLabel);
		
		DefaultTableModel tableModel = initTable();
		
		table = new JTable(tableModel);
		panel.add(table);
		
		reserveButton = new JButton("예매하기");
		reserveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserveButtonEvent();
			}
		});
		reserveButton.setBounds(624, 98, 150, 67);
		contentPane.add(reserveButton);
		
		lblNewLabel = new JLabel("현재 날짜 : 2023/06/01");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel.setBounds(35, 0, 391, 67);
		contentPane.add(lblNewLabel);
	}
	
	
	private DefaultTableModel initTable() throws SQLException {
		ArrayList<HashMap<String, Object>> res = MovieScheduleRepository.findMovieScheduleByName(mName);
		
		if(res.size() <= 0)
			return null;
		// 칼럼 명과 첫번째 HashMap 추출
		HashMap<String, Object> firstRow = res.get(0);
		String[] columnNames = firstRow.keySet().toArray(new String[0]);
		
		//System.out.println(firstRow.toString());
		
		// table 모델 생성
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
			
			 @Override
	            public boolean isCellEditable(int row, int column) {
	                return false; // 모든 셀을 수정 불가로 설정
			 }
		};
		
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
	
	private void reserveButtonEvent() {
		int selectedRow = table.getSelectedRow();
		if(selectedRow == -1) {
			JFrame frame = new JFrame("경고!");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setSize(300, 200);
	        // 경고 메시지 다이얼로그 표시
	        JOptionPane.showMessageDialog(frame, "원하는 상영시간을 선택하시오", "선택되지 않음", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int s_id = (int) table.getValueAt(selectedRow, 0);
		String s_time = table.getValueAt(selectedRow, 1).toString();
		String s_date = table.getValueAt(selectedRow, 3).toString();
		String s_thtr = table.getValueAt(selectedRow, 4).toString();
		String s_day = (String) table.getValueAt(selectedRow, 5);
		
		SeatSelectView seatSelectView = new SeatSelectView(s_id,s_time,s_date,s_thtr,s_day , mName);
		seatSelectView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		seatSelectView.setVisible(true);
	}
}
