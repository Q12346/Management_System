package hotel.management.system;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener
{
	JButton add,cancal;
	JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
	JComboBox availablecombo,agecombo,gendercombo;
	
	
	AddDriver()
	{
		getContentPane().setBackground(Color.cyan);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma",Font.BOLD,25));
		heading.setBounds(150,10,200,20);
		heading.setForeground(Color.DARK_GRAY);
		add(heading);
		
		JLabel lblroom = new JLabel("Name");
		lblroom.setFont(new Font("Tahoma",Font.BOLD,16));
		lblroom.setForeground(Color.black);
		lblroom.setBounds(60,60,120,20);
		add(lblroom);
		
		 tfname = new JTextField();
		 tfname.setBounds(200,60,150,30);
		 tfname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfname);
		
		JLabel lblavailable= new JLabel("Age");
		lblavailable.setFont(new Font("Tahoma",Font.BOLD,16));
		lblavailable.setBounds(60,115,120,20);
		lblavailable.setForeground(Color.black);
		add(lblavailable);
		
		tfage = new JTextField();
		tfage.setBounds(200,110,150,30);
		tfage.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfage);
		
		
		JLabel lblgender= new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma",Font.BOLD,16));
		lblgender.setBounds(60,165,120,20);
		lblgender.setForeground(Color.black);
		add(lblgender);
		
		String genderOptions [] = {"Male","Female"};
		gendercombo = new JComboBox(genderOptions);
		gendercombo.setBounds(200,160,150,30);
		gendercombo.setBackground(Color.white);
		gendercombo.setFont(new Font("Tahoma",Font.BOLD,14));
		add(gendercombo);
		
		
		JLabel lblcarcompany = new JLabel("Car Company");
		lblcarcompany.setFont(new Font("Tahoma",Font.BOLD,16));
		lblcarcompany.setBounds(60,215,120,20);
		lblcarcompany.setForeground(Color.black);
		add(lblcarcompany);
		
		 tfcompany = new JTextField();
		 tfcompany.setBounds(200,210,150,30);
		 tfcompany.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfcompany);
		
		JLabel lblcarmodel= new JLabel("Car Model");
		lblcarmodel.setFont(new Font("Tahoma",Font.BOLD,16));
		lblcarmodel.setBounds(60,265,120,20);
		lblcarmodel.setForeground(Color.black);
		add(lblcarmodel);
		
		tfmodel = new JTextField();
		tfmodel.setBounds(200,260,150,30);
		tfmodel.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfmodel);
	    
		JLabel lblage= new JLabel("Available");
		lblage.setFont(new Font("Tahoma",Font.BOLD,16));
		lblage.setBounds(60,310,120,20);
		lblage.setForeground(Color.black);
		add(lblage);
		
		String driverOptions [] = {"Available","Busy"};
		 availablecombo = new JComboBox(driverOptions);
		 availablecombo.setBounds(200,310,150,30);
		 availablecombo.setBackground(Color.white);
		 availablecombo.setFont(new Font("Tahoma",Font.BOLD,14));
		add(availablecombo);
		
		
		JLabel lbllocation= new JLabel("Location");
		lbllocation.setFont(new Font("Tahoma",Font.BOLD,16));
		lbllocation.setBounds(60,365,120,20);
		lbllocation.setForeground(Color.black);
		add(lbllocation);
		
		tflocation = new JTextField();
		tflocation.setBounds(200,360,150,30);
		tflocation.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tflocation);
		
		
		add = new JButton("Add Driver");
		add.setBackground(Color.green);
		add.setForeground(Color.white);
		add.setBounds(60,420,130,30);
		add.setFont(new Font("Tahoma",Font.BOLD,15));
		add.addActionListener(this);
		add(add);
		
		 cancal = new JButton("Cancal");
		cancal.setBackground(Color.red);
		cancal.setForeground(Color.white);
		cancal.setBounds(220,420,130,30);
		cancal.setFont(new Font("Tahoma",Font.BOLD,15));
		cancal.addActionListener(this);
		add(cancal);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,70,500,300);
        add(image);
		
		
		
		setBounds(180,150,980,520);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			String NAME = tfname.getText();
			String age = tfage.getText();
			String gender = (String) gendercombo.getSelectedItem();
			String company = tfcompany.getText();
			String brand = tfmodel.getText();
			String available = (String) availablecombo.getSelectedItem();
			String location = tflocation.getText();
			
			if(NAME.equals("") )
			{
				JOptionPane.showMessageDialog(null, "Name should not be empty");
				return;
			}
			
			try
			{
				Conn conn = new Conn();
				String str = "insert into driver values('"+NAME+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
				
				conn.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "New Driver added Successfully");
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
		new AddDriver();

	}

}
