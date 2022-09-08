package tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {
    JMenu MenuGame = new JMenu("Game");
    JMenuItem MenuHumanHuman = new JMenuItem("Human vs Human");
    JMenuItem MenuHumanRobot = new JMenuItem("Human vs Robot");
    JMenuItem MenuRobotHuman = new JMenuItem("Robot vs Human");
    JMenuItem MenuRobotRobot = new JMenuItem("Robot vs Robot");
    JMenuItem MenuExit = new JMenuItem("Exit");

    Menu() {
        add(MenuGame);
        MenuGame.add(MenuHumanHuman);
        MenuGame.add(MenuHumanRobot);
        MenuGame.add(MenuRobotHuman);
        MenuGame.add(MenuRobotRobot);
        MenuGame.addSeparator();
        MenuGame.add(MenuExit);

        MenuHumanHuman.addActionListener(this);
        MenuHumanRobot.addActionListener(this);
        MenuRobotHuman.addActionListener(this);
        MenuRobotRobot.addActionListener(this);
        MenuExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Exit")) {
            System.exit(0);
        } else if (actionEvent.getActionCommand().equals("Human vs Human")) {
            Reset.getButtonStartReset().addActionListener(Reset.putReset);
        }
    }
}
