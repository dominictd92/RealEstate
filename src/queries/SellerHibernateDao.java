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
import org.springframework.util.StringUtils;
import utilities.DATABASE_CONSTANTS;

/**
 * This holds all of the sql statements that are needed 
 * for the Seller page
 */
public class SellerHibernateDao {
    public static final String SSN = "ssn";
    public static final String ZIP = "zipCode";
    public static final String ADDRESS = "streetAddress";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String PHONE = "phoneNumber";
    public static final String FNAME = "f_name";
    public static final String MNAME = "m_name";
    public static final String LNAME = "l_name";
    public static final String SELL_PROP_SSN = "seller_ssn";
    public static final String SELL_PROP_PROPID = "Property_propertyID";
    public static final String SELL_PROP_TSSN = "Property_Tennant_ssn";
    public static final String SELL_PROP_PRICE = "price";
    
    public static final String SELECT_SELLER = "SELECT * FROM Seller";
    public static final String CREATE_SELLER = "INSERT INTO Seller ( " + SSN + ", " + ZIP + ", " + ADDRESS + ", " + CITY
        + ", " + STATE + ", " + PHONE + ", " + FNAME + ", " + MNAME + ", " + LNAME + ")"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_SELLER = "UPDATE Seller SET " + ZIP + " = ?, " + ADDRESS + " = ?, " + CITY + " = ?, " + STATE + " = ?, "
        + PHONE +" = ?, " + FNAME + " = ?, " + MNAME + " = ?, " + LNAME + " = ? WHERE " + SSN + " = ?";
    public static final String FILTER_SELLERS = "SELECT * FROM Seller s "
        + " INNER JOIN Seller_Sells_Property sp ON sp." + SELL_PROP_SSN + " = s." + SSN
        + " INNER JOIN Property p ON p.propertyID = sp." + SELL_PROP_PROPID
        + " WHERE (-1 = ? OR s." + SSN + " = ? ) AND (-1 = ? OR s." + ZIP + " =  ? ) "
        + " AND s." + ADDRESS + " LIKE ? AND s." + CITY + " LIKE ? AND s." + STATE + " LIKE ? AND s." 
        + PHONE + " LIKE ? AND s." + FNAME + " LIKE ? AND s." + MNAME + " LIKE ? AND s." + LNAME + " LIKE ? "
        + " AND (-1 = ? OR sp." + SELL_PROP_PRICE + " = ? ) AND (-1 = ? OR sp." + SELL_PROP_PROPID + " = ? )";
    public static final String SELLER_FOR_PROPERTY = 
        " SELECT * FROM Seller a "
        + " INNER JOIN Seller_Sells_Property ap ON ap." + SELL_PROP_SSN + " = a." + SSN
        + " INNER JOIN Property p ON p.propertyID = ap." + SELL_PROP_PROPID;
    public static final String INSERT_SELLER_PROPERTY_RELATION = ""
        + "INSERT INTO Seller_Sells_Property (" + SELL_PROP_SSN + ", " + SELL_PROP_PROPID + ", " 
        + SELL_PROP_TSSN + ", " + SELL_PROP_PRICE + ")" + " VALUES (?, ?, ?, ?)";
    public static final String UPDATE_SELLER_PROPERTY_RELATION = ""
        + "UPDATE Seller_Sells_Property "
        + " SET " + SELL_PROP_SSN + " = ?, " + SELL_PROP_PROPID + " = ?, " + SELL_PROP_TSSN 
        +  " = ?, " + SELL_PROP_PRICE + " = ? " + " WHERE " + SELL_PROP_SSN + " = ? AND " + SELL_PROP_PROPID + " = ?" ;
    
