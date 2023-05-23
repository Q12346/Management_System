package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener
{
	Choice ccustomer;
	JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
	JButton check,update,back;
	
	UpdateCheck()
	{
		getContentPane().setBackground(Color.green);
		setLayout(null);
		
		JLabel text = new JLabel("Update Status");
		text.setFont(new Font("Tahoma",Font.BOLD,25));
		text.setBounds(190,10,200,30);
		text.setForeground(Color.blue);
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
		lblroom.setBounds(30,120,150,30);
		lblroom.setForeground(Color.black);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,120,150,30);
		tfroom.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfroom);
		
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma",Font.BOLD,15));
		lblname.setBounds(30,160,150,30);
		lblname.setForeground(Color.black);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,150,30);
		tfname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfname);
		
		
		JLabel lblcheckin = new JLabel("Checkin Time");
		lblcheckin.setFont(new Font("Tahoma",Font.BOLD,15));
		lblcheckin.setBounds(30,200,150,30);
		lblcheckin.setForeground(Color.black);
		add(lblcheckin);
		
		tfcheckin = new JTextField();
		tfcheckin.setBounds(200,200,150,30);
		tfcheckin.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfcheckin);
		
		JLabel lblpaid = new JLabel("Paid Amount ");
		lblpaid.setFont(new Font("Tahoma",Font.BOLD,15));
		lblpaid.setBounds(30,240,150,30);
		lblpaid.setForeground(Color.black);
		add(lblpaid);
		
		tfpaid = new JTextField();
		tfpaid.setBounds(200,240,150,30);
		tfpaid.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfpaid);
		
		JLabel lblpending = new JLabel("Pending Amount");
		lblpending.setFont(new Font("Tahoma",Font.BOLD,15));
		lblpending.setBounds(30,280,150,30);
		lblpending.setForeground(Color.black);
		add(lblpending);
		
		tfpending = new JTextField();
		tfpending.setBounds(200,280,150,30);
		tfpending.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfpending);
		
		check = new JButton("Check");
		check.setBackground(Color.MAGENTA);
		check.setForeground(Color.white);
		check.setBounds(30,355,100,30);
		check.setFont(new Font("Tahoma",Font.BOLD,16));
		check.addActionListener(this);
		add(check);
		
		 update = new JButton("Update");
		 update.setBackground(Color.blue);
		 update.setForeground(Color.white);
		 update.setBounds(150,355,100,30);
		 update.setFont(new Font("Tahoma",Font.BOLD,16));
		 update.addActionListener(this);
		add(update);
		
		 back = new JButton("Back");
		 back.setBackground(Color.red);
		 back.setForeground(Color.white);
		 back.setBounds(270,355,100,30);
		 back.setFont(new Font("Tahoma",Font.BOLD,16));
		 back.addActionListener(this);
		add(back);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,83,500,300);
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
				ResultSet rs1 = c.s.executeQuery(query);
				while(rs1.next())
				{
					tfroom.setText(rs1.getString("room"));
					tfname.setText(rs1.getString("name"));
					tfcheckin.setText(rs1.getString("checkintime"));
					tfpaid.setText(rs1.getString("deposit"));
				}
				
				ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
				while(rs2.next())
				{
					String price = rs2.getString("price");
					int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
					tfpending.setText(""+ amountPaid);
					
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
			String name = tfname.getText();
			String checkin = tfcheckin.getText();
			String deposit = tfpaid.getText();
			
			try
			{
				Conn c = new Conn();
				c.s.executeUpdate("update customer set room ='"+room+"',name = '"+name+"',checkintime = '"+checkin+"',deposit = '"+deposit+"' where number = '"+number+"'");
                
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
       new UpdateCheck();
	}

}
