package Solutions;

import Structures.TreeNode;
import Utils.MyTreePrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution114Test {
    Solution114 s = new Solution114();
    @Test
    void flatten() {
        int[] inorder1 = new int[]{3,2,4,1,5,6};
        int[] preorder1 = new int[]{1,2,3,4,5,6};

        TreeNode root1 = TreeNode.buildTreeByInAndPreOrder(inorder1,preorder1);
        MyTreePrinter.printTree(root1);

        s.flatten(root1);
        TreeNode flattenedRoot1 = root1;
        MyTreePrinter.printTree(flattenedRoot1);

        TreeNode root2 = null;
        s.flatten(root2);
        String actual2 = TreeNode.toStringLikeBST(root2);



        String actual1 = TreeNode.toStringLikeBST(root1);
        String exp1 = "[1, null, 2, null, 3, null, 4, null, 5, null, 6]";
        assertAll(
                ()->Assertions.assertEquals(exp1,actual1)
        );


    }
}