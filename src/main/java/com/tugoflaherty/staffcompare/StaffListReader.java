/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.staffcompare;

/**
 *
 * @author tugso
 */
import java.util.List;	  		 	  	 	        	     	
import java.util.ArrayList;	  		 	  	 	        	     	
import java.io.FileReader;	  		 	  	 	        	     	
import java.io.BufferedReader;	  		 	  	 	        	     	
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
	  		 	  	 	        	     	
public final class StaffListReader {
    private static StaffListReader instance;
    private static List<Staff> oldStaff = new ArrayList();
    private static List<Staff> newStaff = new ArrayList();
    
    public static StaffListReader getInstance() {
        if (instance == null) {
            instance = new StaffListReader();
        }
        return instance;
    }
    
    private StaffListReader() {
        
    }
	  		 	  	 	        	     	
    public static void readOldCSVFile(String oldList) {	  		 	  	 	        	     	
        // try with resources - read the file using filereader then buffered reader from the specified parameter	  		 	  	 	        	     	
        try(BufferedReader oldBuffread = new BufferedReader(new FileReader(oldList))) {	  		 	  	 	        	     	
            // while no new lines (while ready())	  		 	  	 	        	     	
            while (oldBuffread.ready()) {	  		 	  	 	        	     	
                // for each line, create new object, read the line	  		 	  	 	        	     	
                String oldCurrentLine = oldBuffread.readLine();
                // deliminate at each comma	  		 	  	 	        	     	
                String oldStaffList[] = oldCurrentLine.trim().split(",");	  		 	  	 	        	     	
                // put contents before comma into title	  		 	  	 	        	     	
                Staff oldAddedStaff = new Staff(oldStaffList[0],oldStaffList[1],oldStaffList[2]);	  		 	  	 	        	     	
                oldStaff.add(oldAddedStaff);	  		 	  	 	        	     	
                // then next contents before comma into priority then next contents into target date	  		 	  	 	        	     	
            }	  		 	  	 	        	     	
            setOldStaff(oldStaff);	  		 	  	 	        	     	
        }
        // catch all exceptions (Exception e)
        catch (Exception e) {	  		 	  	 	        	     	
            System.out.println("Error reading old staff list file: " + e.toString());	  		 	  	 	        	     	 		 	  	 	        	     	
        }	  		 	  	 	        	     		  		 	  	 	        	     	
    }
  
    public static void readNewCSVFile(String newList) {	  		 	  	 	        	     	
        // try with resources - read the file using filereader then buffered reader from the specified parameter	  		 	  	 	        	     	
        try(BufferedReader newBuffread = new BufferedReader(new FileReader(newList))) {	  		 	  	 	        	     	
            // while no new lines (while ready())	  		 	  	 	        	     	
            while (newBuffread.ready()) {	  		 	  	 	        	     	
                // for each line, create new object, read the line	  		 	  	 	        	     	
                String newCurrentLine = newBuffread.readLine();
                // deliminate at each comma	  		 	  	 	        	     	
                String newStaffList[] = newCurrentLine.trim().split(",");	  		 	  	 	        	     	
                // put contents before comma into title	  		 	  	 	        	     	
                Staff newAddedStaff = new Staff(newStaffList[0],newStaffList[1],newStaffList[2]);	  		 	  	 	        	     	
                newStaff.add(newAddedStaff);	  		 	  	 	        	     	
                // then next contents before comma into priority then next contents into target date	  		 	  	 	        	     	
            }	  		 	  	 	        	     	
            setNewStaff(newStaff);	  		 	  	 	        	     	
        }	  	
        // catch all exceptions (Exception e)
        catch (Exception e) {	  		 	  	 	        	     	
            System.out.println("Error reading new staff list file");	  		 	  	 	        	     	 		 	  	 	        	     	
        }	  		 	  	 	        	     		  		 	  	 	        	     	
    }
	  		 	  	 	        	     	
    public static List<Staff> getOldStaff(){	  		 	  	 	        	     	
        return oldStaff;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    public static void setOldStaff(List<Staff> oldStaff){	  		 	  	 	        	     	
        StaffListReader.oldStaff = oldStaff;	  		 	  	 	        	     	
    }	
  
    public static List<Staff> getNewStaff(){	  		 	  	 	        	     	
        return oldStaff;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    public static void setNewStaff(List<Staff> newStaff){	  		 	  	 	        	     	
        StaffListReader.newStaff = newStaff;	  		 	  	 	        	     	
    }
  
    public static void getStaffChanges() {
        List<Staff> staffLeft = new ArrayList();
        List<Staff> staffArrived = new ArrayList();
        for(Staff oldStaffMember: oldStaff){
            for(Staff newStaffMember: newStaff){
                if (oldStaffMember.equals(newStaffMember)){
                    // If the staff member still works there, do nothing
                }
                else {
                    if (!oldStaff.contains(newStaffMember)) {
                        // If old staff list doesn't contain new staff member
                        // Staff member must have joined the school
                        staffArrived.add(newStaffMember);
                    }
                    if (!newStaff.contains(oldStaffMember)) {
                        // If new staff list doesn't contain old staff member
                        // Staff member must have left the school
                        staffLeft.add(oldStaffMember);
                    }
                }
            }
        }
        List<Staff> distinctStaffLeft = new ArrayList(new HashSet(staffLeft));
        List<Staff> distinctStaffArrived = new ArrayList(new HashSet(staffArrived));
        String staffLeftString = "Staff Members Who Have Left:" + System.getProperty("line.separator");
        String staffArrivedString = "Staff Members Who Have Arrived:" + System.getProperty("line.separator");
        for (Staff staffMemberLeft : distinctStaffLeft) {
            staffLeftString += staffMemberLeft.toString() + System.getProperty("line.separator");
            System.out.println("Staff Member Left     |  "+staffMemberLeft.toString());
        }
        if (staffLeft.isEmpty()) {
            staffLeftString += "No staff have left." + System.getProperty("line.separator");
            System.out.println("No staff have left.");
        }
        for (Staff staffMemberArrived : distinctStaffArrived) {
            staffArrivedString += staffMemberArrived.toString() + System.getProperty("line.separator");
            System.out.println("Staff Member Arrived  |  "+staffMemberArrived.toString());
        }
        if (staffArrived.isEmpty()) {
            staffArrivedString += "No staff have arrived." + System.getProperty("line.separator");
            System.out.println("No staff have arrived.");
        }
        GUIViewer.getInstance().getStaffChangeDisplay().setText(staffLeftString + staffArrivedString);
    }
    
    public void writeFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+".csv"))) {
            try {
                bWriter.write(GUIViewer.getInstance().getStaffChangeDisplay().getText());
            } catch (IOException e) {
                System.out.println("Error reading staff changes to save to file: " + e);
            }
        }	  		 	  	 	        	     	
        catch (Exception e) {
            System.out.println("Error writing staff changes file: " + e);	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
}