package realEstate;

import entities.ApplicantEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import queries.ApplicantHibernateDao;
import static realEstate.Main.frame;
import utilities.APP_CONSTANTS;

/**
 *
 * @author ddangerfield
 */
public class Applicants {
    public static JPanel createApplicantsPane() {
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(APP_CONSTANTS.APPLICANTS);
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        JButton showData = new JButton("Push Button");
        showData.addActionListener((ActionEvent e) -> {
            //display/center the jdialog when the button is pressed
            ApplicantHibernateDao dao = new ApplicantHibernateDao();
            List<ApplicantEntity> retrieval = dao.getAllApplications();
            
            JDialog d = new JDialog(frame, "Applicants", true);
            d.setBounds(400, 400, 50, 100);
            d.setVisible(true);
        });
        showData.setBounds(200, 200, 100, 100);
        card1.add(showData);
        
        return card1;
    }
}
