package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main2 extends JFrame {

    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;

    public static void main(String[] args) {

        new Main2();

    }

    public Main2() {

        this.setSize(400, 500);

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Dimensions
        Dimension dimension = toolkit.getScreenSize();
        int xPos = (dimension.width / 2) - (this.getWidth() / 2);
        int yPos = (dimension.height / 2) - (this.getHeight() / 2);

        this.setLocation(xPos, yPos);

        // Closing operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        this.setTitle("Second lesson");


        // Button
        button1 = new JButton("Click here");
        ListenForButton listenForButton = new ListenForButton();
        button1.addActionListener(listenForButton);

        // TextArea
        textArea1 = new JTextArea(15, 20);
        textArea1.setText("Tracking events\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Text Field
        textField1 = new JTextField("T", 15);
        //ListenForKeys listenForKeys = ListenForKeys();
        //textField1.addKeyListener(listenForKeys);


        // Panel
        JPanel thePanel = new JPanel();
        thePanel.add(button1);
        thePanel.add(scrollBar1);

        this.add(thePanel);


    }

    // Implementing Listeners
    private class ListenForButton implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == button1) {
                buttonClicked++;
                textArea1.append("Button clicked " + buttonClicked + " times\n");
                event.getSource().toString();
            }
        }

    }

    private class ListenForKeys implements KeyListener {


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
