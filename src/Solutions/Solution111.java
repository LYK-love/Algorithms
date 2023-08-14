package Solutions;

import Structures.TreeNode;

class Solution111 {
    public int minDepth(TreeNode root) {
        if(root != null)
            return BFS(root) + 1;
        else
            return 0;
    }
    private int BFS(TreeNode root)
    {
        if(root == null || (root.left == null && root.right == null) )
            return 0;

        int leftDepth = BFS(root.left);
        int rightDepth = BFS(root.right);
        int minDepth;

        if(root.left == null)
            minDepth = rightDepth + 1;
        else if(root.right == null)
            minDepth = leftDepth + 1;
        else
            minDepth = Math.min(leftDepth, rightDepth)+1;
        return minDepth;
    }
}