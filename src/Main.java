import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int n = 5;

        // Construct the tree
        System.out.printf("Constructing decision tree with height %d.%n", n * (n - 1) / 2);
        Node node = Node.construct(n);
        System.out.println("Construction complete. Nodes: " + node.size());

        // Run a test
        int[] table = new int[n];
        for (int i = 0; i < n; i++) table[i] = (int) (Math.random() * 1000);

        node.sort(table);
        System.out.println("Sorted test set: " + Arrays.toString(table));

        // Print representation
        System.out.println("\nTree representation:");
        System.out.println(node);
    }

}
