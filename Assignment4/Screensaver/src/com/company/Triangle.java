package com.company;

import java.awt.*;
import java.awt.Graphics;

public class Triangle extends Shape {
    public Triangle(int height, int width, Color shapeColor, int xPosition, int yPosition, int xSpeed, int ySpeed) {
        this.setHeight(height);
        this.setWidth(width);
        this.setshapeColor(shapeColor);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
        this.setxSpeed(xSpeed);
        this.setySpeed(ySpeed);
    }

    @Override
    public void drawShape(Graphics g) {
        Color shapeColor = this.getShapecolor();
        g.setColor(shapeColor);
        g.fillPolygon(new int[] {this.getxPosition(), this.getxPosition() + (this.getWidth() / 2), this.getxPosition() + this.getWidth()}, new int[] {this.getyPosition(), this.getyPosition() - this.getHeight(), this.getyPosition()}, 3);
    }

    @Override
    public void moveShape() {

        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}
