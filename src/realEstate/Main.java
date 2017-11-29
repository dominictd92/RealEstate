package realEstate;
 
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
 

public class Main {
    public static JFrame frame; 
    public void addComponentsToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        
        //create all of the pages in the form or tabs
        tabbedPane.addTab("Home", Home.createHomePane());
        tabbedPane.addTab("Properties", Properties.createPropertiesPane());
        tabbedPane.addTab("Applicants", Applicants.createApplicantsPane());
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
        Main realEstate = new Main();
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