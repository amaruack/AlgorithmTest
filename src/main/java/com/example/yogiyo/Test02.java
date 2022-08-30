package com.example.yogiyo;

import java.util.Arrays;

public class Test02 {

    public static void main(String[] args) {
        Test02 test = new Test02();
        System.out.println(test.solution(new int[]{}));
        System.out.println(test.solution(new int[]{1,2,1}));
        System.out.println(test.solution(new int[]{2,1,4,4}));
        System.out.println(test.solution(new int[]{6,2,3,5,6,3}));
    }

    private final int MAX = 1000000000;

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0 ;
        // sort
        Arrays.sort(A);
        for (int i = 0; i < A.length ; i++) {
            result += Math.abs(A[i] - (i + 1));
            if (MAX < result) {
                result = -1;
                break;
            }
        }
        return result;
    }
}
