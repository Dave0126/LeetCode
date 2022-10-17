package LeetCode;

import DataStructure.TreeNode;
import LeetCode.Tree.LeetCode_TraverseTreeByLevel;

public class LeetCode_BFS_Demo {
    public static void main(String[] args) {
        TreeNode tree1 =
                new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(11,
                                        new TreeNode(7),
                                        new TreeNode(2)),
                                null),
                        new TreeNode(8,
                                new TreeNode(13),
                                new TreeNode(4,
                                        null,
                                        new TreeNode(1))));
        BFS(tree1);
    }

    public static void BFS(TreeNode root) {

    }
}
