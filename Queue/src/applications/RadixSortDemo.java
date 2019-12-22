package applications;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import structures.LinkedOutputRestrictedDeque;

/**
 * This program has ability to read a text file containing unsorted 
 * integers entered one per line. Then, sorted order from smallest to 
 * largest and write them back in new text file called "output.txt".
 * 
 * @author minhphan
 * @version Winter 2019
 *
 */
public final class RadixSortDemo {
    
    /** Scanner variable. */
    private static Scanner myInput;
    /** Master queue. */
    private static LinkedOutputRestrictedDeque<Integer> myQueue;
    /** TEN_DIGITS number. */
    private static final int TEN_DIGITS = 10;
    /** Length of max number. */
    private static int MAX_NUM_LEN;
    /** Scanner input from user. */
    private static Scanner keyboard;

    /**
     * Default Constructor.
     */
    private RadixSortDemo() {

    }

    /**
     * Main method.
     * @param theArgs .
     * @throws IOException throw exception.
     */
    public static void main(final String[] theArgs) {
        
        /** input file directory. */
        File fileInput;
        String filename;
        String fileDirectory;
        
        keyboard = new Scanner(System.in);
        do {
            System.out.println("Type the input filename(include extension) : ");
            filename = keyboard.nextLine();
            fileDirectory = "./" + filename;

            fileInput = new File(fileDirectory);
          //  System.out.println("Try Again.");
        } while (!fileInput.exists());
        
        
        readFile(fileInput);
        System.out.println("Done!");
        MAX_NUM_LEN = String.valueOf(getMax(myQueue)).length();
        myQueue = radixSort(myQueue);

        BufferedWriter output = null;
        try {
            final File file = new File("output.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(RadixSortDemo.radixSort(myQueue).toString());
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Read and scan the file input.
     * 
     * @param theInput file.
     */
    private static void readFile(final File theInput) {
        FileReader reader = null;
        try {
            reader = new FileReader(theInput);
        } catch (final FileNotFoundException e) {

            e.printStackTrace();
        }
        myInput = new Scanner(reader);
        myQueue = new LinkedOutputRestrictedDeque<>();
        while (myInput.hasNextInt()) {
            myQueue.enqueue(myInput.nextInt());

        }

    }

    /**
     * Get the highest number in given list.
     * @param theQueue main queue.
     * @return highest number.
     */
    public static int getMax(final LinkedOutputRestrictedDeque<Integer> theQueue) {
        final LinkedOutputRestrictedDeque<Integer> temp = new LinkedOutputRestrictedDeque<>();

        if (theQueue == null) {
            throw new NullPointerException("Queue can't be null");
        }

        if (theQueue.isEmpty()) {
            throw new IllegalArgumentException("Queue can't be empty");
        }

        int max = theQueue.dequeue();
        temp.enqueue(max);

        while (!theQueue.isEmpty()) {
            final int test = theQueue.dequeue();
            temp.enqueue(test);

            if (max < test) {
                max = test;
            }
        } 

        while (!temp.isEmpty()) {
            theQueue.enqueue(temp.dequeue());
        }

        return max;
    }

    /**
     * Radix Sort method.
     * 
     * @param theQueue unsorted queue.
     * @return sorted queue.
     */
    public static LinkedOutputRestrictedDeque<Integer> radixSort(final 
                                                                 LinkedOutputRestrictedDeque
                                                                 <Integer> theQueue) {

        /*
         * Array to hold the 10 digit queues.
         */
        @SuppressWarnings("unchecked")
        final LinkedOutputRestrictedDeque<Integer>[] digitQueue = 
                        new LinkedOutputRestrictedDeque[TEN_DIGITS];
        for (int i = 0; i < TEN_DIGITS; i++) {
            digitQueue[i] = new LinkedOutputRestrictedDeque<Integer>();
        }

        int dividend = 1; // 1 10 100 1000
        while (MAX_NUM_LEN-- > 0) {
            while (!theQueue.isEmpty()) {
                final Integer currentNumber = theQueue.dequeue(); // 3456
                Integer processNumber = currentNumber; // 3456
                processNumber = processNumber / dividend; // 3456 / 10 = 345
                processNumber = processNumber % TEN_DIGITS; // 5 (digit only)

                // 5 <-- 3456
                digitQueue[processNumber].enqueue(currentNumber);
            }

            // put all integers from small queues back to the master queue
            for (int i = 0; i < TEN_DIGITS; i++) {
                while (!digitQueue[i].isEmpty()) {
                    theQueue.enqueue((Integer) digitQueue[i].dequeue());
                }
            }

            dividend = dividend * TEN_DIGITS; // 100
        }

        return theQueue;

    }

}
