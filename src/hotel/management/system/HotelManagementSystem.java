package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener
{
	HotelManagementSystem()
	{
		
		setBounds(100,100,1166,565);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0,0,1166,565);
		add(image);
		
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,410,800,100);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("serif",Font.PLAIN,40));
		image.add(text);
		
		JLabel veer = new JLabel("VEER");
		veer.setBounds(730,20,600,100);
		veer.setForeground(Color.WHITE);
		veer.setFont(new Font("serif",Font.PLAIN,120));
		image.add(veer);
		
		JLabel veer2 = new JLabel("VEER");
		veer2.setBounds(730,20,600,100);
		veer2.setForeground(Color.green);
		veer2.setFont(new Font("serif",Font.PLAIN,120));
		image.add(veer2);
		
		
		
		JButton next = new JButton("NEXT");
		next.setBounds(970,430,130,50);
		next.setBackground(Color.CYAN);
		next.setForeground(Color.BLACK);
		next.setFont(new Font("serif",Font.PLAIN,22));
		next.addActionListener(this);
		image.add(next);
		
		setVisible(true);
		
		
		while(true)
		{
			text.setVisible(false);
			veer.setVisible(false);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			text.setVisible(true);
			veer.setVisible(true);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Login();
	}
	
	public static void main(String[] args) 
	{
		new HotelManagementSystem();

	}

}
