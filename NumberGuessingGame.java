import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            
            Random random = new Random();
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 7; 
            boolean guessedCorrectly = false;

            System.out.println("I have selected a number between 1 and 100. You have 7 attempts to guess it.");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempts left: " + attemptsLeft + "): ");
                
                int userGuess;
                try {
                    userGuess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();  
                    continue;
                }

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Game over! Your final score is " + score + " rounds won.");
        scanner.close();
    }
}
