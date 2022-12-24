/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tugoflaherty.staffcompare;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tugso
 */
public class Main {
        // SO FAR THE APP MUST USE THE FILE INPUT BELOW \\
        /////////////////////////////////////////////|\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        // Copy any staff list files into the main package and reference them below:
        // Enter the file name of the old staff list file here:
        // e.g. "C:\\Users\\tugso\\Documents\\General\\StaffLists\\Blenheim High School\\BlenheimHighSchoolStaffList14-04-2022.csv"
        private static final String oldStaffListFile = "C:\\Users\\tugso\\Documents\\General\\StaffLists\\Blenheim High School\\BlenheimHighSchoolStaffList14-04-2022.csv";
        // Enter the file name of the new staff list file here:
        // e.g. "C:\\Users\\tugso\\Documents\\General\\StaffLists\\Blenheim High School\\BlenheimHighSchoolStaffList14-04-2022.csv"
        private static final String newStaffListFile = "C:\\Users\\tugso\\Documents\\General\\StaffLists\\Blenheim High School\\BlenheimHighSchoolStaffList15-04-2022.csv";
        /////////////////////////////////////////////|\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        
        private static List[] staffChanges;
        private static ArrayList<Staff> staffLeft;
        private static ArrayList<Staff> staffArrived;
        private static String staffLeftString = "Staff Members Who Have Left:" + System.getProperty("line.separator");
        private static String staffArrivedString = "Staff Members Who Have Arrived:" + System.getProperty("line.separator");
        
        public static void main(String[] args) {
        StaffListReader.readOldCSVFile(oldStaffListFile);
        StaffListReader.readNewCSVFile(newStaffListFile);
        staffChanges = StaffListReader.getStaffChanges();
        staffLeft = new ArrayList<Staff>(staffChanges[0]);
        staffArrived = new ArrayList<Staff>(staffChanges[1]);
        for (Staff staffMemberLeft : staffLeft) {
            staffLeftString += staffMemberLeft.toString() + System.getProperty("line.separator");
            System.out.println("Staff Member Left     |  "+staffMemberLeft.toString());
        }
        if (staffLeft.isEmpty()) {
            staffLeftString += "No staff have left." + System.getProperty("line.separator");
            System.out.println("No staff have left.");
        }
        for (Staff staffMemberArrived : staffArrived) {
            staffArrivedString += staffMemberArrived.toString() + System.getProperty("line.separator");
            System.out.println("Staff Member Arrived  |  "+staffMemberArrived.toString());
        }
        if (staffArrived.isEmpty()) {
            staffArrivedString += "No staff have arrived." + System.getProperty("line.separator");
            System.out.println("No staff have arrived.");
        }
        
        GUIViewer.getInstance().getStaffChangeDisplay().setText(staffLeftString + staffArrivedString);
    }
}
