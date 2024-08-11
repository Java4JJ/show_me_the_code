/**
 * https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseLinkedList {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            //next用来临时存储下一个节点
            next = head.next;

            //进行一个反转操作，把head.next指向已经反转好的链表
            head.next = pre;

            //是存储已经反转好的链表的头部，所以要把当前的头部赋值给pre
            pre = head;

            //往后移动，才能保证循环
            head = next;
        }
        //返回已经反转好的链表
        return pre;
    }
}
