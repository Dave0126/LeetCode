package DataStructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static DataStructure.TreeNode.buildTreeByInOrderAndPostOrder;
import static DataStructure.TreeNode.buildTreeByInOrderAndPreOrder;
import static LeetCode.Tree.LeetCode_TraverseTree.inOrderTraverse;
import static LeetCode.Tree.LeetCode_TraverseTree.preOrderTraverse;
import static org.junit.Assert.*;

public class TreeNodeTest {

    @Test
    public void testBuildTreeByLevel() {
        String[] s = {"1","2","3","4","null","null","7"};
        TreeNode tree = TreeNode.buildTreeByLevel(s);
        List<Integer> res = new ArrayList<>();
        inOrderTraverse(tree, res);
        for (Integer i:res) {
            System.out.print(i + "\t");
        }
    }

    @Test
    public void testBuildTreeByInOrderAndPreOrder() {
        int[] inOrder = {9,3,15,20,7};
        int[] preOrder = {3,9,20,15,7};
        TreeNode tree = buildTreeByInOrderAndPreOrder(preOrder,inOrder);
        List<Integer> res = new ArrayList<>();
        inOrderTraverse(tree, res);
        for (Integer i:res) {
            System.out.print(i + "\t");
        }
    }

    @Test
    public void testBuildTreeByInOrderAndPostOrder() {
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        TreeNode tree = buildTreeByInOrderAndPostOrder(inOrder,postOrder);
        List<Integer> res = new ArrayList<>();
        inOrderTraverse(tree, res);
        for (Integer i:res) {
            System.out.print(i + "\t");
        }
    }

}