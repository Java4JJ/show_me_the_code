import java.util.Stack;

class MyQueueR1 {
    /**
     * 栈是先近后出的一种数据结果
     * 队列是先进先出的一种数据结果
     */
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueueR1() {
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
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
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
        //先放到in中
        in.push(x);
        //在判断是否要倒数据
        inToOut();
    }

    /**
     * int pop() 从队列的开头移除并返回元素
     *
     * @return
     */
    public int pop() {
        //先看一下是否要倒数据，因为可能out已经空了，in里面还有数据
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
        return in.isEmpty() && out.isEmpty();
    }
}
