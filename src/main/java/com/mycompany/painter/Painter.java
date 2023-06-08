/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.painter;

/**
 *
 * @author Ayat
 */

import javax.swing.*;
import java.awt.*;

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

        // Create the button panel and add the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(colorsButton);
        buttonPanel.add(shapeButton);

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
