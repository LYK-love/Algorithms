package Solutions;

import Structures.TreeNode;

import java.util.HashMap;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree,
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
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();//根据节点的值找到节点的下标
        for(int i=0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return buildBinaryTree(postorder,0,postorder.length,inorder,0,inorder.length, map);
    }

    private TreeNode buildBinaryTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map)
    {
        if( postStart >= postEnd )
            return null;

        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootValue = postorder[postEnd-1];

        // rootVal 在中序遍历数组中的索引
        int rootIdxForInorder = map.get(rootValue);

        //左右子树的大小
        int leftSize = rootIdxForInorder - inStart;
        int rightSize = inEnd - rootIdxForInorder - 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootValue);

        // 递归构造左右子树
        root.left = buildBinaryTree(postorder,postStart, postStart+leftSize, inorder, inStart, inStart+leftSize, map );
        root.right = buildBinaryTree(postorder,postStart+leftSize, postEnd-1, inorder, inStart+leftSize+1, inEnd, map );
        return root;
    }
}