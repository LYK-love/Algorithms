package Utils.TreePrinter;


public class CompleteTree {

    static TreePrinter<AdvanceTreeNode> printer = new TreePrinter<>(n -> ("" + n.getValue()), n -> n.getLeft(), n -> n.getRight());

    public static void main(String[] args) {
        printer.setHspace(2);
        printer.setSquareBranches(true);

        AdvanceTreeNode tree;
        tree = completeLevelOrderTree(90);

        printer.printTree(tree);
        System.out.println();

        tree = completeInOrderTree(1, 90);
        printer.printTree(tree);
        System.out.println();
    }

    public static AdvanceTreeNode completeInOrderTree(int first, int last) {
        if (first > last) return null;
        if (first == last) return new AdvanceTreeNode(first);
        // size = total number of nodes in tree
        int size = last - first + 1;
        // number of nodes on next to last level (a power of 2)
        int nextToLastLevelCount = maxPowerOf2Under(size/2);
        // number of nodes on last level (which may be less than power of 2)
        int lastLevelCount = size - (nextToLastLevelCount * 2) + 1;
        // number of nodes in left subtree
        int leftSize = nextToLastLevelCount - 1 + Math.min(lastLevelCount, nextToLastLevelCount);
        int rootVal = first + leftSize;
        return new AdvanceTreeNode(rootVal, completeInOrderTree(first, rootVal-1), completeInOrderTree(rootVal+1, last));
    }

    public static AdvanceTreeNode completeLevelOrderTree(int size) {
        AdvanceTreeNode[] nodes = new AdvanceTreeNode[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new AdvanceTreeNode(i+1);
        }
        int i = 0;
        while (i*2+1 < size) {
            nodes[i].setLeft(nodes[i*2+1]);
            if (i*2+2 < size) nodes[i].setRight(nodes[i*2+2]);
            i++;
        }
        return nodes[0];
    }

    public static int maxPowerOf2Under(int limit) {
        int lzs = Integer.numberOfLeadingZeros(limit);
        return 1 << (32-lzs-1);
    }
}
