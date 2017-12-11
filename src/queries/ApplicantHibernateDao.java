package queries;

import entities.ApplicantEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import utilities.DATABASE_CONSTANTS;

/**
 * This class contains all of the queries that support the Applicants
 * 
 * @author ddangerfield
 */
public class ApplicantHibernateDao {
    //constants for the objects so that database names aren't mixed up
    //if one is changed, change the constant and it's changed for all of the queries
    private static final String SSN = "ssn";
    private static final String FNAME = "f_name";
    private static final String LNAME = "l_name";
    private static final String MNAME = "m_name";
    private static final String CREDIT_SCORE = "creditScore";
    private static final String ADDRESS = "address";
    private static final String MOVE_DATE = "moveDate";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String EMPLOYER = "employer";
    private static final String JOB_TITLE = "jobTitle";
    private static final String SALARY = "salary";
    private static final String APP_PROP_APPSSN = "Applicant_Ssn";
    private static final String APP_PROP_PROPID = "Property_propertyID";
    private static final String APP_PROP_STATUS = "applicationStatus";
    
    //Put all of the queries above so the document is readable
    public static final String SELECT_APPLICANTS = "SELECT * FROM Applicant;";
    public static final String CREATE_APPLICANT = "INSERT INTO Applicant(" + SSN + ", " + FNAME + ", " + LNAME
        + ", " + MNAME + ", " + CREDIT_SCORE + ", " + ADDRESS + ", " + MOVE_DATE + ", " + PHONE_NUMBER 
        + ", " + EMPLOYER + ", " + JOB_TITLE + ", " + SALARY + ")"
        + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_APPLICANT = "DELETE FROM Applicant WHERE " + SSN + " = ?";
    public static final String FILTER_APPLICANTS = "SELECT * FROM Applicant a "
        + "INNER JOIN Applicant_Applies_For_Property ap ON a." + SSN + " = ap." + APP_PROP_APPSSN
        + " WHERE ( -1 = ? OR " + SSN + " = ? ) "
        + " AND a." + FNAME + " LIKE ? AND a." + LNAME + " LIKE ? AND a." + MNAME + " LIKE ? "
        + " AND a." + CREDIT_SCORE + " LIKE ? AND a." + ADDRESS + " LIKE ? AND a." + MOVE_DATE + " LIKE ? "
        + " AND a." + PHONE_NUMBER + " LIKE ? AND a." + EMPLOYER + " LIKE ? AND a." + JOB_TITLE + " LIKE ? "
        + "AND a." + SALARY + " LIKE ? AND ap." + APP_PROP_STATUS + " LIKE ? AND ( -1 = ? OR ap." + APP_PROP_PROPID + " = ? );";
    public static final String UPDATE_APPLICANT = "UPDATE Applicant "
        + "SET " + FNAME + " = ?, " + LNAME + " = ?, " + MNAME + " = ?, " 
        + CREDIT_SCORE + " = ?, " + ADDRESS + " = ?, " + MOVE_DATE + " = ?, " + PHONE_NUMBER + " = ?, "
        + EMPLOYER + " = ?, " + JOB_TITLE + " = ?, " + SALARY + " = ? "
        + " WHERE " + SSN + " = ? ";
    
    public static final String APPLICANT_FOR_PROPERTY = 
        " SELECT * FROM Applicant a"
        + " INNER JOIN Applicant_Applies_For_Property ap ON ap.Applicant_ssn = a.ssn"
        + " INNER JOIN Property p ON p.propertyID = ap.Property_propertyID ";
    public static final String INSERT_APP_PROPERTY_RELATION = ""
            + "INSERT INTO Applicant_Applies_For_Property (Applicant_Ssn, Property_propertyID, Property_Tennant_ssn, applicationStatus) "
            + " VALUES (?, ?, ?, ?)";
    public static final String UPDATE_APP_PROPERTY_RELATION = ""
            + "UPDATE Applicant_Applies_For_Property "
            + "SET " + APP_PROP_APPSSN + " = ?, " + APP_PROP_PROPID + " = ?, " + APP_PROP_STATUS + " = ? "
            + " WHERE " + APP_PROP_APPSSN + " = ? AND " + APP_PROP_PROPID + " = ?" ;
    
    public List<ApplicantEntity> getAllApplications() {
        Connection conn;
        try { 
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            
            Statement stmt = conn.createStatement();
            List<ApplicantEntity> applicants = new ArrayList<>();
            ResultSet results = stmt.executeQuery(APPLICANT_FOR_PROPERTY);
            while(results.next()) { 
                ApplicantEntity applicant = new ApplicantEntity();
                applicant.setSsn(results.getInt(SSN));
                applicant.setlName(results.getString(LNAME));
                applicant.setfName(results.getString(FNAME));
                applicant.setmName(results.getString(MNAME));
                applicant.setCreditScore(results.getString(CREDIT_SCORE));
                applicant.setAddress(results.getString(ADDRESS));
                applicant.setMoveDate(results.getString(MOVE_DATE));
                applicant.setPhoneNumber(results.getString(PHONE_NUMBER));
                applicant.setEmployer(results.getString(EMPLOYER));
                applicant.setJobTitle(results.getString(JOB_TITLE));
                applicant.setSalary(results.getString(SALARY));
                applicant.setApplicationStatus(results.getString(APP_PROP_STATUS));
                applicant.setPropertyID(results.getInt(APP_PROP_PROPID));
                applicants.add(applicant);
            }
            
            conn.close();
            return applicants;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return null;
        } 
    }
    
