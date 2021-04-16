package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //Constructor
    public MainWindow() {
        //Configure the window's properties
        this.setBounds(100, 100, 800, 800);
        //setting resizable to true so it'll allow the bounds to expand/contract
        this.setResizable(true);
        this.setTitle("ScreenSaver Madness!");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Instantiating my Screenboard
        com.company.ScreenBoard board = new com.company.ScreenBoard(this.getWidth(), this.getHeight());
        board.setBackground(Color.BLACK); //Setting the background to black.
        this.add(board);
    }
}
