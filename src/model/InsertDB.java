package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDB 
{

   public void insert()
   {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test11");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         
         String query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '31', 'ramla','no','null'  , 'null'  );"; 
         stmt.executeUpdate(query);
         
        
         
         query = "INSERT  or replace INTO tbl (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('aviv', '1000000', '24', 'ramla','no',  'null', 'null'  );"; 
         stmt.executeUpdate(query);
         
         
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '32', 'ramla','yes','1'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '33', 'ramla','yes','2'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '34', 'ramla','yes','3'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '35', 'ramla','yes','4'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '36', 'ramla','yes','5'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '37', 'ramla','yes','6'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '38', 'ramla','yes','7'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '39', 'ramla','yes','8'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '40', 'ramla','yes','9'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         query = "INSERT or replace INTO tbl  (name,id,numpackage,branch,istaken,month,year) " +
                 "VALUES ('nuriel', '311776173', '41', 'ramla','yes','10'  , '2019'  );"; 
         stmt.executeUpdate(query);
         
        
         
       
       
       
       
        
         stmt.close();
         c.commit();
         c.close();
      } 
      catch ( Exception e ) 
      {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}