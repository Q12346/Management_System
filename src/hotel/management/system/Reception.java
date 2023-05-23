package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener
{
	JButton newCustmer,rooms,department,allemployee,managerInfo,custmers,search;
	JButton roomStatus,pickup,update,logout,checkout;
	
	Reception()
	{
		getContentPane().setBackground(Color.blue);
		setLayout(null);
		
		 newCustmer = new JButton("New Customer Form");
		newCustmer.setBounds(20,30,200,30);
		newCustmer.setBackground(Color.red);
		newCustmer.setForeground(Color.white);
		newCustmer.setFont(new Font("Tahoma",Font.BOLD,15));
		newCustmer.addActionListener(this);
		add(newCustmer);
		
		 rooms = new JButton("Rooms");
		rooms.setBounds(20,70,200,30);
		rooms.setBackground(Color.red);
		rooms.setForeground(Color.white);
		rooms.setFont(new Font("Tahoma",Font.BOLD,15));
		rooms.addActionListener(this);
		add(rooms);
		
	    department = new JButton("Department");
		department.setBounds(20,110,200,30);
		department.setBackground(Color.red);
		department.setForeground(Color.white);
		department.setFont(new Font("Tahoma",Font.BOLD,15));
		department.addActionListener(this);
		add(department);
		
	    allemployee = new JButton("All Employees");
		allemployee.setBounds(20,150,200,30);
		allemployee.setBackground(Color.red);
		allemployee.setForeground(Color.white);
		allemployee.setFont(new Font("Tahoma",Font.BOLD,15));
		allemployee.addActionListener(this);
		add(allemployee);
		
	    custmers = new JButton("Custmer Info");
		custmers.setBounds(20,190,200,30);
		custmers.setBackground(Color.red);
		custmers.setForeground(Color.white);
		custmers.setFont(new Font("Tahoma",Font.BOLD,15));
		custmers.addActionListener(this);
		add(custmers);
		
	    managerInfo  = new JButton("Manager Info");
		managerInfo.setBounds(20,230,200,30);
		managerInfo.setBackground(Color.red);
		managerInfo.setForeground(Color.white);
		managerInfo.setFont(new Font("Tahoma",Font.BOLD,15));
		managerInfo.addActionListener(this);
		add(managerInfo);
		
		checkout = new JButton("Checkout");
		checkout.setBounds(20,270,200,30);
		checkout.setBackground(Color.red);
		checkout.setForeground(Color.white);
		checkout.setFont(new Font("Tahoma",Font.BOLD,15));
		checkout.addActionListener(this);
		add(checkout);
		
		 update = new JButton("Update Status");
		update.setBounds(20,310,200,30);
		update.setBackground(Color.red);
		update.setForeground(Color.white);
		update.setFont(new Font("Tahoma",Font.BOLD,15));
		update.addActionListener(this);
		add(update);
		
	    roomStatus = new JButton("Update Room Status");
		roomStatus.setBounds(20,350,200,30);
		roomStatus.setBackground(Color.red);
		roomStatus.setForeground(Color.white);
		roomStatus.setFont(new Font("Tahoma",Font.BOLD,15));
		roomStatus.addActionListener(this);
		add(roomStatus);
		
		 pickup = new JButton("Pickup Service");
		pickup.setBounds(20,390,200,30);
		pickup.setBackground(Color.red);
		pickup.setForeground(Color.white);
		pickup.setFont(new Font("Tahoma",Font.BOLD,15));
		pickup.addActionListener(this);
		add(pickup);
		
		search = new JButton("Search Room");
		search.setBounds(20,430,200,30);
		search.setBackground(Color.red);
		search.setForeground(Color.white);
		search.setFont(new Font("Tahoma",Font.BOLD,15));
		search.addActionListener(this);
		add(search);
		
	    logout = new JButton("Logout");
		logout.setBounds(20,470,200,30);
		logout.setBackground(Color.red);
		logout.setForeground(Color.white);
		logout.setFont(new Font("Tahoma",Font.BOLD,15));
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(250,30,500,470);
		add(image);
		
		setBounds(280,140,800,570);
		setVisible(true);
		
	     
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == newCustmer)
		{
			setVisible(false);
			new AddCustmer();
		}
		else if(ae.getSource() == rooms)
		{
			setVisible(false);
			new Room();
		}
		else if(ae.getSource() == department)
		{
			setVisible(false);
			new Department();
		}
		else if(ae.getSource() == allemployee)
		{
			setVisible(false);
			new EmployeeInfo();
		}
		else if(ae.getSource() == managerInfo)
		{
			setVisible(false);
			new ManagerInfo();
		}
		else if(ae.getSource() == custmers)
		{
			setVisible(false);
			new CustomerInfo();
		}
		else if(ae.getSource() == search)
		{
			setVisible(false);
			new SearchRoom();
		}
		else if(ae.getSource() == update)
		{
			setVisible(false);
			new UpdateCheck();
		}
		else if(ae.getSource() == roomStatus)
		{
			setVisible(false);
			new UpdateRoom();
		}
		else if(ae.getSource() == pickup)
		{
			setVisible(false);
			new Pickup();
		}
		else if(ae.getSource() == checkout)
		{
			setVisible(false);
			new Checkout();
		}
		else if(ae.getSource() == logout)
		{
			setVisible(false);
			System.exit(0);
		}


	}

	public static void main(String[] args) 
	{
		new Reception();

	}

}
