package realEstate;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import utilities.APP_CONSTANTS;

/**
 *
 * @author ddangerfield
 */
public class Home {
     public static JPanel createHomePane() {
    	@SuppressWarnings("serial")
		JPanel card1 = new JPanel() {
            //Create the JPanels correct size. This can be done once. 
            @Override
            public Dimension getPreferredSize() {
            	Dimension size = new Dimension(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            	return size;
            }
        };
        //clear the layout as it automatically sets the layout. 
        card1.setLayout(null);
        
        JLabel header = new JLabel(APP_CONSTANTS.HOME);
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        JLabel devs = new JLabel(APP_CONSTANTS.DEVELOPERS);
        devs.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.PAGE_TITLE_HEIGHT, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.DEVELOPERS_HEIGHT);
        devs.setHorizontalAlignment(JLabel.CENTER);
        card1.add(devs);
        
        JTextArea pageInfo = new JTextArea(APP_CONSTANTS.HOME_INFO);
        pageInfo.setBounds(APP_CONSTANTS.CENTER_X, APP_CONSTANTS.HOME_INFO_START_LINE, APP_CONSTANTS.CENTER_WIDTH, APP_CONSTANTS.HOME_INFO_HEIGHT);
        pageInfo.setBackground(APP_CONSTANTS.BACKGROUND_COLOR);
        card1.add(pageInfo);
        
        return card1;
    }
}
