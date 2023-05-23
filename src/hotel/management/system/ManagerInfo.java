package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener
{
	JTable table;
	JButton back;
	
	ManagerInfo()
	{
		getContentPane().setBackground(Color.blue);
		setLayout(null);
		
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(15,10,100,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,16));
		l1.setForeground(Color.yellow);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(150,10,100,30);
		l2.setFont(new Font("Tahoma",Font.BOLD,16));
		l2.setForeground(Color.yellow);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(260,10,100,30);
		l3.setFont(new Font("Tahoma",Font.BOLD,16));
		l3.setForeground(Color.yellow);
		add(l3);
		
		JLabel l4 = new JLabel("Job");
		l4.setBounds(380,10,100,30);
		l4.setFont(new Font("Tahoma",Font.BOLD,16));
		l4.setForeground(Color.yellow);
		add(l4);
		
		JLabel l5 = new JLabel("Salary");
		l5.setBounds(510,10,100,30);
		l5.setFont(new Font("Tahoma",Font.BOLD,16));
		l5.setForeground(Color.yellow);
		add(l5);
		
		JLabel l6 = new JLabel("Phone No");
		l6.setBounds(630,10,100,30);
		l6.setFont(new Font("Tahoma",Font.BOLD,16));
		l6.setForeground(Color.yellow);
		add(l6);
		
		JLabel l7 = new JLabel("Email Id ");
		l7.setBounds(760,10,100,30);
		l7.setFont(new Font("Tahoma",Font.BOLD,16));
		l7.setForeground(Color.yellow);
		add(l7);
		
		JLabel l8 = new JLabel("Aadhar NO");
		l8.setBounds(880,10,100,30);
		l8.setFont(new Font("Tahoma",Font.BOLD,16));
		l8.setForeground(Color.yellow);
		add(l8);
		
		
		table = new JTable();
		table.setBounds(0,40,1000,400);
		add(table);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from Employee where job = 'Manager'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setFont(new Font("varail",Font.BOLD,13));
			table.setBackground(Color.blue);
			table.setForeground(Color.white);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBounds(420,470,120,30);
		back.setBackground(Color.cyan);
		back.setForeground(Color.black);
		back.setFont(new Font("Tahoma",Font.BOLD,16));
		back.addActionListener(this);
		add(back);
		
		setBounds(200,100,1000,600);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
		
	}
	public static void main(String[] args) 
	{
		new ManagerInfo();

	}

}
