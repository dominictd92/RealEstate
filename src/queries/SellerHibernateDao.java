package queries;

import entities.SellerEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utilities.DATABASE_CONSTANTS;

/**
 * This holds all of the sql statements that are needed 
 * for the Properties page
 */
public class SellerHibernateDao {
    public static final String SELECT_SELLER = "SELECT * FROM Seller";
    public static final String CREATE_SELLER = "INSERT INTO Seller (ssn, zipCode, streetAddress, city, State, phoneNumber,"
            + "f_name, m_name, l_name) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_STATES = "SELECT * FROM State"; 
    public static String getPropertiesWithoutTennants = "SELECT * FROM Properties "
            + " WHERE  ";
    
    public ArrayList<SellerEntity> sellerList() {
        ArrayList<SellerEntity> sellList = new ArrayList<>();
        try {
             Class.forName(DATABASE_CONSTANTS.DRIVER);
             Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SELECT_SELLER);
             SellerEntity sell;
             while(rs.next()) {
                sell = new SellerEntity(rs.getInt("ssn"), rs.getInt("zipCode"), rs.getString("streetAddress"),
                        rs.getString("city") ,rs.getString("State"), rs.getString("phoneNumber"),
                        rs.getString("f_name") ,rs.getString("m_name"), rs.getString("l_name"));
                 sellList.add(sell);
             }  
        }
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return sellList;
    }
    
    public String updateSeller(SellerEntity seller, Integer sellerSSN) {
        String result;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, 
                    DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD); 
            
            String sql = "UPDATE Seller SET zipCode = ?, streetAddress = ?, city = ?, State = ?,"
                    + " phoneNumber = ?, f_name = ?, m_name = ?, l_name = ? where ssn = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            int i = 1;
            
            pst.setInt(i++, seller.getZipCode());
            pst.setInt(i++, seller.getStreetAddress());
            pst.setString(i++, seller.getCity());
            pst.setString(i++, seller.getState());
            pst.setString (i++, seller.getPhoneNumber());
            pst.setString(i++, seller.getfName());
            pst.setString(i++, seller.getmName());
            pst.setString(i++, seller.getlName());

            pst.execute();
            
            result = "Record successfully updated";
           
            conn.close();
        } catch(ClassNotFoundException | SQLException e) {
            result = e.getMessage();
        } 
        return result; 
    }
    
    public List<String> getStates() { 
        List<String> stateList = new ArrayList<>(); 
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            PreparedStatement pst = conn.prepareStatement(SELECT_STATES);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                stateList.add(rs.getString("state_abbr"));
            } 
        }
        catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
        }
        return stateList;
    }
    public String createSeller(SellerEntity seller) {
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD); 
            PreparedStatement pst = conn.prepareStatement(CREATE_SELLER);
            
            int i = 1;
            pst.setInt(i++, seller.getZipCode());
            pst.setInt(i++, seller.getStreetAddress());
            pst.setString(i++, seller.getCity());
            pst.setString(i++, seller.getState());
            pst.setString (i++, seller.getPhoneNumber());
            pst.setString(i++, seller.getfName());
            pst.setString(i++, seller.getmName());
            pst.setString(i++, seller.getlName());
            pst.execute();
            
            conn.close();
            return "Entry Saved";
        } catch (ClassNotFoundException | SQLException e) { 
            return e.getMessage();
        }
    }
}