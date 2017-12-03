package realEstate;

import entities.ApplicantEntity;
import entities.PropertyEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.springframework.util.StringUtils;
import queries.ApplicantHibernateDao;
import static realEstate.Main.frame;
import utilities.APPLICANTS_CONSTANTS;
import utilities.APP_CONSTANTS;

/**
 *
 * @author ddangerfield
 */
public class Applicants {
    static ApplicantHibernateDao dao = new ApplicantHibernateDao();
    static JTextField fNameField, mNameField, lNameField, ssnField, addressField, creditField, moveField,
        phoneField, employerField, jobField, salaryField;
    static JLabel fNameLabel, mNameLabel, lNameLabel, ssnLabel, addressLabel, creditLabel, moveLabel,
        phoneLabel, employerLabel, jobLabel, salaryLabel; 
    
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
            List<ApplicantEntity> retrieval = dao.getAllApplications();
            
            JDialog d = new JDialog(frame, "Create Applicants", true);
            d.setLayout(null);
            d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            
            getLabelsAndTextAreas(d);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(APPLICANTS_CONSTANTS.SUBMIT_POSITION_X, APPLICANTS_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    ApplicantEntity applicant = new ApplicantEntity();
                    applicant.setfName(fNameField.getText());
                    applicant.setmName(mNameField.getText());
                    applicant.setlName(lNameField.getText());
                    applicant.setSsn(Integer.parseInt(ssnField.getText()));
                    applicant.setAddress(addressField.getText());
                    applicant.setCreditScore(creditField.getText());
                    applicant.setMoveDate(moveField.getText());
                    applicant.setPhoneNumber(phoneField.getText());
                    applicant.setEmployer(employerField.getText());
                    applicant.setJobTitle(jobField.getText());
                    applicant.setSalary(salaryField.getText());
                    
                    String result;
                    if (dao.insertApplicant(applicant)) {
                        result = "Completed insert";
                    } else {
                        result = "Error occured on import.";
                    }
                    
                    d.dispose();
                    JDialog success = new JDialog();
                    success.setBounds(APP_CONSTANTS.WINDOW_WIDTH/2, APP_CONSTANTS.WINDOW_HEIGHT/2, 200, 100);
                    success.setName("Result");
                    
                    JLabel resultReturn = new JLabel(result);
                    resultReturn.setVerticalAlignment(JLabel.CENTER);
                    resultReturn.setHorizontalAlignment(JLabel.CENTER);
                    
                    success.add(resultReturn);
                    success.setVisible(true);
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
            JDialog d = new JDialog(frame, "View All Applicants", true);
            d.setBounds(0, 0, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            d.setLayout(null);
            
            List<ApplicantEntity> retrieval = dao.getAllApplications();
            Object[][] objects = new Object[retrieval.size() + 1][new ApplicantEntity().getColumnArray().length];
            int i = 0;
            objects[i++] = new ApplicantEntity().getColumnArray();
            for (ApplicantEntity applicant : retrieval) {
                objects[i++] = applicant.getApplicantArray();
            }
            JTable resultsTable = new JTable(objects, new ApplicantEntity().getColumnArray());
            resultsTable.setBounds(0, 50, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            resultsTable.setBackground(APP_CONSTANTS.BACKGROUND_COLOR);
            d.add(resultsTable);
            
            d.setVisible(true);
        });
        card1.add(viewApplicants);
        
        JButton filterApplicants = new JButton("Filter Applicants");
        filterApplicants.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.FILTER_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        filterApplicants.addActionListener((ActionEvent e) -> {
            
            JDialog d = new JDialog(frame, "Filter Applicants", true);
            d.setLayout(null);
            d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            
            getLabelsAndTextAreas(d);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(APPLICANTS_CONSTANTS.SUBMIT_POSITION_X, APPLICANTS_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener((ActionEvent ae) -> {
                ApplicantEntity applicant = new ApplicantEntity(); 
                applicant.setfName(fNameField.getText());
                applicant.setmName(mNameField.getText());
                applicant.setlName(lNameField.getText());
                applicant.setSsn(StringUtils.isEmpty(ssnField.getText()) ? -1 : Integer.valueOf(ssnField.getText()));
                applicant.setAddress(addressField.getText());
                applicant.setCreditScore(creditField.getText());
                applicant.setMoveDate(moveField.getText());
                applicant.setPhoneNumber(phoneField.getText());
                applicant.setEmployer(employerField.getText());
                applicant.setJobTitle(jobField.getText());
                applicant.setSalary(salaryField.getText());
                
                List<ApplicantEntity> results = dao.getFilteredApplications(applicant);
                Object[][] objects = new Object[results.size() + 1][applicant.getColumnArray().length];
                JDialog resultDialog = new JDialog(); 
                resultDialog.setLayout(null);
                resultDialog.setBounds(0, 0, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                
                int i = 0;
                objects[i++] = new ApplicantEntity().getColumnArray();
                for (ApplicantEntity applicants : results) {
                    objects[i++] = applicants.getApplicantArray();
                }
                JTable resultsTable = new JTable(objects, new ApplicantEntity().getColumnArray());
                resultsTable.setBounds(0, 50, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                resultsTable.setBackground(APP_CONSTANTS.BACKGROUND_COLOR);
                resultDialog.add(resultsTable);
                
                d.dispose();
                resultDialog.setVisible(true);
            });
            d.add(submit);
            
            d.setVisible(true);
        });
        card1.add(filterApplicants);
        
        return card1;
    }   
    
    public static void getLabelsAndTextAreas(JDialog d) {
        fNameLabel = new JLabel("First Name:");
        fNameLabel.setBounds(APPLICANTS_CONSTANTS.FNAME_LABEL_POSITION_X, APPLICANTS_CONSTANTS.FNAME_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(fNameLabel);
        
        fNameField = new JTextField(); 
        fNameField.setBounds(APPLICANTS_CONSTANTS.FNAME_TEXT_POSITION_X, APPLICANTS_CONSTANTS.FNAME_TEXT_POSITION_Y, 
            APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(fNameField);
        
        mNameLabel = new JLabel("Middle Name:");
        mNameLabel.setBounds(APPLICANTS_CONSTANTS.MNAME_LABEL_POSITION_X, APPLICANTS_CONSTANTS.MNAME_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(mNameLabel);
            
        mNameField = new JTextField(); 
            mNameField.setBounds(APPLICANTS_CONSTANTS.MNAME_TEXT_POSITION_X, APPLICANTS_CONSTANTS.MNAME_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(mNameField);
        
        lNameLabel = new JLabel("Last Name:");
        lNameLabel.setBounds(APPLICANTS_CONSTANTS.LNAME_LABEL_POSITION_X, APPLICANTS_CONSTANTS.LNAME_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(lNameLabel);
        
        lNameField = new JTextField(); 
            lNameField.setBounds(APPLICANTS_CONSTANTS.LNAME_TEXT_POSITION_X, APPLICANTS_CONSTANTS.LNAME_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(lNameField);
        
        ssnLabel = new JLabel("SSN:");
        ssnLabel.setBounds(APPLICANTS_CONSTANTS.SSN_LABEL_POSITION_X, APPLICANTS_CONSTANTS.SSN_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(ssnLabel);
        
        ssnField = new JTextField(); 
        ssnField.setBounds(APPLICANTS_CONSTANTS.SSN_TEXT_POSITION_X, APPLICANTS_CONSTANTS.SSN_TEXT_POSITION_Y, 
            APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(ssnField);
        
        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(APPLICANTS_CONSTANTS.ADDRESS_LABEL_POSITION_X, APPLICANTS_CONSTANTS.ADDRESS_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(addressLabel);
        
        addressField = new JTextField(); 
        addressField.setBounds(APPLICANTS_CONSTANTS.ADDRESS_TEXT_POSITION_X, APPLICANTS_CONSTANTS.ADDRESS_TEXT_POSITION_Y, 
            APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(addressField);
        
        creditLabel = new JLabel("Credit Score:");
        creditLabel.setBounds(APPLICANTS_CONSTANTS.CREDIT_LABEL_POSITION_X, APPLICANTS_CONSTANTS.CREDIT_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(creditLabel);
        
        creditField = new JTextField(); 
        creditField.setBounds(APPLICANTS_CONSTANTS.CREDIT_TEXT_POSITION_X, APPLICANTS_CONSTANTS.CREDIT_TEXT_POSITION_Y, 
            APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(creditField);
        
        moveLabel = new JLabel("Move Date:");
        moveLabel.setBounds(APPLICANTS_CONSTANTS.MOVE_LABEL_POSITION_X, APPLICANTS_CONSTANTS.MOVE_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(moveLabel);
        
        moveField = new JTextField(); 
        moveField.setBounds(APPLICANTS_CONSTANTS.MOVE_TEXT_POSITION_X, APPLICANTS_CONSTANTS.MOVE_TEXT_POSITION_Y, 
            APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(moveField);
        
        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(APPLICANTS_CONSTANTS.PHONE_LABEL_POSITION_X, APPLICANTS_CONSTANTS.PHONE_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(phoneLabel);
        
        phoneField = new JTextField(); 
            phoneField.setBounds(APPLICANTS_CONSTANTS.PHONE_TEXT_POSITION_X, APPLICANTS_CONSTANTS.PHONE_TEXT_POSITION_Y, 
                    APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(phoneField);
        
        employerLabel = new JLabel("Employer:");
        employerLabel.setBounds(APPLICANTS_CONSTANTS.EMPLOYER_LABEL_POSITION_X, APPLICANTS_CONSTANTS.EMPLOYER_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(employerLabel);
        
        employerField = new JTextField(); 
        employerField.setBounds(APPLICANTS_CONSTANTS.EMPLOYER_TEXT_POSITION_X, APPLICANTS_CONSTANTS.EMPLOYER_TEXT_POSITION_Y, 
            APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(employerField);
        
        jobLabel = new JLabel("Job Title:");
        jobLabel.setBounds(APPLICANTS_CONSTANTS.JOB_LABEL_POSITION_X, APPLICANTS_CONSTANTS.JOB_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(jobLabel);
        
        jobField = new JTextField(); 
        jobField.setBounds(APPLICANTS_CONSTANTS.JOB_TEXT_POSITION_X, APPLICANTS_CONSTANTS.JOB_TEXT_POSITION_Y, 
            APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(jobField);
        
        salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(APPLICANTS_CONSTANTS.SALARY_LABEL_POSITION_X, APPLICANTS_CONSTANTS.SALARY_LABEL_POSITION_Y, 
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(salaryLabel);
        
        salaryField = new JTextField(); 
        salaryField.setBounds(APPLICANTS_CONSTANTS.SALARY_TEXT_POSITION_X, APPLICANTS_CONSTANTS.SALARY_TEXT_POSITION_Y, 
            APPLICANTS_CONSTANTS.TEXT_AREA_WIDTH, APPLICANTS_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(salaryField);
    }
    
    public static List<PropertyEntity> getPropertiesToApplyFor() { 
        
        return null;
    }
}
