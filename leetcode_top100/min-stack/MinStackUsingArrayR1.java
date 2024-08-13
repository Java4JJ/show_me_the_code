/**
 * https://leetcode.cn/problems/min-stack/
 * <p>
 * 155. 最小栈
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 */

/**
 * 核心思想，使用两个栈/数组结构，存储
 * 一个正常压入，另一个最小栈压入时注意，如果比元素小，则压入当前元素，如果比当前元素小则重复压入栈顶的元素
 */
public class MinStackUsingArrayR1 {


    int[] data;
    int[] min;

    int size;

    private static final int MAX = 100;

    public MinStackUsingArrayR1() {
        data = new int[MAX];
        min = new int[MAX];
        size = 0;
    }

    /**
     * 核心
     * 同步压入
     * 如果min是空 或者 当前压入值 小于等于 最小栈中的栈顶，就压入当前值
     * 否则重复压入一次最小栈中的栈顶
     */
    public void push(int val) {
        data[size] = val;
        if (size == 0) {
            min[size] = val;
        } else if (min[size - 1] < val) {
            min[size] = min[size - 1];
        } else {
            min[size] = val;
        }
        size++;
    }

    /**
     * 两个栈都弹出
     */
    public void pop() {
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min[size - 1];
    }
}
