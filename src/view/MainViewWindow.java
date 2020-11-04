package view;
import java.util.Observable;

import java.sql.*;
import javax.swing.JOptionPane;

import model.Database;
import model.SqliteConnection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;


public class MainViewWindow extends Observable implements View
{

	private JFrame frame;
    public void start() 
	{
		try 
		{
			MainViewWindow window = new MainViewWindow();
			window.frame.setVisible(true);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
		
    Connection connection=null;
	public MainViewWindow() 
	{
		initialize();
		connection=SqliteConnection.dbconnector();   //connecting to the database/////////
		System.out.println("the connectin is good, now will test the creating table");
		Database.getDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 811, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btncst = new JButton("\u05DC\u05E7\u05D5\u05D7");
		btncst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ViewOfCustomer customer=new ViewOfCustomer();
				customer.setVisible(true);
			}
		});
		btncst.setFont(new Font("Tahoma", Font.BOLD, 30));
		btncst.setBounds(490, 178, 199, 88);
		frame.getContentPane().add(btncst);
		
		JLabel label = new JLabel("\u05DE\u05E2\u05E8\u05DB\u05EA \u05DC\u05E0\u05D9\u05D4\u05D5\u05DC \u05D7\u05D1\u05D9\u05DC\u05D5\u05EA \u05D3\u05D5\u05D0\u05E8");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(156, 36, 584, 121);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("\u05E2\u05D5\u05D1\u05D3");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ViewOfEmployee emp =new ViewOfEmployee();
				emp.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 30));
		button.setBounds(139, 178, 199, 88);
		frame.getContentPane().add(button);
	}
}
