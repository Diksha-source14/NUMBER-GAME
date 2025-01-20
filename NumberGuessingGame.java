import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRounds = 0;
        int roundsWon = 0;
        
        // Game loop for multiple rounds
        while (true) {
            boolean won = playGame(scanner);
            if (won) {
                roundsWon++;
            }
            totalRounds++;
            
            System.out.print("Would you like to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        System.out.println("Game Over! You played " + totalRounds + " rounds and won " + roundsWon + " of them.");
        System.out.println("Thank you for playing!");
        scanner.close();
    }
    
    public static boolean playGame(Scanner scanner) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int attemptsLeft = 10;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");
        
        // Main game loop
        while (attemptsLeft > 0) {
            System.out.print("You have " + attemptsLeft + " attempts left. Enter your guess: ");
            int guess;
            
            // Validate user input
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // consume the invalid input
            }
            guess = scanner.nextInt();
            scanner.nextLine();  // consume the remaining newline
            
            if (guess < targetNumber) {
                System.out.println("Your guess is too low.");
            } else if (guess > targetNumber) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Congratulations! You guessed the number correctly.");
                return true; // Player won
            }
            
            attemptsLeft--;
        }
        
        System.out.println("Sorry, you've run out of attempts! The correct number was " + targetNumber + ".");
        return false; // Player lost
    }
}