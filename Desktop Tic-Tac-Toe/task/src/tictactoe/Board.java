package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Board extends JPanel {
    GridBagConstraints constraints = new GridBagConstraints();
    String player = "X";
    JPanel topPanel;
    String[] cells = new String[9];
    JPanel bottomPanel;
    StatusLabel statusLabel;
    int turns = 0;

    //Board class that contains all pieces in the JFrame
    //The Board outer class holds a large JPanel and all subordinate components
    public Board() {
        Arrays.fill(cells, "");
        setLayout(new GridBagLayout());
        constraints.fill = GridBagConstraints.BOTH;


        //Create constraints and add top panel
        constraints.weightx = 1.0;
        constraints.weighty = .90;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        topPanel = new TopPanel();
        add(topPanel, constraints);


        //Create constraints and add bottom panel
        constraints.weighty = .10;
        constraints.weightx = .50;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        bottomPanel = new BottomPanel();
        add(bottomPanel, constraints);
    }

    private void checkForWinner() {
        if (!hasWinner()) {
            isDraw();
        } else {
            Component[] components = topPanel.getComponents();
            for (Component component : components) {
                GameCell cell = (GameCell) component;
                cell.switchPlayed();
            }
        }
    }

    private boolean hasWinner() {
        if ((cells[0].equals(cells[1]) && cells[1].equals(cells[2])) && !cells[0].equals("")
                || (cells[3].equals(cells[4]) && cells[4].equals(cells[5])) && !cells[3].equals("")
                || (cells[6].equals(cells[7]) && cells[7].equals(cells[8])) && !cells[6].equals("")
                || (cells[0].equals(cells[3]) && cells[3].equals(cells[6])) && !cells[0].equals("")
                || (cells[1].equals(cells[4]) && cells[4].equals(cells[7])) && !cells[1].equals("")
                || (cells[2].equals(cells[5]) && cells[5].equals(cells[8])) && !cells[2].equals("")
                || (cells[0].equals(cells[4]) && cells[4].equals(cells[8])) && !cells[0].equals("")
                || (cells[2].equals(cells[4]) && cells[4].equals(cells[6])) && !cells[2].equals("")) {
            if ("X".equals(player)) {
                statusLabel.decideStatus(StatusLabel.Status.XWINS);
            } else {
                statusLabel.decideStatus(StatusLabel.Status.OWINS);
            }
            statusLabel.setStatus();
            return true;
        }
        turns++;
        return false;
    }

    private void isDraw() {
        if (turns > 8) {
            statusLabel.decideStatus(StatusLabel.Status.DRAW);
            statusLabel.setStatus();
        }
    }

    private void playerSwitch() {
        if ("X".equals(player)) {
            player = "O";
        } else {
            player = "X";
        }
    }

    public void nextTurn() {
        statusLabel.decideStatus(StatusLabel.Status.PROGRESS);
        statusLabel.setStatus();
        checkForWinner();
        playerSwitch();
    }

    public void resetBoard() {
        player = "X";
        turns = 0;

        Component[] components = topPanel.getComponents();
        for (Component component : components) {
            GameCell cell = (GameCell) component;
            cell.setText(" ");
            cell.resetPlayed();
        }
        cells = new String[9];
        Arrays.fill(cells, "");
        statusLabel.decideStatus(StatusLabel.Status.START);
        statusLabel.setStatus();
    }


    //Inner Class for TopPanel
    public class TopPanel extends JPanel implements ActionListener {
        String[] cellNames = {"A3", "B3", "C3", "A2", "B2", "C2", "A1", "B1", "C1"};

        public TopPanel() {
            setLayout(new GridLayout(3, 3));
            for (String name : cellNames) {
                GameCell cell = new GameCell(name, this);
                add(cell);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GameCell cell = (GameCell) e.getSource();
            if (!cell.isPlayed()) {
                cell.switchPlayed();
                cell.setText(player);
                cells[getComponentZOrder(cell)] = cell.getText();
                nextTurn();
            }
        }
    }

    //Inner Class for the cells that comprise the TopPanel
    public class GameCell extends JButton {
        private boolean played = false;

        public GameCell(String name, ActionListener actionListener) {
            setName("Button" + name);
            setFont(new Font("Arial", Font.BOLD, 40));
            setText(" ");
            addActionListener(actionListener);
        }

        public boolean isPlayed() {
            return played;
        }

        public void switchPlayed() {
            played = true;
        }

        public void resetPlayed() {
            played = false;
        }
    }

    //Inner class for BottomPanel
    public class BottomPanel extends JPanel implements ActionListener {
        GridBagConstraints constraints = new GridBagConstraints();

        public BottomPanel() {
            setLayout(new GridBagLayout());

            constraints.fill = GridBagConstraints.BOTH;
            constraints.ipadx = 50;
            add(new StatusLabel(), constraints);
            add(new ResetButton(this), constraints);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            resetBoard();
        }
    }

    //Inner class for game status label
    public class StatusLabel extends JLabel {
        String labelText;
        public StatusLabel() {
            setFont(new Font("Arial", Font.PLAIN,20));
            setName("LabelStatus");
            decideStatus(Status.START);
            setText(labelText);
            statusLabel = this;
        }

        public enum Status {
            START, PROGRESS, XWINS, OWINS, DRAW
        }

        public void decideStatus(Status status) {
            switch (status) {
                case START -> labelText = "Game is not started";
                case PROGRESS -> labelText = "Game in progress";
                case XWINS -> labelText = "X wins";
                case OWINS -> labelText = "O wins";
                case DRAW -> labelText = "Draw";
            }
        }

        public void setStatus() {
            setText(labelText);
        }
    }

    //Inner class for reset button
    private class ResetButton extends JButton {

        public ResetButton(ActionListener actionListener) {
            super("Reset");
            setFont(new Font("Arial", Font.BOLD,15));
            setName("ButtonReset");
            addActionListener(actionListener);
        }
    }
}