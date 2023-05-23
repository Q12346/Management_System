package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	JTextField username;
	JPasswordField password;
	JButton login,cancal;
	Login()
	{
		getContentPane().setBackground(Color.cyan);
		
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setBounds(40,20,100,30);
		user.setFont(new Font("varail",Font.BOLD,18));
		add(user);
		
		 username = new JTextField();
		username.setBounds(150,20,160,35);
		username.setFont(new Font("varail",Font.BOLD,13));
		add(username);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40,70,100,30);
		pass.setFont(new Font("varail",Font.BOLD,18));
		add(pass);
		
		 password = new JPasswordField();
		password.setBounds(150,70,160,35);
		password.setFont(new Font("varail",Font.BOLD,15));
		add(password);
		
		 login = new JButton("Login");
		login.setBounds(40,150,120,35);
		login.setBackground(Color.blue);
		login.setForeground(Color.white);
		login.setFont(new Font("varail",Font.BOLD,15));
		login.addActionListener(this);
		add(login);
		
		
		 cancal = new JButton("Cancal");
		cancal.setBounds(185,150,120,35);
		cancal.setBackground(Color.red);
		cancal.setForeground(Color.white);
		cancal.setFont(new Font("varail",Font.BOLD,15));
		cancal.addActionListener(this);
		add(cancal);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/veer.jpg"));
		//ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,10,200,200);
		add(image);
		
		
		
		setBounds(400,200,600,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == login)
		{
	       String user = username.getText();
	       String pass = password.getText();
	       
	       try
	       {
	    	   Conn c = new Conn();
	    	   
	    	   String query = "select * from login where username = '"+ user + "' and password = '" + pass + "'";
	    	   
	    	   ResultSet rs = c.s.executeQuery(query);
	    	   
	    	   if(rs.next())
	    	   {
	    		   setVisible(false);
	    		   new Dashboard();
	    	   }
	    	   else
	    	   {
	    		   JOptionPane.showMessageDialog(null,"Invalid username and password");
	    		   setVisible(false);
	    	   }
	       }
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	       }
		}
		else if(ae.getSource() == cancal)
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) 
	{
		new Login();
	}
}
