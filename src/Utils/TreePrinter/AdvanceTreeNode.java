package Utils.TreePrinter;

import Structures.TreeNode;

/**
 * Binary Tree Node for personal use.
 */
public class AdvanceTreeNode {
    private int value;
    private AdvanceTreeNode left;
    private AdvanceTreeNode right;

    public AdvanceTreeNode(int value) {
        this.value = value;
    }

    public AdvanceTreeNode(int value, AdvanceTreeNode left, AdvanceTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

//    public AdvanceTreeNode(TreeNode node) {
//
//    }

    public static AdvanceTreeNode copyFromSimple(TreeNode oriRoot)
    {
        if(oriRoot == null)
            return null;
        AdvanceTreeNode left = copyFromSimple(oriRoot.left);
        AdvanceTreeNode right = copyFromSimple(oriRoot.right);

        return new AdvanceTreeNode(oriRoot.val, left, right);
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AdvanceTreeNode getLeft() {
        return left;
    }

    public void setLeft(AdvanceTreeNode left) {
        this.left = left;
    }

    public AdvanceTreeNode getRight() {
        return right;
    }

    public void setRight(AdvanceTreeNode right) {
        this.right = right;
    }

    // convenience methods to build trees

    public static AdvanceTreeNode tree(int value, AdvanceTreeNode left, AdvanceTreeNode right) {
        return new AdvanceTreeNode(value, left, right);
    }

    public static AdvanceTreeNode treeLeft(int value, AdvanceTreeNode left) {
        return new AdvanceTreeNode(value, left, null);
    }

    public static AdvanceTreeNode treeRight(int value, AdvanceTreeNode right) {
        return new AdvanceTreeNode(value, null, right);
    }

    public static AdvanceTreeNode leaf(int value) {
        return new AdvanceTreeNode(value, null, null);
    }
}

