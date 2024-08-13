/**
 * 用数组实现栈
 */
public class MyStackUsingArrays {

    int[] stack;
    int size;

    //根据题目得到最大值

    public MyStackUsingArrays(int max) {
        stack = new int[max];
        size = 0;
    }

    /**
     * void push(int x) 将元素 x 推到队列的末尾
     *
     * @param x
     */
    public void push(int x) {
        //把元素放到right的位置,然后++
        stack[size++] = x;
    }


    /**
     * int pop() 从队列的开头移除并返回元素
     *
     * @return
     */
    public int pop() {
        //弹出，则从left的位置开始，拿完后left++
        return stack[--size];
    }


    public int size() {
        return size;
    }


    /**
     * int peek() 返回队列开头的元素
     *
     * @return
     */
    public int peek() {
        return stack[size - 1];
    }

    public boolean empty() {
        return size == 0;
    }
}
