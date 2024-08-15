import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 */
public class BinaryTreePreorderTraversalR1 {

    /**
     * 思路1：递归
     * 前序遍历的意思是，第一次遇到节点就打印，所以顺序是，中，左，右
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //第一次遇到就打印
        list.add(root.val);
        //左边
        traversal(root.left, list);
        //右边
        traversal(root.right, list);
    }
}
