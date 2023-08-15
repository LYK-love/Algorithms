package Solutions;

import Structures.TreeNode;

class Solution111 {
    public int minDepth(TreeNode root) {
        if(root != null)
            return BFS(root) + 1;//Leetcode规定深度最小为1, 与标准教材(=0)不符
        else
            return 0;
    }

    /**
     * 计算以root节点为根节点的树的最小深度.
     * root节点为根节点的树的最小深度 = min(root节点的左右子树的最小深度) + 1
     * 如果root节点只有左子树或右子树, 那么不需要考虑空的那颗子树的最小深度(为0)
     * @param root
     * @return
     */
    private int BFS(TreeNode root)
    {
        if(root == null || (root.left == null && root.right == null) )
            return 0;

        int leftDepth = BFS(root.left);
        int rightDepth = BFS(root.right);
        int minDepth;

        //root节点
        if(root.left == null)
            minDepth = rightDepth + 1;
        else if(root.right == null)
            minDepth = leftDepth + 1;
        else
            minDepth = Math.min(leftDepth, rightDepth)+1;
        return minDepth;
    }
}