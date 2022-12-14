package tictactoe;

import javax.swing.*;
import java.awt.*;

public class ButtonLogic extends JFrame {

    private static final JButton[] arrayButtons = new JButton[9];
    private static final String[] buttonNames = new String[]{"A3", "B3", "C3", "A2", "B2", "C2", "A1", "B1", "C1"};

    public static void resetButton() {
        for (JButton butt :
                arrayButtons) {
            butt.setText(" ");
        }
    }

    public static JButton TakeElementFromButtonArray(int x) {
        return arrayButtons[x];
    }

    public static JPanel createButtonField() {

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        var buttonsField = new JPanel();
        buttonsField.setLayout(new GridLayout(3, 3, 0, 0));
        createButtons(buttonsField);


        gamePanel.add(buttonsField, BorderLayout.CENTER);

        return gamePanel;
    }

    public static void setEnabledButton(boolean enable) {
        for (JButton button :
                arrayButtons) {
            button.setEnabled(enable);
        }
    }

    private static void createButtons(JPanel buttonsField) {
        for (int i = 0; i < arrayButtons.length; i++) {
            JButton button = new JButton();
            button.setName("Button" + buttonNames[i]);
            /*if (GameMode.getGameMod().equals(Game.Robot+"-" + Game.Human) ||
                    GameMode.getGameMod().equals(Game.Robot+"-" + Game.Robot) ){
                Robot.randomMove("X","O");
            }*/
            button.addActionListener(actionEvent -> Logic.chanceGameMode(button));
            button.setFocusPainted(false);
            button.setFont(new Font("Arial", Font.PLAIN, 50));
            button.setText(" ");
            buttonsField.add(button);
            arrayButtons[i] = button;
            button.setEnabled(false);
        }
    }
}