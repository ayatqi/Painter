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
import javax.swing.event.*;
import java.awt.*;

public class MyColor extends JPanel {
    private MyLine line;

    public MyColor(MyLine line) {
        this.line = line;
        setPreferredSize(new Dimension(600, 300));
        setBackground(Color.LIGHT_GRAY);
        JColorChooser colorChooser = new JColorChooser();

        // Add a change listener to the color chooser
        colorChooser.getSelectionModel().addChangeListener(e -> {
            Color newColor = colorChooser.getColor();
            line.setLineColor(newColor);   // Set the new color for the line
            repaint();                      // Repaint the line panel
        });

        JSlider widthSlider = new JSlider(JSlider.VERTICAL, 1, 50, 4);
        widthSlider.setPreferredSize(new Dimension(20, 200));
        widthSlider.setMajorTickSpacing(1);
        widthSlider.setSnapToTicks(true);
        widthSlider.setPaintTicks(true);
        widthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int newWidth = widthSlider.getValue();
                line.setWidthSize(newWidth);   // Set the new width for the line
                repaint();                     // Repaint the line panel
            }
        });

        setLayout(new BorderLayout());
        add(colorChooser, BorderLayout.CENTER);   // Add the color chooser to the center of the panel
        add(widthSlider, BorderLayout.EAST);      // Add the width slider to the east of the panel
    }
}
