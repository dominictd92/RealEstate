package realEstate;

import entities.ApplicantEntity;
import entities.PropertyEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.springframework.util.StringUtils;
import queries.ApplicantHibernateDao;
import queries.PropertiesHibernateDao;
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
        phoneLabel, employerLabel, jobLabel, salaryLabel, statusLabel, propertyLabel; 
    static JComboBox statusList, propertyList;
    public static Integer applicantSsn;
    public static Integer propertyId;
    
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
            JDialog d = new JDialog(frame, "Create Applicants", true);
            d.setLayout(null);
            d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            
            getLabelsAndTextAreas(d);
            getPropertyLabelsAndDropdown(d);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(APPLICANTS_CONSTANTS.SUBMIT_POSITION_X, APPLICANTS_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    ApplicantEntity applicant = new ApplicantEntity(Integer.parseInt(ssnField.getText()), fNameField.getText(), 
                            mNameField.getText(), lNameField.getText(), addressField.getText(), phoneField.getText(),
                            creditField.getText(), moveField.getText(), employerField.getText(), 
                            jobField.getText(), salaryField.getText());
                    
                    applicant.setApplicationStatus(statusList.getSelectedItem().toString());
                    int propertyID = Integer.parseInt(StringUtils.trimAllWhitespace(propertyList.getSelectedItem().toString()));
                    
                    String result;
                    if (dao.insertApplicant(applicant) && dao.insertApplicantPropertyRelationship(applicant, propertyID)) {
                        result = "Completed insert";
                    } else {
                        result = "Error occured on creation";
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
            getPropertyLabelsAndDropdown(d);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(APPLICANTS_CONSTANTS.SUBMIT_POSITION_X, APPLICANTS_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener((ActionEvent ae) -> {
                ApplicantEntity applicant = new ApplicantEntity(Integer.parseInt(StringUtils.isEmpty(ssnField.getText()) ? "-1" : ssnField.getText()), 
                    fNameField.getText(), mNameField.getText(), lNameField.getText(), 
                    addressField.getText(), phoneField.getText(), creditField.getText(), 
                    moveField.getText(), employerField.getText(), jobField.getText(), salaryField.getText()); 
                applicant.setApplicationStatus(statusList.getSelectedItem().toString());
                applicant.setPropertyID(StringUtils.isEmpty(propertyList.getSelectedItem().toString()) ? 
                    -1 : Integer.parseInt(propertyList.getSelectedItem().toString()));
              
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
        
        JButton updateApplicants = new JButton("Update Applicants");
        updateApplicants.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.UPDATE_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        updateApplicants.addActionListener((ActionEvent e) -> {
            
            JDialog selectApplicant = new JDialog(frame, "Select Applicant", true);
            selectApplicant.setLayout(null);
            selectApplicant.setSize(350, 150);
            
            JLabel applicantLabel = new JLabel("Applicant SSN:");
            applicantLabel.setBounds(APPLICANTS_CONSTANTS.UPDATE_LABEL_X, APPLICANTS_CONSTANTS.UPDATE_LABEL_Y,
                APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
            selectApplicant.add(applicantLabel);
            
            JComboBox applicantDropdown = new JComboBox();
            applicantDropdown.setBounds(APPLICANTS_CONSTANTS.UPDATE_DROPDOWN_X, APPLICANTS_CONSTANTS.UPDATE_DROPDOWN_Y,
                APPLICANTS_CONSTANTS.DROPDOWN_WIDTH, APPLICANTS_CONSTANTS.DROPDOWN_HEIGHT);
            List<ApplicantEntity> applicants = dao.getAllApplications();
            for (ApplicantEntity applicant : applicants) {
                applicantDropdown.addItem(applicant.getSsn() + "; " + applicant.getPropertyID());
            }
            selectApplicant.add(applicantDropdown);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(APPLICANTS_CONSTANTS.SUBMIT_POSITION_X, APPLICANTS_CONSTANTS.UPDATE_SUBMIT_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener((ActionEvent ae) -> {
                JDialog d = new JDialog(frame, "Update Applicants", true);
                d.setLayout(null);
                d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                
                String select = applicantDropdown.getSelectedItem().toString();
                String[] selectArray = select.split(";");
                applicantSsn = Integer.parseInt(selectArray[0].trim());
                propertyId = Integer.parseInt(selectArray[1].trim());
                getLabelsAndTextAreas(d);
                getPropertyLabelsAndDropdown(d);
                //set the fields based on their selection
                for (ApplicantEntity applicant : applicants) {
                    if (Objects.equals(applicant.getSsn(), applicantSsn) && applicant.getPropertyID().equals(propertyId)) {
                        fNameField.setText(applicant.getfName()); 
                        mNameField.setText(applicant.getmName());  
                        lNameField.setText(applicant.getlName());
                        ssnField.setText(Integer.toString(applicant.getSsn()));
                        ssnField.setEnabled(false);
                        addressField.setText(applicant.getAddress());
                        creditField.setText(applicant.getCreditScore());
                        moveField.setText(applicant.getMoveDate());
                        phoneField.setText(applicant.getPhoneNumber());
                        employerField.setText(applicant.getEmployer());
                        jobField.setText(applicant.getJobTitle());
                        salaryField.setText(applicant.getSalary());
                        statusList.setSelectedItem(applicant.getApplicationStatus()); 
                        propertyList.setSelectedItem(applicant.getPropertyID().toString());
                        propertyList.setEnabled(false);
                        break;
                    }
                }
            
                //Submit buttons            
                JButton submitUpdate = new JButton("Submit");
                submitUpdate.setBounds(APPLICANTS_CONSTANTS.SUBMIT_POSITION_X, APPLICANTS_CONSTANTS.SUBMIT_POSITION_Y, 
                    APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
                submitUpdate.addActionListener((ActionEvent act) -> {
                    ApplicantEntity applicant = new ApplicantEntity(applicantSsn, fNameField.getText(), 
                        mNameField.getText(), lNameField.getText(), addressField.getText(), phoneField.getText(),
                        creditField.getText(), moveField.getText(), employerField.getText(), 
                        jobField.getText(), salaryField.getText()); 
                    applicant.setApplicationStatus(statusList.getSelectedItem().toString().trim());
                    applicant.setPropertyID(propertyId);
                    
                    boolean updateSuccess = dao.updateApplicant(applicant);
                    d.dispose();
                    
                    JDialog resultPage = new JDialog(frame, "Results", null);
                    resultPage.setLayout(null);
                    resultPage.setSize(100, 100);
                    
                    JLabel resultLabel = new JLabel(updateSuccess ? "Success" : "Error");
                    resultLabel.setBounds(0,0, APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, 
                            APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
                    resultPage.add(resultLabel);
                    
                    resultPage.setVisible(true);
                });
                d.add(submitUpdate);
                selectApplicant.dispose();
                d.setVisible(true);
            });
            selectApplicant.add(submit);
            
            selectApplicant.setVisible(true);
        });
        card1.add(updateApplicants);
        
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
        
        statusLabel = new JLabel("Status:");
        statusLabel.setBounds(APPLICANTS_CONSTANTS.STATUS_LABEL_POSITION_X, APPLICANTS_CONSTANTS.STATUS_LABEL_POSITION_Y,
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(statusLabel);

        statusList = new JComboBox();
        statusList.setBounds(APPLICANTS_CONSTANTS.STATUS_DROPDOWN_POSITION_X, APPLICANTS_CONSTANTS.STATUS_DROPDOWN_POSITION_Y,
            APPLICANTS_CONSTANTS.DROPDOWN_WIDTH, APPLICANTS_CONSTANTS.DROPDOWN_HEIGHT);
        statusList.addItem("");
        for (String status : APPLICANTS_CONSTANTS.STATUS_OPTIONS) {
            statusList.addItem(status);
        }
        d.add(statusList);
    }
    
    public static void getPropertyLabelsAndDropdown(JDialog d) { 
        propertyLabel = new JLabel("Property:");
        propertyLabel.setBounds(APPLICANTS_CONSTANTS.PROPERTY_LABEL_POSITION_X, APPLICANTS_CONSTANTS.PROPERTY_LABEL_POSITION_Y,
            APPLICANTS_CONSTANTS.LABEL_SIZE_WIDTH, APPLICANTS_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(propertyLabel);

        propertyList = new JComboBox();
        propertyList.setBounds(APPLICANTS_CONSTANTS.PROPERTY_DROPDOWN_POSITION_X, APPLICANTS_CONSTANTS.PROPERTY_DROPDOWN_POSITION_Y,
            APPLICANTS_CONSTANTS.DROPDOWN_WIDTH, APPLICANTS_CONSTANTS.DROPDOWN_HEIGHT);
        propertyList.addItem("");
        for (PropertyEntity property : new PropertiesHibernateDao().propertyList()) {
            propertyList.addItem(property.getPropertyId().toString());
        }
        d.add(propertyList);
    }
}
