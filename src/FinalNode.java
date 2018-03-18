import java.util.Arrays;

@SuppressWarnings("ManualArrayCopy")
public class FinalNode extends Node {

    private int[] permutation;

    FinalNode(int[] table) {
        permutation = table.clone();
    }

    @Override
    void sort(int[] table) {
        int[] sortedTable = new int[table.length];

        for (int i = 0; i < table.length; i++) {
            sortedTable[i] = table[permutation[i]];
        }

        for (int i = 0; i < table.length; i++) {
            table[i] = sortedTable[i];
        }
    }

    @Override
    int size() {
        return 1;
    }

    @Override
    public String toString() {
        String array = Arrays.toString(permutation);
        return "(" + array.substring(1, array.length() - 1) + ")";
    }
}
