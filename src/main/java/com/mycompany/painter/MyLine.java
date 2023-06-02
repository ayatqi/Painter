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
        this.widthSize = widthSize;
        this.lineColor = Color.BLACK;
        this.lines = new ArrayList<>();
        setSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
        MyMouseAdapter ma = new MyMouseAdapter();
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void setWidthSize(int widthSize) {
        this.widthSize = widthSize;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Iterate over each line and draw it
        for (Line line : lines) {
            g.setColor(line.getColor());

            // Only draw the line if it has at least 2 points
            if (line.getPoints().size() >= 2) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(line.getWidth()));

                // Iterate over each point in the line and draw a line segment between consecutive points
                for (int i = 1; i < line.getPoints().size(); i++) {
                    Point p1 = line.getPoints().get(i - 1);
                    Point p2 = line.getPoints().get(i);
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
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
            currentLine.setColor(lineColor);
            currentLine.setWidth(widthSize);
            currentLine.getPoints().add(me.getPoint());
            addLine(currentLine);
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            // Add points to the current line as mouse is dragged
            currentLine.getPoints().add(me.getPoint());
            repaint();
        }
    }

    public static class Line {
        private List<Point> points;   // List to store the points of the line
        private Color color;          // Color of the line
        private int width;            // Width of the line

        public Line() {
            this.points = new ArrayList<>();
        }

        public List<Point> getPoints() {
            return points;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
