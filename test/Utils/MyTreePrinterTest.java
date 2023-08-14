package Utils;

import Structures.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTreePrinterTest {


    @Test
    void printTree() {

        int[] inorder1 = new int[]{9,3,15,20,7};
        int[] preorder1 = new int[]{3,9,20,15,7};
        TreeNode root1 = TreeNode.buildTreeByInAndPreOrder(inorder1,preorder1);
        String ascii = MyTreePrinter.getStringOfTree(root1);

//        System.out.println(ascii);
        String exp1 = "  3    \n" +
                " / \\   \n" +
                "9   20 \n" +
                "   / \\ \n" +
                "  15  7\n";
        assertAll(
                ()-> Assertions.assertEquals(exp1, ascii)
        );
    }
}