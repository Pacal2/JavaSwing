package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main4 extends JFrame {

    JButton button1;
    String infoOnComponent = "";
    JList favoriteGames, favoriteComics;
    DefaultListModel defaultListModel = new DefaultListModel();
    JScrollPane scrollPane;

    public static void main(String[] args){

        new Main4();

    }

    public Main4(){

        // Window/frame basic setup
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Fourth frame");

        JPanel thePanel = new JPanel();

        // Button 1
        button1 = new JButton("Get Answer:");
        ListenForButton listenForButton = new ListenForButton();
        button1.addActionListener(listenForButton);
        thePanel.add(button1);

        // Array
        //Type 1
        String[] games = {"Planescape: Torment", "Morrowind", "Bloodborne", "Nier: Automata", "Hollow Knight"};
        favoriteGames = new JList(games);
        favoriteGames.setFixedCellHeight(30);
        favoriteGames.setFixedCellWidth(150);
        favoriteGames.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        // Type 2
        String[] comics = {"The Maxx", "Dorohedoro", "Nausicaa", "Incal", "Blame", "Metabarons"};
        for(String comic: comics) {
            defaultListModel.addElement(comic);
        }

        defaultListModel.add(6, "Scott Pilgrim");
        favoriteComics = new JList(defaultListModel);
        favoriteComics.setVisibleRowCount(4);
        scrollPane = new JScrollPane(favoriteComics,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        favoriteComics.setFixedCellHeight(30);
        favoriteComics.setFixedCellWidth(150);
        thePanel.add(favoriteGames);
        thePanel.add(scrollPane);

        // Panel close up
        this.add(thePanel);
        this.setVisible(true);

    }

    // Listener methods
    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(defaultListModel.contains("Morrowind")) {
                infoOnComponent += "Morrowind is here\n";
            }
            if(!defaultListModel.isEmpty()) {
                infoOnComponent += "Isn't empty\n";
            }

            infoOnComponent += "Elements in the List" + defaultListModel.size() + "\n";

            infoOnComponent += "Last Element" + defaultListModel.lastElement() + "\n";

            infoOnComponent += "First Element" + defaultListModel.firstElement() + "\n";

            infoOnComponent += "In Index 1: " + defaultListModel.get(1) + "\n";

            defaultListModel.remove(0);

            defaultListModel.removeElement("Bloodborne");

            Object[] arrayOfList = defaultListModel.toArray();

            for(Object comic: arrayOfList) {
                infoOnComponent += comic + "\n";
            }

            JOptionPane.showMessageDialog(Main4.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
