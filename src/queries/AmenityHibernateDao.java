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
public class AmenityHibernateDao {
    public static final String SELECT_AMENITIES = "SELECT * FROM Amenity";
    public static final String CREATE_AMENITY = "INSERT INTO Amenity (amenityid, amenity) "
            + "values (?, ?)";
    public static final String SELECT_STATES = "SELECT * FROM State"; 
    public static String getPropertiesWithoutTennants = "SELECT * FROM Property "
            + " WHERE  ";
    
    public ArrayList<AmenityEntity> amenityList() {
        ArrayList<AmenityEntity> amenityList = new ArrayList<>();
        try {
             Class.forName(DATABASE_CONSTANTS.DRIVER);
             Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SELECT_AMENITIES);
             AmenityEntity amenity;
             while(rs.next()) {
                amenity = new AmenityEntity(rs.getInt("amenityid"), rs.getString("amenity"));
                amenityList.add(amenity);
             }  
        }
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return amenityList;
    }
    
    public String updateAmenity(AmenityEntity amenity, Integer amenityid) {
        String result;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, 
                    DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD); 
            
            String sql = "UPDATE Amenity SET amenity = ? where amenityid = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            int i = 1;

            pst.setString(i++, amenity.getAmenity());

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
    public String createAmenity(AmenityEntity amenity) {
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD); 
            PreparedStatement pst = conn.prepareStatement(CREATE_AMENITY);
            
            int i = 1; 
            pst.setString(i++, amenity.getAmenityid());
            pst.setString(i++, amenity.getAmenity());
            pst.execute();
            
            conn.close();
            return "Entry Saved";
        } catch (ClassNotFoundException | SQLException e) { 
            return e.getMessage();
        }
    }
}