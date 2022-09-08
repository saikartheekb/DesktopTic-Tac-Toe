package tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMode {


    private static JButton ButtonPlayer1 = new JButton(String.valueOf(Game.Human));
    private static JButton ButtonPlayer2 = new JButton(String.valueOf(Game.Human));

    private static String firstMod = String.valueOf(Game.Human);
    public static ActionListener gameModeForFirstButton = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ButtonPlayer1.getText().equals(String.valueOf(Game.Human))) {
                getButtonPlayer1().setText(String.valueOf(Game.Robot));
                firstMod = String.valueOf(Game.Robot);
            } else {
                getButtonPlayer1().setText(String.valueOf(Game.Human));
                firstMod = String.valueOf(Game.Human);
            }
        }
    };
    private static String secondMod = String.valueOf(Game.Human);
    public static ActionListener gameModeForSecondButton = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ButtonPlayer2.getText().equals(String.valueOf(Game.Human))) {
                getButtonPlayer2().setText(String.valueOf(Game.Robot));
                secondMod = String.valueOf(Game.Robot);
            } else {
                getButtonPlayer2().setText(String.valueOf(Game.Human));
                secondMod = String.valueOf(Game.Human);
            }
        }
    };

    public static String getGameMod() {
        return firstMod + "-" + secondMod;
    }

    public static void offModeButtons(boolean x) {
        ButtonPlayer1.setEnabled(x);
        ButtonPlayer2.setEnabled(x);
    }

    public static JButton getButtonPlayer1() {
        return ButtonPlayer1;
    }

    public static void setButtonPlayer1(JButton buttonPlayer1) {
        ButtonPlayer1 = buttonPlayer1;
    }

    public static JButton getButtonPlayer2() {
        return ButtonPlayer2;
    }

    public static void setButtonPlayer2(JButton buttonPlayer2) {
        ButtonPlayer2 = buttonPlayer2;
    }
}
