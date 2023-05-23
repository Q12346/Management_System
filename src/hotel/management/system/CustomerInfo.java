package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener
{
	JTable table;
	JButton back;
	
	CustomerInfo()
	{
		getContentPane().setBackground(Color.cyan);
		setLayout(null);
		
		
		JLabel l1 = new JLabel("Document Type");
		l1.setBounds(05,10,150,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,16));
		l1.setForeground(Color.red);
		add(l1);
		
		JLabel l2 = new JLabel("Number");
		l2.setBounds(150,10,100,30);
		l2.setFont(new Font("Tahoma",Font.BOLD,16));
		l2.setForeground(Color.red);
		add(l2);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(285,10,100,30);
		l3.setFont(new Font("Tahoma",Font.BOLD,16));
		l3.setForeground(Color.red);
		add(l3);
		
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(420,10,100,30);
		l4.setFont(new Font("Tahoma",Font.BOLD,16));
		l4.setForeground(Color.red);
		add(l4);
		
		JLabel l5 = new JLabel("Country");
		l5.setBounds(560,10,100,30);
		l5.setFont(new Font("Tahoma",Font.BOLD,16));
		l5.setForeground(Color.red);
		add(l5);
		
		JLabel l6 = new JLabel("Room No");
		l6.setBounds(700,10,100,30);
		l6.setFont(new Font("Tahoma",Font.BOLD,16));
		l6.setForeground(Color.red);
		add(l6);
		
		JLabel l7 = new JLabel("Checkin Time");
		l7.setBounds(830,10,200,30);
		l7.setFont(new Font("Tahoma",Font.BOLD,16));
		l7.setForeground(Color.red);
		add(l7);
		
		JLabel l8 = new JLabel("Deposit");
		l8.setBounds(965,10,100,30);
		l8.setFont(new Font("Tahoma",Font.BOLD,16));
		l8.setForeground(Color.red);
		add(l8);
		
		
		table = new JTable();
		table.setBounds(0,40,1100,400);
		add(table);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setFont(new Font("varail",Font.BOLD,13));
			table.setBackground(Color.cyan);
			table.setForeground(Color.black);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBounds(460,450,120,30);
		back.setBackground(Color.red);
		back.setForeground(Color.white);
		back.setFont(new Font("Tahoma",Font.BOLD,16));
		back.addActionListener(this);
		add(back);
		
		setBounds(200,100,1100,600);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
		
	}
	public static void main(String[] args) 
	{
		new CustomerInfo();

	}

}
