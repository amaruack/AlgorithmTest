package com.example.kakaomobility;

import java.util.concurrent.LinkedBlockingQueue;

public class Test03 {

    public static void main(String[] args) {
        Test03 test = new Test03();
//        test.solution(new int[] {4,4,4});
//        System.out.println(test.solution(new int[] {7,4,-2, 4,-2,-9, 0}));
        System.out.println(test.solution(new int[] {7,-5,-5,-5,7,-1,7}));

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;

        if (A.length == 1) {
            return 1;
        }
        // odd
        LinkedBlockingQueue<Integer> oddQueue = new LinkedBlockingQueue<>(100000);
        // even
        LinkedBlockingQueue<Integer> evenQueue = new LinkedBlockingQueue<>(100000);

        int maxSlice = 0;
        for (int i = 0; i < A.length; i++) {
            // odd
            if (oodFlag(i)){
                if (oddQueue.isEmpty()){
                    oddQueue.offer(A[i]);
                } else {
                    int preOdd = oddQueue.peek();
                    if (preOdd == A[i]) {
                        oddQueue.offer(A[i]);
                    } else {
                        // 클리어 하기 전에 카운트
                        int slice = oddQueue.size() + evenQueue.size();
                        if (slice > maxSlice) {
                            maxSlice = slice;
                        }
                        // odd clear
                        oddQueue.clear();
                        // even 도 클리어
                        if (!evenQueue.isEmpty()) {
                            int preEven = evenQueue.peek();
                            evenQueue.clear();
                            evenQueue.offer(preEven);
                        } else {
                            evenQueue.clear();
                        }
                        oddQueue.offer(A[i]);
                    }
                }
            } else {
                if (evenQueue.isEmpty()){
                    evenQueue.offer(A[i]);
                } else {
                    int preEven = evenQueue.peek();
                    if (preEven == A[i]) {
                        evenQueue.offer(A[i]);
                    } else {
                        // 클리어 하기 전에 카운트
                        int slice = oddQueue.size() + evenQueue.size();
                        if (slice > maxSlice) {
                            maxSlice = slice;
                        }
                        // odd clear
                        evenQueue.clear();
                        // even 도 클리어
                        if (!oddQueue.isEmpty()) {
                            int preOdd = oddQueue.peek();
                            oddQueue.clear();
                            oddQueue.offer(preOdd);
                        } else {
                            oddQueue.clear();
                        }
                        evenQueue.offer(A[i]);
                    }
                }
            }
        }

        int slice = oddQueue.size() + evenQueue.size();
        if (slice > maxSlice) {
            maxSlice = slice;
        }

        result = maxSlice;

        return result;
    }


    public boolean oodFlag(int a){
        return a % 2 != 0 ? true : false;
    }

}
