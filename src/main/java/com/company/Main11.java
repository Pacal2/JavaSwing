package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main11 extends JFrame {

    static JLabel firstNameLabel, lastNameLabel, stateLabel, birthDateLabel;

    static JTextField firstNameText, lastNameText, StateText, birthDateText;

    static java.util.Date dateBirthDate, sqlBirthDate;

    static Object[][] databaseResults;

    static Object[] columns = {"First Name", "LastName", "State", "Birth Date"};

    static DefaultTableModel defaultTableModel = new DefaultTableModel(databaseResults, columns){
        public Class getColumnClass(int column) {
            Class returnValue;

            if((column >= 0) && (column < getColumnCount())) {
                returnValue = getValueAt(0, column).getClass();
            } else {
                returnValue = Object.class;
            }
            return returnValue;
        }
    };

    static JTable table = new JTable(defaultTableModel);

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection();

        }


    }
}
