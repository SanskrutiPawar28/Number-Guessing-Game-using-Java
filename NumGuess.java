import java.util.Random;
import java.util.Scanner;

public class NumGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int numberToGuess = random.nextInt(100) + 1;
        int userGuess = 0;
        int numberOfTries = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numberOfTries++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low. " + getHint(numberToGuess, userGuess));
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high. " + getHint(numberToGuess, userGuess));
            } else {
                System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
            }
        }

        scanner.close();
    }

    private static String getHint(int numberToGuess, int userGuess) {
        int difference = Math.abs(numberToGuess - userGuess);
        StringBuilder hint = new StringBuilder();

        if (difference >= 20) {
            hint.append("You are far from the number. ");
        } else if (difference >= 10) {
            hint.append("You are close. ");
        } else {
            hint.append("You are very close! ");
        }

        if (numberToGuess % 2 == 0) {
            hint.append("The number is even. ");
        } else {
            hint.append("The number is odd. ");
        }

        if (numberToGuess % 3 == 0) {
            hint.append("The number is divisible by 3. ");
        }

        if (numberToGuess % 5 == 0) {
            hint.append("The number is divisible by 5. ");
        }

        return hint.toString();
    }
}

