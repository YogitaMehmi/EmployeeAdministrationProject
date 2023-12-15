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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditEmp implements ActionListener{
	private JFrame frame;
	public JTextField textField_1;
	public  JTextField textField_3;
	public  JTextField textField_4;
	public  JTextField textField_5;
	public  JTextField textField_6;
	public JComboBox comboBox;
	String n,gender,email_address,d;
	int ph;
	double s;
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmp window = new EditEmp();
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
	public EditEmp() {
		initialize();
		dispValue();
	}

	private void dispValue() {
		ResultSet rs;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from employee where id=?;");
			ps.setInt(1, EditEmployee.id);
			rs = ps.executeQuery();
			while(rs.next())
			{                         
				textField_1.setText(rs.getString(2));
//				comboBox.setSelectedItem(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
				textField_5.setText(rs.getString(6));
				textField_6.setText(rs.getString(7));
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEnterName.setBounds(43, 138, 120, 47);
		frame.getContentPane().add(lblEnterName);
		
		JLabel lblEnterGender = new JLabel("Enter Gender");
		lblEnterGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEnterGender.setBounds(43, 196, 120, 47);
		frame.getContentPane().add(lblEnterGender);
		
		JLabel lblEnterPhone = new JLabel("Enter Phone Number");
		lblEnterPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEnterPhone.setBounds(43, 254, 120, 47);
		frame.getContentPane().add(lblEnterPhone);
		
		JLabel lblEnterEmailAddress = new JLabel("Enter Email Address");
		lblEnterEmailAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEnterEmailAddress.setBounds(43, 312, 120, 47);
		frame.getContentPane().add(lblEnterEmailAddress);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDesignation.setBounds(43, 374, 120, 47);
		frame.getContentPane().add(lblDesignation);
		
		JLabel lblEnterSalary = new JLabel("Enter Salary($)");
		lblEnterSalary.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEnterSalary.setBounds(43, 434, 120, 47);
		frame.getContentPane().add(lblEnterSalary);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 145, 265, 34);
		frame.getContentPane().add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(259, 261, 265, 34);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(259, 319, 265, 34);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(259, 381, 265, 34);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(259, 441, 265, 34);
		frame.getContentPane().add(textField_6);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox.addItem("male");
		comboBox.addItem("female");
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setEditable(true);
		comboBox.setMaximumRowCount(3);
		comboBox.setToolTipText("Male");
		comboBox.setBounds(259, 203, 257, 35);
		frame.getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[] {});
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(43, 499, 154, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSubmit.setBounds(277, 499, 178, 41);
		frame.getContentPane().add(btnSubmit);
		frame.setVisible(true);
		
	}
		
	public void actionPerformed(ActionEvent e) {
		n=textField_1.getText();
		gender=String.valueOf(comboBox.getSelectedItem());
		ph=Integer.parseInt(textField_3.getText());
		email_address=textField_4.getText();
		d=textField_5.getText();
		s=Double.parseDouble(textField_6.getText());
		
		try {
			EmployeeDao.updateEmp(EditEmployee.id,n,gender,ph,email_address,d,s);
			frame.dispose();
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Please, Enter all details.");
		}
	}
}
