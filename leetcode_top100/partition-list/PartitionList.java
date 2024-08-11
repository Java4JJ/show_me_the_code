/**
 * https://leetcode.cn/problems/partition-list/description/
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class PartitionList {

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
        //先确定4个范围
        //left表示小于x节点的头节点和尾节点
        ListNode leftHead = null, leftTail = null;
        //right表示大于等于x节点的头结点和尾节点
        ListNode rightHead = null, rightTail = null;

        //next变量用来存储下一个节点
        ListNode next = null;

        while (head != null) {
            next = head.next;
            //断开head.next的指针
            head.next = null;
            if (head.val < x) {
                //设置小于x区域的头和尾，头只需要设置第一次
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                //设置大于x区域的头和尾，头只需要设置第一次
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            //保证循环，head往下跳一步
            head = next;
        }

        //如果没有小于x的区域，那么可以直接返回大于x的区域
        if (leftHead == null) {
            return rightHead;
        }
        //小于x区域的尾指向大于x区域的头
        leftTail.next = rightHead;
        return leftHead;
    }
}
