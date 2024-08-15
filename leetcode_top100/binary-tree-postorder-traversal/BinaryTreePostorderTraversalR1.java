import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 * 145. 二叉树的后序遍历
 * <p>
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 */
public class BinaryTreePostorderTraversalR1 {

    /**
     * 后序遍历，第三次遇到的时候打印，所以顺序是左右中
     * 思路，递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }
}
