package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {

        new Main();

    }

    public Main() {

        // Lesson 1
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        Toolkit toolkit = Toolkit.getDefaultToolkit();


        // Dimensions
        Dimension dimension = toolkit.getScreenSize();
        int xPos = (dimension.width / 2) - (this.getWidth() / 2);
        int yPos = (dimension.height / 2) - (this.getHeight() / 2);

        this.setLocation(xPos, yPos);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        this.setTitle("Java Swing Program");

        // The Panel
        JPanel thePanel = new JPanel();

        // Label
        JLabel label1 = new JLabel("Information text");
        label1.setText("Text of label");
        label1.setToolTipText("Doesn't do anything");
        thePanel.add(label1);

        // Button
        JButton button1 = new JButton("Send");
        button1.setText("New Button");
        button1.setToolTipText("It's a button");
        thePanel.add(button1);

        // TextField
        JTextField textField1 = new JTextField("Type here", 15);
        textField1.setColumns(10);
        textField1.setText("Type again");
        textField1.setToolTipText("It's a field");
        thePanel.add(textField1);

        // TextArea
        JTextArea textArea1 = new JTextArea(15, 20);
        textArea1.setText("A lot of text about stuff and thing and even concepts, ideas or perhaps memes\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        int numOfLines = textArea1.getLineCount();
        textArea1.append(" number o lines: " + numOfLines);
        JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollbar1);


        this.add(thePanel);
        this.setVisible(true);

        textField1.requestFocus();
    }
}
