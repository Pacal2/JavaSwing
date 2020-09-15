package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main7 extends JFrame {

    JButton button1, button2, button, button3, button4, button5;

    public static void main(String[] args) {

        new Main7();

    }

    public Main7() {

        // Window/frame basic setup
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Seventh frame");

        // Flow Layout
        /*
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 20));

        // Buttons
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");

        thePanel.add(button1);
        thePanel.add(button2);
         */

        // Border Layout
        /*
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new BorderLayout());

        // Buttons
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");

        JPanel thePanel2 = new JPanel();
        thePanel2.add(button1);
        thePanel2.add(button2);

        thePanel.add(thePanel2, BorderLayout.NORTH);
        thePanel.add(button3, BorderLayout.SOUTH);
        thePanel.add(button4, BorderLayout.EAST);
        thePanel.add(button5, BorderLayout.WEST);
         */

        // Box Layout
        Box theBox = Box.createHorizontalBox();
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");
        theBox.add(button1);
        theBox.add(Box.createHorizontalStrut(2));
        theBox.add(button2);
        theBox.add(Box.createHorizontalStrut(4));
        theBox.add(button3);
        theBox.add(Box.createHorizontalStrut(6));
        theBox.add(button4);
        theBox.add(Box.createHorizontalGlue());
        theBox.add(button5);
        this.add(theBox);



        // Panel close up
        // Panel used in flow and border layout but not in box layout
        // this.add(thePanel);
        this.setVisible(true);


    }

    // Listeners
    public class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
