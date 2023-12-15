package emp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employee{

	private JFrame frame;
	private JTextField AdminUsername;
	private JTextField AdminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
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
	public Employee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsername.setBounds(46, 55, 84, 30);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(46, 131, 78, 30);
		frame.getContentPane().add(lblPassword);
		
		AdminUsername = new JTextField();
		AdminUsername.setBounds(171, 54, 176, 35);
		frame.getContentPane().add(AdminUsername);
		AdminUsername.setColumns(10);
		
		AdminPassword = new JPasswordField();
		AdminPassword.setColumns(10);
		AdminPassword.setBounds(171, 130, 176, 35);
		frame.getContentPane().add(AdminPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=AdminUsername.getText();
				String password=String.valueOf(((JPasswordField) AdminPassword).getPassword());
				
				if(username.equals(""))
//				if(username == null)
					JOptionPane.showMessageDialog(btnSubmit,"Please enter username.");
					
				else if(AdminDao.validateAdmin(username, password))
				{		AdminSuccess.main(new String[] {});frame.dispose();}
				
				else 
				{
					if(AdminDao.validateUsername(username) == false)
					{
						JOptionPane.showMessageDialog(btnSubmit,"The username you entered does not exist.");
						AdminUsername.setText("");
					}
					else
					{
						if(password.equals(""))
							JOptionPane.showMessageDialog(btnSubmit,"Please enter the password.");
						else
						{
							JOptionPane.showMessageDialog(btnSubmit,"The password you entered is invalid.\n Please try again!!!");
							AdminPassword.setText("");
						}
					}
				}
			}
		});
		btnSubmit.setBackground(SystemColor.activeCaption);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSubmit.setBounds(171, 202, 101, 35);
		frame.getContentPane().add(btnSubmit);
		
		
	}
}