    public ArrayList<SellerEntity> getAllSellers() {
        ArrayList<SellerEntity> sellList = new ArrayList<>();
        try {
             Class.forName(DATABASE_CONSTANTS.DRIVER);
             Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SELLER_FOR_PROPERTY);
             SellerEntity sell;
             while(rs.next()) {
                sell = new SellerEntity(rs.getInt(SSN), rs.getInt(ZIP), rs.getString(ADDRESS),
                        rs.getString(CITY) ,rs.getString(STATE), rs.getString(PHONE),
                        rs.getString(FNAME) ,rs.getString(MNAME), rs.getString(LNAME));
                sell.setPropertyID(rs.getInt(SELL_PROP_PROPID));
                sell.setPrice(rs.getBigDecimal(SELL_PROP_PRICE));
                sellList.add(sell);
             }  
        }
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return sellList;
    }
    
    public boolean updateSeller(SellerEntity seller) {
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, 
                    DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD); 
            
            PreparedStatement pst = conn.prepareStatement(UPDATE_SELLER);
            
            int i = 1;
            
            pst.setInt(i++, seller.getZipCode());
            pst.setString(i++, seller.getStreetAddress());
            pst.setString(i++, seller.getCity());
            pst.setString(i++, seller.getState());
            pst.setString (i++, seller.getPhoneNumber());
            pst.setString(i++, seller.getfName());
            pst.setString(i++, seller.getmName());
            pst.setString(i++, seller.getlName());
            pst.setInt(i++, seller.getSsn());
            
            pst.execute();
            
            conn.close();
            return true;
        } catch(ClassNotFoundException | SQLException e) {
            return false;
        } 
    }
    
    public List<SellerEntity> getFilteredSellers(SellerEntity sell) {
        List<SellerEntity> sellerList = new ArrayList<>();
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(FILTER_SELLERS);
            
            stmt.setInt(i++, sell.getSsn());
            stmt.setInt(i++, sell.getSsn());
            stmt.setInt(i++, sell.getZipCode());
            stmt.setInt(i++, sell.getZipCode());
            stmt.setString(i++, StringUtils.isEmpty(sell.getStreetAddress()) ? "%" : "%" + sell.getStreetAddress()+ "%" );
            stmt.setString(i++, StringUtils.isEmpty(sell.getCity()) ? "%" : "%" + sell.getCity() + "%");
            stmt.setString(i++, StringUtils.isEmpty(sell.getState()) ? "%" : "%" + sell.getState() + "%");
            stmt.setString(i++, StringUtils.isEmpty(sell.getPhoneNumber()) ? "%" : "%" + sell.getPhoneNumber() + "%");
            stmt.setString(i++, StringUtils.isEmpty(sell.getfName()) ? "%" : "%" + sell.getfName()+ "%");
            stmt.setString(i++, StringUtils.isEmpty(sell.getmName()) ? "%" : "%" + sell.getmName()+ "%");
            stmt.setString(i++, StringUtils.isEmpty(sell.getlName()) ? "%" : "%" + sell.getlName() + "%");
            stmt.setDouble(i++, sell.getPropertyID());
            stmt.setDouble(i++, sell.getPropertyID());
            stmt.setInt(i++, sell.getPropertyID());
            stmt.setInt(i++, sell.getPropertyID());
            
            ResultSet results = stmt.executeQuery();
            
            while(results.next()) { 
                SellerEntity seller = new SellerEntity();
                seller.setSsn(results.getInt(SSN));
                seller.setlName(results.getString(LNAME));
                seller.setfName(results.getString(FNAME));
                seller.setmName(results.getString(MNAME));
                seller.setCity(results.getString(CITY));
                seller.setPhoneNumber(results.getString(PHONE));
                seller.setPrice(results.getBigDecimal(SELL_PROP_PRICE));
                seller.setPropertyID(results.getInt(SELL_PROP_PROPID));
                seller.setState(results.getString(STATE));
                seller.setStreetAddress(results.getString(ADDRESS));
                
                sellerList.add(seller);
            }
            
            conn.close();
            return sellerList;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return sellerList;
        } 
    } 
    
    public boolean createSeller(SellerEntity seller) {
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD); 
            PreparedStatement pst = conn.prepareStatement(CREATE_SELLER);
            
            int i = 1;
            pst.setInt(i++, seller.getSsn());
            pst.setInt(i++, seller.getZipCode());
            pst.setString(i++, seller.getStreetAddress());
            pst.setString(i++, seller.getCity());
            pst.setString(i++, seller.getState());
            pst.setString (i++, seller.getPhoneNumber());
            pst.setString(i++, seller.getfName());
            pst.setString(i++, seller.getmName());
            pst.setString(i++, seller.getlName());
            pst.executeUpdate();
            
            conn.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught on creation of Seller");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean insertSellerPropertyRelationship(SellerEntity seller) { 
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(INSERT_SELLER_PROPERTY_RELATION);
            
            stmt.setInt(i++, seller.getSsn());
            stmt.setInt(i++, seller.getPropertyID());
            stmt.setString(i++, null);
            stmt.setBigDecimal(i++, seller.getPrice());
            
            stmt.executeUpdate();
            
            conn.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return false;
        } 
    } 
}