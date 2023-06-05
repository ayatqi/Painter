/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.painter;

/**
 *
 * author Ayat
 */

import javax.swing.*;
import java.awt.*;

public class MyShapes extends JPanel {
    private MyLine line;
    private MyLine.Shape[] savedShapes;  // Array to store the previously drawn shapes

    public MyShapes(MyLine line) {
        this.line = line;
        this.savedShapes = new MyLine.Shape[0];  // Initialize the array to store the previously drawn shapes

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
            line.setDrawingMode(true); // Enable drawing mode
            line.setDrawOval(false);
        });

        ovalButton.addActionListener(e -> {
            // Handle oval button click event
            // Code to perform when the oval button is clicked
            line.setDrawSquare(false); // Disable drawing Square/Rectangles
            line.setDrawOval(true);
            line.setDrawingMode(true); // Enable drawing mode
        });

        triangleButton.addActionListener(e -> {
            // Handle triangle button click event
            // Code to perform when the triangle button is clicked
            line.setDrawSquare(false); // Disable drawing squares/rectangles
            line.setDrawOval(false); // Disable drawing ovals
            line.setDrawTriangle(true); // Enable drawing triangles
            line.setDrawingMode(true); // Enable drawing mode
        });

        circleButton.addActionListener(e -> {
            // Handle brush button click event
            // Code to perform when the brush button is clicked
            line.setDrawSquare(false); // Disable drawing Square/Rectangles
            line.setDrawingMode(true); // Enable drawing mode
            line.setDrawOval(false);
        });

        brushButton.addActionListener(e -> {
            // Handle brush button click event
            // Code to perform when the brush button is clicked
            line.setDrawSquare(false); // Disable drawing Square/Rectangles
            line.setDrawOval(false);
            line.setDrawingMode(true); // Enable drawing mode
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

    public void saveShapes() {
        savedShapes = line.getShapes(); // Save the currently drawn shapes
        line.clearShapes(); // Clear the currently drawn shapes
    }

    public void restoreShapes() {
        line.clearShapes(); // Clear the currently drawn shapes
        line.setShapes(savedShapes); // Restore the previously drawn shapes
    }

}