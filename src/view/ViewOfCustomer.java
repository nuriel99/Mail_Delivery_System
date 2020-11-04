package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewOfCustomer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public void run() 
	{
		try 
		{
			ViewOfCustomer frame = new ViewOfCustomer();
			frame.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
		
	

	/**
	 * Create the frame.
	 */
	public ViewOfCustomer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 833, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("\u05DC\u05E7\u05D5\u05D7");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		label_1.setBounds(348, 16, 125, 121);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u05D1\u05D1\u05D9\u05EA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ViewOfEnterPackage enter =new ViewOfEnterPackage();
				enter.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 30));
		button.setBounds(440, 207, 199, 88);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("\u05D4\u05D9\u05DB\u05DF \u05E0\u05DE\u05E6\u05D0?");
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		label_2.setBounds(617, 149, 141, 42);
		contentPane.add(label_2);
		
		JButton button_1 = new JButton("\u05D1\u05E1\u05E0\u05D9\u05E3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				VeiwOfQueue queue =new VeiwOfQueue();
				queue.setVisible(true);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_1.setBounds(142, 207, 199, 88);
		contentPane.add(button_1);
	}

}
