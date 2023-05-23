package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*
;
public class Dashboard extends JFrame implements ActionListener
{
	Dashboard()
	{
		setBounds(0,0,1390,730);
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1390, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1390,730);
		add(image);
		
		JLabel text = new JLabel("THE TAJ GROUP WELWCOMES YOU");
		text.setBounds(300,50,1000,50);
		text.setFont(new Font("Tahoma",Font.PLAIN,46));
		text.setForeground(Color.red);
		image.add(text);
		
		JLabel text2 = new JLabel("THE TAJ GROUP WELWCOMES YOU");
		text2.setBounds(300,50,1000,50);
		text2.setFont(new Font("Tahoma",Font.PLAIN,46));
		text2.setForeground(Color.yellow);
		image.add(text2);
		
		
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,0,1390,30);
		image.add(mb);
		
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.RED);
		hotel.setFont(new Font("varail",Font.BOLD,14));
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.blue);
		admin.setFont(new Font("varail",Font.BOLD,14));
		mb.add(admin);
		
		JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this);
		admin.add(addemployee);
		
		JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		addrooms.addActionListener(this);
		admin.add(addrooms);
		
		JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
		adddrivers.addActionListener(this);
		admin.add(adddrivers);
		
		  
		
		
		setVisible(true);
		
		
			
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("ADD EMPLOYEE"))
		{
			new AddEmployee();
		}
		else if(ae.getActionCommand().equals("ADD ROOMS"))
		{
			new AddRooms();
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS"))
		{
			new AddDriver();
		}
		else if(ae.getActionCommand().equals("RECEPTION"))
		{
			new Reception();
		}
	}

	public static void main(String[] args) 
	{
		new Dashboard();
	}

}
