package view;

import java.awt.BorderLayout;
import java.util.Date;
import model.PersonDetails;
import model.QueuePerson;
import model.SqliteConnection;
import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;


public class ViewOfEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JTable table5;
	private JTextField textField4;
	
	/**
	 * Launch the application.
	 */
	
		
			public void run()
			{
				try {
					ViewOfEmployee frame = new ViewOfEmployee();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
	
	

	/**
	 * Create the frame.
	 */
	public ViewOfEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u05E2\u05D5\u05D1\u05D3");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(338, 0, 125, 80);
		contentPane.add(label);
		
		JButton button = new JButton("\u05D4\u05DC\u05E7\u05D5\u05D7 \u05D4\u05D1\u05D0");
		button.addActionListener(new ActionListener() {
 
			public void actionPerformed(ActionEvent e) 
			{
				if(QueuePerson.numQueueOfEmployee<QueuePerson.numQueue)
				{									
				    int num=QueuePerson.numQueueOfEmployee;  //תור רץ של העובד
				    List<PersonDetails> temp = QueuePerson.list;  // רשימה של כל הנתונים
			    	PersonDetails pd = temp.get(num-1);  // 
			    	textField.setText(pd.getId());
			    	textField1.setText(Integer.toString(pd.getInLine()));
			    	QueuePerson.prepareNext();
				
			    	try       // טעינת כל החבילות של אותו הלקוח בטבלה
		     		{
					String query="select * from tbl where id=? and istaken='no'";
					PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					pst.setString(1,textField.getText());
					ResultSet rs=pst.executeQuery();	
					table5.setModel(DbUtils.resultSetToTableModel(rs));
		 	     	} 
		     		catch(Exception e1)
		     		{
					//JOptionPane.showMessageDialog(null,e);
					System.out.println(e1);
			    	}	
				
				}	
				else 
				{
					JOptionPane.showMessageDialog(null, "אין ממתינים בתור");
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 26));
		button.setBounds(596, 99, 207, 45);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u05D3\u05D5\u05D7\u05D5\u05EA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				Reports reports=new Reports();
				reports.setVisible(true);
				
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_1.setBounds(15, 8, 150, 68);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(317, 96, 207, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField1.setColumns(10);
		textField1.setBounds(50, 100, 207, 45);
		contentPane.add(textField1);
		
		JLabel label_1 = new JLabel("\u05EA.\u05D6");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_1.setBounds(529, 112, 52, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u05EA\u05D5\u05E8");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_2.setBounds(266, 112, 52, 20);
		contentPane.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 157, 491, 215);
		contentPane.add(scrollPane);
		
		table5 = new JTable();
		
		
		scrollPane.setViewportView(table5);
		
		JButton button2 = new JButton("\u05E1\u05DE\u05DF \u05E0\u05DC\u05E7\u05D7");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				   //  בעת לחיצה על "סמן כנלקח"
				
				   Connection c = null;
				   Statement stmt = null;
				   
				   try 
				   {
					  c=SqliteConnection.db();
				      c.setAutoCommit(false);
				      System.out.println("Opened database successfully");

				      stmt = c.createStatement();
				     
				      String sql = "UPDATE tbl set istaken = 'yes' where numpackage='"+textField4.getText()+"';";
				      stmt.executeUpdate(sql);
				      c.commit();
                     
				      //הוספת חודש ושנה
				      
				      Date date=new Date();
				      String month=Integer.toString((date.getMonth()+1));
				      String year=Integer.toString((date.getYear()+1900));
				      
				      sql = "UPDATE tbl set month = '"+month+"' where numpackage='"+textField4.getText()+"';";
				      stmt.executeUpdate(sql);
				      c.commit();
				      
				      sql = "UPDATE tbl set year = '"+year+"' where numpackage='"+textField4.getText()+"';";
				      stmt.executeUpdate(sql);
				      c.commit();
				      
				      
				      //תצוגה בטבלה את כל החבילות שלא נאספו
				      String query="select * from tbl where id='"+textField4.getText()+"' and istaken='no' ";
					  PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					  ResultSet rs=pst.executeQuery();	
					  table5.setModel(DbUtils.resultSetToTableModel(rs));
				 
				      stmt.close();
				      c.close();
				      JOptionPane.showMessageDialog(null, "updated");
				   } 
				   catch ( Exception e5 ) 
				   {
	                  JOptionPane.showMessageDialog(null, e5);
                      System.err.println( e5.getClass().getName() + ": " + e5.getMessage() );
				      System.exit(0);
				   }
				    
				
				
				
				
				
				
				
				
				
				
			}
		});
		button2.setFont(new Font("Tahoma", Font.BOLD, 26));
		button2.setBounds(15, 401, 172, 68);
		contentPane.add(button2);
		
		textField4 = new JTextField();
		textField4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField4.setColumns(10);
		textField4.setBounds(243, 414, 116, 45);
		contentPane.add(textField4);
		
		JLabel label_5 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D7\u05D1\u05D9\u05DC\u05D4");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_5.setBounds(374, 417, 150, 39);
		contentPane.add(label_5);
	}
}
