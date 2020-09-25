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
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;


        textResult = new JTextField("0", 20);
        Font font = new Font("Helvetica", Font.PLAIN, 18);
        textResult.setFont(font);

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
        clearAll = new JButton("C");

        thePanel.add(clearAll, gridBagConstraints);
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridx = 5;
        thePanel.add(textResult, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        thePanel.add(button1, gridBagConstraints);
        gridBagConstraints.gridx = 5;
        thePanel.add(button2, gridBagConstraints);
        gridBagConstraints.gridx = 9;
        thePanel.add(button3, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        thePanel.add(button4, gridBagConstraints);
        gridBagConstraints.gridx = 5;
        thePanel.add(button5, gridBagConstraints);
        gridBagConstraints.gridx = 9;
        thePanel.add(button6, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        thePanel.add(button7, gridBagConstraints);
        gridBagConstraints.gridx = 5;
        thePanel.add(button8, gridBagConstraints);
        gridBagConstraints.gridx = 9;
        thePanel.add(button9, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        thePanel.add(button0, gridBagConstraints);
        gridBagConstraints.gridx = 5;
        thePanel.add(buttonPlus, gridBagConstraints);
        gridBagConstraints.gridx = 9;
        thePanel.add(buttonMinus, gridBagConstraints);


        // Panel close up
        this.add(thePanel);
        this.setVisible(true);

    }
}
