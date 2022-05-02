package com.example.codility.lessons5;


/**
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class CountingDiv {

    public static void main(String[] args) {
        CountingDiv test = new CountingDiv();
//        int result = test.solution(10, 10, 20); // 0
//        int result = test.solution(10, 10, 10); // 0
//        int result = test.solution(0, 0, 11);
//        int result = test.solution(0, 1, 11);
//        int result = test.solution(11, 11, 11);
//        int result = test.solution(0, 5, 1);
//        int result = test.solution(6, 11, 2);
        int result = test.solution(11, 345, 17); //20
        System.out.println(result);
        System.out.println("sdaf");
    }
//    {0,1}, K = 11
//minimal
//        A = B in {0,1}, K = 11✘WRONG ANSWER
//    got 0 expected 1
//            1.0.004 sWRONG ANSWER, got 0 expected 1
//            2.0.008 sWRONG ANSWER, got -1 expected 0
//    A = 11, B = 345, K = 17

//    minimal
//            A = B in {0,1}, K = 11✘WRONG ANSWER
//    got 0 expected 1
//            1.0.004 sWRONG ANSWER, got 0 expected 1
//            2.0.004 sWRONG ANSWER, got -1 expected 0

    public int solution(int A, int B, int K) {
        int result = 0;

        if (A > B) {
            return result;
        }
        // write your code in Java SE 8
        int start =  A / K;
        if ( (A % K) != 0) {
            start++;
        }

        int end = B / K;
        if ( (B % K) != 0 || end != 0) {
            end++;
        }

        result = end - start;

        if (A == 0 && B == 0 ) {
            result ++;
        }

        return result;
    }

}
