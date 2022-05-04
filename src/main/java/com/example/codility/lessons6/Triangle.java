package com.example.codility.lessons6;

import java.util.Arrays;
import java.util.Collections;

public class Triangle {

    public static void main(String[] args) {
        Triangle test = new Triangle();
        System.out.println(test.solution(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE+1, Integer.MAX_VALUE+2}));
//        System.out.println(test.solution(new int[]{10,2,5,1,8,20}));
//        System.out.println(test.solution(new int[]{10,50,5,1}));
//        System.out.println(test.solution(new int[]{-100, 2, 4, 5}));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;

        Arrays.sort(A);

        //조건 1
//        0 ≤ P < Q < R < N
        int P = 0;
        int Q = 1;
        int R = 2;

        while (true) {
            // overflow
            if (R >= A.length ) {
                break;
            }

            //조건 2
//        A[P] + A[Q] > A[R],
//        A[Q] + A[R] > A[P],
//        A[R] + A[P] > A[Q].
            if (A[R] >= A[P] + A[Q]) {
                P++;
                Q++;
                R++;
                continue;
            }

            result = 1;
            break;
        }
        return result;
    }

}
