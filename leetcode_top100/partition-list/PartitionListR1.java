/**
 * https://leetcode.cn/problems/partition-list/description/
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class PartitionListR1 {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        //定义4个区域
        ListNode leftHead = null, leftTail = null, rightHead = null, rightTail = null;

        ListNode next = null;

        while (head != null) {
            //临时记录下next的值，因为下一步要把head.next=null设置为null
            next = head.next;
            head.next = null;
            if (head.val < x) {
                //设置小于x的头尾
                if (leftHead == null) {
                    //如果之前没有头部，才需要设置
                    leftHead = head;
                } else {
                    //从尾部上连接上当前节点
                    leftTail.next = head;
                }
                //最新的尾部
                leftTail = head;
            } else {
                if (rightHead == null) {
                    //如果之前没有头部，才需要设置
                    rightHead = head;
                } else {
                    //从尾部上连接
                    rightTail.next = head;
                }
                //最新的尾部
                rightTail = head;
            }
            //保证循环
            head = next;
        }

        //如果小于x的头部节点都不存在，那么说明都是大于x的区域，直接返回大于x区域的头部节点
        if (leftHead == null) {
            return rightHead;
        }
        //否则就拼接上
        leftTail.next = rightHead;
        return leftHead;
    }
}
