package tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset {

    private static final JButton ButtonStartReset = new JButton("Start");

    public static JButton getButtonStartReset() {
        return ButtonStartReset;
    }

    public static void setTextButtonStartReset(String textButtonStartReset) {
        ButtonStartReset.setText(textButtonStartReset);
    }

    public static ActionListener putReset = new ActionListener() {
        private boolean startOrReset = true;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (startOrReset) {
                setTextButtonStartReset("Reset");
                Winners.setGameStatus("Game in progress");
                Logic logic = new Logic();
                ButtonLogic.setEnabledButton(true);
                startOrReset = !startOrReset;
                GameMode.offModeButtons(false);
                Robot.robotFirst();
                Logic.playRobotRobot();

            } else {
                setTextButtonStartReset("Start");
                Winners.setGameStatus("Game is not started");
                ButtonLogic.setEnabledButton(false);
                GameMode.offModeButtons(true);
                startOrReset = !startOrReset;
                ButtonLogic.resetButton();
                Logic.resetLogic();
                Winners.resetWiners();
            }

        }
    };
}