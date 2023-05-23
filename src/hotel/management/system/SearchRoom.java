package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener
{
	JTable table;
	JButton back,submit;
	JComboBox bedType;
	JCheckBox available;
	
	SearchRoom()
	{
		getContentPane().setBackground(Color.cyan);
		setLayout(null);
		
		JLabel text = new JLabel("Search for Room");
		text.setBounds(400,20,200,30);
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		text.setForeground(Color.black);
		add(text);
		
		JLabel lblbed = new JLabel("Bed Type");
		lblbed.setBounds(50,80,100,30);
		lblbed.setFont(new Font("Tahoma",Font.BOLD,16));
		lblbed.setForeground(Color.black);
		add(lblbed);
		
		bedType = new JComboBox(new String[] {"Single Bed","Double Bed"});
		bedType.setBounds(150,80,150,30);
		bedType.setBackground(Color.white);
		bedType.setFont(new Font("Tahoma",Font.BOLD,14));
		bedType.setForeground(Color.black);
		add(bedType);
		
		available = new JCheckBox("Only display Available");
		available.setBounds(650,80,200,30);
		available.setBackground(Color.cyan);
		available.setForeground(Color.black);
		available.setFont(new Font("Tahoma",Font.BOLD,13));
		add(available);
		
		JLabel l1 = new JLabel("Room No");
		l1.setBounds(30,140,100,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,16));
		l1.setForeground(Color.red);
		add(l1);
		
		JLabel l2 = new JLabel("Availibility");
		l2.setBounds(220,140,100,30);
		l2.setFont(new Font("Tahoma",Font.BOLD,16));
		l2.setForeground(Color.red);
		add(l2);
		
		JLabel l3 = new JLabel("Cleaning Status");
		l3.setBounds(420,140,200,30);
		l3.setFont(new Font("Tahoma",Font.BOLD,16));
		l3.setForeground(Color.red);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(640,140,100,30);
		l4.setFont(new Font("Tahoma",Font.BOLD,16));
		l4.setForeground(Color.red);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(830,140,100,30);
		l5.setFont(new Font("Tahoma",Font.BOLD,16));
		l5.setForeground(Color.red);
		add(l5);
		
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
			ResultSet rs = c.s.executeQuery("select * from room ");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setFont(new Font("varail",Font.PLAIN,15));
			table.setBackground(Color.cyan);
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
				String query1 = "select * from room where bed_type ='"+bedType.getSelectedItem()+"'";
				String query2 = "select * from room where availability = 'Available'AND bed_type ='"+bedType.getSelectedItem()+"'";
				
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
		new SearchRoom();

	}

}
