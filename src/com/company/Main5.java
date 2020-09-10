package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class Main5 extends JFrame{

    JButton button1;
    JSpinner spinner1, spinner2, spinner3, spinner4;
    String outputString = "";

    public static void main(String[] args){

        new Main5();

    }

    public Main5() {

        // Window/frame basic setup
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Fifth frame");

        JPanel thePanel = new JPanel();

        // Button 1
        button1 = new JButton("Get Answer:");
        ListenForButton listenForButton = new ListenForButton();
        button1.addActionListener(listenForButton);
        thePanel.add(button1);

        // Spinners
        spinner1 = new JSpinner();
        thePanel.add(spinner1);

        spinner2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        thePanel.add(spinner2);

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        spinner3 = new JSpinner(new SpinnerListModel(weekDays));
        thePanel.add(spinner3);

        Dimension dimension =  spinner3.getPreferredSize();
        dimension.width = 80;
        spinner3.setPreferredSize(dimension);

        // Dates
        Date todaysDate = new Date();
        spinner4 = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4, "dd/MM/yy");
        spinner4.setEditor(dateEditor);
        thePanel.add(spinner4);


        // Panel close up
        this.add(thePanel);
        this.setVisible(true);

    }

    // Listeners
    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {

                outputString += "Spinner 1 value: " + spinner1.getValue() + "\n";
                outputString += "Spinner 2 value: " + spinner2.getValue() + "\n";
                outputString += "Spinner 3 value: " + spinner3.getValue() + "\n";
                outputString += "Spinner 4 value: " + spinner4.getValue() + "\n";

                JOptionPane.showMessageDialog(Main5.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);

                outputString = "";

            }
        }
    }


}
