package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Main3 extends JFrame{

    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollarSign, commaSeparator;
    JRadioButton addNums, subtractNums, multNums, divideNums;
    JSlider howManyTimes;

    double number1, number2, totalCalc;

    public static void main(String[] args){

        new Main3();

    }

    public Main3(){

        // Window/frame basic setup
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Third frame");

        JPanel thePanel = new JPanel();

        // Button 1
        button1 = new JButton("Calculate");
        ListenForButton listenForButton = new ListenForButton();
        button1.addActionListener(listenForButton);

        thePanel.add(button1);

        // Label 1
        label1 = new JLabel("Number 1");
        thePanel.add(label1);

        // TextField 1
        textField1 = new JTextField("", 5);
        thePanel.add(textField1);

        // Label 2
        label2 = new JLabel("Number 2");
        thePanel.add(label2);

        // TextField 2
        textField2 = new JTextField("", 5);
        thePanel.add(textField2);

        // Checkboxes
        dollarSign = new JCheckBox("Dollars");
        commaSeparator = new JCheckBox("Commas");

        thePanel.add(dollarSign);
        thePanel.add(commaSeparator, true);

        // Radio buttons
        addNums = new JRadioButton("Add");
        subtractNums = new JRadioButton("Subtract");
        multNums  = new JRadioButton("Multiply");
        divideNums  = new JRadioButton("Divide");

        ButtonGroup operation = new ButtonGroup();
        operation.add(addNums);
        operation.add(subtractNums);
        operation.add(multNums);
        operation.add(divideNums);

        // Borders and pannels
        JPanel operationPanel = new JPanel();
        Border operationBorder = BorderFactory.createTitledBorder("Operation");
        operationPanel.setBorder(operationBorder);

        operationPanel.add(addNums);
        operationPanel.add(subtractNums);
        operationPanel.add(multNums);
        operationPanel.add(divideNums);

        addNums.setSelected(true);

        thePanel.add(operationPanel);

        // Label 3
        label3 = new JLabel("Perform how many times: ");
        thePanel.add(label3);

        // Slider
        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);

        ListenForSlider listenForSlider = new ListenForSlider();

        howManyTimes.addChangeListener(listenForSlider);
        thePanel.add(howManyTimes);

        // Close up panel setup
        this.add(thePanel);
        this.setVisible(true);
        textField1.requestFocus();


    }

    //Listener methods

    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == button1) {
                try {
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());

                }
                catch (NumberFormatException excep) {
                    JOptionPane.showMessageDialog(Main3.this, "Please enter the right info", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                if(addNums.isSelected()) {
                    totalCalc = addNumbers(number1, number2, howManyTimes.getValue());
                } else if (subtractNums.isSelected()) {
                    totalCalc = subtractNumbers(number1, number2, howManyTimes.getValue());
                } else if (multNums.isSelected()) {
                    totalCalc = multiplyNumbers(number1, number2, howManyTimes.getValue());
                } else {
                    totalCalc = divideNumbers(number1, number2, howManyTimes.getValue());
                }

                if(dollarSign.isSelected()){
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(Main3.this, numberFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);
                } else if(commaSeparator.isSelected()) {
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(Main3.this, numberFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Main3.this, totalCalc, "Solution", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }

    private class ListenForSlider implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {

            if(e.getSource() == howManyTimes){
                label3.setText("Perform how many times? " + howManyTimes.getValue());
            }
        }
    }

    // Calculation methods

    public static double addNumbers(double number1, double number2, int howMany) {
        double total = 0;
        int i = 1;
        while(i <= howMany) {
            total = total + (number1 + number2);
            i++;
        }
        return total;
    }

    public static double subtractNumbers(double number1, double number2, int howMany) {
        double total = 0;
        int i = 1;
        while(i <= howMany) {
            total = total + (number1 - number2);
            i++;
        }
        return total;
    }

    public static double multiplyNumbers(double number1, double number2, int howMany) {
        double total = 0;
        int i = 1;
        while(i <= howMany) {
            total = total + (number1 * number2);
            i++;
        }
        return total;
    }

    public static double divideNumbers(double number1, double number2, int howMany) {
        double total = 0;
        int i = 1;
        while(i <= howMany) {
            total = total + (number1 / number2);
            i++;
        }
        return total;
    }
}
