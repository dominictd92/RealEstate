package realEstate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import utilities.APP_CONSTANTS;

/**
 *
 * @author ahead01
 */
public class Seller {
    public static JPanel createSellerPane() {
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(APP_CONSTANTS.SELLER);
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        return card1;
    }
}
