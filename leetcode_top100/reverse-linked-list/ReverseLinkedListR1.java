/**
 * https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseLinkedListR1 {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        //pre用来存储已经反转好的链表
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            //进行反转操作
            head.next = pre;
            //pre更新为修改后的节点
            pre = head;
            //保证循环
            head = next;
        }
        return pre;
    }
}
