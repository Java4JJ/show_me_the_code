import java.util.Stack;

/**
 * 用栈实现队列
 * 思路：用两个栈，一个in栈，一个out栈
 */
class MyQueueR2 {

    Stack<Integer> in;
    Stack<Integer> out;

    int left;
    int right;

    public MyQueueR2() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void inToOut() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    /**
     * void push(int x) 将元素 x 推到队列的末尾
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
     */
    public int peek() {
        inToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
