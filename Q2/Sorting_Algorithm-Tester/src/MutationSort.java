import java.util.Arrays;

public class MutationSort implements IntegerSorter {

    /** sample sorting class which mutates array based on small probability */
    @Override
    public int[] sort(int[] original) {
        int[] sorted = original.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {
            if (Math.random() <= 0.01) {
                sorted[i] = original[Math.abs(i-1)];
                sorted[Math.abs(i-1)] = original[i];
            }
        }
        return sorted;
    }
}
