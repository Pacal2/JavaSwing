package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        ListenForKeys listenForKeys = new ListenForKeys();
        textField1.addKeyListener(listenForKeys);


        // Panel
        JPanel thePanel = new JPanel();
        thePanel.add(button1);
        thePanel.add(scrollBar1);

        this.add(thePanel);

        // Listening events for window
        ListenForWindow listenForWindow = new ListenForWindow();
        this.addWindowListener(listenForWindow);

        // Mouse listener
        ListenForMouse listenForMouse = new ListenForMouse();
        thePanel.addMouseListener(listenForMouse);

        this.setVisible(true);


    }

    // Implementing Listeners
    private class ListenForButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                buttonClicked++;
                textArea1.append("Button clicked " + buttonClicked + " times\n");
                e.getSource().toString();
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

    private class ListenForWindow implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
            textArea1.append("Window is created");
        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            textArea1.append("Window in normal state");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            textArea1.append("Window is active");

        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("Window is not active");
        }
    }

    private class ListenForMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            textArea1.append("Mouse Panel pos: " + e.getX() + " " + e.getY() + "\n");
            textArea1.append("Mouse Screen pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
            textArea1.append("Mouse Button: " + e.getButton() + "\n");
            textArea1.append("Mouse Clicks: " + e.getClickCount() + "\n");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
