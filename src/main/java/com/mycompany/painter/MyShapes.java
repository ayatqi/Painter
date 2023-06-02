/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.painter;

/**
 *
 * @author Ayat
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MyShapes extends JPanel {

    public MyShapes() {
        setLayout(new FlowLayout());

        JButton squareButton = new JButton("Square");
        JButton ovalButton = new JButton("Oval");
        JButton triangleButton = new JButton("Triangle");
        JButton rectangleButton = new JButton("Rectangle");

        squareButton.addActionListener(e -> {
            // Handle square button click event
            // Code to perform when the square button is clicked
        });

        ovalButton.addActionListener(e -> {
            // Handle oval button click event
            // Code to perform when the oval button is clicked
        });

        triangleButton.addActionListener(e -> {
            // Handle triangle button click event
            // Code to perform when the triangle button is clicked
        });

        rectangleButton.addActionListener(e -> {
            // Handle rectangle button click event
            // Code to perform when the rectangle button is clicked
        });

        add(squareButton);
        add(ovalButton);
        add(triangleButton);
        add(rectangleButton);
    }
}
