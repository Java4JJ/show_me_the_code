/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode9 = new ListNode(9);
        listNode1.next = listNode4;
        listNode4.next = listNode9;


        ListNode listNode2 = new ListNode(2);
        ListNode listNode4x = new ListNode(4);
        ListNode listNode6 = new ListNode(6);

        listNode2.next = listNode4x;
        listNode4x.next = listNode6;
        new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode2);
    }

    /**
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        //1. 选取一个链表作为开头（通过第一个元素的大小进行判断）,另外剩下的一个链表就是用来比较的
        ListNode head = list1.val <= list2.val ? list1 : list2;
        //当前比较的元素1
        ListNode cur1 = head.next;
        //当前比较的元素2
        ListNode cur2 = head == list1 ? list2 : list1;
        //已经处理好的节点
        ListNode pre = head;

        //循环条件, 两个比较元素不等于空
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                //1、进行指针的修改
                pre.next = cur2;
                //2、为了保证循环，更新cur2的值
                cur2 = cur2.next;
            } else {
                //1、进行指针的修改
                pre.next = cur1;
                //2、为了保证循环，更新cur2的值
                cur1 = cur1.next;
            }

            //3、更新pre的值。指向最新已经处理好的最后一个节点
            pre = pre.next;

        }

        //4、最后一个元素
        pre.next = cur1 != null ? cur1 : cur2;

        return head;
    }
}
