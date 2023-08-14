package Utils;


import Structures.TreeNode;
import Utils.TreePrinter.AdvanceTreeNode;
import Utils.TreePrinter.TreePrinter;

public class MyTreePrinter {


    public static String getStringOfTree(TreeNode root)
    {
        AdvanceTreeNode rootToPrint = AdvanceTreeNode.copyFromSimple(root);

        /*
            We declare a TreePrinter object, parameterized with the type of tree object it will be printing (in this
            case TreeNode), and call the TreePrinter constructor, providing lambda functions to get the TreeNode's
            label as a String, and to get the left and right and right subtrees.
         */
        TreePrinter<AdvanceTreeNode> printer = new TreePrinter<>(n -> ""+n.getValue(), n -> n.getLeft(), n -> n.getRight());
        // set minimum horizontal spacing between node labels with setHspace
        printer.setHspace(1);

        // use diagonal branches
        printer.setSquareBranches(false);

        return printer.getAsciiRepresentation(rootToPrint);
    }

    public static void printTree(TreeNode root)
    {
        System.out.println(getStringOfTree(root));
    }


}
