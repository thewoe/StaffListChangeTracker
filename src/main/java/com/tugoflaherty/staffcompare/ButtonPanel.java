/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugoflaherty.staffcompare;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tugso
 */
public class ButtonPanel extends JPanel {
    private JButton openOldFile = new JButton("Open Old File");
    private JButton openNewFile = new JButton("Open New File");
    private JButton saveFile = new JButton("Save File");
    private JButton quit = new JButton("Quit");
    
    public ButtonPanel() {
        GUIController eventHandler = new GUIController();
        this.setLayout(new FlowLayout());
        openOldFile.setPreferredSize(new Dimension(150, 25));
        openOldFile.setActionCommand("openOldFile");
        openOldFile.addActionListener(eventHandler);
        openNewFile.setPreferredSize(new Dimension(150, 25));
        openNewFile.setActionCommand("openNewFile");
        openNewFile.addActionListener(eventHandler);
        saveFile.setPreferredSize(new Dimension(150, 25));
        saveFile.setActionCommand("saveFile");
        saveFile.addActionListener(eventHandler);
        quit.setPreferredSize(new Dimension(150, 25));
        quit.setActionCommand("quit");
        quit.addActionListener(eventHandler);
        this.add(openOldFile);
        this.add(openNewFile);
        this.add(saveFile);
        this.add(quit);
    }
}
