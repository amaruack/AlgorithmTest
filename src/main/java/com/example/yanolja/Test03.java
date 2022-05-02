package com.example.yanolja;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test03 {

    public static void main(String[] args) {

        Test03 test = new Test03();
//        int result = test.solution(new int[]{5,3,6,1,3},2);
        int result = test.solution(new int[]{2,1,1,1,1,1,1,3},2);
        System.out.println(result);
    }

    public int solution(int[] A, int K) {
        // write your code in Java SE 8
        int result = 0;

        // min / max 큐 생성
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        // 우선 K length 이후 부터 큐에 넣음
        for (int i = K; i < A.length ; i++) {
            minQueue.offer(A[i]);
            maxQueue.offer(A[i]);
        }

        int minAm = maxQueue.peek() - minQueue.peek();

        for (int i = 0; i < A.length - K ; i++) {

            minQueue.remove(A[i+K]);
            maxQueue.remove(A[i+K]);

            minQueue.offer(A[i]);
            maxQueue.offer(A[i]);

            int tmpMinAm = maxQueue.peek() - minQueue.peek();
            if (tmpMinAm < minAm) {
                minAm = tmpMinAm;
            }
        }

        result = minAm;

        return result;
    }

}
