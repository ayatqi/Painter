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
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MyLine extends JPanel {
    private int widthSize;          // Width of the line
    private Color lineColor;        // Color of the line
    private List<Line> lines;       // List to store all the lines drawn

    public MyLine(int widthSize) {
        this.widthSize = widthSize;  // Initialize the width of the line
        this.lineColor = Color.BLACK;  // Initialize the color of the line to black
        this.lines = new ArrayList<>();  // Initialize the list to store all the lines drawn
        setSize(new Dimension(800, 600));  // Set the size of the panel
        setBackground(Color.WHITE);  // Set the background color of the panel to white
        MyMouseAdapter ma = new MyMouseAdapter();  // Create a new mouse adapter object
        addMouseListener(ma);  // Add mouse listener to the panel
        addMouseMotionListener(ma);  // Add mouse motion listener to the panel
    }

    public void setWidthSize(int widthSize) {
        this.widthSize = widthSize;  // Set the width of the line
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;  // Set the color of the line
    }

    public void addLine(Line line) {
        lines.add(line);  // Add a new line to the list of lines drawn
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Iterate over each line and draw it
        for (Line line : lines) {
            g.setColor(line.getColor());  // Set the color of the current line

            // Only draw the line if it has at least 2 points
            if (line.getPoints().size() >= 2) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(line.getWidth()));  // Set the width of the current line

                // Iterate over each point in the line and draw a line segment between consecutive points
                for (int i = 1; i < line.getPoints().size(); i++) {
                    Point p1 = line.getPoints().get(i - 1);
                    Point p2 = line.getPoints().get(i);
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);  // Draw a line segment between consecutive points in the current line
                } 

                
            }
        }
    }

    private class MyMouseAdapter extends MouseAdapter {
        private Line currentLine;

        @Override
        public void mousePressed(MouseEvent me) {
            // Create a new line when mouse is pressed
            currentLine = new Line();
            currentLine.setColor(lineColor);  // Set the color of the new line to be drawn
            currentLine.setWidth(widthSize);  // Set the width of the new line to be drawn
            currentLine.getPoints().add(me.getPoint());  // Add a new point to the new line being drawn at mouse press location 
            addLine(currentLine);  // Add a new line to list of lines drawn 
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            currentLine.getPoints().add(me.getPoint());  // Add a new point to current line being drawn as mouse is dragged 
            repaint();   // Repaint panel with updated drawing 
        }
    }

    /***  
     ***/
    public static class Line {
        private List<Point> points;   // List to store all points in a single drawn line 
        private Color color;          // Color of a single drawn line 
        private int width;            // Width of a single drawn line 

        public Line() {
            this.points = new ArrayList<>();   // Initialize list of points in a single drawn line 
        }

        public List<Point> getPoints() {
            return points;   // Return list of points in a single drawn line 
        }

        public Color getColor() { // This method returns the color of the object.
            return color;
        }

        public void setColor(Color color) { // This method sets the color of the object.
            this.color = color;
        }

        public int getWidth() { // This method returns the width of the object.
            return width;
        }

        public void setWidth(int width) { // This method sets the width of the object.
            this.width = width;
        }

    }
}