package com.company;

import java.awt.*;
import java.awt.Graphics;

public class Circle extends Shape {

    private int size;

    public Circle(int size,  Color shapeColor, int xPosition, int yPosition, int xSpeed, int ySpeed) {
        this.setSize(size);
        this.setshapeColor(shapeColor);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
        this.setxSpeed(xSpeed);
        this.setySpeed(ySpeed);

    }

    @Override
    public void drawShape(Graphics g) {
        Color mainColor = this.getShapecolor();
        g.setColor(mainColor);
        g.fillOval(this.getxPosition(), this.getyPosition(), this.getSize(), this.getSize());

    }

    @Override
    public void moveShape() {

        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
