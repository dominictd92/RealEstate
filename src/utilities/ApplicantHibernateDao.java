package utilities;

/**
 * @author ddangerfield
 * This holds all of the sql statements that are needed 
 * for the Applicants page
 */
public class ApplicantHibernateDao {
	public static String getApplicants = "SELECT * FROM Applicants"; 
	public static String createApplicant = "INSERT INTO Applicants() VALUES()";
}
