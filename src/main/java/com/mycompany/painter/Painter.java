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

    public Painter() {
        super("Painter");

        line = new MyLine(4);

        // Create the content pane
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(line, BorderLayout.CENTER);

        // Create the Colors button
        JButton colorsButton = new JButton("Colors");
        colorsButton.setPreferredSize(new Dimension(110, 30));
        
        colorsButton.addActionListener(e -> {
            // Create the color chooser dialog
            JDialog dialog = new JDialog(this, "Color Chooser", true);
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            // Add the MyColour panel to the dialog
            dialog.getContentPane().add(new MyColour(line));
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });

        // Create the button panel and add the colors button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(colorsButton);

        // Add the button panel to the content pane
        contentPane.add(buttonPanel, BorderLayout.PAGE_END);

        // Set the content pane, size, and other properties of the frame
        setContentPane(contentPane); // Set the content pane of the frame to be our custom JPanel.
        setSize(800, 600); // Set the size of the frame.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Set what happens when we close the frame.
        setVisible(true); // Make the frame visible.
    }

    public static void main(String[] a) {
        new Painter(); // Create a new instance of our Painter class.
    }
}
