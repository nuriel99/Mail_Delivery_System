package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.SqliteConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class ViewOfEnterPackage extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTable table;
	private JTextField textField4;
	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					ViewOfEnterPackage frame = new ViewOfEnterPackage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the frame.
	 */
	public ViewOfEnterPackage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05D7\u05D1\u05D9\u05DC\u05D5\u05EA");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(232, 0, 361, 121);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u05E9\u05DD");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		label_1.setBounds(689, 159, 61, 42);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA-\u05D6\u05D4\u05D5\u05EA");
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		label_2.setBounds(546, 219, 204, 42);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u05E1\u05E0\u05D9\u05E3");
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		label_3.setBounds(664, 319, 80, 42);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D7\u05D1\u05D9\u05DC\u05D4");
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		label_4.setBounds(539, 263, 211, 42);
		contentPane.add(label_4);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField1.setBounds(364, 168, 172, 34);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField2.setColumns(10);
		textField2.setBounds(364, 228, 172, 34);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField3.setColumns(10);
		textField3.setBounds(364, 272, 172, 34);
		contentPane.add(textField3);
		
		JButton button = new JButton("\u05D4\u05D5\u05E1\u05E3");
		button.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					String query="insert into tbl (name,id,numpackage,branch,istaken,month,year) values (?,?,?,?,?,?,?)";
				
					PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					pst.setString(1,textField1.getText());
					pst.setString(2,textField2.getText());
					pst.setString(3,textField3.getText());
					pst.setString(4,textField4.getText());
					pst.setString(5,"no");
					pst.setString(6,"null");
					pst.setString(7,"null");
					pst.execute();
					JOptionPane.showMessageDialog(null, "saved");	
				} 
				catch(Exception e)
				{
					System.out.println(e);
					JOptionPane.showMessageDialog(null,e);
				}	
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 30));
		button.setBounds(652, 381, 118, 62);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u05D4\u05E8\u05D0\u05D4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try       //בעת לחיצה על הכפתור LOAD.....................
				{
					String valueOfId= textField2.getText();
					String query="select * from tbl where id='"+valueOfId+"' ";
					PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					ResultSet rs=pst.executeQuery();	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1)
				{
		
					System.out.println(e1);
				}	
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_1.setBounds(510, 381, 127, 62);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 159, 340, 284);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button_2 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)   //מחיקה.........///////////
			{
				 try
				    {
				    	String query="delete from tbl where numpackage =? ";
					    PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					    pst.setString(1,textField3.getText());
					    pst.execute();
				     	JOptionPane.showMessageDialog(null,"Deleted");
				   } 
				   catch(Exception e6)
				   {
					
					   JOptionPane.showMessageDialog(null,e6);
			      }	
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_2.setBounds(358, 381, 147, 62);
		contentPane.add(button_2);
		
		textField4 = new JTextField();
		textField4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField4.setColumns(10);
		textField4.setBounds(364, 319, 172, 34);
		contentPane.add(textField4);
	}
}
