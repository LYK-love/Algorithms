package Solutions;

import Utils.ListUtils;
import Structures.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution95Test {

    Solution95 s = new Solution95();
    @Test
    void generateTrees() {
        int n1 = 3;
        List<List<Integer>> res1 = Arrays.asList(
                Arrays.asList(1,null,2,null,3),
                Arrays.asList(1,null,3,2,null),
                Arrays.asList(2,1,3),
                Arrays.asList(3,1,null,2,null),
                Arrays.asList(3,2,1,null,null)
        );
        String res1_str = res1.toString();

        List<TreeNode> actual1 = s.generateTrees(n1);
        String actual1_str = ListUtils.toStringAsFormat(actual1, TreeNode::toStringLikeBST); // Using method reference

        for(TreeNode BST: actual1)
        {
            System.out.println(TreeNode.toStringLikeBST(BST));
        }
        assertAll(
                () -> Assertions.assertEquals( res1_str, actual1_str )

        );
    }
}