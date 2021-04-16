package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class ScreenBoard extends JPanel {

    //Array to hold Shape objects
    private ArrayList<Shape> shapes;

    //Make an array of random colors.
    Color[] colors = new Color[] {Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.ORANGE, Color.CYAN, Color.WHITE};

    //Constructor. Explicitly gets its panel size from parent frame.
    public ScreenBoard(int boardWidth, int boardHeight) {

        //Set ScreenBoard dimensions (taken from frame)
        this.setBounds(100, 100, boardWidth, boardHeight);

        //Shape array to hold new shapes
        shapes = new ArrayList<Shape>();
        Timer timer = new Timer(10, new TimerAction());
        timer.start(); //timer..ALWAYS ON.

        // Code to add a mouse listener, to capture mouse-related events
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Generating random number in bounds of the Switch case below that will choose at random which shape to create.
                Random rand = new Random();
                int shapeCount = rand.nextInt(5);

                //Getting coordinates from Mouse-click that will be used as parameters to place random shape
                int mouseX = e.getX();
                int mouseY = e.getY();

                //Switch case that takes random generated int to decide which shape to create on Mouse-click.
                switch(shapeCount) {
                    case 0:
                        //Create a random Circle
                        Circle theCircle = new Circle(rand.nextInt(40), getRandomColor(), mouseX, mouseY, rand.nextInt(10)+ 1, rand.nextInt(10) + 1);
                        shapes.add(theCircle);
                        break;
                    case 1:
                        //Create a random Square
                        Square theSquare = new Square(rand.nextInt(40), getHeight(), getRandomColor(), mouseX, mouseY, rand.nextInt(10) + 1, rand.nextInt(10) + 1);
                        shapes.add(theSquare);
                        break;
                    case 2:
                        //Create a random Rectangle
                        Rectangle theRectangle = new Rectangle(rand.nextInt(40), rand.nextInt(40) * 2, getRandomColor(), mouseX, mouseY, rand.nextInt(10) + 1, rand.nextInt(10) + 1);
                        shapes.add(theRectangle);
                        break;
                    case 3:
                        //Create a random Cross that only a mother could love :)
                        Cross theCross = new Cross(rand.nextInt(40), rand.nextInt(40), getRandomColor(), mouseX, mouseY, rand.nextInt(10) + 1, rand.nextInt(10) + 1);
                        shapes.add(theCross);
                        break;
                    case 4:
                        //Create a random Triangle, actually kind of nailed this one I think
                        Triangle theTriangle = new Triangle(rand.nextInt(40), rand.nextInt(40), getRandomColor(), mouseX, mouseY, rand.nextInt(10) +1, rand.nextInt(10)+ 1);
                        shapes.add(theTriangle);
                        break;
                }
            }
        });

        //Start timer object
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape sha: shapes) {
           sha.drawShape(g);
        }
    }

    //Get a random color from color array.
    private Color getRandomColor() {
        Random rand = new Random();
        return colors[rand.nextInt(colors.length)];
    }

    public void moveShapes() {
        for (Shape sha: shapes){
            sha.moveShape();
            //checkForShapeHit(sha);
            // Had some issues getting the collision testing working for objects. Feel free to uncomment this method to see how horrible it looks.
            // I'm assuming by doing this I'm creating an infinite loop, maybe from the current Shape finding itself in the array?
            checkForWallHit(sha);
        }
        this.repaint();
    }

    public void checkForWallHit(Shape currShape) {
        //Checking for wall hit, and if so change the color, direction, size and speed.
        Random rand = new Random();
        if ((currShape.getxPosition() + currShape.getWidth()) >= this.getWidth()) {
            currShape.setshapeColor(getRandomColor());
            currShape.setxSpeed(rand.nextInt(10));
            currShape.setxSpeed(currShape.getxSpeed() * -1);
            currShape.setHeight(rand.nextInt(40));
            currShape.setWidth(rand.nextInt(40));
        } else if (currShape.getxPosition() < 0 ) {
            currShape.setxSpeed(currShape.getxSpeed() * -1);
            currShape.setshapeColor(getRandomColor());
            currShape.setxSpeed(rand.nextInt(10));
            currShape.setHeight(rand.nextInt(40));
            currShape.setWidth(rand.nextInt(40));
        } else if ((currShape.getyPosition() + currShape.getHeight()) >= this.getHeight()) {
            currShape.setshapeColor(getRandomColor());
            currShape.setySpeed(rand.nextInt(10));
            currShape.setySpeed(currShape.getySpeed() * -1);
            currShape.setHeight(rand.nextInt(40));
            currShape.setWidth(rand.nextInt(40));
        } else if (currShape.getyPosition() < 0) {
            currShape.setySpeed(currShape.getySpeed() * -1);
            currShape.setshapeColor(getRandomColor());
            currShape.setySpeed(rand.nextInt(10));
            currShape.setHeight(rand.nextInt(40));
            currShape.setWidth(rand.nextInt(40));
        }

    }

    //Look upon my work and cry:

//    public void checkForShapeHit(Shape currShape) {
//        Random rand = new Random();
//        for (Shape sha: shapes){
//            if (currShape.getxPosition() + currShape.getWidth() >= sha.getxPosition()) {
//                currShape.setshapeColor(getRandomColor());
//                currShape.setxSpeed(currShape.getxSpeed() * -1);
//                currShape.setySpeed(currShape.getySpeed() * -1);
//                sha.setxSpeed(sha.getxSpeed() * -1);
//                sha.setySpeed(sha.getySpeed() * -1);
//            } else if (currShape.getxPosition() < sha.getWidth()) {
//                currShape.setshapeColor(getRandomColor());
//                currShape.setxSpeed(currShape.getxSpeed() * -1);
//                currShape.setySpeed(currShape.getySpeed() * -1);
//            } else if (currShape.getyPosition() + currShape.getHeight() >= sha.getyPosition() + sha.getHeight()){
//                currShape.setshapeColor(getRandomColor());
//                currShape.setySpeed(currShape.getySpeed() * -1);
//                currShape.setxSpeed(currShape.getxSpeed() * -1);
//                sha.setxSpeed(sha.getxSpeed() * -1);
//                sha.setySpeed(sha.getySpeed() * -1);
//            } else if (currShape.getyPosition() < sha.getHeight()) {
//                currShape.setshapeColor(getRandomColor());
//                currShape.setySpeed(currShape.getySpeed() * -1);
//                currShape.setxSpeed(currShape.getxSpeed() * -1);
//            }
//        }
//
//    }
    //Creating a TimerObject that implements ActionListener
    private class TimerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveShapes();
        }
    }
}