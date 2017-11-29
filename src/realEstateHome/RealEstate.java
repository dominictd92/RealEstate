package realEstateHome;
 
import entities.ApplicantEntity;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDialog;
import queries.ApplicantHibernateDao;
import utilities.APP_CONSTANTS;
 

public class RealEstate {
    public static JFrame frame; 
    public void addComponentsToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        
        //create all of the pages in the form or tabs
        tabbedPane.addTab("Home", createHomePane());
        tabbedPane.addTab("Properties", createPropertiesPane());
        tabbedPane.addTab("Repairs", createRepairsPane());
        
        pane.add(tabbedPane, BorderLayout.CENTER);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Real Estate");
        frame.setSize(APP_CONSTANTS.WINDOW_WIDTH, APP_CONSTANTS.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        RealEstate realEstate = new RealEstate();
        realEstate.addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            //ConnectionSetup.connect();
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    public JPanel createHomePane() {
        ApplicantHibernateDao dao = new ApplicantHibernateDao();
    	@SuppressWarnings("serial")
		JPanel card1 = new JPanel() {
            //Create the JPanels correct size. This can be done once. 
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
    
    public JPanel createPropertiesPane() { 
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(APP_CONSTANTS.PROPERTIES);
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        return card1;
    }
    
    public JPanel createApplicantsPane() {
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(APP_CONSTANTS.APPLICANTS);
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        JButton showData = new JButton("Push Button");
        showData.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //display/center the jdialog when the button is pressed
                    ApplicantHibernateDao dao = new ApplicantHibernateDao();
                    List<ApplicantEntity> retrieval = dao.getAllApplications();
                    
                    JDialog d = new JDialog(frame, "Applicants", true);
                    d.setBounds(400, 400, 50, 100);
                    d.setVisible(true);
                }
        });
        showData.setBounds(200, 200, 100, 100);
        card1.add(showData);
        
        return card1;
    }
    
    public JPanel createRepairsPane() { 
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(APP_CONSTANTS.HOME);
        header.setFont(APP_CONSTANTS.HEADER_FONT);
        header.setBounds(APP_CONSTANTS.HEADER_X, APP_CONSTANTS.HEADER_Y, APP_CONSTANTS.PAGE_TITLE_WIDTH, APP_CONSTANTS.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        
        return card1;
    }
}