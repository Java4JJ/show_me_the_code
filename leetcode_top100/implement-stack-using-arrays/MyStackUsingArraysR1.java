/**
 * 用数组实现栈
 * 栈是一种先进后出的数据结构
 * 通过size来控制位移
 */
public class MyStackUsingArraysR1 {

    int[] data;
    int size;

    public MyStackUsingArraysR1(int max) {
        size = 0;
        data = new int[max];
    }

    /**
     * void push(int x) 将元素 X 加到栈中
     */
    public void push(int x) {
        data[size++] = x;
    }


    /**
     * int pop() 从栈中移除并返回元素
     */
    public int pop() {
        return data[--size];
    }


    public int size() {
        return size;
    }


    /**
     * int peek() 返回栈顶的元素，不删除
     */
    public int peek() {
        return data[size - 1];
    }

    public boolean empty() {
        return size == 0;
    }
}
