package LeetCode;

import DataStructure.TreeNode;
import DataStructure.TreeNodeFactory;

/**
 * @author Guohao
 * @version 1.0
 * @description
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *
 *
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 *
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 * @create 2023/9/6 16:19
 */
public class LeetCode_0100_SameTree {
    public static void main(String[] args) {
        TreeNodeFactory treeNodeFactory = new TreeNodeFactory();
        TreeNode p = treeNodeFactory.buildTreeByLevel(new Integer[]{1, 2, 3});
        TreeNode q = treeNodeFactory.buildTreeByLevel(new Integer[]{1, 2, 3});
        boolean result = isSameTree(p, q);
//        boolean resultSol2 = isSameTreeSol2(p, q);
//        System.out.println("(" + result + ", " + resultSol2 + ")");
    }

    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.getVal().equals(q.getVal())
                && isSameTree(p.getLeft(), q.getLeft())
                && isSameTree(p.getRight(), q.getRight());
    }

//    public static boolean isSameTreeSol2(TreeNode p, TreeNode q){
//        return p.isSameWith(q);
//    }
}
