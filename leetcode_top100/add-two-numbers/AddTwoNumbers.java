/**
 * https://leetcode.cn/problems/add-two-numbers/description/
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode9 = new ListNode(3);
        listNode1.next = listNode4;
        listNode4.next = listNode9;


        ListNode listNode2 = new ListNode(5);
        ListNode listNode4x = new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode2.next = listNode4x;
        listNode4x.next = listNode6;

        new AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * <p>
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        //cur变量用来保存处理好的最后一个节点，也是为了连接链表
        ListNode cur = null;
        //是否进位
        int carry = 0;
        for (int sum, val;
             l1 != null || l2 != null;
             l1 = l1 == null ? null : l1.next,
                     l2 = l2 == null ? null : l2.next) {
            //进行求和
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            //得到结果的值
            val = sum % 10;
            //得到是否进位
            carry = sum / 10;

            if (head == null) {
                head = new ListNode(val);
                //cur和head指向同一个地址，后续只需要操作cur
                cur = head;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        //如果最后一个还有进行，那么在加一个节点
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head;
    }
}
