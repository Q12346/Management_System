package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener
{
	JTable table;
	JButton back,submit;
	Choice typeofcar;
	JCheckBox available;
	
	Pickup()
	{
		getContentPane().setBackground(Color.ORANGE);
		setLayout(null);
		
		JLabel text = new JLabel("Pickup Service");
		text.setBounds(400,20,200,40);
		text.setFont(new Font("Tahoma",Font.BOLD,25));
		text.setForeground(Color.black);
		add(text);
		
		JLabel lblbed = new JLabel("Type of Car");
		lblbed.setBounds(30,75,110,30);
		lblbed.setFont(new Font("Tahoma",Font.BOLD,18));
		lblbed.setForeground(Color.black);
		add(lblbed);
		
		typeofcar = new Choice();
		typeofcar.setBounds(150,80,200,25);
		add(typeofcar);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
			while(rs.next())
			{
				typeofcar.add(rs.getString("brand"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		available = new JCheckBox("Only display Available");
		available.setBounds(650,80,200,30);
		available.setBackground(Color.orange);
		available.setForeground(Color.black);
		available.setFont(new Font("Tahoma",Font.BOLD,13));
		add(available);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(20,140,100,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,16));
		l1.setForeground(Color.red);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(170,140,100,30);
		l2.setFont(new Font("Tahoma",Font.BOLD,16));
		l2.setForeground(Color.red);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(310,140,200,30);
		l3.setFont(new Font("Tahoma",Font.BOLD,16));
		l3.setForeground(Color.red);
		add(l3);
		
		JLabel l4 = new JLabel("Company");
		l4.setBounds(460,140,100,30);
		l4.setFont(new Font("Tahoma",Font.BOLD,16));
		l4.setForeground(Color.red);
		add(l4);
		
		JLabel l5 = new JLabel("Brand");
		l5.setBounds(600,140,100,30);
		l5.setFont(new Font("Tahoma",Font.BOLD,16));
		l5.setForeground(Color.red);
		add(l5);
		
		JLabel l6 = new JLabel("Availibilty");
		l6.setBounds(750,140,100,30);
		l6.setFont(new Font("Tahoma",Font.BOLD,16));
		l6.setForeground(Color.red);
		add(l6);
		
		JLabel l7 = new JLabel("Location");
		l7.setBounds(900,140,100,30);
		l7.setFont(new Font("Tahoma",Font.BOLD,16));
		l7.setForeground(Color.red);
		add(l7);
		
		back = new JButton("Back");
		back.setBounds(500,485,120,30);
		back.setBackground(Color.red);
		back.setForeground(Color.white);
		back.setFont(new Font("Tahoma",Font.BOLD,16));
		back.addActionListener(this);
		add(back);
		
		submit = new JButton("Submit");
		submit.setBounds(300,485,120,30);
		submit.setBackground(Color.blue);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Tahoma",Font.BOLD,16));
		submit.addActionListener(this);
		add(submit);
		
		
		table = new JTable();
		table.setBounds(0,180,1030,300);
		add(table);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver ");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setFont(new Font("varail",Font.PLAIN,15));
			table.setBackground(Color.orange);
			table.setForeground(Color.black);
			
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
		if(ae.getSource() == submit)
		{
			try
			{
				String query1 = "select * from driver where brand ='"+typeofcar.getSelectedItem()+"'";
				String query2 = "select * from driver where available ='Available'AND brand ='"+typeofcar.getSelectedItem()+"'";
				
				Conn conn = new Conn();
				
				ResultSet rs;
				
				if(available.isSelected())
				{
					rs = conn.s.executeQuery(query2);
				}
				else
				{
					rs = conn.s.executeQuery(query1);
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
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
		new Pickup();

	}

}
