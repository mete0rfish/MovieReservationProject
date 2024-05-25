package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Repository.AdminPageRepository;

public class AdminPage extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfQuery;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewWindowBuilder frame = new AdminViewWindowBuilder();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInit = new JButton("초기화");
		btnInit.setBounds(28, 10, 178, 78);
		contentPane.add(btnInit);
		
		JButton btnCUD = new JButton("입력/삭제/변경");
		btnCUD.setBounds(312, 10, 178, 78);
		contentPane.add(btnCUD);
		
		JButton btnReadAllTable = new JButton("전체 테이블 보기");
		btnReadAllTable.setBounds(587, 10, 149, 78);
		contentPane.add(btnReadAllTable);
		
		JPanel pnShowAllTable = new JPanel();
		pnShowAllTable.setBounds(12, 136, 762, 417);
		contentPane.add(pnShowAllTable);
		pnShowAllTable.setLayout(null);
		pnShowAllTable.setVisible(false);
		
		JList listTable = new JList();
		listTable.setFont(new Font("Gulim", Font.PLAIN, 18));
		listTable.setModel(new AbstractListModel() {
			String[] values = new String[] {"movie", "movie_schedule", "user", "reservation", "theater", "seat", "movie_schedule_seat", "ticket"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listTable.setBounds(33, 10, 717, 263);
		listTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pnShowAllTable.add(listTable);
		
		JButton btnShowTableContent = new JButton("테이블 내용 보기");
		btnShowTableContent.setBounds(266, 312, 233, 56);
		pnShowAllTable.add(btnShowTableContent);
		
		JPanel pnInit = new JPanel();
		pnInit.setBounds(28, 152, 720, 372);
		contentPane.add(pnInit);
		pnInit.setLayout(null);
		pnInit.setVisible(false);
		
		JLabel lblInitFinish = new JLabel("초기화되었습니다");
		lblInitFinish.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblInitFinish.setBounds(230, 120, 318, 102);
		pnInit.add(lblInitFinish);
		
		JPanel pnQuery = new JPanel();
		pnQuery.setBounds(0, 114, 774, 391);
		pnQuery.setVisible(false);
		contentPane.add(pnQuery);
		pnQuery.setLayout(null);
		
		
		tfQuery = new JTextField();
		tfQuery.setBounds(54, 45, 708, 161);
		pnQuery.add(tfQuery);
		tfQuery.setColumns(10);
		
		JButton btnExecute = new JButton("실행");
		btnExecute.setBounds(285, 243, 206, 71);
		pnQuery.add(btnExecute);
		
		btnInit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AdminPageRepository.ExecuteInitSql();
					pnInit.setVisible(true);
					pnQuery.setVisible(false);
					pnShowAllTable.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		btnCUD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnInit.setVisible(false);
				pnQuery.setVisible(true);
				pnShowAllTable.setVisible(false);
			}
			
		});
		
		btnExecute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 쿼리 받아서 Repository로 넘겨주기
				String sql = tfQuery.getText();
				AdminPageRepository.executeQuery(sql);
			}
			
		});
		
		btnReadAllTable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnInit.setVisible(false);
				pnQuery.setVisible(false);
				pnShowAllTable.setVisible(true);
			}
			
		});
		
		btnShowTableContent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 리스트에서 테이블 명 받아오기
				String selectedValue = (String) listTable.getSelectedValue();
				System.out.println("선택됨: " + selectedValue);
				// TableContentView 실행하기 + 인자로 이름 넘기기
				TableContentView tableContentView;
				try {
					tableContentView = new TableContentView(selectedValue);
					tableContentView.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
}
