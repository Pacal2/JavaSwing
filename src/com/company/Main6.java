package com.company;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class Main6 extends JFrame {

    JButton button1;
    String outputString = "";

    JTree theTree;

    DefaultMutableTreeNode documents, work, games, emails;
    DefaultMutableTreeNode fileSystem = new DefaultMutableTreeNode("C Drive");

    public static  void main(String[] args) {

        new Main6();

    }

    public Main6 () {

        // Window/frame basic setup
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sixth frame");

        JPanel thePanel = new JPanel();

        // Button 1
        button1 = new JButton("Get Answer:");
        ListenForButton listenForButton = new ListenForButton();
        button1.addActionListener(listenForButton);
        thePanel.add(button1);

        // Trees
        theTree = new JTree(fileSystem);
        theTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        theTree.setVisibleRowCount(8);

        documents = addAFile("Docs", fileSystem);

        addAFile("Taxes.exl", documents);
        addAFile("Story.txt", documents);

        emails = addAFile("Emails", documents);
        addAFile("Schedule.txt", documents);

        addAFile("CallBob.txt", emails);

        work = addAFile("Work Applications", fileSystem);

        addAFile("Spreadsheet.exe", work);
        addAFile("Wordprocessor.exe", work);

        games = addAFile("Games", fileSystem);

        addAFile("Planescape: Torment", work);
        addAFile("Morrowind", work);

        JScrollPane scrollBox = new JScrollPane(theTree);

        Dimension dimension = scrollBox.getPreferredSize();
        dimension.width = 200;
        scrollBox.setPreferredSize(dimension);

        thePanel.add(scrollBox);

        // Panel close up
        this.add(thePanel);
        this.setVisible(true);

    }

    // Listeners
    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {

                Object treeObject = theTree.getLastSelectedPathComponent();

                DefaultMutableTreeNode theFile = (DefaultMutableTreeNode) treeObject;

                String treeNode = (String) theFile.getUserObject();

                outputString += "The Selected Node: " + treeNode + "\n";

                outputString += "Number of Children" + theFile.getChildCount() + "\n";

                outputString += "Number of Siblings" + theFile.getSiblingCount() + "\n";

                outputString += "Parent: " + theFile.getParent() + "\n";

                outputString += "Next Node" + theFile.getNextNode() + "\n";

                outputString += "Previous Node" + theFile.getPreviousNode() + "\n";

                outputString += "\nChildren of Node\n";

                for (Enumeration enumerationValue = theFile.children(); enumerationValue.hasMoreElements(); ) {

                    outputString += enumerationValue.nextElement() + "\n";

                }

                outputString += "\nPath from Root\n";

                TreeNode[] pathNodes = theFile.getPath();

                for (TreeNode individualNodes: pathNodes) {
                    outputString += individualNodes + "\n";
                }

                JOptionPane.showMessageDialog(Main6.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    // Add a file method
    private  DefaultMutableTreeNode addAFile(String fileName, DefaultMutableTreeNode parentFolder){

        DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(fileName);
        parentFolder.add(newFile);

        return  newFile;


    }


}
