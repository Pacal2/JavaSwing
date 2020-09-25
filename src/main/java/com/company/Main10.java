package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.transform.Result;
import java.awt.*;
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

    public static void main(String[] args) throws ClassNotFoundException {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lahman591","mysqladm","turtledove");
            Statement sqlState = connection.createStatement();
            String selectStuff = "select b.yearID, b.playerID, " +
                    "CONCAT(m.nameFirst, ' ', m.nameLast) AS NAME, " +
                    "((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.TB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB)) AS TTRC, " +
                    "b.teamID AS Team, 0 AS Salary, " +
                    "0 AS CPR, f.POS AS POS " +
                    "FROM Batting b, Master m, Fielding f, TOTBYR as t " +
                    "WHERE b.playerID = m.playerID AND t.playerID = m.playerID " +
                    "AND t.yearID = 2011 AND b.yearID = t.yearID " +
                    "AND b.AB > 100 AND f.playerID = b.playerID " +
                    "GROUP BY b.playerID ORDER BY TTRC DESC LIMIT 200;";
            rows = sqlState.executeQuery(selectStuff);

            /* How to get column number
            metaData = rows.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            columns = new String[numberOfColumns];
            for(int i=1; i <= numberOfColumns; i++) {
                columns[i] = metaData.getCatalogName(i);
            }

             */

            Object[] tempRow;

            // In JTables indexes start with 1 not 0
            while (rows.next()){
                tempRow = new Object[]{
                        rows.getInt(1), rows.getString(2), rows.getString(3),
                        rows.getDouble(4), rows.getString(5), rows.getInt(6),
                        rows.getDouble(7), rows.getString(8)
                };
                dataTableModel.addRow(tempRow);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(dataTableModel);
        table.setRowHeight(table.getRowHeight() + 10);
        table.setFont(new Font("Serif", Font.PLAIN, 20));
        //table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TableColumn col1 = table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(100);

        TableColumn col2 = table.getColumnModel().getColumn(1);
        col2.setPreferredWidth(190);

        TableColumn tc = table.getColumn("Team");
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        tc = table.getColumn("POS");
        centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(800, 500);
        frame.setVisible(true);



    }

    static class CenterTableCellRenderer extends DefaultTableCellRenderer {
        public CenterTableCellRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

    }
}
