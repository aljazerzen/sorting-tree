import java.util.Arrays;

public abstract class Node {

    static Node construct(int n) {
        int table[] = new int[n];
        for (int i = 0; i < n; i++) table[i] = i;

        return construct(n, 0, -1, table, true);
    }

    private static Node construct(int n, int i, int j, int table[], boolean done) {
        j++;
        if (j >= n - i - 1) {
            i++;

            if (i == n - 1 || done)
                return new FinalNode(table);
            j = 0;
            done = true;
        }


        CompareNode node = new CompareNode(table[j], table[j + 1]);
        node.lesserChild = construct(n, i, j, table, done);

        swap(table, j, j + 1);
        node.greaterChild = construct(n, i, j, table, false);
        swap(table, j, j + 1);

        return node;
    }

    static void swap(int[] table, int i, int j) {
        int a = table[i];
        table[i] = table[j];
        table[j] = a;
    }

    abstract void sort(int table[]);

    abstract int size();

}
