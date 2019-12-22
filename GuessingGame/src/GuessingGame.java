
/*
 * GuessingGame.java
 *
 * TCSS 142 - Winter 2009 Assignment 5
 */

import java.util.Random;
import java.util.Scanner;

/**
 * This program generates a random number between 1 and some maximum value
 * controlled by a class constant. The program then prompts the user
 * to guess the number. When the user guesses incorrectly, the game gives the
 * user a hint about whether the correct answer is higher or lower than the
 * guess. Once the user guesses correctly, the program asks the user if they
 * would like to play again. The game repeats until the user chooses to quit.
 * When the user chooses to quit, the program displays a summary of statistics
 * including the number of games played, the total number of guesses made, the
 * average number of guesses per game, the minimum number of guesses (best
 * game), and the maximum number of guesses (worst game).
 * 
 * This implementation demonstrates the use of various types of loop structures.
 * All looping structures are represented: while loop do/while loop for loop
 * Infinite for loop with break infinite while loop with break
 * 
 * The loops have been commented to show the purpose of each.
 * 
 * It is a bit artificial to use every type of loop in this program. The only
 * reason to do so was for demonstration purposes. The program could have been
 * written with fewer type of loops. The choice of which type of loop is best to
 * use in each case is open to debate.
 * 
 * @author Alan Fowler
 * @version long, long ago
 */
public final class GuessingGame {
    
    /**
     * The game will randomly generate a number between 1 and MAX_NUMBER for the
     * player to try to guess.
     */
    public static final int MAX_NUMBER = 50;
    
    /**
     * A private constructor to inhibit instantiation.
     */
    private GuessingGame() {
        // do nothing
    }

    /**
     * main runs the game repeatedly until the user chooses to quit, then
     * displays results.
     * 
     * @param theArgs - command line arguments - ignored in this program
     */
    public static void main(final String[] theArgs) {
        final Scanner console = new Scanner(System.in);

        int countGames = 0;
        int countGuesses = 0;
        int minGuesses = Integer.MAX_VALUE; // initialize min to a big number
        int maxGuesses = 0;

        displayIntro();

        for (;;) { // Loop until the user chooses to quit.
                   // Many software engineers recommend against ever using an infinite loop
                   // with an internal break statement such as this loop.            

            // play a game
            final int guesses = playGame(console);

            // update the statistics
            minGuesses = Math.min(minGuesses, guesses);
            maxGuesses = Math.max(maxGuesses, guesses);
            countGuesses += guesses;
            countGames++;

            // check if the users wants to play again
            if (!playAgain(console)) {
                break;
            }
        }
        reportResults(countGames, countGuesses, minGuesses, maxGuesses);
    }

    /**
     * Explains the game to the user.
     */
    public static void displayIntro() {
        System.out.println("In this game you will try to guess a number");
        System.out.println("between 1 and " + MAX_NUMBER);
        
        System.out.println("\nFor each guess, a clue will be given such as ");
        System.out.println("the right answer is higher or lower than your guess.");
    }

    /**
     * Plays one round of the game.
     * 
     * @param theConsole a Scanner used to gather user input
     * @return the number of guesses taken in this round of the game
     */
    public static int playGame(final Scanner theConsole) {

        // generate a number for the user to guess
        final Random rand = new Random();
        final int numberToGuess = 1 + rand.nextInt(MAX_NUMBER);

        int guess;
        int countGuesses = 0;

        // use a do/while loop to repeatedly ask the user for guesses
        // until the user enters the correct guess
        do {
            countGuesses++;
            guess = getInt(theConsole, "\nPlease enter your guess : ");

            if (guess < numberToGuess) {
                System.out.println("higher");
            } else if (guess > numberToGuess) {
                System.out.println("lower");
            }
        }
        while (guess != numberToGuess);

        System.out.println("You got it right in " + countGuesses + " guesses");
        System.out.println();
        return countGuesses;
    }

    /**
     * Asks if the user wants to play another game.
     * 
     * @param theConsole a Scanner used to capture user input
     * @return true if the user wants to play again, false otherwise
     */
    public static boolean playAgain(final Scanner theConsole) {
        boolean response = false;

        // Use the infinite below loop to prompt the user.
        // Break out of the loop when valid input is given.
        
        // Many software engineers recommend against ever using an infinite loop
        // with an internal break statement such as this loop.
        while (true) {
            System.out.print("Do you want to play again? Y/N: ");
            final String again = theConsole.next();
            if ("Y".equalsIgnoreCase(again)) {
                response = true;
                break;
            } else if ("N".equalsIgnoreCase(again)) {
                response = false;
                break;
            } else {
                System.out.println("\nI did not understand your answer.");
            }
        }

        return response;
    }

    /**
     * Prompts for an integer until an integer is entered.
     * 
     * This method is copied from page 315 of "Building Java Programs"
     * by Reges and Stepp
     * 
     * @param theConsole a Scanner used to capture user input
     * @param thePrompt the prompt to display
     * @return the integer entered by the user
     */
    public static int getInt(final Scanner theConsole, final String thePrompt) {
        System.out.print(thePrompt); // fencepost prompt

        // use a while loop to prompt repeatedly until
        // user enters an integer
        while (!theConsole.hasNextInt()) {
            theConsole.next(); // read the garbage
            System.out.println("Not an integer; try again.");
            System.out.print(thePrompt);
        }

        return theConsole.nextInt();
    }

    /**
     * Reports number of games played, total guesses made, average number of
     * guesses per game, min and max number of guesses in any game.
     * 
     * @param theGames the number of games played
     * @param theGuesses the total number of guesses
     * @param theMin the minimum number of guesses
     * @param theMax the maximum number of guesses
     */
    public static void reportResults(final int theGames,
                                     final int theGuesses,
                                     final int theMin,
                                     final int theMax) {
        System.out.println("\nOverall results:\n");
        System.out.println("   total games played   = " + theGames);
        System.out.println("   total guesses        = " + theGuesses);
        // round the average to 2 decimal places using printf
        System.out.printf("   average guesses/game = %.2f\n",
                          (double) theGuesses / theGames);
        System.out.println("   minimum guesses      = " + theMin);
        System.out.println("   maximum guesses      = " + theMax);
    }
}
