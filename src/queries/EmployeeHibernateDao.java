package queries;

import entities.EmployeeEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import utilities.DATABASE_CONSTANTS;

/**
 * This class contains all of the queries that support the Employee
 * 
 * @author ddangerfield
 */
public class EmployeeHibernateDao {
    //constants for the objects so that database names aren't mixed up
    //if one is changed, change the constant and it's changed for all of the queries
    private static final String SSN = "ssn";
    private static final String FNAME = "f_Name";
    private static final String LNAME = "l_Name";
    private static final String MNAME = "m_Name";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String PAY = "pay";
    
    private static final String EMP_PROP_SSN = "Employee_ssn";
    private static final String EMP_PROP_PROPID = "Property_propertyID";
    private static final String EMP_PROP_TSSN = "Property_Tennant_ssn";
    
    //Put all of the queries above so the document is readable
    public static final String SELECT_EMPLOYEES = "SELECT * FROM Employee;";
    public static final String CREATE_EMPLOYEE = "INSERT INTO Employee(" + SSN + ", " + FNAME + ", " + LNAME
        + ", " + MNAME + ", " + PHONE_NUMBER + ", " + PAY + ")"
        + " VALUES(?, ?, ?, ?, ?, ?)";
    public static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE " + SSN + " = ?";
    public static final String FILTER_EMPLOYEE = "SELECT * FROM Employee a "
        + " INNER JOIN Employee_Works_At_Property p ON a." + SSN + " = p." + EMP_PROP_SSN
        + " WHERE (-1 = ? OR " + SSN + " = ? ) "
        + " AND a." + FNAME + " LIKE ? AND a." + LNAME + " LIKE ? AND a." + MNAME + " LIKE ? "
        + " AND a." + PHONE_NUMBER + " LIKE ? AND (-1 = ? OR a." + PAY + " = ? ) "
        + " AND (-1 = ? OR p." + EMP_PROP_PROPID + " = ?);";
    public static final String UPDATE_EMPLOYEE = "UPDATE Employee "
        + "SET " + FNAME + " = ?, " + LNAME + " = ?, " + MNAME + " = ?, " 
        + PHONE_NUMBER + " = ?, " + PAY + " = ? " + " WHERE " + SSN + " = ? ";
    public static final String EMPLOYEE_FOR_PROPERTY = 
        " SELECT * FROM Employee a "
        + " INNER JOIN Employee_Works_At_Property ap ON ap." + EMP_PROP_SSN + " = a." + SSN
        + " INNER JOIN Property p ON p.propertyID = ap.Property_propertyID ";
    public static final String INSERT_EMP_PROPERTY_RELATION = ""
            + "INSERT INTO Employee_Works_At_Property (" + EMP_PROP_SSN + ", " + EMP_PROP_PROPID + ", " + EMP_PROP_TSSN + ")"  
            + " VALUES (?, ?, ?)";
    public static final String UPDATE_EMP_PROPERTY_RELATION = ""
            + "UPDATE Employee_Works_At_Property "
            + " SET " + EMP_PROP_SSN + " = ?, " + EMP_PROP_PROPID + " = ?, " + EMP_PROP_TSSN +  " = ? "
            + " WHERE " + EMP_PROP_SSN + " = ? AND " + EMP_PROP_PROPID + " = ?" ;
    
    public List<EmployeeEntity> getAllEmployees() {
        Connection conn;
        try { 
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            
            Statement stmt = conn.createStatement();
            List<EmployeeEntity> employees = new ArrayList<>();
            ResultSet results = stmt.executeQuery(EMPLOYEE_FOR_PROPERTY);
            while(results.next()) { 
                EmployeeEntity employee = new EmployeeEntity();
                employee.setSsn(results.getInt(SSN));
                employee.setlName(results.getString(LNAME));
                employee.setfName(results.getString(FNAME));
                employee.setmName(results.getString(MNAME));
                employee.setPhoneNumber(results.getString(PHONE_NUMBER));
                employee.setPay(results.getBigDecimal(PAY));
                employee.setPropertyID(results.getInt(EMP_PROP_PROPID));
                employees.add(employee);
            }
            
            conn.close();
            return employees;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return null;
        } 
    }
    
