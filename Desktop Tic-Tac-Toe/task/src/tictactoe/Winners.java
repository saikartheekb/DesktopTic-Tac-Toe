package tictactoe;

import javax.swing.*;
import java.util.HashMap;

class Winners {
    private static boolean stopGame = false;
    private static final JLabel GameStatus = new JLabel();


    public static JLabel getGameStatus() {
        return GameStatus;
    }

    public static void setGameStatus(String status) {
        GameStatus.setText(status);
    }

    public static void checkWinX(HashMap<String, Boolean> elements) {
        if (elements.get("X1") && elements.get("X2") && elements.get("X3") ||
                elements.get("X4") && elements.get("X5") && elements.get("X6") ||
                elements.get("X7") && elements.get("X8") && elements.get("X9") ||
                elements.get("X1") && elements.get("X4") && elements.get("X7") ||
                elements.get("X2") && elements.get("X5") && elements.get("X8") ||
                elements.get("X3") && elements.get("X6") && elements.get("X9") ||
                elements.get("X1") && elements.get("X5") && elements.get("X9") ||
                elements.get("X3") && elements.get("X5") && elements.get("X7")) {
            stopGame = true;
            ButtonLogic.setEnabledButton(false);
            setGameStatus("X wins");
        }
    }

    public static void checkWinO(HashMap<String, Boolean> elements) {
        if (elements.get("O1") && elements.get("O2") && elements.get("O3") ||
                elements.get("O4") && elements.get("O5") && elements.get("O6") ||
                elements.get("O7") && elements.get("O8") && elements.get("O9") ||
                elements.get("O1") && elements.get("O4") && elements.get("O7") ||
                elements.get("O2") && elements.get("O5") && elements.get("O8") ||
                elements.get("O3") && elements.get("O6") && elements.get("O9") ||
                elements.get("O1") && elements.get("O5") && elements.get("O9") ||
                elements.get("O3") && elements.get("O5") && elements.get("O7")) {
            stopGame = true;
            ButtonLogic.setEnabledButton(false);
            setGameStatus("O wins");
        }
    }

    public static void resetWiners() {
        stopGame = false;
    }

    public static boolean isStopGame() {
        return stopGame;
    }

    public static void setStopGame(boolean stopGame) {
        Winners.stopGame = stopGame;
    }

    public static void checkDraw(int move) {
        if (move > 7) {
            stopGame = true;
            ButtonLogic.setEnabledButton(false);
            setGameStatus("Draw");
        }
    }

    public static void checkDrawWithRobot(int move) {
        if (move > 8) {
            stopGame = true;
            ButtonLogic.setEnabledButton(false);
            setGameStatus("Draw");
        }
    }

    public static void checkDrawWithRobotRobot(int move) {
        if (move > 9) {
            stopGame = true;
            ButtonLogic.setEnabledButton(false);
            setGameStatus("Draw");
        }
    }
}