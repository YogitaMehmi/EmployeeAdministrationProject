package emp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSuccess {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSuccess window = new AdminSuccess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSuccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Employee Management Sysytem");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 21, 434, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnViewEmp = new JButton("View All Employees");
		btnViewEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmployee.main(new String[] {});
			}
		});
		btnViewEmp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnViewEmp.setBounds(133, 92, 182, 39);
		frame.getContentPane().add(btnViewEmp);
		
		JButton btnAddEmp = new JButton("Add An Employee");
		btnAddEmp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee.main(new String[] {});
				frame.dispose();
			}
		});
		btnAddEmp.setBounds(133, 142, 182, 39);
		frame.getContentPane().add(btnAddEmp);
		
		JButton btnEditEmp = new JButton("Edit An Employee");
		btnEditEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEmployee.main(new String[] {});
			}
		});
		btnEditEmp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEditEmp.setBounds(133, 192, 182, 39);
		frame.getContentPane().add(btnEditEmp);
		
		JButton btnDeleteEmp = new JButton("Delete An Employee");
		btnDeleteEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployee.main(new String[] {});
			}
		});
		btnDeleteEmp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDeleteEmp.setBounds(133, 242, 182, 39);
		frame.getContentPane().add(btnDeleteEmp);
		
		JButton btnExitSystem = new JButton("Exit");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExitSystem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnExitSystem.setBounds(133, 298, 182, 39);
		frame.getContentPane().add(btnExitSystem);
	}
}
