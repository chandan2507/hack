/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



/**
 *
 * @author CHANDAN
 */
@WebService(serviceName = "myFinal")
public class myFinal {
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
    @WebMethod(operationName = "insert")
    public String insert(@WebParam(name = "id") final int id, @WebParam(name = "name") final String name) {
        //TODO write your implementation code here:
   
       
  try {
  Class.forName("com.mysql.jdbc.Driver");
  Connection con = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/test", 
"", "");
  PreparedStatement st = 
con.prepareStatement("insert into login values(?,?)");
  st.setInt(1, id);
  st.setString(2,name);
  st.executeUpdate();
  } catch (Exception e) {
  System.out.println(e.getMessage());
  }
  return "record inserted";
  }
}    
        
        
       
