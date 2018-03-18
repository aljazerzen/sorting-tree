public class CompareNode extends Node {

    private int a;
    private int b;

    public Node lesserChild;
    public Node greaterChild;

    CompareNode(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    void sort(int[] table) {
        if (table[a] < table[b])
            lesserChild.sort(table);
        else
            greaterChild.sort(table);
    }

    @Override
    int size() {
        return 1 + lesserChild.size() + greaterChild.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("if %d < %d:\n", a, b));

        String []lesser = lesserChild.toString().split("\n");
        for(String part : lesser) {
            sb.append("  ").append(part).append("\n");
        }

        sb.append("else:\n");

        String []greater = greaterChild.toString().split("\n");
        for(String part : greater) {
            sb.append("  ").append(part).append("\n");
        }

        return sb.toString();
    }
}

