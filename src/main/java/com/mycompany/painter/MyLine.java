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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MyLine extends JPanel {
    private int widthSize;          // Width of the line
    private Color lineColor;        // Color of the line
    private boolean drawSquare;     // Flag to indicate if Square/Rectangle should be drawn
    private boolean drawingMode;    // Flag to indicate the current drawing mode
    private List<Shape> shapes;     // List to store all the shapes drawn

    public MyLine(int widthSize) {
        this.widthSize = widthSize;  // Initialize the width of the line
        this.lineColor = Color.BLACK;  // Initialize the color of the line to black
        this.drawSquare = false; // Initialize the flag to false
        this.drawingMode = false; // Initialize the drawing mode to false
        this.shapes = new ArrayList<>();  // Initialize the list to store all the shapes drawn
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
    
    public void addShape(Shape shape) {
        shapes.add(shape);  // Add the provided shape to the list of shapes
        repaint();  // Repaint the panel to update the drawing
    }

    public void setDrawSquare(boolean drawSquare) {
        this.drawSquare = drawSquare; // Set the flag to indicate if Square/Rectangle should be drawn
        repaint(); // Repaint the panel to update the drawing
    }

    public void setDrawingMode(boolean drawingMode) {
        this.drawingMode = drawingMode; // Set the current drawing mode
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = new ArrayList<>(List.of(shapes)); // Set the shapes drawn in the previous mode
        repaint(); // Repaint the panel to update the drawing
    }

    public Shape[] getShapes() {
        return shapes.toArray(new Shape[0]); // Return the shapes drawn in the current mode
    }

    public void clearShapes() {
        shapes.clear(); // Clear the shapes drawn on the panel
        repaint(); // Repaint the panel to update the drawing
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Iterate over each shape and draw it
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    private class MyMouseAdapter extends MouseAdapter {
        private Point startPoint;

        @Override
        public void mousePressed(MouseEvent me) {
            startPoint = me.getPoint();  // Store the starting point of the shape

            if (drawSquare && drawingMode) {
                int width = 0;
                int height = 0;
                Square square = new Square(startPoint, width, height);
                square.setColor(lineColor);  // Set the color of the new square to be drawn
                square.setWidth(widthSize);  // Set the width of the new square to be drawn
                addShape(square);  // Add a new square to the list of shapes drawn
                
            } else {
                Line line = new Line();
                line.setColor(lineColor);  // Set the color of the new line to be drawn
                line.setWidth(widthSize);  // Set the width of the new line to be drawn
                line.getPoints().add(startPoint);  // Add a new point to the new line being drawn at the mouse press location
                addShape(line);  // Add a new line to the list of shapes drawn
            }
    }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (drawSquare && drawingMode) {
                int width = me.getX() - startPoint.x;
                int height = me.getY() - startPoint.y;
                Square square = new Square(startPoint, width, height);
                square.setColor(lineColor);  // Set the color of the new square to be drawn
                square.setWidth(widthSize);  // Set the width of the new square to be drawn
                addShape(square);  // Add a new square to list of shapes drawn
                repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            if (!drawSquare || !drawingMode) {
                Shape shape = shapes.get(shapes.size() - 1);
                if (shape instanceof Line) {
                    Line line = (Line) shape;
                    line.getPoints().add(me.getPoint());  // Add a new point to current line being drawn as mouse is dragged
                }
                repaint();   // Repaint panel with updated drawing
            }
        }
    }

    public static abstract class Shape {
        private Color color;          // Color of a single drawn shape
        private int width;            // Width of a single drawn shape

        public Color getColor() { // This method returns the color of the shape.
            return color;
        }

        public void setColor(Color color) { // This method sets the color of the shape.
            this.color = color;
        }

        public int getWidth() { // This method returns the width of the shape.
            return width;
        }

        public void setWidth(int width) { // This method sets the width of the shape.
            this.width = width;
        }

        public abstract void draw(Graphics g); // This method is implemented by each shape class to draw the shape.
    }

    public static class Line extends Shape {
        private List<Point> points;   // List to store all points in a single drawn line

        public Line() {
            this.points = new ArrayList<>();   // Initialize list of points in a single drawn line
        }

        public List<Point> getPoints() {
            return points;   // Return list of points in a single drawn line
        }

        @Override
        public void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(getColor());  // Set the color of the current line
            g2d.setStroke(new BasicStroke(getWidth()));  // Set the width of the current line

            // Only draw the line if it has at least 2 points
            if (points.size() >= 2) {
                for (int i = 1; i < points.size(); i++) {
                    Point p1 = points.get(i - 1);
                    Point p2 = points.get(i);
                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);  // Draw a line segment between consecutive points in the current line
                }
            }
        }
    }

    public static class Square extends Shape {
        private Point startPoint;
        private int width;
        private int height;

        public Square(Point startPoint, int width, int height) {
            this.startPoint = startPoint;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(getColor());  // Set the color of the current square
            g2d.setStroke(new BasicStroke(getWidth()));  // Set the width of the current square

            g2d.drawRect(startPoint.x, startPoint.y, width, height);  // Draw a square/rectangle with the given parameters
        }
    }
}
