package realEstate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import utilities.APP_CONSTANTS;

/**
 *
 * @author domin
 */
public class Properties {
    public static JPanel createPropertiesPane() { 
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(APP_CONSTANTS.PROPERTIES);
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        return card1;
    }
}
