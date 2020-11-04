package model;
import java.sql.*;
import javax.swing.JOptionPane;

public class SqliteConnection 
{
	 Connection c=null;
     public static Connection dbconnector()
     {
    	 try 
    	 {
    		 Class.forName("org.sqlite.JDBC");
    		 Connection c=DriverManager.getConnection("jdbc:sqlite:C:test11");
    		 JOptionPane.showMessageDialog(null,"your DB is connected  ");
    		 return c;
    	 }
    		 
    	 catch(Exception e)
    	 {
    		 JOptionPane.showMessageDialog(null, e);
        	 System.out.println(e);
        	 return null;
         }
     }
    
     
     public static Connection db()
     {
    	 try 
    	 {
    		 Class.forName("org.sqlite.JDBC");
    		 Connection c=DriverManager.getConnection("jdbc:sqlite:C:test11");
    		 return c;
    	 }
    		 
    	 catch(Exception e)
    	 {
    	 JOptionPane.showMessageDialog(null, e);
    	 System.out.println(e);
    	 return null;
         }
     }
     
}