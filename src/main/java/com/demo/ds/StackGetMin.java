package com.demo.ds;

import java.util.Stack;

/**
 * 最小栈解法：
 * 1. 辅助栈
 * 2. 优先级队列
 * 3. 差值法
 */
public class StackGetMin {
    public static void main(String[] args) {
        SubStackGetMin stack = new SubStackGetMin();
        stack.push(44);
        stack.push(23);
        stack.push(32);
        stack.push(323);
        stack.push(111);
        stack.push(34);
        stack.push(56);

        System.out.println(stack.getMin());
    }

    static class SubStackGetMin{
        public Stack<Integer> stack = new Stack<>();
        private int min;


        public void push(int data) {
            if (stack.isEmpty()) {
                min = data;
                stack.push(data);
            }
            else {
                stack.push(data - min);
                min = Math.min(data, min);
            }
        }

        /**
         * T(k) = V(k) – M(k-1)
         * M(k) = min(M(k-1), V(k))
         * if(T(k) >=0) M(k) = M(k - 1)
         * else if(T(k) <0) M(k) = V(k)
         */
        public Integer pop() {
            int top = stack.pop();
            if (top >= 0) {
                return top + min;
            }
            else {
                min = min - top;
                return min;
            }
        }

        public int getMin() {
            return min;
        }
    }

    static class StackWithGetMin{
        public static Stack<Integer> stack = new Stack<>();
        public static Stack<Integer> helper = new Stack<>();
        public void push(int data) {
            stack.push(data);
            if (helper.isEmpty()) {
                helper.push(data);
            } else if (helper.peek() >= data) {
                helper.push(data);
            }
            else {
                helper.push(helper.pop());
            }
        }
        public Integer pop() {
            if (stack.isEmpty()) {
                return null;
            }
            helper.pop();
            return stack.pop();
        }

        public Integer getMin() {
            return helper.isEmpty() ? null : helper.peek();
        }
    }
}
