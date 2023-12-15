package emp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import emp.DeleteEmployee.DeleteEmp;

public class EditEmployee implements ActionListener{

	private JFrame frame;
	public JTextField IDTextField;
	public JButton btnSubmit;
	public static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmployee window = new EditEmployee();
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
	public EditEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmpID = new JLabel("Enter Employee ID :");
		lblEmpID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmpID.setBounds(36, 68, 165, 36);
		frame.getContentPane().add(lblEmpID);
		
		IDTextField = new JTextField();
		IDTextField.setBounds(201, 77, 149, 20);
		frame.getContentPane().add(IDTextField);
		IDTextField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[] {});
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(43, 170, 108, 41);
		frame.getContentPane().add(btnBack);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSubmit.setBounds(201, 170, 156, 41);
		frame.getContentPane().add(btnSubmit);
		frame.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		String text=IDTextField.getText();
		if(text==null||text.trim().equals("")){
			JOptionPane.showMessageDialog(btnSubmit,"Please enter id first!");
		}
		else
		{
			id=Integer.parseInt(text);
	
			try {
				ResultSet rs=EmployeeDao.compareId(id);
				if(rs.next()==false)
				{
					JOptionPane.showMessageDialog(null,"Please, Enter a valid ID.");
					IDTextField.setText(null);
				}
				else
				{
					EditEmp.main(new String[] {});
					frame.dispose();
				}
			}	
			catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
	
