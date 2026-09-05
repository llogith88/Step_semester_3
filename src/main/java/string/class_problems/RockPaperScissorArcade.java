package string.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorArcade {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};


    static class RoundRecord {
        int roundNumber;
        String playerMove;
        String computerMove;
        String result;

        public RoundRecord(int roundNumber, String playerMove, String computerMove, String result) {
            this.roundNumber = roundNumber;
            this.playerMove = playerMove;
            this.computerMove = computerMove;
            this.result = result;
        }
    }


    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("Scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("Rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("Paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        int totalRounds = 5;
        RoundRecord[] history = new RoundRecord[totalRounds];

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Predefined demo moves for quick demo testing
        String[] demoMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        boolean isDemoMode = true; // Set to false if you want real manual keyboard input

        int wins = 0, losses = 0, draws = 0;

        System.out.println("=== Welcome to the College Coding Arcade: Rock-Paper-Scissors ===");
        System.out.println("Playing " + totalRounds + " rounds...\n");

        for (int i = 0; i < totalRounds; i++) {
            String playerMove;

            if (isDemoMode) {
                playerMove = demoMoves[i];
            } else {
                System.out.print("Round " + (i + 1) + " - Enter move (Rock, Paper, Scissors): ");
                playerMove = scanner.nextLine().trim();
            }


            String computerMove = MOVES[random.nextInt(3)];


            String result = playRound(playerMove, computerMove);


            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }


            history[i] = new RoundRecord(i + 1, playerMove, computerMove, result);


            System.out.printf("Round %d — Player: %-8s Computer: %-8s Result: %s%n",
                    (i + 1), playerMove, computerMove, result);
        }


        System.out.println("\n========================================================");
        System.out.println("                     FINAL SUMMARY                      ");
        System.out.println("========================================================");
        System.out.printf("%-8s | %-12s | %-13s | %-12s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("--------------------------------------------------------");

        for (RoundRecord record : history) {
            System.out.printf("%-8d | %-12s | %-13s | %-12s%n",
                    record.roundNumber, record.playerMove, record.computerMove, record.result);
        }

        System.out.println("--------------------------------------------------------");

        // Calculate and print metrics
        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
        System.out.println("========================================================");

        scanner.close();
    }
}