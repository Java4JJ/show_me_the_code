import java.util.NoSuchElementException;

/**
 * 用单链表实现队列
 */
public class MyQueueUsingLists {

    //定义一个头结点
    ListNode head;
    //尾结点
    ListNode tail;

    //当前指针
    ListNode cur;

    public MyQueueUsingLists() {
        head = null;
        tail = null;
        cur = null;
    }

    /**
     * void push(int x) 将元素 x 推到队列的末尾
     *
     * @param x
     */
    public void push(int x) {
        ListNode node = new ListNode(x);
        if (head == null) {
            head = node;
            cur = head;
        } else {
            cur.next = node;
            cur = cur.next;
        }
        tail = node;
    }

    /**
     * int pop() 从队列的开头移除并返回元素
     *
     * @return
     */
    public int pop() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        int result = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return result;
    }

    /**
     * int peek() 返回队列开头的元素
     *
     * @return
     */
    public int peek() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.val;
    }

    public boolean empty() {
        return head == null;
    }
}
