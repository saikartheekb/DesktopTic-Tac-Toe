package tictactoe;

import java.util.Random;

public class Robot {

    private static final String charX = "X";
    private static final String charO = "O";
    private static final Random random = new Random();

    private static void robotMove(String playChar, int x) {
        if (playChar.equals(charO)) {
            ButtonLogic.TakeElementFromButtonArray(x - 1).setText("O");
            Logic.setOElements(x);
        } else if (playChar.equals(charX)) {
            ButtonLogic.TakeElementFromButtonArray(x - 1).setText("X");
            Logic.setXElements(x);
        }
    }

    public static void RobotPlay() {
        int move = Logic.getMove();
        if (move == 1) {
            randomMove(charO, charX);
        } else if (move == 2) {
            randomMove(charX, charO);
        } else if (move == 3) {
            randomMove(charO, charX);
        } else if (move == 4) {
            randomMove(charX, charO);
        } else if (move == 5) {
            randomMove(charO, charX);
        } else if (move == 6) {
            randomMove(charX, charO);
        } else if (move == 7) {
            randomMove(charO, charX);
        } else if (move == 8) {
            randomMove(charX, charO);
        }
        Logic.movePlusOne();

    }

    public static void randomMove(String gameChar, String notGameChar) {
        int rand = random.nextInt(9) + 1;
        if (!Logic.getHashforCheck().get(notGameChar + rand) &&
                !Logic.getHashforCheck().get(gameChar + rand)) {
            robotMove(gameChar, rand);
        } else {
            randomMove(gameChar, notGameChar);
        }
    }

    public static void robotFirst() {
        if (GameMode.getGameMod().equals(Game.Robot + "-" + Game.Human) ||
                GameMode.getGameMod().equals(Game.Robot + "-" + Game.Robot)) {
            Robot.randomMove("X", "O");
            Logic.movePlusOne();
        }
    }
}