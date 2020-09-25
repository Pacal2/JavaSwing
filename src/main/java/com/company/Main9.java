package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class Main9 extends JFrame {

    JLabel nameLabel, streetLabel, stateLabel, dateLabel, ageLabel, sexLabel, optionsLabel, aboutLabel;
    JTextField nameText, streetText;
    JComboBox stateList;
    JSpinner dateSpin;
    JSlider ageSlider;
    JRadioButton maleRadio, femaleRadio;
    ButtonGroup sexGroup;
    JCheckBox morningCheck, afterNCheck, eveningCheck;
    JTextArea aboutYou;

    public static void main(String[] args) {

        new Main9();

    }

    public Main9() {

        // Inital setup
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Random Layout");

        JPanel thePanel = new JPanel();

        thePanel.setLayout(new GridBagLayout());

        // Data labels
        nameLabel = new JLabel("Name:");
        addComp(thePanel, nameLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        nameText = new JTextField(30);
        addComp(thePanel, nameText, 1, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        streetLabel = new JLabel("Street: ");
        addComp(thePanel, streetLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        streetText = new JTextField(30);
        addComp(thePanel, streetText, 1, 1, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        // Sex group box
        Box sexBox = Box.createVerticalBox();
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        sexGroup = new ButtonGroup();
        sexGroup.add(maleRadio);
        sexGroup.add(femaleRadio);
        sexBox.add(maleRadio);
        sexBox.add(femaleRadio);
        sexBox.setBorder(BorderFactory.createTitledBorder("Sex"));
        addComp(thePanel, sexBox, 3, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        // State Panel
        JPanel statePanel = new JPanel();
        statePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        stateLabel = new JLabel("State");
        statePanel.add(stateLabel);
        String[] states = {"PA", "NY", "OH", "WV", "NJ"};
        stateList = new JComboBox(states);
        statePanel.add(stateList);

        // Date label
        dateLabel = new JLabel("Appointment Date");
        statePanel.add(dateLabel);
        Date todaysDate = new Date();
        dateSpin = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpin, "dd/MM/yy");
        dateSpin.setEditor(dateEditor);

        ageLabel = new JLabel("Age: 50");
        statePanel.add(ageLabel);
        ageSlider = new JSlider(1, 99, 50);
        ListenForSlider listenForSlider = new ListenForSlider();
        ageSlider.addChangeListener(listenForSlider);
        statePanel.add(ageSlider);

        // OptionBox
        addComp(thePanel, statePanel, 1, 2, 5, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        Box optionBox = Box.createVerticalBox();
        morningCheck = new JCheckBox("Morning");
        afterNCheck = new JCheckBox("Afternoon");
        eveningCheck = new JCheckBox("Evening");
        optionBox.add(morningCheck);
        optionBox.add(afterNCheck);
        optionBox.add(eveningCheck);
        optionBox.setBorder(BorderFactory.createTitledBorder("Time of Day"));
        addComp(thePanel, optionBox, 1, 3, 2, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);

        // About You text are
        aboutYou = new JTextArea(6, 40);
        aboutYou.setText("Tell us about you");
        aboutYou.setLineWrap(true);
        aboutYou.setWrapStyleWord(true);
        JScrollPane scrollbar1 = new JScrollPane(aboutYou, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);        addComp(thePanel, scrollbar1, 2, 3, 3, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(thePanel, scrollbar1, 2, 3, 3, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        // Final setup
        this.add(thePanel);
        //this.pack();
        this.setVisible(true);
        //this.setResizable(false);
    }

    // Listener
    private class ListenForSlider implements ChangeListener{


        @Override
        public void stateChanged(ChangeEvent e) {

            if(e.getSource() == ageSlider) {
                ageLabel.setText("Age: " + ageSlider.getValue());
            }

        }

    }

    private void addComp(JPanel thePanel, JComponent component, int xPos, int yPos, int componentWidth, int componentHeight, int place, int stretch) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = xPos;
        gridBagConstraints.gridy = yPos;
        gridBagConstraints.gridwidth = componentWidth;
        gridBagConstraints.gridheight = componentHeight;
        gridBagConstraints.weightx = 100;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = place;
        gridBagConstraints.fill = stretch;

        thePanel.add(component, gridBagConstraints);

    }

}
