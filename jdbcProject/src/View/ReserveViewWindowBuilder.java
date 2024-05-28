package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class ReserveViewWindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReserveViewWindowBuilder frame = new ReserveViewWindowBuilder();
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
	public ReserveViewWindowBuilder() {
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
		
		table = new JTable();
		panel.add(table);
		
		JLabel movieName = new JLabel("현재 [영화이름] 상영표");
		movieName.setFont(new Font("맑은 고딕", Font.PLAIN, 31));
		movieName.setBounds(208, 21, 468, 67);
		contentPane.add(movieName);
	}
}
