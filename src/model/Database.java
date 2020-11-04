package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Database extends InsertDB   {
	
	private static Database db;

	   private Database()   //design pattern singelton//constractor
	   {
		   packageDB();
	  }
	   
	   public static Database getDB()  // נקודת קריאה ראשונית
	   {
		   if(db == null)
		   {
		       db = new Database();
		     
		   }
		   return db;
	    }
	   
	   public static Database status()
	   {
		   return db;
	   }
	   
	   
	   
	   public void packageDB() 
	   {
		   
		   	Connection c = null;
		    Statement stmt = null;     
		      try {
		         Class.forName("org.sqlite.JDBC");
		         c = DriverManager.getConnection("jdbc:sqlite:test11");
		         System.out.println("Opened database successfully");
		         stmt = c.createStatement();
		         String query = "CREATE TABLE IF NOT EXISTS tbl" +
		                        "(name         	CHAR(10) , " +
		                        "id		     	CHAR(10), " +
		                        "numpackage      CHAR (10) PRIMARY KEY  NOT NULL, " + 
		                        "branch           CHAR(10),"+
		                        "istaken      CHAR(10),"+
		                        "month      CHAR(10),"+
		                        "year      CHAR(10)) ";
                                   

		         stmt.executeUpdate(query);
		         stmt.close();
		         c.close();
		         insert();
		            		         
		      } 
		      catch ( Exception e )
		      {
		         System.out.println( e );
		         System.exit(0);
		      }
		      System.out.println("Table created successfully");
	   }
	  
	   
	   }