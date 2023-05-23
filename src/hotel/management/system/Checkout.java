package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener
{
	Choice ccustomer;
	JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
	JButton checkout,back,detail;
	
    Checkout()
    {
    	getContentPane().setBackground(Color.yellow);
    	setLayout(null);
    	
    	JLabel text = new JLabel("Checkout");
    	text.setBounds(100,20,140,40);
    	text.setForeground(Color.red);
    	text.setFont(new Font("Tahoma",Font.BOLD,24));
    	add(text);
    	
    	JLabel lblid = new JLabel("Customer Id");
    	lblid.setBounds(30,80,120,30);
    	lblid.setForeground(Color.black);
    	lblid.setFont(new Font("Tahoma",Font.BOLD,16));
    	add(lblid);
    	
    	
    	ccustomer = new Choice();
		ccustomer.setBounds(177,83,150,30);
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
		
		
    	
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(330,84,20,20);
		image.setBackground(Color.green);
		add(image);
    	
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30,130,120,30);
		lblroom.setForeground(Color.black);
		lblroom.setFont(new Font("Tahoma",Font.BOLD,16));
    	add(lblroom);
    	
    	lblroomnumber = new JLabel();
    	lblroomnumber.setBounds(177,130,120,30);
    	lblroomnumber.setForeground(Color.black);
    	lblroomnumber.setFont(new Font("Tahoma",Font.BOLD,16));
    	add(lblroomnumber);
    	
    	JLabel lblcheckin = new JLabel("Checkin Time");
    	lblcheckin.setBounds(30,180,120,30);
    	lblcheckin.setForeground(Color.black);
    	lblcheckin.setFont(new Font("Tahoma",Font.BOLD,16));
    	add(lblcheckin);
    	
        lblcheckintime = new JLabel();
    	lblcheckintime.setBounds(177,180,120,30);
    	lblcheckintime.setForeground(Color.black);
    	lblcheckintime.setFont(new Font("Tahoma",Font.BOLD,16));
    	add(lblcheckintime);
    	
    	
    	JLabel lblcheckout = new JLabel("Checkout Time");
    	lblcheckout.setBounds(30,230,140,30);
    	lblcheckout.setForeground(Color.black);
    	lblcheckout.setFont(new Font("Tahoma",Font.BOLD,16));
    	add(lblcheckout);
    	
    	Date date = new Date();
        lblcheckouttime = new JLabel(""+date);
        lblcheckouttime.setBounds(177,230,170,30);
        lblcheckouttime.setForeground(Color.black);
        lblcheckouttime.setFont(new Font("Tahoma",Font.BOLD,14));
    	add(lblcheckouttime);
    	
    	detail = new JButton("Detail");
    	detail.setBackground(Color.green);
    	detail.setForeground(Color.white);
    	detail.setBounds(20,290,100,30);
    	detail.setFont(new Font("Tahoma",Font.BOLD,16));
    	detail.addActionListener(this);
		add(detail);
    	
    	checkout = new JButton("Checkout");
    	checkout.setBackground(Color.blue);
    	checkout.setForeground(Color.white);
    	checkout.setBounds(140,290,105,30);
    	checkout.setFont(new Font("Tahoma",Font.BOLD,15));
    	checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton("Back");
	    back.setBackground(Color.red);
		back.setForeground(Color.white);
		back.setBounds(265,290,100,30);
		back.setFont(new Font("Tahoma",Font.BOLD,16));
		back.addActionListener(this);
		add(back);
		
		
		
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(375,70,400,250);
		image1.setBackground(Color.green);
		add(image1);
		
    	
    	setBounds(300,200,800,400);
    	setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource() == detail)
    	{    		
    		try
    		{
    			
    			 Conn c = new Conn();
    			 
    			 ResultSet rs = c.s.executeQuery("select * from customer");
    			 while(rs.next())
    			 {
    				 ccustomer.add(rs.getString("number"));
    				 lblroomnumber.setText(rs.getString("room"));
    				 lblcheckintime.setText(rs.getString("checkintime"));
    			 }
    			 
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}    	
    		
    		
    	}
    	
    	
    	if(ae.getSource() == checkout)
    	{
    		String query = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
    		String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
    		
    		
    		try
    		{
    			Conn c = new Conn();
    			c.s.executeUpdate(query);
    			c.s.executeUpdate(query2);
    			
    			
    			JOptionPane.showMessageDialog(null, "Checkout Done");
    			
    			setVisible(false);
    			new Reception();
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	else if (ae.getSource() == back)
    	{
    		setVisible(false);
    		new Reception();
    	}
    }
    
    public static void main(String[] args)
    {
    	new Checkout();
    }
}
