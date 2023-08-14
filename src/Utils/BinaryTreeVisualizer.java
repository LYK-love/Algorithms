package Utils;

import Structures.TreeNode;

public class BinaryTreeVisualizer {
    public static void printTree(TreeNode root) {
        printTree(root, "", true);
    }
    
    private static void printTree(TreeNode node, String prefix, boolean isTail) {
        if (node == null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + "null");
            return;
        }
        
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);
        
        if (node.left != null || node.right != null) {
            printTree(node.left, prefix + (isTail ? "    " : "│   "), false);
            printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );
        
        printTree(root);
    }
}





