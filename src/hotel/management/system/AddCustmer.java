package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustmer extends JFrame implements ActionListener
{
	JComboBox comboid;
	JTextField tfnumber,tfname,tfcountry,tfdeposit;
	JRadioButton rbmale,rbfemale;
	Choice croom;
	JLabel checkintime;
	JButton add,back;
	
	AddCustmer()
	{   
		getContentPane().setBackground(Color.magenta);
	    setLayout(null);
	    
	    JLabel text = new JLabel("NEW CUSTMER FORM");
	    text.setFont(new Font("Tahoma",Font.BOLD,20));
	    text.setBounds(100,20,300,30);
	    text.setForeground(Color.BLACK);
		add(text);
		
		JLabel lblid= new JLabel("ID");
		lblid.setFont(new Font("Tahoma",Font.BOLD,16));
		lblid.setBounds(35,80,100,30);
		lblid.setForeground(Color.black);
		add(lblid);
		
		String Options [] = {"Aadhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
		 comboid = new JComboBox(Options);
		comboid.setBounds(200,80,160,30);
		comboid.setBackground(Color.white);
		comboid.setForeground(Color.black);
		comboid.setFont(new Font("Tahoma",Font.BOLD,14));
		add(comboid);
		
		JLabel lblnumber= new JLabel("Number");
		lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
		lblnumber.setBounds(35,120,100,30);
		lblnumber.setForeground(Color.black);
		add(lblnumber);
		
		tfnumber = new JTextField();
		tfnumber.setBounds(200,120,160,30);
		tfnumber.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfnumber);
		
		JLabel lblname= new JLabel("Name");
		lblname.setFont(new Font("Tahoma",Font.BOLD,16));
		lblname.setBounds(35,160,100,30);
		lblname.setForeground(Color.black);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,160,30);
		tfname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfname);
	    
		JLabel lblgender= new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma",Font.BOLD,16));
		lblgender.setBounds(35,210,120,20);
		lblgender.setForeground(Color.black);
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
	    rbmale.setBounds(200,200,70,30);
		rbmale.setFont(new Font("Tahoma",Font.BOLD,16	));
		rbmale.setBackground(Color.magenta);
		rbmale.setForeground(Color.black);
		add(rbmale);
			
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280,200,100,30);
		rbfemale.setFont(new Font("Tahoma",Font.BOLD,16));
		rbfemale.setBackground(Color.magenta);
		rbfemale.setForeground(Color.black);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel lblcountry= new JLabel("Country");
		lblcountry.setFont(new Font("Tahoma",Font.BOLD,16));
		lblcountry.setBounds(35,250,100,30);
		lblcountry.setForeground(Color.black);
		add(lblcountry);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(200,250,160,30);
		tfcountry.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfcountry);
		
		JLabel lblroom= new JLabel("Room Number");
		lblroom.setFont(new Font("Tahoma",Font.BOLD,16));
		lblroom.setBounds(35,290,150,20);
		lblroom.setForeground(Color.black);
		add(lblroom);
		
		croom = new Choice();
		try
		{
			Conn conn = new Conn();
			String query = "select * from room where availability = 'Available'";
		    ResultSet rs = conn.s.executeQuery(query);
		    while(rs.next())
		    {
		    	croom.add(rs.getString("roomnumber"));
		    }
			
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		croom.setBounds(200,290,160,30);
		croom.setFont(new Font("Tahoma",Font.BOLD,15));
		add(croom);
		
		JLabel lbltime= new JLabel("Checkin time");
		lbltime.setFont(new Font("Tahoma",Font.BOLD,16));
		lbltime.setBounds(35,330,150,20);
		lbltime.setForeground(Color.black);
		add(lbltime);
		
		Date date = new Date();
		
		checkintime= new JLabel(""+date);
		checkintime.setFont(new Font("Tahoma",Font.BOLD,14));
		checkintime.setBounds(200,330,155,20);
		checkintime.setForeground(Color.black);
		add(checkintime);
		
		JLabel lbldeposit= new JLabel("Deposit");
		lbldeposit.setFont(new Font("Tahoma",Font.BOLD,16));
		lbldeposit.setBounds(35,370,100,30);
		lbldeposit.setForeground(Color.black);
		add(lbldeposit);
		
		tfdeposit = new JTextField();
		tfdeposit.setBounds(200,370,160,30);
		tfdeposit.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfdeposit);
		
		add = new JButton("Add ");
		add.setBackground(Color.blue);
		add.setForeground(Color.white);
		add.setBounds(50,430,130,30);
		add.setFont(new Font("Tahoma",Font.BOLD,16));
		add.addActionListener(this);
		add(add);
		
		 back = new JButton("Back");
		 back.setBackground(Color.red);
		 back.setForeground(Color.white);
		 back.setBounds(230,430,130,30);
		 back.setFont(new Font("Tahoma",Font.BOLD,16));
		 back.addActionListener(this);
		 add(back);
		 
		 
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,50,300,400);
		add(image);
		
		setBounds(275,145,800,550);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource() == add)
		{
			String id =(String)comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();
			String gender = null;
			
			if(rbmale.isSelected())
			{
				gender = "Male";
			}
			else
			{
				gender = "Female";
			}
			
			String country = tfcountry.getText();
			String room = croom.getSelectedItem();
			String time = checkintime.getText();
			String deposit = tfdeposit.getText();
			
			if(name.equals("") )
			{
				JOptionPane.showMessageDialog(null, "Name should not be empty");
				return;
			}
			
			try
			{
				String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
				String query2 = "Update room set availability ='Occupied'  where roomnumber = '"+room+"'";
				
				Conn conn = new Conn();
				
				conn.s.executeLargeUpdate(query);
				conn.s.executeLargeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
				
				setVisible(false);
				new Reception();
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == back)
		{
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) 
	{
		new AddCustmer();

	}

}
