package realEstateHome;
 
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

import utilities.Constants;
 

public class RealEstate {
 
    public void addComponentsToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Home", createHomePane());
        tabbedPane.addTab("Properties", createPropertiesPane());
        tabbedPane.addTab("Third", createRepairsPane());
 
        pane.add(tabbedPane, BorderLayout.CENTER);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Real Estate");
        frame.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
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
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
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
    	@SuppressWarnings("serial")
		JPanel card1 = new JPanel() {
            //Create the JPanels correct size. This can be done once. 
            public Dimension getPreferredSize() {
            	Dimension size = new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            	return size;
            }
        };
        //clear the layout as it automatically sets the layout. 
        card1.setLayout(null);
        
        JLabel header = new JLabel(Constants.HOME);
        header.setFont(Constants.HEADER_FONT);
        header.setBounds(Constants.HEADER_X, Constants.HEADER_Y, Constants.PAGE_TITLE_WIDTH, Constants.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        JLabel devs = new JLabel(Constants.DEVELOPERS);
        devs.setBounds(Constants.HEADER_X, Constants.PAGE_TITLE_HEIGHT, Constants.PAGE_TITLE_WIDTH, Constants.DEVELOPERS_HEIGHT);
        devs.setHorizontalAlignment(JLabel.CENTER);
        card1.add(devs);
        
        JTextArea pageInfo = new JTextArea(Constants.HOME_INFO);
        pageInfo.setBounds(Constants.CENTER_X, Constants.HOME_INFO_START_LINE, Constants.CENTER_WIDTH, Constants.HOME_INFO_HEIGHT);
        pageInfo.setBackground(Constants.BACKGROUND_COLOR);
        card1.add(pageInfo);
        
        return card1;
    }
    
    public JPanel createPropertiesPane() { 
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(Constants.PROPERTIES);
        header.setFont(Constants.HEADER_FONT);
        header.setBounds(Constants.HEADER_X, Constants.HEADER_Y, Constants.PAGE_TITLE_WIDTH, Constants.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        return card1;
    }
    
    public JPanel createApplicantsPane() {
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(Constants.APPLICANTS);
        header.setFont(Constants.HEADER_FONT);
        header.setBounds(Constants.HEADER_X, Constants.HEADER_Y, Constants.PAGE_TITLE_WIDTH, Constants.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        return card1;
    }
    
    public JPanel createRepairsPane() { 
    	JPanel card1 = new JPanel();
        
    	JLabel header = new JLabel(Constants.HOME);
        header.setFont(Constants.HEADER_FONT);
        header.setBounds(Constants.HEADER_X, Constants.HEADER_Y, Constants.PAGE_TITLE_WIDTH, Constants.PAGE_TITLE_HEIGHT);
        header.setHorizontalAlignment(JLabel.CENTER);
        card1.add(header);
        
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        
        return card1;
    }
}