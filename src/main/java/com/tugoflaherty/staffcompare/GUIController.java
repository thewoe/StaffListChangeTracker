/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.staffcompare;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tugoflaherty
 */
public class GUIController implements ActionListener {

    /**
     * This method is an override of the actionPerformed method in ActionListener
     * It determines the option selected in the Button Panel in the user interface and calls the relevant method
     * It returns no values
     * @param ae This is an ActionEvent parameter to determine which  methods to run when the user interaction happens
     */
    
    //get openFile GUI functionality to work
    @Override
    public void actionPerformed(ActionEvent ae) {
        GUIViewer guiViewer = GUIViewer.getInstance();
        StaffListReader staffListReader = StaffListReader.getInstance();
        switch (ae.getActionCommand()) {
            case "openOldFile":
                int continueOpeningOldFile = JOptionPane.showConfirmDialog(guiViewer, "Opening a file will erase all Staff Lists and Staff Changes unless they have already been saved. Continue?", "Continue to Open File", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (continueOpeningOldFile == JOptionPane.YES_OPTION) {
                    //eventManager.initialiseModelDeleteOrganisers();
                    JFileChooser openFileChooser = new JFileChooser();
                    FileNameExtensionFilter openFileFilter = new FileNameExtensionFilter("CSV Files", "csv");
                    openFileChooser.setFileFilter(openFileFilter);
                    int openFileOption = openFileChooser.showOpenDialog(guiViewer);
                    if (openFileOption == JFileChooser.APPROVE_OPTION) {
                        File fileToOpen = openFileChooser.getSelectedFile();
                        String openFilePath = fileToOpen.getAbsolutePath();
                        staffListReader.readOldCSVFile(openFilePath);
                        System.out.println("Config File Path: " + openFilePath);
                    }
                }
                break;
            case "openNewFile":
                int continueOpeningNewFile = JOptionPane.showConfirmDialog(guiViewer, "Opening a file will erase all Staff Lists and Staff Changes unless they have already been saved. Continue?", "Continue to Open File", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (continueOpeningNewFile == JOptionPane.YES_OPTION) {
                    //eventManager.initialiseModelDeleteOrganisers();
                    JFileChooser openFileChooser = new JFileChooser();
                    FileNameExtensionFilter openFileFilter = new FileNameExtensionFilter("CSV Files", "csv");
                    openFileChooser.setFileFilter(openFileFilter);
                    int openFileOption = openFileChooser.showOpenDialog(guiViewer);
                    if (openFileOption == JFileChooser.APPROVE_OPTION) {
                        File fileToOpen = openFileChooser.getSelectedFile();
                        String openFilePath = fileToOpen.getAbsolutePath();
                        staffListReader.readNewCSVFile(openFilePath);
                        System.out.println("Config File Path: " + openFilePath);
                    }
                }
                break;
            case "saveFile":
                JFileChooser saveFileChooser = new JFileChooser();
                FileNameExtensionFilter saveFileFilter = new FileNameExtensionFilter("CSV Files", "csv");
                saveFileChooser.setFileFilter(saveFileFilter);
                int saveFileOption = saveFileChooser.showSaveDialog(guiViewer);
                if (saveFileOption == JFileChooser.APPROVE_OPTION) {
                    File fileToSave;
                    String saveFilePath;
                    fileToSave = saveFileChooser.getSelectedFile();
                    saveFilePath = fileToSave.getAbsolutePath();
                    staffListReader.writeFile(saveFilePath);
                    System.out.println("Config File Path: " + saveFilePath);
                }
                break;
            case "help":
                String helpString = "";
                helpString += "Staff list Comparison Application:" + System.getProperty("line.separator");
                helpString += "This application allows you to compare two staff lists, in the CSV format." + System.getProperty("line.separator");
                helpString += "Staff lists must be in the format: Mr. A. A. Bodell, Headteacher, headteacher@blenheim.surrey.sch.uk" + System.getProperty("line.separator");
                helpString += "Firstly, use the 'File > Open Old File' option to select the old staff list you wish to compare with." + System.getProperty("line.separator");
                helpString += "Next, use the 'File > Open New File' option to select the new staff list you wish to compare with." + System.getProperty("line.separator");
                helpString += "These files will be uploaded into the application and compared." + System.getProperty("line.separator");
                helpString += "If the two staff member entries are identical, the record will be ignored." + System.getProperty("line.separator");
                helpString += "If the new staff list contains a staff member not contained on the old staff list, the staff member will be displayed under the 'Staff Member Arrived' heading." + System.getProperty("line.separator");
                helpString += "If the old staff list contains a staff member not contained on the new staff list, the staff member will be displayed under the 'Staff Member Left' heading." + System.getProperty("line.separator");
                helpString += "If no staff have arrived or left, the appropriate message will be displayed under the relevant heading." + System.getProperty("line.separator") + System.getProperty("line.separator");
                helpString += "The changes in staff lists may be exported to a CSV file using 'File > Save File'." + System.getProperty("line.separator");
                GUIViewer.getInstance().getStaffChangeDisplay().setText(helpString);
                break;
            case "about":
                String aboutString = "";
                aboutString += "This application was written in Java by Tug O'Flaherty." + System.getProperty("line.separator");
                aboutString += "Version: v1.0" + System.getProperty("line.separator");
                aboutString += "Java Build Version: 16" + System.getProperty("line.separator");
                aboutString += "Created Date: 24/12/2022" + System.getProperty("line.separator");
                aboutString += "Modified Date: 24/12/2022" + System.getProperty("line.separator");
                aboutString += "© 2022 Tug O'Flaherty" + System.getProperty("line.separator");
                GUIViewer.getInstance().getStaffChangeDisplay().setText(aboutString);
                break;
            case "quit":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}