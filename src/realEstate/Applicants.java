package realEstate;

import entities.ApplicantEntity;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import queries.ApplicantHibernateDao;
import static realEstate.Main.frame;
import utilities.APPLICANTS_CONSTANTS;
import utilities.APP_CONSTANTS;

/**
 *
 * @author ddangerfield
 */
public class Applicants {
    public static ApplicantHibernateDao dao = new ApplicantHibernateDao();
    public static JPanel createApplicantsPane() {
    	JPanel card1 = new JPanel();
        card1.setLayout(null);
        
    	JLabel header = new JLabel(APP_CONSTANTS.APPLICANTS);
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        JButton createApplicants = new JButton("Create Applicants");
        createApplicants.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.CREATE_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        createApplicants.addActionListener((ActionEvent e) -> {
            //display/center the jdialog when the button is pressed
            List<ApplicantEntity> retrieval = dao.getAllApplications();
            
            JDialog d = new JDialog(frame, "Create Applicants", true);
            d.setLayout(null);
            d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            
            //ROW 1
            JLabel fNameLabel = new JLabel("First Name:");
            fNameLabel.setBounds(APPLICANTS_CONSTANTS.FNAME_LABEL_POSITION_X, APPLICANTS_CONSTANTS.FNAME_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(fNameLabel);
            
            JTextField fNameField = new JTextField(); 
            fNameField.setBounds(APPLICANTS_CONSTANTS.FNAME_TEXT_POSITION_X, APPLICANTS_CONSTANTS.FNAME_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(fNameField);
            
            JLabel mNameLabel = new JLabel("Middle Name:");
            mNameLabel.setBounds(APPLICANTS_CONSTANTS.MNAME_LABEL_POSITION_X, APPLICANTS_CONSTANTS.MNAME_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(mNameLabel);
            
            JTextField mNameField = new JTextField(); 
            mNameField.setBounds(APPLICANTS_CONSTANTS.MNAME_TEXT_POSITION_X, APPLICANTS_CONSTANTS.MNAME_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(mNameField);
    
            JLabel lNameLabel = new JLabel("Last Name:");
            lNameLabel.setBounds(APPLICANTS_CONSTANTS.LNAME_LABEL_POSITION_X, APPLICANTS_CONSTANTS.LNAME_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(lNameLabel);
            
            JTextField lNameField = new JTextField(); 
            lNameField.setBounds(APPLICANTS_CONSTANTS.LNAME_TEXT_POSITION_X, APPLICANTS_CONSTANTS.LNAME_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(lNameField);
            //ROW 2
            JLabel ssnLabel = new JLabel("SSN:");
            ssnLabel.setBounds(APPLICANTS_CONSTANTS.SSN_LABEL_POSITION_X, APPLICANTS_CONSTANTS.SSN_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(ssnLabel);
            
            JTextField ssnField = new JTextField(); 
            ssnField.setBounds(APPLICANTS_CONSTANTS.SSN_TEXT_POSITION_X, APPLICANTS_CONSTANTS.SSN_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(ssnField);
            
            JLabel addressLabel = new JLabel("Address:");
            addressLabel.setBounds(APPLICANTS_CONSTANTS.ADDRESS_LABEL_POSITION_X, APPLICANTS_CONSTANTS.ADDRESS_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(addressLabel);
            
            JTextField addressField = new JTextField(); 
            addressField.setBounds(APPLICANTS_CONSTANTS.ADDRESS_TEXT_POSITION_X, APPLICANTS_CONSTANTS.ADDRESS_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(addressField);
            
            JLabel creditLabel = new JLabel("Credit Score:");
            creditLabel.setBounds(APPLICANTS_CONSTANTS.CREDIT_LABEL_POSITION_X, APPLICANTS_CONSTANTS.CREDIT_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(creditLabel);
            
            JTextField creditField = new JTextField(); 
            creditField.setBounds(APPLICANTS_CONSTANTS.CREDIT_TEXT_POSITION_X, APPLICANTS_CONSTANTS.CREDIT_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(creditField);
            
            //ROW 3
            JLabel moveLabel = new JLabel("Move Date:");
            moveLabel.setBounds(APPLICANTS_CONSTANTS.MOVE_LABEL_POSITION_X, APPLICANTS_CONSTANTS.MOVE_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(moveLabel);
            
            JTextField moveField = new JTextField(); 
            moveField.setBounds(APPLICANTS_CONSTANTS.MOVE_TEXT_POSITION_X, APPLICANTS_CONSTANTS.MOVE_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(moveField);
            
            JLabel phoneLabel = new JLabel("Phone Number:");
            phoneLabel.setBounds(APPLICANTS_CONSTANTS.PHONE_LABEL_POSITION_X, APPLICANTS_CONSTANTS.PHONE_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(phoneLabel);
            
            JTextField phoneField = new JTextField(); 
            phoneField.setBounds(APPLICANTS_CONSTANTS.PHONE_TEXT_POSITION_X, APPLICANTS_CONSTANTS.PHONE_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(phoneField);
            
            //ROW 4
            JLabel employerLabel = new JLabel("Employer:");
            employerLabel.setBounds(APPLICANTS_CONSTANTS.EMPLOYER_LABEL_POSITION_X, APPLICANTS_CONSTANTS.EMPLOYER_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(employerLabel);
            
            JTextField employerField = new JTextField(); 
            employerField.setBounds(APPLICANTS_CONSTANTS.EMPLOYER_TEXT_POSITION_X, APPLICANTS_CONSTANTS.EMPLOYER_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(employerField);
            
            JLabel jobLabel = new JLabel("Job Title:");
            jobLabel.setBounds(APPLICANTS_CONSTANTS.JOB_LABEL_POSITION_X, APPLICANTS_CONSTANTS.JOB_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(jobLabel);
            
            JTextField jobField = new JTextField(); 
            jobField.setBounds(APPLICANTS_CONSTANTS.JOB_TEXT_POSITION_X, APPLICANTS_CONSTANTS.JOB_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(jobField);
            
            JLabel salaryLabel = new JLabel("Salary:");
            salaryLabel.setBounds(APPLICANTS_CONSTANTS.SALARY_LABEL_POSITION_X, APPLICANTS_CONSTANTS.SALARY_LABEL_POSITION_Y, 
                    APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            d.add(salaryLabel);
            
            JTextField salaryField = new JTextField(); 
            salaryField.setBounds(APPLICANTS_CONSTANTS.SALARY_TEXT_POSITION_X, APPLICANTS_CONSTANTS.SALARY_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(salaryField);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(APPLICANTS_CONSTANTS.SUBMIT_POSITION_X, APPLICANTS_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener((ActionEvent ae) -> {
                ApplicantEntity applicant = new ApplicantEntity(); 
                applicant.setfName(fNameField.getText());
                applicant.setmName(mNameField.getText());
                applicant.setlName(lNameField.getText());
                applicant.setSsn(Integer.getInteger(ssnField.getText()));
                applicant.setAddress(addressField.getText());
                applicant.setCreditScore(creditField.getText());
                applicant.setMoveDate(moveField.getText());
                applicant.setPhoneNumber(phoneField.getText());
                applicant.setEmployer(employerField.getText());
                applicant.setJobTitle(jobField.getText());
                applicant.setSalary(salaryField.getText());
                
                if (dao.insertApplicant(applicant)) { 
                    System.out.println("Completed insert");
                } else { 
                    System.out.println("Error occured on import.");
                }
            });
            d.add(submit);
            
            d.setVisible(true);
        });
        card1.add(createApplicants);
        
        JButton viewApplicants = new JButton("View All Applicants");
        viewApplicants.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.VIEW_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        viewApplicants.addActionListener((ActionEvent e) -> {
            //display/center the jdialog when the button is pressed
            ApplicantHibernateDao dao = new ApplicantHibernateDao();
            List<ApplicantEntity> retrieval = dao.getAllApplications();
            
            JDialog d = new JDialog(frame, "View All Applicants", true);
            d.setBounds(0, 0, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            d.setVisible(true);
        });
        card1.add(viewApplicants);
        
        JButton filterApplicants = new JButton("Filter Applicants");
        filterApplicants.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.FILTER_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        filterApplicants.addActionListener((ActionEvent e) -> {
            //display/center the jdialog when the button is pressed
            ApplicantHibernateDao dao = new ApplicantHibernateDao();
            List<ApplicantEntity> retrieval = dao.getAllApplications();
            
            JDialog d = new JDialog(frame, "Filter Applicants", true);
            d.setBounds(0, 0, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            d.setVisible(true);
        });
        card1.add(filterApplicants);
        
        return card1;
    }
    
    public JDialog createNewApplicant () {
        JDialog dialog = new JDialog(); 
        
        return dialog;
    }
}
