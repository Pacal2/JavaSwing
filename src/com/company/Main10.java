package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.transform.Result;
import java.sql.*;

public class Main10 extends JFrame {

    static Object[][] databaseInfo;

    static Object[] columns = {"Year", "PlayerID", "Name", "TTRC", "Team", "Salary", "CPR", "POS"};

    static ResultSet rows;

    static ResultSetMetaData metaData;

    static DefaultTableModel dataTableModel = new DefaultTableModel(databaseInfo, columns){
        public Class getColumnClass(int column) {
            Class returnValue;

            if((column >= 0) && (column > getColumnCount())) {
                returnValue = getValueAt(0, column).getClass();
            } else {
                returnValue = Object.class;
            }
            return returnValue;
        }
    };

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useTimezone=true&amp;serverTimezone=UTC", "root", "root");
            Statement sqlState = connection.createStatement();
            String selectStuff = ""
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
