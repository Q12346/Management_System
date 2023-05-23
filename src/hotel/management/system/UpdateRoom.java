package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener
{
	Choice ccustomer;
	JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
	JButton check,update,back;
	
	UpdateRoom()
	{
		getContentPane().setBackground(Color.cyan);
		setLayout(null);
		
		JLabel text = new JLabel("Update Room Status");
		text.setFont(new Font("Tahoma",Font.BOLD,25));
		text.setBounds(30,20,300,30);
		text.setForeground(Color.red);
		add(text);
		
		JLabel lblid = new JLabel("Customer Id");
		lblid.setFont(new Font("Tahoma",Font.BOLD,15));
		lblid.setBounds(30,80,100,30);
		lblid.setForeground(Color.black);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200,83,150,30);
		ccustomer.setFont(new Font("Tahoma",Font.BOLD,14));
		add(ccustomer);
		
		try
		{
			 Conn c = new Conn();
			 
			 ResultSet rs = c.s.executeQuery("select * from customer");
			 while(rs.next())
			 {
				 ccustomer.add(rs.getString("number"));
			 }
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setFont(new Font("Tahoma",Font.BOLD,15));
		lblroom.setBounds(30,130,150,30);
		lblroom.setForeground(Color.black);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,130,150,30);
		tfroom.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfroom);
		
		
		JLabel lblname = new JLabel("Availability");
		lblname.setFont(new Font("Tahoma",Font.BOLD,15));
		lblname.setBounds(30,180,150,30);
		lblname.setForeground(Color.black);
		add(lblname);
		
		tfavailable = new JTextField();
		tfavailable.setBounds(200,180,150,30);
		tfavailable.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfavailable);
		
		
		JLabel lblcheckin = new JLabel("Cleaning Status");
		lblcheckin.setFont(new Font("Tahoma",Font.BOLD,15));
		lblcheckin.setBounds(30,230,150,30);
		lblcheckin.setForeground(Color.black);
		add(lblcheckin);
		
		tfstatus = new JTextField();
		tfstatus.setBounds(200,230,150,30);
		tfstatus.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfstatus);
		
		
		check = new JButton("Check");
		check.setBackground(Color.green);
		check.setForeground(Color.white);
		check.setBounds(30,330,100,30);
		check.setFont(new Font("Tahoma",Font.BOLD,15));
		check.addActionListener(this);
		add(check);
		
		 update = new JButton("Update");
		 update.setBackground(Color.blue);
		 update.setForeground(Color.white);
		 update.setBounds(150,330,100,30);
		 update.setFont(new Font("Tahoma",Font.BOLD,15));
		 update.addActionListener(this);
		add(update);
		
		 back = new JButton("Back");
		 back.setBackground(Color.red);
		 back.setForeground(Color.white);
		 back.setBounds(270,330,100,30);
		 back.setFont(new Font("Tahoma",Font.BOLD,15));
		 back.addActionListener(this);
		add(back);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,60,500,300);
		add(image);
		
		
		setBounds(250,160,980,500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		
		if(ae.getSource() == check)
		{
			String id =ccustomer.getSelectedItem();
			String query = "select * from customer where number = '"+id+"'";
			try
			{
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next())
				{
					tfroom.setText(rs.getString("room"));
				}
				
				ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
				while(rs2.next())
				{
					tfavailable.setText(rs2.getString("availability"));
					tfstatus.setText(rs2.getString("cleaning_status"));
					
					
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == update)
		{
			String number = ccustomer.getSelectedItem();
			String room = tfroom.getText();
			String available = tfavailable.getText();
			String status = tfstatus.getText();
		
			
			try
			{
				Conn c = new Conn();
				c.s.executeUpdate("update room set availability ='"+available+"',cleaning_status = '"+status+"' where roomnumber ='"+room+"'");
                
				JOptionPane.showMessageDialog(null, "Data Upadted Successfully");
				
				setVisible(false);
				new Reception();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else 
		{
			setVisible(false);
			new Reception();
		}
	}
	public static void main(String[] args) 
	{
       new UpdateRoom();
	}

}
