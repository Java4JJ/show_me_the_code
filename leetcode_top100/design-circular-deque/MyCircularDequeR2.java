/**
 * https://leetcode.cn/problems/design-circular-deque/description/
 * 641. 设计循环双端队列
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 * <p>
 * 解释
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次
 */
public class MyCircularDequeR2 {

    int[] stack;
    int left;
    int right;
    int limit;
    int size;

    public MyCircularDequeR2(int k) {
        stack = new int[k];
        right = left = size = 0;
        limit = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            left = right = 0;
            stack[0] = value;
        } else {
            left = left == 0 ? limit - 1 : left - 1;
            stack[left] = value;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            left = right = 0;
            stack[0] = value;
        } else {
            right = right == limit - 1 ? 0 : right + 1;
            stack[right] = value;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        left = left == limit - 1 ? 0 : left + 1;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        right = right == 0 ? limit - 1 : right - 1;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return stack[left];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return stack[right];
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }
}
