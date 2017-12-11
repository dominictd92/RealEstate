package realEstate;

import entities.EmployeeEntity;
import entities.PropertyEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.springframework.util.StringUtils;
import queries.EmployeeHibernateDao;
import queries.PropertiesHibernateDao;
import static realEstate.Main.frame;
import utilities.EMPLOYEE_CONSTANTS;
import utilities.APP_CONSTANTS;

/**
 *
 * @author ddangerfield
 */
public class Employees {
    static EmployeeHibernateDao dao = new EmployeeHibernateDao();
    static JTextField fNameField, mNameField, lNameField, ssnField, payField, phoneField;
    static JLabel fNameLabel, mNameLabel, lNameLabel, ssnLabel, payLabel, phoneLabel, propertyLabel; 
    static JComboBox propertyList;
    public static Integer employeeSsn;
    public static Integer propertyId;
    
    public static JPanel createEmployeesPane() {
    	JPanel card1 = new JPanel();
        card1.setLayout(null);
        
    	JLabel header = new JLabel("Employees");
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        JButton createEmployees = new JButton("Create Employees");
        createEmployees.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.CREATE_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        createEmployees.addActionListener((ActionEvent e) -> {            
            JDialog d = new JDialog(frame, "Create Employees", true);
            d.setLayout(null);
            d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            
            getLabelsAndTextAreas(d);
            getPropertyLabelsAndDropdown(d);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(EMPLOYEE_CONSTANTS.SUBMIT_POSITION_X, EMPLOYEE_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    EmployeeEntity employee = new EmployeeEntity(Integer.parseInt(ssnField.getText()),  
                        fNameField.getText(), mNameField.getText(), lNameField.getText(), 
                        BigDecimal.valueOf(Double.parseDouble(payField.getText())), phoneField.getText());

                    int propertyID = Integer.parseInt(propertyList.getSelectedItem().toString().trim());
                    
                    String result;
                    if (dao.insertEmployee(employee) && dao.insertEmployeePropertyRelationship(employee, propertyID)) {
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
        card1.add(createEmployees);
        
        JButton viewEmployees = new JButton("View All Employees");
        viewEmployees.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.VIEW_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        viewEmployees.addActionListener((ActionEvent e) -> {
            JDialog d = new JDialog(frame, "View All Employees", true);
            d.setBounds(0, 0, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            d.setLayout(null);
            
            List<EmployeeEntity> retrieval = dao.getAllEmployees();
            Object[][] objects = new Object[retrieval.size() + 1][new EmployeeEntity().getColumnArray().length];
            int i = 0;
            objects[i++] = new EmployeeEntity().getColumnArray();
            for (EmployeeEntity employee : retrieval) {
                objects[i++] = employee.getEmployeeArray();
            }
            JTable resultsTable = new JTable(objects, new EmployeeEntity().getColumnArray());
            resultsTable.setBounds(0, 50, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            resultsTable.setBackground(APP_CONSTANTS.BACKGROUND_COLOR);
            d.add(resultsTable);
            
            d.setVisible(true);
        });
        card1.add(viewEmployees);
        
        JButton filterEmployees = new JButton("Filter Employees");
        filterEmployees.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.FILTER_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        filterEmployees.addActionListener((ActionEvent e) -> {
            
            JDialog d = new JDialog(frame, "Filter Employees", true);
            d.setLayout(null);
            d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            
            getLabelsAndTextAreas(d);
            getPropertyLabelsAndDropdown(d);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(EMPLOYEE_CONSTANTS.SUBMIT_POSITION_X, EMPLOYEE_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener((ActionEvent ae) -> {
                EmployeeEntity employee = new EmployeeEntity((StringUtils.isEmpty(ssnField.getText())) ? 
                    -1 : Integer.parseInt(ssnField.getText()), 
                    fNameField.getText().trim(), mNameField.getText().trim(), lNameField.getText().trim(), 
                    (StringUtils.isEmpty(payField.getText().trim()) ? BigDecimal.valueOf(Double.parseDouble("-1")) : 
                    BigDecimal.valueOf(Double.parseDouble(payField.getText()))), phoneField.getText());
                employee.setPropertyID(StringUtils.isEmpty(propertyList.getSelectedItem().toString()) ? 
                    -1 : Integer.parseInt(propertyList.getSelectedItem().toString()));
                
                List<EmployeeEntity> results = dao.getFilteredEmployees(employee);
                Object[][] objects = new Object[results.size() + 1][employee.getColumnArray().length];
                JDialog resultDialog = new JDialog(); 
                resultDialog.setLayout(null);
                resultDialog.setBounds(0, 0, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                
                int i = 0;
                objects[i++] = new EmployeeEntity().getColumnArray();
                for (EmployeeEntity applicants : results) {
                    objects[i++] = applicants.getEmployeeArray();
                }
                JTable resultsTable = new JTable(objects, new EmployeeEntity().getColumnArray());
                resultsTable.setBounds(0, 50, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                resultsTable.setBackground(APP_CONSTANTS.BACKGROUND_COLOR);
                resultDialog.add(resultsTable);
                
                d.dispose();
                resultDialog.setVisible(true);
            });
            d.add(submit);
            
            d.setVisible(true);
        });
        card1.add(filterEmployees);
        
        JButton updateEmployees = new JButton("Update Employees");
        updateEmployees.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.UPDATE_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        updateEmployees.addActionListener((ActionEvent e) -> {
            
            JDialog selectEmployee = new JDialog(frame, "Select Employee", true);
            selectEmployee.setLayout(null);
            selectEmployee.setSize(350, 150);
            
            JLabel applicantLabel = new JLabel("Employee SSN:");
            applicantLabel.setBounds(EMPLOYEE_CONSTANTS.UPDATE_LABEL_X, EMPLOYEE_CONSTANTS.UPDATE_LABEL_Y,
                EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
            selectEmployee.add(applicantLabel);
            
            JComboBox employeeDropdown = new JComboBox();
            employeeDropdown.setBounds(EMPLOYEE_CONSTANTS.UPDATE_DROPDOWN_X, EMPLOYEE_CONSTANTS.UPDATE_DROPDOWN_Y,
                EMPLOYEE_CONSTANTS.DROPDOWN_WIDTH, EMPLOYEE_CONSTANTS.DROPDOWN_HEIGHT);
            List<EmployeeEntity> employees = dao.getAllEmployees();
            for (EmployeeEntity employee : employees) {
                employeeDropdown.addItem(employee.getSsn() + "; " + employee.getPropertyID());
            }
            selectEmployee.add(employeeDropdown);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(EMPLOYEE_CONSTANTS.SUBMIT_POSITION_X, EMPLOYEE_CONSTANTS.UPDATE_SUBMIT_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener((ActionEvent ae) -> {
                JDialog d = new JDialog(frame, "Update Employees", true);
                d.setLayout(null);
                d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                
                String select = employeeDropdown.getSelectedItem().toString();
                String[] selectArray = select.split(";");
                employeeSsn = Integer.parseInt(selectArray[0].trim());
                propertyId = Integer.parseInt(selectArray[1].trim());
                getLabelsAndTextAreas(d);
                getPropertyLabelsAndDropdown(d);
                //set the fields based on their selection
                for (EmployeeEntity employee : employees) {
                    if (employee.getSsn() == employeeSsn && employee.getPropertyID() == propertyId) {
                        fNameField.setText(employee.getfName()); 
                        mNameField.setText(employee.getmName());  
                        lNameField.setText(employee.getlName());
                        ssnField.setText(Integer.toString(employee.getSsn()));
                        ssnField.setEnabled(false);
                        payField.setText(employee.getPay().toString());
                        phoneField.setText(employee.getPhoneNumber());
                        propertyList.setSelectedItem(propertyId.toString());
                        propertyList.setEnabled(false);
                        break;
                    }
                }
            
                //Submit buttons            
                JButton submitUpdate = new JButton("Submit");
                submitUpdate.setBounds(EMPLOYEE_CONSTANTS.SUBMIT_POSITION_X, EMPLOYEE_CONSTANTS.SUBMIT_POSITION_Y, 
                    APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
                submitUpdate.addActionListener((ActionEvent act) -> {
                    EmployeeEntity employee = new EmployeeEntity(employeeSsn, fNameField.getText(), 
                        mNameField.getText(), lNameField.getText(), 
                        BigDecimal.valueOf(Double.parseDouble(payField.getText())), phoneField.getText());
                    employee.setPropertyID(propertyId);
                    
                    boolean updateSuccess = dao.updateEmployee(employee);
                    d.dispose();
                    
                    JDialog resultPage = new JDialog(frame, "Results", null);
                    resultPage.setLayout(null);
                    resultPage.setSize(100, 100);
                    
                    JLabel resultLabel = new JLabel(updateSuccess ? "Success" : "Error");
                    resultLabel.setBounds(0,0, EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, 
                            EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
                    resultPage.add(resultLabel);
                    
                    resultPage.setVisible(true);
                });
                d.add(submitUpdate);
                selectEmployee.dispose();
                d.setVisible(true);
            });
            selectEmployee.add(submit);
            
            selectEmployee.setVisible(true);
        });
        card1.add(updateEmployees);
        
        return card1;
    }   
    
    public static void getLabelsAndTextAreas(JDialog d) {
        fNameLabel = new JLabel("First Name:");
        fNameLabel.setBounds(EMPLOYEE_CONSTANTS.FNAME_LABEL_POSITION_X, EMPLOYEE_CONSTANTS.FNAME_LABEL_POSITION_Y, 
            EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(fNameLabel);
        
        fNameField = new JTextField(); 
        fNameField.setBounds(EMPLOYEE_CONSTANTS.FNAME_TEXT_POSITION_X, EMPLOYEE_CONSTANTS.FNAME_TEXT_POSITION_Y, 
            EMPLOYEE_CONSTANTS.TEXT_AREA_WIDTH, EMPLOYEE_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(fNameField);
        
        mNameLabel = new JLabel("Middle Name:");
        mNameLabel.setBounds(EMPLOYEE_CONSTANTS.MNAME_LABEL_POSITION_X, EMPLOYEE_CONSTANTS.MNAME_LABEL_POSITION_Y, 
            EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(mNameLabel);
            
        mNameField = new JTextField(); 
            mNameField.setBounds(EMPLOYEE_CONSTANTS.MNAME_TEXT_POSITION_X, EMPLOYEE_CONSTANTS.MNAME_TEXT_POSITION_Y, 
                    EMPLOYEE_CONSTANTS.TEXT_AREA_WIDTH, EMPLOYEE_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(mNameField);
        
        lNameLabel = new JLabel("Last Name:");
        lNameLabel.setBounds(EMPLOYEE_CONSTANTS.LNAME_LABEL_POSITION_X, EMPLOYEE_CONSTANTS.LNAME_LABEL_POSITION_Y, 
            EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(lNameLabel);
        
        lNameField = new JTextField(); 
            lNameField.setBounds(EMPLOYEE_CONSTANTS.LNAME_TEXT_POSITION_X, EMPLOYEE_CONSTANTS.LNAME_TEXT_POSITION_Y, 
                    EMPLOYEE_CONSTANTS.TEXT_AREA_WIDTH, EMPLOYEE_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(lNameField);
        
        ssnLabel = new JLabel("SSN:");
        ssnLabel.setBounds(EMPLOYEE_CONSTANTS.SSN_LABEL_POSITION_X, EMPLOYEE_CONSTANTS.SSN_LABEL_POSITION_Y, 
            EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(ssnLabel);
        
        ssnField = new JTextField(); 
        ssnField.setBounds(EMPLOYEE_CONSTANTS.SSN_TEXT_POSITION_X, EMPLOYEE_CONSTANTS.SSN_TEXT_POSITION_Y, 
            EMPLOYEE_CONSTANTS.TEXT_AREA_WIDTH, EMPLOYEE_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(ssnField);
        
        payLabel = new JLabel("Pay:");
        payLabel.setBounds(EMPLOYEE_CONSTANTS.PAY_LABEL_POSITION_X, EMPLOYEE_CONSTANTS.PAY_LABEL_POSITION_Y, 
            EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(payLabel);
        
        payField = new JTextField(); 
        payField.setBounds(EMPLOYEE_CONSTANTS.PAY_TEXT_POSITION_X, EMPLOYEE_CONSTANTS.PAY_TEXT_POSITION_Y, 
            EMPLOYEE_CONSTANTS.TEXT_AREA_WIDTH, EMPLOYEE_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(payField);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(EMPLOYEE_CONSTANTS.PHONE_LABEL_POSITION_X, EMPLOYEE_CONSTANTS.PHONE_LABEL_POSITION_Y, 
            EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(phoneLabel);
        
        phoneField = new JTextField(); 
            phoneField.setBounds(EMPLOYEE_CONSTANTS.PHONE_TEXT_POSITION_X, EMPLOYEE_CONSTANTS.PHONE_TEXT_POSITION_Y, 
                    EMPLOYEE_CONSTANTS.TEXT_AREA_WIDTH, EMPLOYEE_CONSTANTS.TEXT_AREA_HEIGHT);
            d.add(phoneField);
    }
    
    public static void getPropertyLabelsAndDropdown(JDialog d) { 
        propertyLabel = new JLabel("Property:");
        propertyLabel.setBounds(EMPLOYEE_CONSTANTS.PROPERTY_LABEL_POSITION_X, EMPLOYEE_CONSTANTS.PROPERTY_LABEL_POSITION_Y,
            EMPLOYEE_CONSTANTS.LABEL_SIZE_WIDTH, EMPLOYEE_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(propertyLabel);

        propertyList = new JComboBox();
        propertyList.setBounds(EMPLOYEE_CONSTANTS.PROPERTY_DROPDOWN_POSITION_X, EMPLOYEE_CONSTANTS.PROPERTY_DROPDOWN_POSITION_Y,
            EMPLOYEE_CONSTANTS.DROPDOWN_WIDTH, EMPLOYEE_CONSTANTS.DROPDOWN_HEIGHT);
        propertyList.addItem("");
        for (PropertyEntity property : new PropertiesHibernateDao().propertyList()) {
            propertyList.addItem(property.getPropertyId().toString());
        }
        d.add(propertyList);
    }
}
