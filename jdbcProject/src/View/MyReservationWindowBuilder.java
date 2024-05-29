package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Repository.AdminPageRepository;
import Repository.JdbcConnect;
import Repository.ReservationRepository;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class MyReservationWindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdbcConnect.userJdbcConnect();
					MyReservationWindowBuilder frame = new MyReservationWindowBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MyReservationWindowBuilder() throws SQLException {
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
				
				dispose();
			}
		});
		panel_1.add(btnMyRes);
		panel.setLayout(null);
		
		DefaultTableModel tableModel = initTable();
		
		JTable table = new JTable(tableModel);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2) {
					JOptionPane.showMessageDialog(null, "안녕하세요");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		
			
		});
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(0, 0, 762, 391);
		panel.add(scrollpane);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("Gulim", Font.PLAIN, 20));
		btnDelete.setBounds(12, 401, 87, 44);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("변경");
		btnUpdate.setFont(new Font("Gulim", Font.PLAIN, 20));
		btnUpdate.setBounds(111, 401, 111, 44);
		panel.add(btnUpdate);
		
		JLabel lblTips = new JLabel("* 자세한 예매 정보는 더블클릭하세요");
		lblTips.setFont(new Font("Gulim", Font.PLAIN, 23));
		lblTips.setBounds(333, 38, 426, 45);
		contentPane.add(lblTips);
	}
	
	private DefaultTableModel initTable() throws SQLException {
		ArrayList<HashMap<String, Object>> res = ReservationRepository.findAll();
		
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
					return false;
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

