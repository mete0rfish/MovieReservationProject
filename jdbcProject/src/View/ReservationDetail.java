package View;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Repository.MovieScheduleRepository;
import Repository.ReservationRepository;

public class ReservationDetail extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public ReservationDetail(int id) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel tableModel = initTable(id);
		
		table = new JTable(tableModel);
		table.setBounds(34, 129, 723, 211);
		contentPane.add(table);
	}
	
	private DefaultTableModel initTable(int id) throws SQLException {
		ArrayList<HashMap<String, Object>> res = ReservationRepository.findById(id);
		
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
}
