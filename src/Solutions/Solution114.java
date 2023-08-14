package Solutions;

import Structures.TreeNode;
import java.util.LinkedList;
import java.util.List;

class Solution114 {
    public void flatten(TreeNode root) {

        List<Integer> preOrder = preOrderTraversal(root);
        TreeNode flattenedRoot = convertToLinkedList( preOrder);
        deepCopy(flattenedRoot, root);
    }

    private void deepCopy(TreeNode src, TreeNode dest)
    {
        if(src == null)
            return;

        dest.val = src.val;
        dest.left = src.left;
        dest.right = src.right;
    }

    private static TreeNode __deepCopy(TreeNode oriRoot)
    {
        if(oriRoot == null)
            return null;
        TreeNode left = __deepCopy(oriRoot.left);
        TreeNode right = __deepCopy(oriRoot.right);

        return new TreeNode(oriRoot.val, left, right);
    }

    private TreeNode convertToLinkedList(List<Integer> preOrder)
    {
        if (preOrder.isEmpty())
            return null;

        int val;
        while( !preOrder.isEmpty() && preOrder.get(0) == null)//preOrder中可能有null值, 将其全部去除.
        {
            preOrder.remove(0);
//            System.out.println("NULL");
        }
        if(preOrder.isEmpty())
            return null;

        val = preOrder.get(0);
        preOrder.remove(0);

        TreeNode left = null;
        TreeNode right = convertToLinkedList(preOrder);

        TreeNode root = new TreeNode(val, left, right );
        return root;

    }
    private List<Integer> preOrderTraversal(TreeNode root)
    {
        List<Integer> res = new LinkedList<>();
        if(root == null)
        {
            res.add(null);
            return res;
        }
        else if( root.left == null && root.right == null )
        {
            res.add(root.val);
            return res;
        }
        else
        {
            res.add(root.val);
//            System.out.println(root.val + " ");
            res.addAll(preOrderTraversal(root.left));
            res.addAll(preOrderTraversal(root.right));
            return res;
        }
    }
}
