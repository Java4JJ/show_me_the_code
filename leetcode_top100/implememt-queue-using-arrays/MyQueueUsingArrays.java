import java.util.NoSuchElementException;

/**
 * 用数组实现队列
 * <p>
 * 定义
 * L：表示数组的左边界
 * R：表示数组的右边界
 * L==0 && R==0 说明没数据
 * L<R 说明队列有数据
 * L==R 说明队列没数据
 * <p>
 * 加元素，比如加入10，把10放在R的位置，然后让R++
 */
public class MyQueueUsingArrays {

    int[] data;
    int left;
    int right;

    //根据题目得到最大值

    public MyQueueUsingArrays(int max) {
        data = new int[max];
        left = 0;
        right = 0;

    }

    /**
     * void push(int x) 将元素 x 推到队列的末尾
     *
     * @param x
     */
    public void push(int x) {
        //把元素放到right的位置,然后++
        data[right++] = x;
    }

    public int tail() {
        //right表示新元素防止的位置，那么right-1就是尾部
        return data[right - 1];
    }

    public int size() {
        return right - left;
    }

    /**
     * int pop() 从队列的开头移除并返回元素
     *
     * @return
     */
    public int pop() {
        //弹出，则从left的位置开始，拿完后left++
        return data[left++];
    }

    /**
     * int peek() 返回队列开头的元素
     *
     * @return
     */
    public int peek() {
        if (empty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data[left];
    }

    public boolean empty() {
        return left == right;
    }

    public int head() {
        return data[left];
    }
}
