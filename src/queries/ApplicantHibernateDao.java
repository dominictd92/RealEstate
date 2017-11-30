package queries;

import entities.ApplicantEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utilities.DATABASE_CONSTANTS;

/**
 * This class contains all of the queries that support the Applicants
 * 
 * @author ddangerfield
 */
public class ApplicantHibernateDao {
    //constants for the objects so that names aren't mixed up 
    private static final String SSN = "ssn";
    private static final String FNAME = "fName";
    private static final String LNAME = "lName";
    private static final String MNAME = "mName";
    private static final String CREDIT_SCORE = "creditScore";
    private static final String ADDRESS = "address";
    private static final String MOVE_DATE = "moveDate";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String EMPLOYER = "employer";
    private static final String JOB_TITLE = "jobTitle";
    private static final String SALARY = "salary";
    
    //Put all of the queries above so the document is readable
    public static final String SELECT_APPLICANTS = "SELECT * FROM Applicant;";
    public static final String CREATE_APPLICANT = "INSERT INTO Applicant(ssn, fName, lName,"
            + " mName, creditScore, address, moveDate, phoneNumber, employer, jobTitle, salary)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FILTER_APPLICANTS = "";
    
    public List<ApplicantEntity> getAllApplications() {
        try { 
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            
            Statement stmt = conn.createStatement();
            List<ApplicantEntity> applicants = new ArrayList<>();
            ResultSet results = stmt.executeQuery(SELECT_APPLICANTS);
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
        try { 
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
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
    
}