/*
 * DisplayCostsMain TCSS 342
 */

package application;

import java.util.Scanner;

import structures.Vertex;
import structures.WeightedAdjMatrixGraph;
import structures.WeightedGraph;

/**
 * A program to display path costs in a weighted directed graph.
 * 
 * @author Alan Fowler
 * @version 1.1
 */
public final class DisplayCostsMain {

    /**
     * A value the user can enter to quit the program.
     */
    private static final int QUIT_OPTION = 0;

    /**
     * The graph used in this program.
     */
    private final WeightedGraph<String> myGraph;

    /**
     * Private constructor to inhibit external instantiation.
     */
    private DisplayCostsMain() {
        myGraph = new WeightedAdjMatrixGraph<String>();
    }

    /**
     * The start point for the program.
     * 
     * @param theArgs command line arguments - ignored
     */
    public static void main(final String[] theArgs) {
        new DisplayCostsMain().start();
    }

    /**
     * Calls various methods to provide program functionality.
     */
    private void start() {
        FileIO.createGraphFromFile(myGraph);
        final Vertex<String>[] vertices = myGraph.getVertices();

        // temporarily comment in the next line to display a representation of the graph
        // System.out.println(myGraph);

// report basic statistics correctly
        System.out.println("The number of vertices in the graph : " + 0);
        System.out.println("The number of edges in the graph : " + 0);

        // find diameter
        double diameter;
// add code here to set diameter correctly or write a helper method to do it
        diameter = 0;
        System.out.println("The diameter of this graph is : " + diameter);

        // creates a Scanner for keyboard input
        final Scanner console = new Scanner(System.in);
        boolean runAgain = true;

        // displays an introduction
        displayIntro();

        while (runAgain) { // loops until the user chooses to quit

            int from = 0;
            int to = 0;

            // get the user's choice for a start city
            from =
                            promptForChoice(console, "\nChoose a city to start at " + "(1 - "
                                                     + myGraph.getNumberOfVertices()
                                                     + ") or enter " + QUIT_OPTION
                                                     + " to quit the program : ");

            // perform some processing based on the menu choice
            if (from == QUIT_OPTION) {
                runAgain = false;
            } else {
                
// edit this to show correct degree for the 'from' city
                System.out.println(vertices[from - 1] + " has degree " + 0 + ".");

                // get the user's choice for an end city
                to =
                                promptForChoice(console, "\nChoose a city to end at (1 - "
                                                         + myGraph.getNumberOfVertices()
                                                         + ") or " + QUIT_OPTION
                                                         + " to quit : ");
            }
            if (to == QUIT_OPTION) {
                runAgain = false;
            } else {
                displayPathLength(vertices[from - 1], vertices[to - 1]);
            }
        }
        System.out.println("\nThanks for trying this program. Have a nice day.");
    }

    /**
     * Displays an introduction to the program.
     */
    public void displayIntro() {
        System.out.println("\nThis program reports the length of "
                           + "the shortest path between two cities.");
        System.out.println("The program will repeat until the user chooses to quit.");
        System.out.println("\nThe cities are:");
        int city = 1;
        for (final Vertex<String> name : myGraph.getVertices()) {
            System.out.printf("%-3d%s\n", city++, name);
        }
    }

    /**
     * Prompts for a menu choice in the range 1 to QUIT_OPTION.
     * 
     * @param theConsole a Scanner used to capture user input
     * @param thePrompt a prompt to the user
     * @return the number entered by the user
     */
    private int promptForChoice(final Scanner theConsole, final String thePrompt) {
        int choice = getInt(theConsole, thePrompt);
        while (choice < 0 || choice > myGraph.getNumberOfVertices()) {
            System.out.println("Invalid selection. Please try again.");
            choice = getInt(theConsole, thePrompt);
        }
        return choice;
    }

    /**
     * Prompts for an integer until an integer is entered.
     * 
     * This method is adopted from getInt() on page 315 of
     * "Building Java Programs" by Reges and Stepp
     * 
     * @param theConsole a Scanner used to capture user input
     * @param thePrompt a prompt to the user
     * @return the integer entered by the user
     */
    private int getInt(final Scanner theConsole, final String thePrompt) {
        System.out.print(thePrompt);
        while (!theConsole.hasNextInt()) {
            theConsole.next();
            System.out.println("Enter an integer. Please try again.");
            System.out.print(thePrompt);
        }
        return theConsole.nextInt();
    }

    /**
     * Displays the length of the path from thePoint1 to thePoint2.
     * 
     * @param thePoint1 the start point for the path
     * @param thePoint2 the end point for the path
     */
    private void displayPathLength(final Vertex<String> thePoint1,
                                   final Vertex<String> thePoint2) {
        double pathLength;
// add code here to set path_length correctly
        pathLength = 0;
        System.out.printf("The distance from " + thePoint1 + " to " + thePoint2 + " is: %,.1f",
                          pathLength);
    }

}
