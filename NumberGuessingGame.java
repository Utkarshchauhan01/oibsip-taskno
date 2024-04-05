import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;


public class NumberGuessingGame {

    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number game");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
        System.out.println("--------------------");

        do {
            System.out.print("What action would you like to do from the above actions? ");
            int menuOption;
            try {
                menuOption = input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Invalid number entry. Please try again.");
                continue; // Restart loop for invalid input
            }

            switch (menuOption) {
                case 1:
                    playGame(input);
                    break;
                case 2:
                    displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\nThanks for playing the game!");
                    System.exit(1);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (true); // Loop continuously until user exits
    }

    public static void playGame(Scanner input) {
        System.out.print("\nWhat would you like the range of the numbers to be? ");
        int numberRange = input.nextInt();
        int randomNumber = generateRandomNumber(numberRange);
        guessNumber(randomNumber, input);
    }

    public static int generateRandomNumber(int numberRange) {
        Random random = new Random();
        return random.nextInt(numberRange) + 1;
    }

    public static void guessNumber(int randomNumber, Scanner input) {
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);

        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");
    }

    public static void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out of all tries is: " + "\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
    }
}