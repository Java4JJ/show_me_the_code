import java.util.LinkedList;
import java.util.Queue;

class MyStackUsingQueue {
    Queue<Integer> queue;

    public MyStackUsingQueue() {
        queue = new LinkedList<>();
    }

    /**
     * 核心，
     * 1.先记录原来有几个数
     * 2.把新的数加入到尾部
     * 3.根据几个数循环的把原来的数取出来，再次加入到尾部
     *
     * @param x
     */
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}