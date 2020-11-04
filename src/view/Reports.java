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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Reports extends JFrame {

	private JPanel contentPane;
	private JTable table6;
	private JTextField textField;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reports() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u05D3\u05D5\u05D7\u05D5\u05EA");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(346, 16, 135, 63);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 242, 457, 221);
		contentPane.add(scrollPane);
		
		table6 = new JTable();
		scrollPane.setViewportView(table6);
		
		JButton button = new JButton("\u05D4\u05E8\u05D0\u05D4 \u05D0\u05EA \u05DB\u05DC \u05D4\u05D7\u05D1\u05D9\u05DC\u05D5\u05EA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				try       //בעת לחיצה על הכפתור "הראה הכל".....................
				{
					String query="select * from tbl";
					PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					ResultSet rs=pst.executeQuery();	
					table6.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1)
				{
					//JOptionPane.showMessageDialog(null,e);
					System.out.println(e1);
				}	
				
				
				
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button.setBounds(36, 84, 257, 42);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05DC\u05E4\u05D9 \u05EA.\u05D6");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(696, 84, 121, 42);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0)
			
			{
				
				try 
				{
					String query="select * from tbl where id =?";
					PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					pst.setString(1,textField.getText());
					ResultSet rs=pst.executeQuery();
					table6.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
				
				
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(507, 88, 174, 34);
		contentPane.add(textField);
		
		JLabel lblVip = new JLabel("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA VIP");
		lblVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVip.setBounds(710, 154, 107, 42);
		contentPane.add(lblVip);
		
		JButton btnNewButton = new JButton("\u05D7\u05E4\u05E9");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)   
			{
				
				
				try       //בעת לחיצה על הכפתור "לקוחות VIP".....................
				{
					String query="select name, id,count(id) as conutOfPacackages from tbl group by id having count(id) >9  ";
					PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					ResultSet rs=pst.executeQuery();	
					table6.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1)
				{
					//JOptionPane.showMessageDialog(null,e);
					System.out.println(e1);
				}	
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(507, 156, 174, 42);
		contentPane.add(btnNewButton);
		
		JLabel label_2 = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05DC\u05E4\u05D9 \u05D7\u05D5\u05D3\u05E9");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(674, 227, 143, 42);
		contentPane.add(label_2);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField1.setColumns(10);
		textField1.setBounds(613, 227, 46, 42);
		contentPane.add(textField1);
		
		JButton button_1 = new JButton("\u05D7\u05E4\u05E9");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try       //בעת לחיצה על הכפתור "חיפוש לפי חודש".....................
				{
					String valueOfMonth= textField1.getText();
					String query="select * from tbl where month='"+valueOfMonth+"'      ";
					PreparedStatement pst=(SqliteConnection.db()).prepareStatement(query);
					ResultSet rs=pst.executeQuery();	
					table6.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1)
				{
					//JOptionPane.showMessageDialog(null,e);
					System.out.println(e1);
				}	
				
				
				
				
				
				
			}
		});
		button_1.setBounds(508, 229, 92, 42);
		contentPane.add(button_1);
	}
}
