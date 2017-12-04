package utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

public class APP_CONSTANTS {
	public final static int WINDOW_HEIGHT = 600;
	public final static int WINDOW_WIDTH = 800;
	public final static Color BACKGROUND_COLOR = UIManager.getColor("Panel.background");
	
	//Objects
	public final static int BUTTON_WIDTH = 175;
	public final static int BUTTON_HEIGHT = 25;
	
	//Headers
	public final static int HEADER_X = 0;
	public final static int HEADER_Y = 0;
	public final static Font HEADER_FONT = new Font("Courier", Font.BOLD, 20);
	public final static int PAGE_TITLE_WIDTH = WINDOW_WIDTH;
	public final static int PAGE_TITLE_HEIGHT = 50;
	
	//Center the data under the header
	public final static int CENTER_X = 100; 
	public final static int CENTER_WIDTH = WINDOW_WIDTH - (CENTER_X * 2);
        public final static int CENTER_Y = 100;
        public final static int CENTER_HEIGHT = WINDOW_HEIGHT - (CENTER_Y * 2);
	
	//Home Constants
	public final static String HOME = "SHD Real Estate Investments";
	public final static String DEVELOPERS = "Creators: Charles Carr, Dominic Dangerfield, Austin Dase, Justin Lewis, Emmanuel Teko";
	public final static String HOME_INFO = "This application maintains the SHD Real Estate Investments. The data from here is connected"
		+ " to the servers \nof Towson University.";
	public final static int DEVELOPERS_HEIGHT = 25;
	public final static int HOME_INFO_HEIGHT = 100;
	public final static int HOME_INFO_START_LINE = PAGE_TITLE_HEIGHT + (DEVELOPERS_HEIGHT * 2);
	
	//Applicants Constants
	public final static String APPLICANTS = "Applicants";
        public final static int APPLICANTS_BUTTON_X = WINDOW_WIDTH/2 - BUTTON_WIDTH/2;
        
        public final static int CREATE_BUTTON_Y = PAGE_TITLE_HEIGHT + 10;
        public final static int VIEW_BUTTON_Y = PAGE_TITLE_HEIGHT + 45;
        public final static int FILTER_BUTTON_Y = PAGE_TITLE_HEIGHT + 80;
        public final static int UPDATE_BUTTON_Y = PAGE_TITLE_HEIGHT + 115;
        
	//Properties Constants
	public final static String PROPERTIES = "Properties";

	//Seller Constants
	public final static String SELLER = "Seller";
}
