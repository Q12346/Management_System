package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener
{
	JTable table;
	JButton back;
	
	Department()
	{
		getContentPane().setBackground(Color.pink);
		setLayout(null);
		
		JLabel l1 = new JLabel(" Department");
		l1.setBounds(120,0,150,60);
		l1.setFont(new Font("Tahoma",Font.BOLD,16));
		l1.setForeground(Color.black);
		add(l1);
		
		JLabel l2 = new JLabel("Budget");
		l2.setBounds(410,0,100,60);
		l2.setFont(new Font("Tahoma",Font.BOLD,16));
		l2.setForeground(Color.black);
		add(l2);
		
		
		table = new JTable();
		table.setBounds(0,60,700,300);
		add(table);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setFont(new Font("varail",Font.BOLD,14));
			table.setBackground(Color.pink);
			table.setForeground(Color.black);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 back = new JButton("Back");
		 back.setBackground(Color.blue);
		 back.setForeground(Color.white);
		 back.setBounds(250,370,130,30);
		 back.setFont(new Font("Tahoma",Font.BOLD,16));
		 back.addActionListener(this);
		 add(back);
		
		setBounds(250,160,700,480);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
		
	}
	public static void main(String[] args) 
	{
		new Department();

	}

}
