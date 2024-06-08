import java.util.Random;
import java.util.Scanner;

public class guess {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        while (playAgain) {
            roundsPlayed++;
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 10;
            boolean roundWon = false;

            System.out.println("Round " + roundsPlayed + ": Guess the number between 1 and 100.");
            
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundWon = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
                
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!roundWon) {
                System.out.println("You've run out of attempts. The correct number was " + numberToGuess);
            }

            System.out.println("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You played " + roundsPlayed + " rounds and won " + roundsWon + " rounds.");
        scanner.close();
    }
}
