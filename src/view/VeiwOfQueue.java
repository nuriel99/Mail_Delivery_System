package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import model.PersonDetails;
import model.QueuePerson;
public class VeiwOfQueue extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
		
			public void run() {
				try {
					VeiwOfQueue frame = new VeiwOfQueue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	


	/**
	 * Create the frame.
	 */
	public VeiwOfQueue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u05D4\u05DE\u05EA\u05E0\u05D4 \u05DC\u05EA\u05D5\u05E8");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(236, 28, 361, 121);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA-\u05D6\u05D4\u05D5\u05EA");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		label_1.setBounds(533, 165, 204, 42);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(299, 165, 204, 34);
		contentPane.add(textField);
		
		JButton Button1 = new JButton("\u05D4\u05DB\u05E0\u05E1 \u05DC\u05EA\u05D5\u05E8");
		Button1.setFont(new Font("Tahoma", Font.BOLD, 23));
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String id=textField.getText();
				int numinline=QueuePerson.numQueue;
				QueuePerson.addPersonDetails(textField.getText());
				
				JOptionPane.showMessageDialog(null,  " hello to Id: "+ id+"," +" your turn is " +numinline);
			}
		});
		Button1.setBounds(113, 165, 162, 34);
		contentPane.add(Button1);
	}
}
