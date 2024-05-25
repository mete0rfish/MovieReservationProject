package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Repository.AdminPageRepository;

public class TableContentView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public TableContentView(String tableName) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultTableModel tableModel = initTable(tableName);
		
		table = new JTable(tableModel);
		table.setBounds(22, 105, 741, 448);
		contentPane.add(table);
		
//		JScrollPane scrollPane = new JScrollPane(table);
//		contentPane.add(scrollPane, BorderLayout.CENTER);
//		
		JLabel lblTableName = new JLabel(tableName);
		lblTableName.setFont(new Font("Gulim", Font.PLAIN, 32));
		lblTableName.setBounds(270, 23, 441, 66);
		contentPane.add(lblTableName);
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
}
