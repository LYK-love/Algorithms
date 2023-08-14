package Solutions;

import Structures.TreeNode;

import java.util.HashMap;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
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
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < inorder.length; i++)
            map.put(inorder[i], i);//根据root节点的值找到在inorder[]中找到root节点的下标

        return buildBinaryTree(preorder,0,preorder.length,inorder,0,inorder.length, map);
    }

    /**
     * 前序遍历数组: preorder[preStart, ..., preEnd-1]
     * 中序遍历数组: inorder[inStart, ..., inEnd-1]
     * 根据给定的preorder和inorder, 构造二叉树, 返回其root.
     */
    private TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map)
    {
        if( preStart >= preEnd )
            return null;

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootValue = preorder[preStart];

        // rootVal 在中序遍历数组中的索引
        int rootIdxForInorder = map.get(rootValue);

        int leftSize = rootIdxForInorder - inStart;
        int rightSize = inEnd - rootIdxForInorder - 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootValue);

        // 递归构造左右子树
        root.left = buildBinaryTree(preorder,preStart+1, preStart+leftSize+1, inorder, inStart, inStart+leftSize, map );
        root.right = buildBinaryTree(preorder,preStart+leftSize+1, preEnd, inorder, inStart+leftSize+1, inEnd, map );
        return root;
    }
}
