/**
 * https://leetcode.cn/problems/design-circular-queue/
 * <p>
 * 622. 设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 */
public class MyCircularQueueR2 {

    public static void main(String[] args) {
        MyCircularQueueR2 myCircularQueueR2 = new MyCircularQueueR2(3);
        myCircularQueueR2.enQueue(1);
        myCircularQueueR2.enQueue(2);
        myCircularQueueR2.enQueue(3);
    }

    int[] stack;
    int size;
    int limit;
    int left;
    int right;

    public MyCircularQueueR2(int k) {
        stack = new int[k];
        left = right = size = 0;
        limit = k;
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真。
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        stack[right] = value;
        right = right == limit - 1 ? 0 : right + 1;
        size++;
        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真。
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        left = left == limit - 1 ? 0 : left + 1;
        size--;
        return true;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1 。
     *
     * @return
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return stack[left];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1 。
     *
     * @return
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int last = right == 0 ? limit - 1 : right - 1;
        return stack[last];
    }

    /**
     * isEmpty(): 检查循环队列是否为空。
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * isFull(): 检查循环队列是否已满。
     *
     * @return
     */
    public boolean isFull() {
        return size == limit;
    }
}