    public boolean insertApplicant(ApplicantEntity app) {
        Connection conn;
        try { 
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(CREATE_APPLICANT);
            
            stmt.setInt(i++, app.getSsn());
            stmt.setString(i++, app.getfName());
            stmt.setString(i++, app.getlName());
            stmt.setString(i++, app.getmName());
            stmt.setString(i++, app.getCreditScore());
            stmt.setString(i++, app.getAddress());
            stmt.setString(i++, app.getMoveDate());
            stmt.setString(i++, app.getPhoneNumber());
            stmt.setString(i++, app.getEmployer());
            stmt.setString(i++, app.getJobTitle());
            stmt.setString(i++, app.getSalary());
            stmt.executeUpdate();
            
            conn.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public List<ApplicantEntity> getFilteredApplications(ApplicantEntity app) {
        List<ApplicantEntity> applicants = new ArrayList<>();
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(FILTER_APPLICANTS);
            
            stmt.setInt(i++, app.getSsn());
            stmt.setInt(i++, app.getSsn());
            stmt.setString(i++, StringUtils.isEmpty(app.getfName()) ? "%" : "%" + app.getfName()+ "%" );
            stmt.setString(i++, StringUtils.isEmpty(app.getlName()) ? "%" : "%" + app.getlName() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getmName()) ? "%" : "%" + app.getmName() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getCreditScore()) ? "%" : "%" + app.getCreditScore() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getAddress()) ? "%" : "%" + app.getAddress() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getMoveDate()) ? "%" : "%" + app.getMoveDate() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getPhoneNumber()) ? "%" : "%" + app.getPhoneNumber() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getEmployer()) ? "%" : "%" + app.getEmployer() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getJobTitle()) ? "%" : "%" + app.getJobTitle() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getSalary()) ? "%" : "%" + app.getSalary() + "%");
            stmt.setString(i++, StringUtils.isEmpty(app.getApplicationStatus()) ? "%" : "%" + app.getApplicationStatus() + "%");
            stmt.setInt(i++, app.getPropertyID());
            stmt.setInt(i++, app.getPropertyID());
            
            ResultSet results = stmt.executeQuery();
            
            while(results.next()) { 
                ApplicantEntity applicant = new ApplicantEntity();
                applicant.setSsn(results.getInt(SSN));
                applicant.setlName(results.getString(LNAME));
                applicant.setfName(results.getString(FNAME));
                applicant.setmName(results.getString(MNAME));
                applicant.setCreditScore(results.getString(CREDIT_SCORE));
                applicant.setAddress(results.getString(ADDRESS));
                applicant.setMoveDate(results.getString(MOVE_DATE));
                applicant.setPhoneNumber(results.getString(PHONE_NUMBER));
                applicant.setEmployer(results.getString(EMPLOYER));
                applicant.setJobTitle(results.getString(JOB_TITLE));
                applicant.setSalary(results.getString(SALARY));
                applicant.setApplicationStatus(results.getString(APP_PROP_STATUS));
                applicant.setPropertyID(results.getInt(APP_PROP_PROPID));
                applicants.add(applicant);
            }
            
            conn.close();
            return applicants;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return applicants;
        } 
    } 
    
    public boolean insertApplicantPropertyRelationship(ApplicantEntity app, int propertyID) { 
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(INSERT_APP_PROPERTY_RELATION);
            
            stmt.setInt(i++, app.getSsn());
            stmt.setInt(i++, propertyID);
            stmt.setString(i++, null);
            stmt.setString(i++, app.getApplicationStatus());
            
            stmt.executeUpdate();
            
            conn.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public boolean updateApplicant(ApplicantEntity app) { 
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(UPDATE_APPLICANT);
            
            stmt.setString(i++, app.getfName());
            stmt.setString(i++, app.getlName());
            stmt.setString(i++, app.getmName());
            stmt.setString(i++, app.getCreditScore());
            stmt.setString(i++, app.getAddress());
            stmt.setString(i++, app.getMoveDate());
            stmt.setString(i++, app.getPhoneNumber());
            stmt.setString(i++, app.getEmployer());
            stmt.setString(i++, app.getJobTitle());
            stmt.setString(i++, app.getSalary());
            stmt.setInt(i++, app.getSsn());
            
            stmt.executeUpdate();
            
            conn.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public boolean updateApplicantPropertyRelationship(ApplicantEntity app) { 
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(INSERT_APP_PROPERTY_RELATION);
            
            stmt.setInt(i++, app.getSsn());
            stmt.setInt(i++, app.getPropertyID());
            stmt.setString(i++, null);
            stmt.setString(i++, app.getApplicationStatus());
            stmt.setInt(i++, app.getSsn());
            stmt.setInt(i++, app.getPropertyID());
            
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