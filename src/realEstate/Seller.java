package realEstate;

import entities.SellerEntity;
import entities.PropertyEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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
import queries.SellerHibernateDao;
import queries.PropertiesHibernateDao;
import static realEstate.Main.frame;
import utilities.SELLER_CONSTANTS;
import utilities.APP_CONSTANTS;

/**
 *
 * @author ahead01
 */
public class Seller {
    static SellerHibernateDao dao = new SellerHibernateDao();
    static JTextField fNameField, mNameField, lNameField, ssnField, zipcodeField, phoneField, cityField, stateField, addressField, priceField;
    static JLabel fNameLabel, mNameLabel, lNameLabel, ssnLabel, zipcodeLabel, phoneLabel, cityLabel, stateLabel, addressLabel, propertyLabel, priceLabel; 
    static JComboBox propertyList;
    public static Integer sellerSsn;
    public static Integer propertyId;
    
    public static JPanel createSellersPane() {
    	JPanel card1 = new JPanel();
        card1.setLayout(null);
        
    	JLabel header = new JLabel("Seller");
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        JButton createSellers = new JButton("Create Sellers");
        createSellers.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.CREATE_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        createSellers.addActionListener((ActionEvent e) -> {            
            JDialog d = new JDialog(frame, "Create Sellers", true);
            d.setLayout(null);
            d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            
            getLabelsAndTextAreas(d);
            getPropertyLabelsAndDropdown(d);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(SELLER_CONSTANTS.SUBMIT_POSITION_X, SELLER_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    SellerEntity seller = new SellerEntity(Integer.parseInt(ssnField.getText()), Integer.parseInt(zipcodeField.getText()), addressField.getText(), 
                        cityField.getText(), stateField.getText(), phoneField.getText(), fNameField.getText(), mNameField.getText(), lNameField.getText());
                    seller.setPropertyID(Integer.parseInt(propertyList.getSelectedItem().toString().trim()));
                    seller.setPrice(BigDecimal.valueOf(Double.parseDouble(priceField.getText())));
                    String result;
                    if (dao.createSeller(seller) && dao.insertSellerPropertyRelationship(seller)) {
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
        card1.add(createSellers);
        
        JButton viewSellers = new JButton("View All Sellers");
        viewSellers.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.VIEW_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        viewSellers.addActionListener((ActionEvent e) -> {
            JDialog d = new JDialog(frame, "View All Sellers", true);
            d.setBounds(0, 0, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            d.setLayout(null);
            
            List<SellerEntity> retrieval = dao.getAllSellers();
            Object[][] objects = new Object[retrieval.size() + 1][new SellerEntity().getColumnArray().length];
            int i = 0;
            objects[i++] = new SellerEntity().getColumnArray();
            for (SellerEntity seller : retrieval) {
                objects[i++] = seller.getSellerArray();
            }
            JTable resultsTable = new JTable(objects, new SellerEntity().getColumnArray());
            resultsTable.setBounds(0, 50, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            resultsTable.setBackground(APP_CONSTANTS.BACKGROUND_COLOR);
            d.add(resultsTable);
            
            d.setVisible(true);
        });
        card1.add(viewSellers);
        
        JButton filterSellers = new JButton("Filter Sellers");
        filterSellers.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.FILTER_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        filterSellers.addActionListener((ActionEvent e) -> {
            
            JDialog d = new JDialog(frame, "Filter Sellers", true);
            d.setLayout(null);
            d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
            
            getLabelsAndTextAreas(d);
            getPropertyLabelsAndDropdown(d);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(SELLER_CONSTANTS.SUBMIT_POSITION_X, SELLER_CONSTANTS.SUBMIT_POSITION_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener((ActionEvent ae) -> {
                SellerEntity seller = new SellerEntity((StringUtils.isEmpty(ssnField.getText()) ? -1 : Integer.parseInt(ssnField.getText())), 
                    (StringUtils.isEmpty(zipcodeField.getText()) ? -1 : Integer.parseInt(zipcodeField.getText())),
                    addressField.getText(), cityField.getText(), stateField.getText(), phoneField.getText(), fNameField.getText(), mNameField.getText(), lNameField.getText());
                seller.setPropertyID(StringUtils.isEmpty(propertyList.getSelectedItem().toString()) ? 
                    -1 : Integer.parseInt(propertyList.getSelectedItem().toString()));
                seller.setPrice(StringUtils.isEmpty(priceField.getText()) ? BigDecimal.valueOf(-1) : 
                        BigDecimal.valueOf(Double.parseDouble(priceField.getText())));
                List<SellerEntity> results = dao.getFilteredSellers(seller);
                Object[][] objects = new Object[results.size() + 1][seller.getColumnArray().length];
                JDialog resultDialog = new JDialog(); 
                resultDialog.setLayout(null);
                resultDialog.setBounds(0, 0, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                
                int i = 0;
                objects[i++] = new SellerEntity().getColumnArray();
                for (SellerEntity applicants : results) {
                    objects[i++] = applicants.getSellerArray();
                }
                JTable resultsTable = new JTable(objects, new SellerEntity().getColumnArray());
                resultsTable.setBounds(0, 50, APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                resultsTable.setBackground(APP_CONSTANTS.BACKGROUND_COLOR);
                resultDialog.add(resultsTable);
                
                d.dispose();
                resultDialog.setVisible(true);
            });
            d.add(submit);
            
            d.setVisible(true);
        });
        card1.add(filterSellers);
        
        JButton updateSellers = new JButton("Update Sellers");
        updateSellers.setBounds(APP_CONSTANTS.APPLICANTS_BUTTON_X, APP_CONSTANTS.UPDATE_BUTTON_Y, 
            APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
        updateSellers.addActionListener((ActionEvent e) -> {
            
            JDialog selectSeller = new JDialog(frame, "Select Seller", true);
            selectSeller.setLayout(null);
            selectSeller.setSize(350, 150);
            
            JLabel applicantLabel = new JLabel("Seller SSN:");
            applicantLabel.setBounds(SELLER_CONSTANTS.UPDATE_LABEL_X, SELLER_CONSTANTS.UPDATE_LABEL_Y,
                SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
            selectSeller.add(applicantLabel);
            
            JComboBox sellerDropdown = new JComboBox();
            sellerDropdown.setBounds(SELLER_CONSTANTS.UPDATE_DROPDOWN_X, SELLER_CONSTANTS.UPDATE_DROPDOWN_Y,
                SELLER_CONSTANTS.DROPDOWN_WIDTH, SELLER_CONSTANTS.DROPDOWN_HEIGHT);
            List<SellerEntity> sellers = dao.getAllSellers();
            for (SellerEntity seller : sellers) {
                sellerDropdown.addItem(seller.getSsn() + "; " + seller.getPropertyID());
            }
            selectSeller.add(sellerDropdown);
            
            //Submit buttons            
            JButton submit = new JButton("Submit");
            submit.setBounds(SELLER_CONSTANTS.SUBMIT_POSITION_X, SELLER_CONSTANTS.UPDATE_SUBMIT_Y, 
                APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
            submit.addActionListener((ActionEvent ae) -> {
                JDialog d = new JDialog(frame, "Update Sellers", true);
                d.setLayout(null);
                d.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
                
                String select = sellerDropdown.getSelectedItem().toString();
                String[] selectArray = select.split(";");
                sellerSsn = Integer.parseInt(selectArray[0].trim());
                propertyId = Integer.parseInt(selectArray[1].trim());
                getLabelsAndTextAreas(d);
                getPropertyLabelsAndDropdown(d);
                //set the fields based on their selection
                for (SellerEntity seller : sellers) {
                    if (seller.getSsn() == sellerSsn && Objects.equals(seller.getPropertyID(), propertyId)) {
                        fNameField.setText(seller.getfName()); 
                        mNameField.setText(seller.getmName());  
                        lNameField.setText(seller.getlName());
                        ssnField.setText(Integer.toString(seller.getSsn()));
                        ssnField.setEnabled(false);
                        addressField.setText(seller.getStreetAddress());
                        zipcodeField.setText(seller.getZipCode().toString());
                        phoneField.setText(seller.getPhoneNumber());
                        stateField.setText(seller.getState());
                        cityField.setText(seller.getCity());
                        priceField.setText(seller.getPrice().toString());
                        propertyList.setSelectedItem(propertyId.toString());
                        propertyList.setEnabled(false);
                        break;
                    }
                }
            
                //Submit buttons            
                JButton submitUpdate = new JButton("Submit");
                submitUpdate.setBounds(SELLER_CONSTANTS.SUBMIT_POSITION_X, SELLER_CONSTANTS.SUBMIT_POSITION_Y, 
                    APP_CONSTANTS.BUTTON_WIDTH, APP_CONSTANTS.BUTTON_HEIGHT);
                submitUpdate.addActionListener((ActionEvent act) -> {
                    SellerEntity seller = new SellerEntity((StringUtils.isEmpty(ssnField.getText()) ? -1 : Integer.parseInt(ssnField.getText())), 
                        (StringUtils.isEmpty(zipcodeField.getText()) ? -1 : Integer.parseInt(zipcodeField.getText())),
                        addressField.getText(), cityField.getText(), stateField.getText(), phoneField.getText(), fNameField.getText(), mNameField.getText(), lNameField.getText());
                    
                    seller.setPropertyID(propertyId);
                    
                    boolean updateSuccess = dao.updateSeller(seller);
                    d.dispose();
                    
                    JDialog resultPage = new JDialog(frame, "Results", null);
                    resultPage.setLayout(null);
                    resultPage.setSize(100, 100);
                    
                    JLabel resultLabel = new JLabel(updateSuccess ? "Success" : "Error");
                    resultLabel.setBounds(0,0, SELLER_CONSTANTS.LABEL_SIZE_WIDTH, 
                            SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
                    resultPage.add(resultLabel);
                    
                    resultPage.setVisible(true);
                });
                d.add(submitUpdate);
                selectSeller.dispose();
                d.setVisible(true);
            });
            selectSeller.add(submit);
            
            selectSeller.setVisible(true);
        });
        card1.add(updateSellers);
        
        return card1;
    }   
    
    public static void getLabelsAndTextAreas(JDialog d) {
        fNameLabel = new JLabel("First Name:");
        fNameLabel.setBounds(SELLER_CONSTANTS.FNAME_LABEL_POSITION_X, SELLER_CONSTANTS.FNAME_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(fNameLabel);
        
        fNameField = new JTextField(); 
        fNameField.setBounds(SELLER_CONSTANTS.FNAME_TEXT_POSITION_X, SELLER_CONSTANTS.FNAME_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(fNameField);
        
        mNameLabel = new JLabel("Middle Name:");
        mNameLabel.setBounds(SELLER_CONSTANTS.MNAME_LABEL_POSITION_X, SELLER_CONSTANTS.MNAME_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(mNameLabel);
            
        mNameField = new JTextField(); 
        mNameField.setBounds(SELLER_CONSTANTS.MNAME_TEXT_POSITION_X, SELLER_CONSTANTS.MNAME_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(mNameField);
        
        lNameLabel = new JLabel("Last Name:");
        lNameLabel.setBounds(SELLER_CONSTANTS.LNAME_LABEL_POSITION_X, SELLER_CONSTANTS.LNAME_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(lNameLabel);
        
        lNameField = new JTextField(); 
        lNameField.setBounds(SELLER_CONSTANTS.LNAME_TEXT_POSITION_X, SELLER_CONSTANTS.LNAME_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(lNameField);
        
        ssnLabel = new JLabel("SSN:");
        ssnLabel.setBounds(SELLER_CONSTANTS.SSN_LABEL_POSITION_X, SELLER_CONSTANTS.SSN_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(ssnLabel);
        
        ssnField = new JTextField(); 
        ssnField.setBounds(SELLER_CONSTANTS.SSN_TEXT_POSITION_X, SELLER_CONSTANTS.SSN_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(ssnField);
        
        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(SELLER_CONSTANTS.ADDRESS_LABEL_POSITION_X, SELLER_CONSTANTS.ADDRESS_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(addressLabel);
        
        addressField = new JTextField(); 
        addressField.setBounds(SELLER_CONSTANTS.ADDRESS_TEXT_POSITION_X, SELLER_CONSTANTS.ADDRESS_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(addressField);

        cityLabel = new JLabel("City:");
        cityLabel.setBounds(SELLER_CONSTANTS.CITY_LABEL_POSITION_X, SELLER_CONSTANTS.CITY_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(cityLabel);
        
        cityField = new JTextField(); 
        cityField.setBounds(SELLER_CONSTANTS.CITY_TEXT_POSITION_X, SELLER_CONSTANTS.CITY_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(cityField);
        
        stateLabel = new JLabel("State:");
        stateLabel.setBounds(SELLER_CONSTANTS.STATE_LABEL_POSITION_X, SELLER_CONSTANTS.STATE_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(stateLabel);
        
        stateField = new JTextField(); 
        stateField.setBounds(SELLER_CONSTANTS.STATE_TEXT_POSITION_X, SELLER_CONSTANTS.STATE_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(stateField);
        
        zipcodeLabel = new JLabel("Zip:");
        zipcodeLabel.setBounds(SELLER_CONSTANTS.ZIP_LABEL_POSITION_X, SELLER_CONSTANTS.ZIP_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(zipcodeLabel);
        
        zipcodeField = new JTextField(); 
        zipcodeField.setBounds(SELLER_CONSTANTS.ZIP_TEXT_POSITION_X, SELLER_CONSTANTS.ZIP_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(zipcodeField);
        
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(SELLER_CONSTANTS.PHONE_LABEL_POSITION_X, SELLER_CONSTANTS.PHONE_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(phoneLabel);
        
        phoneField = new JTextField(); 
        phoneField.setBounds(SELLER_CONSTANTS.PHONE_TEXT_POSITION_X, SELLER_CONSTANTS.PHONE_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(phoneField);
        
        priceLabel = new JLabel("Price:");
        priceLabel.setBounds(SELLER_CONSTANTS.PRICE_LABEL_POSITION_X, SELLER_CONSTANTS.PRICE_LABEL_POSITION_Y, 
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(priceLabel);
        
        priceField = new JTextField(); 
        priceField.setBounds(SELLER_CONSTANTS.PRICE_TEXT_POSITION_X, SELLER_CONSTANTS.PRICE_TEXT_POSITION_Y, 
            SELLER_CONSTANTS.TEXT_AREA_WIDTH, SELLER_CONSTANTS.TEXT_AREA_HEIGHT);
        d.add(priceField);
    }
    
    public static void getPropertyLabelsAndDropdown(JDialog d) { 
        propertyLabel = new JLabel("Property:");
        propertyLabel.setBounds(SELLER_CONSTANTS.PROPERTY_LABEL_POSITION_X, SELLER_CONSTANTS.PROPERTY_LABEL_POSITION_Y,
            SELLER_CONSTANTS.LABEL_SIZE_WIDTH, SELLER_CONSTANTS.LABEL_SIZE_HEIGHT);
        d.add(propertyLabel);

        propertyList = new JComboBox();
        propertyList.setBounds(SELLER_CONSTANTS.PROPERTY_DROPDOWN_POSITION_X, SELLER_CONSTANTS.PROPERTY_DROPDOWN_POSITION_Y,
            SELLER_CONSTANTS.DROPDOWN_WIDTH, SELLER_CONSTANTS.DROPDOWN_HEIGHT);
        propertyList.addItem("");
        for (PropertyEntity property : new PropertiesHibernateDao().propertyList()) {
            propertyList.addItem(property.getPropertyId().toString());
        }
        d.add(propertyList);
    }
}