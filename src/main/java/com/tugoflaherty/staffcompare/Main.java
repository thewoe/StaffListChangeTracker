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
        //private static final String oldStaffListFile = "C:\\Users\\tugso\\Documents\\General\\StaffLists\\Blenheim High School\\BlenheimHighSchoolStaffList14-04-2022.csv";
        // Enter the file name of the new staff list file here:
        // e.g. "C:\\Users\\tugso\\Documents\\General\\StaffLists\\Blenheim High School\\BlenheimHighSchoolStaffList14-04-2022.csv"
        //private static final String newStaffListFile = "C:\\Users\\tugso\\Documents\\General\\StaffLists\\Blenheim High School\\BlenheimHighSchoolStaffList15-04-2022.csv";
        /////////////////////////////////////////////|\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        
        public static void main(String[] args) {
        String welcomeString = "";
        welcomeString += "Welcome to the Staff List Change Tracker." + System.getProperty("line.separator");
        welcomeString += "Please select the old and new staff lists to compare." + System.getProperty("line.separator");
        welcomeString += "Either use 'File > Open Old File' or the Button below." + System.getProperty("line.separator");
        GUIViewer.getInstance().getStaffChangeDisplay().setText(welcomeString);
    }
}
