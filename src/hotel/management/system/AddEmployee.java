package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener
{
	JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
	JRadioButton rbmale,rbfemale;
	JButton submit;
	JComboBox cbjob;
	
	AddEmployee()
	{
		getContentPane().setBackground(Color.red);
		setLayout(null);
		
		
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(60,30,120,30);
		lblname.setForeground(Color.white);
		lblname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblname);
		
		 tfname = new JTextField();
		tfname.setBounds(200,30,160,30);
		tfname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfname);
		
		
		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(60,80,120,30);
		lblage.setForeground(Color.white);
		lblage.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblage);
		
		 tfage = new JTextField();
		tfage.setBounds(200,80,160,30);
		tfage.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfage);
		
		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(60,130,120,30);
		lblgender.setForeground(Color.white);
		lblgender.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblgender);
		
		 rbmale = new JRadioButton("Male");
		rbmale.setBounds(200,130,70,30);
		rbmale.setFont(new Font("Tahoma",Font.BOLD,15));
		rbmale.setBackground(Color.blue);
		rbmale.setForeground(Color.white);
		add(rbmale);
		
		 rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280,130,80,30);
		rbfemale.setFont(new Font("Tahoma",Font.BOLD,15));
		rbfemale.setBackground(Color.blue);
		rbfemale.setForeground(Color.white);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(60,180,120,30);
		lbljob.setForeground(Color.white);
		lbljob.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lbljob);
		
		String str[] = {"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
		 cbjob = new JComboBox(str);
		cbjob.setBounds(200,180,160,30);
		cbjob.setFont(new Font("Tahoma",Font.BOLD,14));
		cbjob.setBackground(Color.blue);
		cbjob.setForeground(Color.white);
		add(cbjob);
		
		
		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(60,230,120,30);
		lblsalary.setForeground(Color.white);
		lblsalary.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblsalary);
		
		 tfsalary = new JTextField();
		tfsalary.setBounds(200,230,160,30);
		tfsalary.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfsalary);
		
		JLabel lblphone = new JLabel("PHONE NO");
		lblphone.setBounds(60,280,120,30);
		lblphone.setForeground(Color.white);
		lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblphone);
		
		 tfphone = new JTextField();
		tfphone.setBounds(200,280,160,30);
		tfphone.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfphone);
		
		JLabel lblemail = new JLabel("EMAIL ID");
		lblemail.setBounds(60,330,120,30);
		lblemail.setForeground(Color.white);
		lblemail.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblemail);
		
		 tfemail = new JTextField();
		tfemail.setBounds(200,330,160,30);
		tfemail.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfemail);
		
		JLabel lblaadhar = new JLabel("AADHAR NO");
		lblaadhar.setBounds(60,380,120,30);
		lblaadhar.setForeground(Color.white);
		lblaadhar.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblaadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200,380,160,30);
		tfaadhar.setFont(new Font("Tahoma",Font.BOLD,14));
		add(tfaadhar);
		
		
		 submit = new JButton("SUBMIT");
		submit.setBounds(200,430,160,30);
		submit.setBackground(Color.green);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Tahoma",Font.BOLD,16));
		submit.addActionListener(this);
		add(submit);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380,30,430,370);
		image.setBackground(Color.YELLOW);
		add(image);
		
		
		
		setBounds(245,155,850,540);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhar = tfaadhar.getText();
		
		String gender = null;
		
		if(name.equals("") )
		{
			JOptionPane.showMessageDialog(null, "Name should not be empty");
			return;
		}
		
		if(rbmale.isSelected())
		{
			gender ="Male";
		}
		else if (rbfemale.isSelected())
		{
			gender = "Female";
		}
		
		String job = (String) cbjob.getSelectedItem();
		
		try
		{
			Conn conn = new Conn();
			
			String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			
			conn.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(this, "Employee added Successfully");
			
			setVisible(false);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		new AddEmployee();

	}

}
