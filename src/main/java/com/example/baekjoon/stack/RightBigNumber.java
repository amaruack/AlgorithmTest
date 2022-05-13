package com.example.baekjoon.stack;

import java.util.Stack;

public class RightBigNumber {
    public static void main(String[] args) {

        RightBigNumber test = new RightBigNumber();
        int[] result = test.solution(new int[] {3,5,2,7,8});
        System.out.println("sdf");
    }

    public int[] solution(int[] a) {
        int[] result = new int[a.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < a.length ; i++) {

            int targetIndex = stack.peek();
            if (a[targetIndex] < a[i]) {
                result[targetIndex] = a[i];
                stack.pop();
                if (stack.size() > 0) {
                    while (true) {
                        if (stack.isEmpty()) {
                            break;
                        }
                        targetIndex = stack.peek();
                        if (a[targetIndex] < a[i]) {
                            result[targetIndex] = a[i];
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }

        if (stack.size() > 0) {
            int stackSize = stack.size();
            for (int i = 0; i < stackSize ; i++) {
                int tartgetIndex = stack.pop();
                result[tartgetIndex] = -1;
            }
        }

        return  result;
    }
}
