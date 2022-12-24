/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugoflaherty.staffcompare;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author tugso
 */
public class GUIViewer extends JFrame {
    private static GUIViewer instance;
    private ButtonPanel buttonPanel = new ButtonPanel();
    private JTextArea staffChangeDisplay = new JTextArea();
    private JScrollPane staffChangeDisplayScrollPane = new JScrollPane(staffChangeDisplay);
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu helpMenu = new JMenu("About");
    private JMenuItem openOldFile = new JMenuItem("Open Old File");
    private JMenuItem openNewFile = new JMenuItem("Open New File");
    private JMenuItem saveFile = new JMenuItem("Save File");
    private JMenuItem quit = new JMenuItem("Quit");
    private JMenuItem help = new JMenuItem("Help");
    private JMenuItem about = new JMenuItem("About Application");
    
    public static GUIViewer getInstance() {
        if (instance == null) {
            instance = new GUIViewer();
        }
        return instance;
    }
    
    private GUIViewer() {
        GUIController eventHandler = new GUIController();
        ImageIcon icon = new ImageIcon("applicationicon.png");
        this.setIconImage(icon.getImage());
        this.setTitle("Staff List Change Tracker");
        this.add(staffChangeDisplayScrollPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.add(openOldFile);
        openOldFile.setActionCommand("openOldFile");
        openOldFile.addActionListener(eventHandler);
        fileMenu.add(openNewFile);
        openNewFile.setActionCommand("openNewFile");
        openNewFile.addActionListener(eventHandler);
        fileMenu.add(saveFile);
        saveFile.setActionCommand("saveFile");
        saveFile.addActionListener(eventHandler);
        fileMenu.add(quit);
        quit.setActionCommand("quit");
        quit.addActionListener(eventHandler);
        helpMenu.add(help);
        help.setActionCommand("help");
        help.addActionListener(eventHandler);
        helpMenu.add(about);
        about.setActionCommand("about");
        about.addActionListener(eventHandler);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public JTextArea getStaffChangeDisplay() {
        return staffChangeDisplay;
    }
}