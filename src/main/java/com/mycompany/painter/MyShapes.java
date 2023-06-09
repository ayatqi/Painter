/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class MyShapes extends JPanel {
    private MyLine line;

    public MyShapes(MyLine line) {
        this.line = line;

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false); // Disable toolbar floating

        JButton squareButton = new JButton("Square");
        JButton ovalButton = new JButton("Oval");
        JButton triangleButton = new JButton("Triangle");
        JButton circleButton = new JButton("Circle ");
        JButton brushButton = new JButton("Brush");

        squareButton.addActionListener(e -> {
            // Handle square button click event
            // Code to perform when the square button is clicked
            line.setDrawSquare(true); // Enable drawing Square/Rectangles
            line.setDrawTriangle(false);
            line.setDrawOval(false);
            line.setDrawCircle(false);
            line.setDrawingMode(true); // Enable drawing mode
            
        });

        ovalButton.addActionListener(e -> {
            // Handle oval button click event
            // Code to perform when the oval button is clicked
            line.setDrawSquare(false);
            line.setDrawTriangle(false);
            line.setDrawOval(true);
            line.setDrawCircle(false);
            line.setDrawingMode(true); 
        });

        triangleButton.addActionListener(e -> {
            // Handle triangle button click event
            // Code to perform when the triangle button is clicked
            line.setDrawSquare(false);
            line.setDrawTriangle(true);
            line.setDrawOval(false);
            line.setDrawCircle(false);
            line.setDrawingMode(true); 
        });

        circleButton.addActionListener(e -> {
            // Handle brush button click event
            // Code to perform when the brush button is clicked
            line.setDrawSquare(false);
            line.setDrawTriangle(false);
            line.setDrawOval(false);
            line.setDrawCircle(true);
            line.setDrawingMode(true); 
        });

        brushButton.addActionListener(e -> {
            // Handle brush button click event
            // Code to perform when the brush button is clicked
             line.setDrawSquare(false);
            line.setDrawTriangle(false);
            line.setDrawOval(false);
            line.setDrawCircle(false);
            line.setDrawingMode(true); 
        });

        toolbar.add(squareButton);
        toolbar.add(ovalButton);
        toolbar.add(triangleButton);
        toolbar.add(circleButton);
        toolbar.add(brushButton);

        setLayout(new BorderLayout());
        add(toolbar, BorderLayout.PAGE_START);
        add(line, BorderLayout.CENTER);
    }

}