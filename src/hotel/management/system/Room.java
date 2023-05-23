package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener
{
	JTable table;
	JButton back;
	
	Room()
	{
		getContentPane().setBackground(Color.red);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(520, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(510,05,520,550);
		add(image);
		
		JLabel l1 = new JLabel("Room No");
		l1.setBounds(05,10,100,20);
		l1.setFont(new Font("Tahoma",Font.BOLD,14));
		l1.setForeground(Color.white);
		add(l1);
		
		JLabel l2 = new JLabel("Availibility");
		l2.setBounds(110,10,100,20);
		l2.setFont(new Font("Tahoma",Font.BOLD,14));
		l2.setForeground(Color.white);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(210,10,100,20);
		l3.setFont(new Font("Tahoma",Font.BOLD,14));
		l3.setForeground(Color.white);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(310,10,100,20);
		l4.setFont(new Font("Tahoma",Font.BOLD,14));
		l4.setForeground(Color.white);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(410,10,100,20);
		l5.setFont(new Font("Tahoma",Font.BOLD,14));
		l5.setForeground(Color.white);
		add(l5);
		
		back = new JButton("Back");
		back.setBounds(170,500,120,30);
		back.setBackground(Color.green);
		back.setForeground(Color.black);
		back.setFont(new Font("Tahoma",Font.BOLD,16));
		back.addActionListener(this);
		add(back);
		
		
		table = new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setFont(new Font("varail",Font.PLAIN,14));
			table.setBackground(Color.red);
			table.setForeground(Color.white);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		setBounds(220,115,1050,600);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
		
	}
	public static void main(String[] args) 
	{
		new Room();

	}

}
