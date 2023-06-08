/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.painter;

/**
 *
 * 1. Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335)
 * 2. Mohammad Harez Bin Hafez (ID: 1191202413)
 * 3. Nur Irdina Binti Hassan (ID: 1191202351)
 * 4. Adam Arief Bin Rodzlan (ID: 1191202129)    
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painter extends JFrame {
    private MyLine line;
    private MyShapes shapes;

    public Painter() {
        super("Painter");

        line = new MyLine(4);
        shapes = new MyShapes(line);

        // Create the content pane
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(line, BorderLayout.CENTER);

        // Create the Colors button
        JButton colorsButton = new JButton("Colors");
        colorsButton.setPreferredSize(new Dimension(110, 30));

        JButton shapeButton = new JButton("Shapes");
        shapeButton.setPreferredSize(new Dimension(110, 30));

        JButton clearButton = new JButton("Clear Canvas");
        clearButton.setPreferredSize(new Dimension(110, 30));

        colorsButton.addActionListener(e -> {
            // Create the color chooser dialog
            JDialog dialog = new JDialog(this, "Color Chooser", true);
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            // Add the MyColour panel to the dialog
            dialog.getContentPane().add(new MyColor(line));
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });

        shapeButton.addActionListener(e -> {
            // Create the shapes dialog
            JDialog dialog = new JDialog(this, "Shapes", true);
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            // Add the MyShapes panel to the dialog
            dialog.getContentPane().add(shapes);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                line.clear();
                repaint();
            }
        });

        // Create the button panel and add the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(colorsButton);
        buttonPanel.add(shapeButton);
        buttonPanel.add(clearButton);

        // Add the button panel to the content pane
        contentPane.add(buttonPanel, BorderLayout.PAGE_END);

        // Set the content pane, size, and other properties of the frame
        setContentPane(contentPane);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] a) {
        new Painter();
    }
}
