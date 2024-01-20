import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            int lowerBound = 1;
            int upperBound = 100;
            int maxAttempts = 5;
            int score = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            
            do {
                int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.println("\nGuess the number between " + lowerBound + " and " + upperBound);

                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        score++;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                }

                System.out.print("Do you want to play again? (yes/no): ");
            } while (scanner.next().equalsIgnoreCase("yes"));

            System.out.println("Your final score: " + score);
        }
        System.out.println("Thanks for playing!");
    }
}