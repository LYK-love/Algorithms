package Structures;

import Utils.ListUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Node. It's public api is the same as which in Leetcode.
 *
 */
public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){this.val = val;}
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    /**
     * Use BFS to traverse the binary tree.
     *
     * If both two subtrees are null, stop BFS the subtrees.
     * If only one subtree is null, then keep BFS. The null node is "null", and will be added to the result list.
     * @param root
     * @return
     */
    public static List<TreeNode> BFS(TreeNode root)
    {
        List<TreeNode> res = new LinkedList<>();
        res.add(root);
        if( root != null && (!(root.left == null && root.right == null)) )
        {
            res.addAll(BFS(root.left));

            res.addAll(BFS(root.right));
        }
        return res;
    }


    public static String toStringLikeBST(TreeNode root)
    {
        List<TreeNode> allNodes = BFS(root);
        return ListUtils.toStringAsFormat(allNodes,TreeNode::toString);
    }

    public static TreeNode buildTreeByInAndPreOrder(int[] inorder, int[] preorder)
    {
        HashMap<Integer,Integer> map = new HashMap<>();//根据节点的值找到节点的下标
        for(int i=0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return __buildTreeByInAndPreOrder(preorder,0,preorder.length,inorder,0,inorder.length, map);
    }

    private static TreeNode __buildTreeByInAndPreOrder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map)
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
        root.left = __buildTreeByInAndPreOrder(preorder,preStart+1, preStart+leftSize+1, inorder, inStart, inStart+leftSize, map );
        root.right = __buildTreeByInAndPreOrder(preorder,preStart+leftSize+1, preEnd, inorder, inStart+leftSize+1, inEnd, map );
        return root;
    }

    public static TreeNode buildTreeByInAndPostOrder(int[] inorder, int[] postorder)
    {
        HashMap<Integer,Integer> map = new HashMap<>();//根据节点的值找到节点的下标
        for(int i=0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return __buildTreeByInAndPostOrder(postorder,0,postorder.length,inorder,0,inorder.length, map);
    }

    private static TreeNode __buildTreeByInAndPostOrder(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map)
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
        root.left = __buildTreeByInAndPostOrder(postorder,postStart, postStart+leftSize, inorder, inStart, inStart+leftSize, map );
        root.right = __buildTreeByInAndPostOrder(postorder,postStart+leftSize, postEnd-1, inorder, inStart+leftSize+1, inEnd, map );
        return root;
    }






}
