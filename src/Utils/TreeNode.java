package Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Node.
 */
public class TreeNode {
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






}
