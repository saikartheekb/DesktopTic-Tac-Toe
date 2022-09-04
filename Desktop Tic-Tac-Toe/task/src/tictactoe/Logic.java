package tictactoe;

import javax.swing.*;
import java.util.HashMap;

public class Logic {
    private static HashMap<String, Boolean> elements;
    private static int move = 0;

    public static int getMove() {
        return move;
    }

    public static void movePlusOne() {
        move++;
    }


    public static void resetLogic() {
        new Logic();
        move = 0;
    }


    public Logic() {
        elements = new HashMap<>(18);
        int size = 10;
        for (int i = 1; i < size; i++) {
            elements.put("X" + i, false);
        }
        for (int i = 1; i < size; i++) {
            elements.put("O" + i, false);
        }

    }

    public static HashMap<String, Boolean> getHashforCheck() {
        return elements;
    }

    public static void setXElements(int element) {
        elements.replace("X" + element, true);
    }

    public static void setOElements(int element) {
        elements.replace("O" + element, true);
    }


    private static void buttonToXKey(JButton butt) {
        if (!Winners.isStopGame()) {
            if (butt.getName().substring(6).equals("A1")) {
                Logic.setXElements(7);
            } else if (butt.getName().substring(6).equals("A2")) {
                Logic.setXElements(4);
            } else if (butt.getName().substring(6).equals("A3")) {
                Logic.setXElements(1);
            } else if (butt.getName().substring(6).equals("B1")) {
                Logic.setXElements(8);
            } else if (butt.getName().substring(6).equals("B2")) {
                Logic.setXElements(5);
            } else if (butt.getName().substring(6).equals("B3")) {
                Logic.setXElements(2);
            } else if (butt.getName().substring(6).equals("C1")) {
                Logic.setXElements(9);
            } else if (butt.getName().substring(6).equals("C2")) {
                Logic.setXElements(6);
            } else if (butt.getName().substring(6).equals("C3")) {
                Logic.setXElements(3);
            }
        }
    }

    private static void buttonToOKey(JButton butt) {
        if (butt.getName().substring(6).equals("A1")) {
            Logic.setOElements(7);
        } else if (butt.getName().substring(6).equals("A2")) {
            Logic.setOElements(4);
        } else if (butt.getName().substring(6).equals("A3")) {
            Logic.setOElements(1);
        } else if (butt.getName().substring(6).equals("B1")) {
            Logic.setOElements(8);
        } else if (butt.getName().substring(6).equals("B2")) {
            Logic.setOElements(5);
        } else if (butt.getName().substring(6).equals("B3")) {
            Logic.setOElements(2);
        } else if (butt.getName().substring(6).equals("C1")) {
            Logic.setOElements(9);
        } else if (butt.getName().substring(6).equals("C2")) {
            Logic.setOElements(6);
        } else if (butt.getName().substring(6).equals("C3")) {
            Logic.setOElements(3);
        }
    }


    public static void chanceGameMode(JButton butt) {
        if (GameMode.getGameMod().equals(Game.Human + "-" + Game.Human)) {
            playHumanHuman(butt);
        } else if ((GameMode.getGameMod().equals(Game.Human + "-" + Game.Robot))) {
            playHumanRobot(butt);
        } else if ((GameMode.getGameMod().equals(Game.Robot + "-" + Game.Human))) {
            playRobotHuman(butt);
        }
    }

    private static void playHumanHuman(JButton butt) {
        if (!Winners.isStopGame() && butt.getText().equals(" ")) {
            if (move % 2 != 0) {
                butt.setText("O");
                buttonToOKey(butt);
            } else {
                butt.setText("X");
                buttonToXKey(butt);
            }
            Winners.checkDraw(move);
            Winners.checkWinX(Logic.getHashforCheck());
            Winners.checkWinO(Logic.getHashforCheck());
            move++;
        }
    }

    private static void playHumanRobot(JButton butt) {
        if (!Winners.isStopGame() && butt.getText().equals(" ")) {
            if (move % 2 == 0) {
                butt.setText("X");
                buttonToXKey(butt);
                move++;
                Winners.checkDrawWithRobot(move);
                Winners.checkWinX(Logic.getHashforCheck());
                Winners.checkWinO(Logic.getHashforCheck());
                if (!Winners.isStopGame()) {
                    Robot.RobotPlay();
                    Winners.checkDrawWithRobot(move);
                    Winners.checkWinX(Logic.getHashforCheck());
                    Winners.checkWinO(Logic.getHashforCheck());
                }

            }
        }
    }

    private static void playRobotHuman(JButton butt) {
        if (!Winners.isStopGame() && butt.getText().equals(" ")) {
            if (move % 2 != 0) {
                Winners.checkDrawWithRobot(move);
                Winners.checkWinX(Logic.getHashforCheck());
                Winners.checkWinO(Logic.getHashforCheck());
                if (!Winners.isStopGame()) {
                    butt.setText("O");
                    buttonToOKey(butt);
                    move++;
                    Winners.checkDraw(move);
                    Winners.checkWinX(Logic.getHashforCheck());
                    Winners.checkWinO(Logic.getHashforCheck());
                    if (!Winners.isStopGame()) {
                        Robot.RobotPlay();
                        Winners.checkDraw(move);
                        Winners.checkWinX(Logic.getHashforCheck());
                        Winners.checkWinO(Logic.getHashforCheck());

                    }
                }
            }
        }
    }

    public static void playRobotRobot() {
        if (GameMode.getGameMod().equals(Game.Robot + "-" + Game.Robot)) {
            if (!Winners.isStopGame()) {
                for (int i = 0; i < 8; i++) {
                    if (!Winners.isStopGame()) {
                        Robot.RobotPlay();
                        Winners.checkDrawWithRobot(move);
                        Winners.checkWinX(Logic.getHashforCheck());
                        Winners.checkWinO(Logic.getHashforCheck());
                    }
                }
            }
        }
    }


}