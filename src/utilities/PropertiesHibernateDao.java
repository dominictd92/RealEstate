package utilities;

/**
 * @author ddangerfield
 * This holds all of the sql statements that are needed 
 * for the Properties page
 */
public class PropertiesHibernateDao {
	public static String getProperties = "SELECT * FROM Properties"; 
	public static String createProperty = "INSERT INTO Properties() VALUES()";
}
