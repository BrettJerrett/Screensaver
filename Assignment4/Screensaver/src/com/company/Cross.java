package com.company;

import java.awt.*;
import java.awt.Graphics;

public class Cross extends Shape {
    public Cross(int height, int width, Color shapeColor, int xPosition, int yPosition, int xSpeed, int ySpeed) {
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

        //vertical line. disgusting.
        g.drawLine(this.getxPosition() + (this.getWidth() / 2), this.getyPosition() - (this.getWidth() / 2),
                this.getxPosition() + (this.getWidth() / 2) , this.getyPosition() + this.getWidth());

        //horizontal line
        g.drawLine(this.getxPosition(), this.getyPosition(), this.getxPosition() + this.getHeight(), this.getyPosition());
    }

    @Override
    public void moveShape() {

        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}
