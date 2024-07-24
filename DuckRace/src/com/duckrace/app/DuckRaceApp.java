package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;

public class DuckRaceApp {
    private final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promprForReward();
        updateReward(id, reward);
        showBoard();
    }

    private Reward promprForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter [D]ebit card pr [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {
                reward = (input.equals("D")) ? Reward.DEBIT_CARD : Reward.PRIZES;
                validInput = true;
            }
        }
        System.out.println();
        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter id of the winner [1-11]: ");
            String input = scanner.nextLine().trim();      // BLOCKs for [Enter]
            if (input.matches("\\d{1,2}")) {        //can safely parseInt()
                id = Integer.parseInt(input);
                if (id >= 1 && id <= 11) {          // you have valid input
                    validInput = true;
                }
            }
        }
        System.out.println();
        return id;
    }

    private void updateReward(int id, Reward reward) {
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("\n");
        System.out.println("- - - - - - -    - -     - - -   - - - -     - - - -");
        System.out.println("W E L C O M E    T O     T H E   D U C K     R A C E");
        System.out.println("- - - - - - -    - -     - - -   - - - -     - - - -");
        System.out.println();

    }
}