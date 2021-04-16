package com.company;

import java.awt.*;
import java.awt.Graphics;

public class Square extends Shape {
    public Square(int height, int width, Color shapeColor, int xPosition, int yPosition, int xSpeed, int ySpeed) {
        this.setHeight(height);
        //hoping setting width to height will create me a square heh.
        this.setWidth(height);
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
        g.fillRect(this.getxPosition(), this.getyPosition(), this.getWidth(), this.getHeight());
    }

    @Override
    public void moveShape() {

        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}

