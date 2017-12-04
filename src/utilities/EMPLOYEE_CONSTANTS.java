package utilities;

/**
 *
 * @author ddangerfield
 */
public class EMPLOYEE_CONSTANTS {
    
    public static final int LABEL_SIZE_WIDTH = 100;
    public static final int LABEL_SIZE_HEIGHT = 25;
    
    public static final int TEXT_AREA_WIDTH = 100;
    public static final int TEXT_AREA_HEIGHT = 25;
    
    public static final int DROPDOWN_WIDTH = 100;
    public static final int DROPDOWN_HEIGHT = 25;
    
    //ROW 1
    public static final int FNAME_LABEL_POSITION_X = 25;
    public static final int FNAME_LABEL_POSITION_Y = 50;
    public static final int FNAME_TEXT_POSITION_X = FNAME_LABEL_POSITION_X + LABEL_SIZE_WIDTH + 10;
    public static final int FNAME_TEXT_POSITION_Y = FNAME_LABEL_POSITION_Y;
    
    public static final int MNAME_LABEL_POSITION_X = FNAME_TEXT_POSITION_X + TEXT_AREA_WIDTH + 25;
    public static final int MNAME_LABEL_POSITION_Y = FNAME_LABEL_POSITION_Y;
    public static final int MNAME_TEXT_POSITION_X = MNAME_LABEL_POSITION_X + LABEL_SIZE_WIDTH + 10;
    public static final int MNAME_TEXT_POSITION_Y = FNAME_LABEL_POSITION_Y;
    
    public static final int LNAME_LABEL_POSITION_X = MNAME_TEXT_POSITION_X + TEXT_AREA_WIDTH + 25;
    public static final int LNAME_LABEL_POSITION_Y = FNAME_LABEL_POSITION_Y;
    public static final int LNAME_TEXT_POSITION_X = LNAME_LABEL_POSITION_X + LABEL_SIZE_WIDTH + 10;
    public static final int LNAME_TEXT_POSITION_Y = FNAME_LABEL_POSITION_Y;
    
    //ROW 2
    public static final int SSN_LABEL_POSITION_X = FNAME_LABEL_POSITION_X;
    public static final int SSN_LABEL_POSITION_Y = FNAME_LABEL_POSITION_Y + LABEL_SIZE_HEIGHT + 50;
    public static final int SSN_TEXT_POSITION_X = SSN_LABEL_POSITION_X + LABEL_SIZE_WIDTH + 10;
    public static final int SSN_TEXT_POSITION_Y = SSN_LABEL_POSITION_Y;
    
    public static final int PAY_LABEL_POSITION_X = SSN_TEXT_POSITION_X + TEXT_AREA_WIDTH + 25;
    public static final int PAY_LABEL_POSITION_Y = SSN_LABEL_POSITION_Y;
    public static final int PAY_TEXT_POSITION_X = PAY_LABEL_POSITION_X + LABEL_SIZE_WIDTH + 10;
    public static final int PAY_TEXT_POSITION_Y = PAY_LABEL_POSITION_Y;
    
    public static final int PHONE_LABEL_POSITION_X = PAY_TEXT_POSITION_X + TEXT_AREA_WIDTH + 25;
    public static final int PHONE_LABEL_POSITION_Y = PAY_LABEL_POSITION_Y;
    public static final int PHONE_TEXT_POSITION_X = PHONE_LABEL_POSITION_X + LABEL_SIZE_WIDTH + 10;
    public static final int PHONE_TEXT_POSITION_Y = PAY_LABEL_POSITION_Y;
    //Row 3
    public static final int PROPERTY_LABEL_POSITION_X = FNAME_LABEL_POSITION_X;
    public static final int PROPERTY_LABEL_POSITION_Y = SSN_LABEL_POSITION_Y + LABEL_SIZE_HEIGHT + 50;
    public static final int PROPERTY_DROPDOWN_POSITION_X = PROPERTY_LABEL_POSITION_X + LABEL_SIZE_WIDTH + 10;
    public static final int PROPERTY_DROPDOWN_POSITION_Y = PROPERTY_LABEL_POSITION_Y;
    
    public static final int SUBMIT_POSITION_X = 25;
    public static final int SUBMIT_POSITION_Y = 400;
    
    //Update 
    public static final int UPDATE_LABEL_X = 25;
    public static final int UPDATE_LABEL_Y = 10;
    public static final int UPDATE_DROPDOWN_X = UPDATE_LABEL_X + LABEL_SIZE_WIDTH;
    public static final int UPDATE_DROPDOWN_Y = UPDATE_LABEL_Y;
    
    public static final int UPDATE_SUBMIT_Y = UPDATE_LABEL_Y + 35;
}