    public boolean insertEmployee(EmployeeEntity app) {
        Connection conn;
        try { 
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(CREATE_EMPLOYEE);
            
            stmt.setInt(i++, app.getSsn());
            stmt.setString(i++, app.getfName());
            stmt.setString(i++, app.getlName());
            stmt.setString(i++, app.getmName());
            stmt.setString(i++, app.getPhoneNumber());
            stmt.setBigDecimal(i++, app.getPay());
            stmt.executeUpdate();
            
            conn.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public List<EmployeeEntity> getFilteredEmployees(EmployeeEntity emp) {
        List<EmployeeEntity> employees = new ArrayList<>();
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(FILTER_EMPLOYEE);
            
            stmt.setInt(i++, emp.getSsn());
            stmt.setInt(i++, emp.getSsn());
            stmt.setString(i++, StringUtils.isEmpty(emp.getfName()) ? "%" : "%" + emp.getfName()+ "%" );
            stmt.setString(i++, StringUtils.isEmpty(emp.getlName()) ? "%" : "%" + emp.getlName() + "%");
            stmt.setString(i++, StringUtils.isEmpty(emp.getmName()) ? "%" : "%" + emp.getmName() + "%");
            stmt.setString(i++, StringUtils.isEmpty(emp.getPhoneNumber()) ? "%" : "%" + emp.getPhoneNumber() + "%");
            stmt.setFloat(i++, emp.getPay().floatValue());
            stmt.setBigDecimal(i++, emp.getPay());
            stmt.setInt(i++, emp.getPropertyID());
            stmt.setInt(i++, emp.getPropertyID());
            System.out.println(stmt);
            ResultSet results = stmt.executeQuery();
            
            while(results.next()) { 
                EmployeeEntity employee = new EmployeeEntity();
                employee.setSsn(results.getInt(SSN));
                employee.setlName(results.getString(LNAME));
                employee.setfName(results.getString(FNAME));
                employee.setmName(results.getString(MNAME));
                employee.setPhoneNumber(results.getString(PHONE_NUMBER));
                employee.setPay(results.getBigDecimal(PAY));
                employee.setPropertyID(results.getInt(EMP_PROP_PROPID));
                employees.add(employee);
            }
            
            conn.close();
            return employees;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return employees;
        } 
    } 
    
    public boolean insertEmployeePropertyRelationship(EmployeeEntity emp, int propertyID) { 
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(INSERT_EMP_PROPERTY_RELATION);
            
            stmt.setInt(i++, emp.getSsn());
            stmt.setInt(i++, propertyID);
            stmt.setString(i++, null);
            
            stmt.executeUpdate();
            
            conn.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public boolean updateEmployee(EmployeeEntity emp) { 
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(UPDATE_EMPLOYEE);
            
            stmt.setString(i++, emp.getfName());
            stmt.setString(i++, emp.getlName());
            stmt.setString(i++, emp.getmName());
            stmt.setString(i++, emp.getPhoneNumber());
            stmt.setBigDecimal(i++, emp.getPay());
            stmt.setInt(i++, emp.getSsn());
            
            stmt.executeUpdate();
            
            conn.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println("Error caught...");
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public boolean updateEmployeePropertyRelationship(EmployeeEntity emp) { 
        Connection conn;
        try {
            Class.forName(DATABASE_CONSTANTS.DRIVER);
            conn = DriverManager.getConnection(DATABASE_CONSTANTS.URL, DATABASE_CONSTANTS.USERNAME, DATABASE_CONSTANTS.PASSWORD);
            int i = 1;
            PreparedStatement stmt = conn.prepareStatement(INSERT_EMP_PROPERTY_RELATION);
            
            stmt.setInt(i++, emp.getSsn());
            stmt.setInt(i++, emp.getPropertyID());
            stmt.setString(i++, null);
            
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