import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter 1 for Rock, 2 for Paper, 3 for Scissor:");
        System.out.println("Enter 0 to Quit");

        while (true) {
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();

            if (userChoice == 0) {
                break;
            }

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("\nUser Choice: " + getChoiceString(userChoice));
            System.out.println("Computer Choice: " + getChoiceString(computerChoice));

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result + "\n");
        }

        scanner.close();
    }

    private static String getChoiceString(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissor";
            default:
                return "";
        }
    }

    private static String determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a tie!";
        }

        switch (userChoice) {
            case 1: // Rock
                return computerChoice == 2 ? "Paper covers Rock. Computer wins!" : "Rock crushes Scissor. User wins!";
            case 2: // Paper
                return computerChoice == 1 ? "Paper covers Rock. User wins!" : "Scissor cuts Paper. Computer wins!";
            case 3: // Scissor
                return computerChoice == 1 ? "Rock crushes Scissor. Computer wins!" : "Scissor cuts Paper. User wins!";
            default:
                return "";
        }
    }
}
