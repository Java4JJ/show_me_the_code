/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedListsR1 {

    /**
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : null;
        }

        //通过判断两个链表的第一个元素，确定一个头节点
        ListNode head = list1.val <= list2.val ? list1 : list2;

        //找到下一次对比的两个节点
        ListNode cur1 = head.next;
        ListNode cur2 = head == list1 ? list2 : list1;

        //pre变量用来存储已经合并好的最后一个节点
        ListNode pre = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                //进行合并
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            //更新pre，因为已经完成了一次合并
            pre = pre.next;
        }
        //有可能两个链表的长度不一样，就会出现cur1==null || cur2 ==null的情况，还要把剩下的元素接上
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }


}
