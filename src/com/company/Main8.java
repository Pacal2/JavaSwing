package com.company;

import javax.swing.*;
import java.awt.*;

public class Main8 extends JFrame {

    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonPlus, buttonMinus, clearAll;

    JTextField textResult;


    public static void main(String[] args) {


        new Main8();


    }

    public Main8() {

        // Window/frame basic setup
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");

        // Panel Grid Layout

        JPanel thePanel = new JPanel();

        thePanel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 50;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button0 = new JButton("0");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");

        thePanel.add(button1);
        thePanel.add(button2);
        thePanel.add(button3);
        thePanel.add(button4);
        thePanel.add(button5);
        thePanel.add(button6);
        thePanel.add(button7);
        thePanel.add(button8);
        thePanel.add(button9);
        thePanel.add(button0);
        thePanel.add(buttonPlus);
        thePanel.add(buttonMinus);

        // Panel close up
        this.add(thePanel);
        this.setVisible(true);

    }
}
