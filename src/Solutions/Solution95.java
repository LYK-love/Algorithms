package Solutions;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * In each node of a binary search tree (BST), all values in the left subtree are smaller and all values in the right subtree are greater.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n==0) return res;

        res = build(1,n);
        return res;
    }

    /* 构造闭区间 [lo, hi] 组成的 BST */
    List<TreeNode> build(int lo, int hi)
    {

        List<TreeNode> res = new ArrayList<>();

        if(lo > hi)
        {
            res.add(null);
            return res;
        }

        if(lo==hi)
        {
            res.add(new TreeNode(lo));
            return res;
        }

        // 1、穷举 root 节点的所有可能。
        for(int i = lo; i <= hi; i++)
        {
            int rootValue = i;

            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> lefts = build(lo, rootValue-1 );
            List<TreeNode> rights = build(rootValue+1, hi );

            // 3、给 root 节点穷举所有左右子树的组合。
            for( TreeNode leftSubTree: lefts)
                for( TreeNode rightSubTree: rights)
                {
                    TreeNode root = new TreeNode(rootValue);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    res.add(root);
                }
        }
        return res;
    }
}
