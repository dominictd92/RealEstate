package queries;

import entities.PropertyEntity;
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
public class PropertiesHibernateDao {
    public static final String SELECT_PROPERTIES = "SELECT * FROM Property"; 
    public static final String CREATE_PROPERTY = "INSERT INTO Property (streetAddress, city, state, zipCode, phoneNumber, numOfRooms,"
            + "numberOfBaths, washer, dryer, deckOrPatio, basement, tennant_ssn, numOfTennants) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_STATES = "SELECT * FROM State"; 
    public static String getPropertiesWithoutTennants = "SELECT * FROM Properties "
            + " WHERE  ";
    
    public ArrayList<PropertyEntity> propertyList() { 
        ArrayList<PropertyEntity> propList = new ArrayList<>();
        try {
             Class.forName(DATABASE_CONSTANTS.DRIVER);
             Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SELECT_PROPERTIES);
             PropertyEntity prop;
             while(rs.next()) {
                prop = new PropertyEntity(rs.getInt("propertyID"), rs.getString("streetAddress"), rs.getString("city"), 
                        rs.getString("state"), rs.getInt("zipCode") ,rs.getString("phoneNumber"), rs.getInt("numOfRooms"),
                        rs.getInt("numberOfBaths") ,rs.getInt("Tennant_ssn"), rs.getInt("numOfTennants"), 
                        rs.getInt("washer"), rs.getInt("dryer"), rs.getInt("deckOrPatio"), rs.getInt("basement"));
                propList.add(prop);
             }  
        }
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return propList;
    }
    
    public String updateProperty(PropertyEntity property, Integer propertyID) { 
        String result;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, 
                    DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD); 
            
            String sql = "UPDATE Property SET deckOrPatio = ?, washer = ?, dryer = ?, numberOfBaths = ?,"
                    + " phoneNumber = ?, basement = ?, numOfRooms = ?, zipCode = ?, streetAddress = ?, city = ?,"
                    + " state = ?, numOfTennants = ?, Tennant_ssn= ? where propertyID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            int i = 1;
            
            pst.setInt(i++, property.getDeckOrPatio());
            pst.setInt(i++, property.getWasher());
            pst.setInt(i++, property.getDryer());
            pst.setInt(i++, property.getNumberOfBaths());
            pst.setString (i++, property.getPhoneNumber());
            pst.setInt(i++, property.getBasement());
            pst.setInt(i++, property.getNumOfRooms());
            pst.setInt(i++, property.getZipCode());
            pst.setString(i++, property.getStreetAddress());
            pst.setString(i++, property.getCity());
            pst.setString(i++, property.getState());
            pst.setInt(i++, property.getNumOfTennants()); 
            pst.setInt(i++, property.getTennantSsn());

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
    public String createProperty(PropertyEntity property) { 
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD); 
            PreparedStatement pst = conn.prepareStatement(CREATE_PROPERTY);
            
            int i = 1; 
            pst.setString(i++, property.getStreetAddress());
            pst.setString(i++, property.getCity());
            pst.setString(i++, property.getState());
            pst.setInt(i++, property.getZipCode());
            pst.setString(i++, property.getPhoneNumber());
            pst.setInt(i++, property.getNumOfRooms());
            pst.setInt(i++, property.getNumberOfBaths());
            pst.setInt(i++, property.getWasher());
            pst.setInt(i++, property.getDryer());
            pst.setInt(i++, property.getDeckOrPatio());
            pst.setInt(i++, property.getBasement());
            if (null == property.getTennantSsn()) {
                pst.setString(i++, null);
            } else {
                pst.setInt(i++, property.getTennantSsn());
            }
            pst.setInt(i++, property.getNumOfTennants());
            pst.execute();
            
            conn.close();
            return "Entry Saved";
        } catch (ClassNotFoundException | SQLException e) { 
            return e.getMessage();
        }
    }
}