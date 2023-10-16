import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

/** a class that is used to test array sorting algorithms by generating a number of test cases and
 * comparing them to the correctly sorted expected output
 * @author Michael Boulos
 * @version 1.0
 */
public class SortingTester {

    PrintWriter outputWriter; // PrintWriter to write to given PrintStream

    /** initializes a SortingTester and tests a given Integer sorting algorithm
     * @param resultStream stream to output results to
     * @param sorterAlgorithm Integer sorting algorithm to test
     * @param numberOfTestCases number of test cases */
    public SortingTester (PrintStream resultStream, IntegerSorter sorterAlgorithm, int numberOfTestCases) {
        outputWriter = new PrintWriter(resultStream);

        int[] sorted, correct;

        for (int i = 1; i <= numberOfTestCases; i++) {
            outputWriter.print("\tTest "+i+'\n');
            sorted = correct = generateIntegerCases(20);
            outputWriter.print("\t\toriginal >> "); printAr(sorted);
            sorted = sorterAlgorithm.sort(sorted);
            Arrays.sort(correct);
            outputWriter.print("\n\t\tsorted >> "); printAr(sorted);
            outputWriter.print("\n\t\tcorrect >> "); printAr(correct);
            outputWriter.print("\n\t\tStatus: " + ((
                    Arrays.equals(correct, sorted)) ? ("\033[32mPASS\033[0m") : ("\033[31mFAIL\033[0m"))
                    + '\n'
            );
            outputWriter.flush();
        }
        outputWriter.close();
    }

    /** generates a random array of integers of varying sizes from -2000 to 2000
     * @param arSize size of array to generate for test case
     * @return generated array test case */
    public int[] generateIntegerCases(int arSize) {
        int[] testAr = new int[arSize];
        for (int i = 0; i < arSize; i++) {
            testAr[i] = -2000 + (int)(Math.random() * 4001);
        }
        return testAr;
    }

    /** helper class to print a given integer array
     * @param ar array to print */
    private void printAr (int[] ar) {
        for (int element : ar) {
            outputWriter.print(element + ", ");
        }
    }
}
