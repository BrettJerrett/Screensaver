package com.company;

import java.awt.*;

public abstract class Shape {
    private int height;
    private int width;
    private Color shapeColor;
    private int xPosition;
    private int yPosition;
    private int xSpeed = 0;
    private int ySpeed = 0;

    public abstract void drawShape(Graphics g);

    public abstract void moveShape();

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getShapecolor(){
        return shapeColor;
    }
    public void setshapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}


