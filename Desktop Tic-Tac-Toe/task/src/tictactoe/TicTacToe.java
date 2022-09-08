package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    public TicTacToe() {
        super("Tic Tac Toe");
        setSize(300, 300);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(new Menu());

        Container window = getContentPane();

        JPanel mainPanel = new JPanel(new GridLayout(3, 3, 0, 0));
        window.add(mainPanel);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        topPanel.add(GameMode.getButtonPlayer1(), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        topPanel.add(Reset.getButtonStartReset(), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        topPanel.add(GameMode.getButtonPlayer2(), c);
        Reset.getButtonStartReset().setName("ButtonStartReset");
        Reset.getButtonStartReset().addActionListener(Reset.putReset);

        GameMode.getButtonPlayer1().setName("ButtonPlayer1");
        GameMode.getButtonPlayer2().setName("ButtonPlayer2");
        GameMode.getButtonPlayer1().addActionListener(GameMode.gameModeForFirstButton);
        GameMode.getButtonPlayer2().addActionListener(GameMode.gameModeForSecondButton);
        window.add(topPanel, BorderLayout.NORTH);


        JPanel downPanel = new JPanel();
        downPanel.setLayout(new BorderLayout());

        Winners.getGameStatus().setName("LabelStatus");
        Winners.getGameStatus().setText("Game is not started");
        downPanel.add(Winners.getGameStatus(), BorderLayout.WEST);
        window.add(downPanel, BorderLayout.SOUTH);


        window.add(ButtonLogic.createButtonField(), BorderLayout.CENTER);
        setVisible(true);
    }
}