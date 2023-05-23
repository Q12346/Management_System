package hotel.management.system;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener
{
	JButton add,cancal;
	JTextField tfroom,tfprice;
	JComboBox typecombo,availablecombo,cleancombo;
	
	
	AddRooms()
	{
		getContentPane().setBackground(Color.green);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma",Font.BOLD,25));
		heading.setBounds(150,20,200,20);
		heading.setForeground(Color.blue);
		add(heading);
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setFont(new Font("Tahoma",Font.BOLD,16));
		lblroom.setForeground(Color.black);
		lblroom.setBounds(60,80,120,20);
		add(lblroom);
		
		 tfroom = new JTextField();
		tfroom.setBounds(200,80,150,30);
		tfroom.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(tfroom);
		
		JLabel lblavailable= new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma",Font.BOLD,16));
		lblavailable.setBounds(60,135,120,20);
		lblavailable.setForeground(Color.black);
		add(lblavailable);
		
		String availableOptions[] = {"Available","Occupied"};
		 availablecombo = new JComboBox(availableOptions);
		availablecombo.setBounds(200,130,150,30);
		availablecombo.setBackground(Color.white);
		availablecombo.setFont(new Font("Tahoma",Font.BOLD,14));
		add(availablecombo);
		
		
		JLabel lblclean= new JLabel("Cleaning Status");
		lblclean.setFont(new Font("Tahoma",Font.BOLD,15));
		lblclean.setBounds(60,185,120,20);
		lblclean.setForeground(Color.black);
		add(lblclean);
		
		String cleanOptions [] = {"Cleaned","Dirty"};
		 cleancombo = new JComboBox(cleanOptions);
		cleancombo.setBounds(200,180,150,30);
		cleancombo.setBackground(Color.white);
		cleancombo.setFont(new Font("Tahoma",Font.BOLD,14));
		add(cleancombo);
		
		
		JLabel lblprice = new JLabel("Room Price");
		lblprice.setFont(new Font("Tahoma",Font.BOLD,16));
		lblprice.setBounds(60,235,120,20);
		lblprice.setForeground(Color.black);
		add(lblprice);
		
		 tfprice = new JTextField();
		tfprice.setBounds(200,230,150,30);
		tfprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(tfprice);
		
		JLabel lbltype= new JLabel("Bed Type");
		lbltype.setFont(new Font("Tahoma",Font.BOLD,16));
		lbltype.setBounds(60,285,120,20);
		lbltype.setForeground(Color.black);
		add(lbltype);
		
		String typeOptions [] = {"Single Bed","Double Bed"};
		 typecombo = new JComboBox(typeOptions);
		typecombo.setBounds(200,280,150,30);
		typecombo.setBackground(Color.white);
		typecombo.setFont(new Font("Tahoma",Font.BOLD,14));
		add(typecombo);
		
		 add = new JButton("Add Room");
		add.setBackground(Color.BLUE);
		add.setForeground(Color.white);
		add.setBounds(60,350,130,30);
		add.setFont(new Font("Tahoma",Font.BOLD,14));
		add.addActionListener(this);
		add(add);
		
		 cancal = new JButton("Cancal");
		cancal.setBackground(Color.BLUE);
		cancal.setForeground(Color.white);
		cancal.setBounds(220,350,130,30);
		cancal.setFont(new Font("Tahoma",Font.BOLD,14));
		cancal.addActionListener(this);
		add(cancal);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,70,490,300);
        add(image);
		
		
		
		setBounds(200,160,940,470);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			String roomnumber = tfroom.getText();
			String availability = (String) availablecombo.getSelectedItem();
			String status = (String) cleancombo.getSelectedItem();
			String price = tfprice.getText();
			String type = (String) typecombo.getSelectedItem();
			
			if(price.equals("") )
			{
				JOptionPane.showMessageDialog(null,"Price should not be empty");
				return;
			}
			
			try
			{
				Conn conn = new Conn();
				String str = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
				
				conn.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "New Room added Successfully");
				setVisible(false);
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) 
	{
		new AddRooms();

	}

}
