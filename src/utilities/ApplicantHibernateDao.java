package utilities;

import java.sql.*;

/**
 *
 * @author ddangerfield
 */
public class ApplicantHibernateDao {
    static final String username="ddange1";//put your MySQL user name
    static final String password="Cosc*8re5";//put your MySQL password
    //private static Connection connection=null;
   
    public String getAllApplications() {
        
        try { 
            String driver = "com.mysql.jdbc.Driver";
            //String driver = "org.gjt.mm.mysql.Driver";
            String url = "jdbc:mysql://triton.towson.edu:3360/ddange1db";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT count(*) AS counter FROM Staff;";
            Statement stmt = conn.createStatement();
            String count = "";
            ResultSet results = stmt.executeQuery(query);
            while(results.next()) { 
                count += results.getString("counter");
            }
            
            conn.close();
            return count;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return "Error";
        } 
    } 
}

