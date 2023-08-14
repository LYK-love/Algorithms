package Solutions;

import Structures.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution105Test {
    Solution105 s = new Solution105();
    @Test
    void buildTree() {
        int[] preorder1 = new int[]{3,9,20,15,7};
        int[] inorder1 = new int[]{9,3,15,20,7};
        TreeNode root1 = s.buildTree(preorder1,inorder1);
        String actualRes1 = TreeNode.toStringLikeBST(root1);
        String expRes1= "[3, 9, 20, 15, 7]";

        assertAll(
                ()-> Assertions.assertEquals(expRes1,actualRes1)
        );
    }
}