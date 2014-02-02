/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;

/**
 *
 * @author CHANDAN
 */
@WebService(serviceName = "retrieve")
public class retrieve {
    @Resource(name = "data1")
    private DataSource data1;

    
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fetcData")
    public String fetcData() {
        //TODO write your implementation code here:
       
        try {
  Class.forName("com.mysql.jdbc.Driver");
  Connection con = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/test", 
"", "");
  
  Statement stmt = con.createStatement(
                           ResultSet.TYPE_SCROLL_INSENSITIVE,
                           ResultSet.CONCUR_READ_ONLY);
      String sql;
      sql = "SELECT id, first, last, age FROM Employees";
      ResultSet rs = stmt.executeQuery(sql);

      // Move cursor to the last row.
      System.out.println("Moving cursor to the last...");
      rs.last();
      
      //STEP 5: Extract data from result set
      System.out.println("Displaying record...");
      //Retrieve by column name
      int id  = rs.getInt("id");
      String name = rs.getString("last");

  } catch (Exception e) {
  System.out.println(e.getMessage());
  }
        
        return null;
    }

    /**
     * Web service operation
     */
 
}
