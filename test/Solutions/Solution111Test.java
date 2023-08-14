package Solutions;

import Structures.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution111Test {
    Solution111 s = new Solution111();
    @Test
    void minDepth() {
        int[] inorder1 = new int[]{9,3,15,20,7};
        int[] preorder1 = new int[]{3,9,20,15,7};
        TreeNode root1 = TreeNode.buildTreeByInAndPreOrder(inorder1,preorder1);
        int actual1 = s.minDepth(root1);

        int[] inorder2 = new int[]{2,3,4,5,6};
        int[] preorder2 = new int[]{2,3,4,5,6};
        TreeNode root2 = TreeNode.buildTreeByInAndPreOrder(inorder2,preorder2);
        int actual2 = s.minDepth(root2);
        assertAll(
                ()->Assertions.assertEquals(2, actual1),
                ()->Assertions.assertEquals(5, actual2)

        );
    }
}