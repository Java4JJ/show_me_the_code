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
public class MinStackR1 {

    /**
     * 思路是用来个栈来实现，一个正常存储数据，另外一个存储最小值
     * 栈用数组来实现
     * 核心在push方法，放入最小栈时候，如果当前元素小于，则放入当前元素，如果大于则再次放入最小栈栈顶的值
     */

    int[] stack;
    int[] minStack;
    int size;

    public MinStackR1() {
        stack = new int[10000];
        minStack = new int[10000];
        size = 0;
    }

    public void push(int val) {
        stack[size] = val;
        if (size == 0 || val < minStack[size]) {
            minStack[size] = val;
        } else {
            minStack[size] = minStack[size - 1];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return stack[size - 1];
    }

    public int getMin() {
        return minStack[size - 1];
    }
}
