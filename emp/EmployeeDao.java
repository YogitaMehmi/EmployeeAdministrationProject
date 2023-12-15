package emp;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class EmployeeDao {
	
	public static void viewRecord() {
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			boolean status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
	}
	
	public static void addEmp(int ID, String name ,String gender, int ph, String mail, String Designation, double Salary) {
		
		if(Integer.toString(ID).equals(""))
			System.out.println("Enter a valid ID!!!!");
		else
		{
			int status;
			try{
				ResultSet rs=compareId(ID);
				if(rs.next())
				{	
					JOptionPane.showMessageDialog(null,"Please, Enter a unique ID.");
				}
				else
				{
					Connection con=DB.getConnection();
					PreparedStatement ps=con.prepareStatement("insert into employee(id,name,gender,phoneNum,email,designation,salary) values(?,?,?,?,?,?,?);");
					ps.setInt(1,ID);
					ps.setString(2,name);
					ps.setString(3,gender);
					ps.setInt(4,ph);
					ps.setString(5,mail);
					ps.setString(6,Designation);
					ps.setDouble(7,Salary);
					status = ps.executeUpdate();
					
					if(status==1)
					{
						JOptionPane.showMessageDialog(null, "Employee added successfully!!!!!");
						AddEmployee.frame.dispose();
						AdminSuccess.main(new String[] {});
					}
					else
						JOptionPane.showMessageDialog(null,"Please, Enter all details.");
					con.close();
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Invalid details!!!!!!!");
			}
			catch(SQLException e)
			{
				System.out.println("Exception thrown");
			}
			catch(Exception e)
			{
				System.out.println("Exception thrown");
			}
		}			
	}
	
	public static ResultSet compareId(int ID)
	{
		ResultSet rs = null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select id from employee where id=?;");
			ps.setInt(1,ID);
			rs = ps.executeQuery();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Enter valid ID!!!!!!!");
		}
		return rs;
	}
	
	public static void uniqueId(ResultSet rs) throws HeadlessException, SQLException
	{
		if(rs.next())
			JOptionPane.showMessageDialog(null,"Please, Enter a unique ID.");
	}

	public static void updateEmp(int id, String n, String gender,int ph, String email_address, String d, double s)
	{
		int status;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("update employee set name=?,gender=?,phoneNum=?,email=?,designation=?,salary=? where id=?");
			ps.setString(1,n);
			ps.setString(2,gender);
			ps.setInt(3,ph);
			ps.setString(4,email_address);
			ps.setString(5,d);
			ps.setDouble(6,s);
			ps.setInt(7,id);
			status = ps.executeUpdate();
			if(status==1)
			{
				JOptionPane.showMessageDialog(null, "Employee details updated successfully!!!!!");
			}
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Sorry, unable to update value!!!!!");
		}
	}
}
