import java.util.Stack;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * <p>
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class ImplementQueueUsingStacks {
}

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    /**
     * 栈是先近后出的一种数据结果
     * 队列是先进先出的一种数据结果
     */

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * 从in栈把数据倒到out栈
     * 触发的时机很重要
     * 1：只要out是空的时候，才能进行倒数据，否则顺序会乱
     * 2：必须一次把in的所有数据倒完
     */
    public void inToOut() {
        if (out.empty()) {
            while (!in.empty()) {
                //in从队列的开头返回元素并删除元素，out再将元素加入到尾部
                out.push(in.pop());
            }
        }
    }

    /**
     * void push(int x) 将元素 x 推到队列的末尾
     *
     * @param x
     */
    public void push(int x) {
        in.push(x);
        inToOut();
    }

    /**
     * int pop() 从队列的开头移除并返回元素
     *
     * @return
     */
    public int pop() {
        inToOut();
        return out.pop();
    }

    /**
     * int peek() 返回队列开头的元素
     *
     * @return
     */
    public int peek() {
        inToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
