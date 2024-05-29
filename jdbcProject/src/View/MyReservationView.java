package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Repository.ReservationRepository;

public class MyReservationView extends JFrame{
	private static final int SELCTED_SAME_MOVIE = 1;
	private static final int SELCTED_OTHER_MOVIE = 2;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;

	public MyReservationView() throws SQLException {
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
		btnAllMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 모든 영화로 이동하기
				AllMovieView allMovie = new AllMovieView();
				allMovie.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnMyRes = new JButton("내 예약");
		panel_1.add(btnMyRes);
		panel.setLayout(null);
		
		tableModel = initTable();
		
		table = new JTable(tableModel);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					//String movieName = (String) table.getValueAt(row, );
					int msId = (int) table.getValueAt(row, 0);
					System.out.println(msId);
					try {
						ReservationDetail rd = new ReservationDetail(msId);
						rd.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 
				try {
					deleteReservation();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("변경");
		btnUpdate.setFont(new Font("Gulim", Font.PLAIN, 20));
		btnUpdate.setBounds(111, 401, 111, 44);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateReservation();
			}
		});
		panel.add(btnUpdate);
		
		JLabel lblTips = new JLabel("* 자세한 예매 정보는 더블클릭하세요");
		lblTips.setFont(new Font("Gulim", Font.PLAIN, 23));
		lblTips.setBounds(333, 38, 426, 45);
		contentPane.add(lblTips);
	}
	
	private void updateReservation() {
		int[] nSelectedRow = table.getSelectedRows();
		if(nSelectedRow.length != 1) {
			JOptionPane.showMessageDialog(null, "한 개만 선택해주세요", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String[] answer={"다른 일정", "다른 영화"};
		int selected = JOptionPane.showOptionDialog(this, "같은 영화의 다른 일정, 다른 영화 중 선택하세요.", "Option"
				,JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, null );
		
		// TODO 입력에 따른 예매 변경으로 이동
		if(selected == 0) {
			
		}
	}
	
	private void deleteReservation() throws NumberFormatException, SQLException {
		int[] nSelectedRow = table.getSelectedRows();
		 
        for (int i : nSelectedRow) {
            String str = table.getModel().getValueAt(i, 8).toString();
            int id = Integer.parseInt(str);
            System.out.println("ID: " + id);
            ReservationRepository.deleteReservationById(id);
        }
        tableModel = initTable();
        table.setModel(tableModel);
        JOptionPane.showMessageDialog(null, "삭제되었습니다.");
	}
	
	private DefaultTableModel initTable() throws SQLException {
		ArrayList<HashMap<String, Object>> res = ReservationRepository.findAll();
		
		if(res.size() <= 0)
			return new DefaultTableModel();
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
