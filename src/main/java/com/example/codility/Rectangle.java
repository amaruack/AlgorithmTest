package com.example.codility;

import java.util.Random;

public class Rectangle {
    public static void main(String[] args) {

        Rectangle test = new Rectangle();
        System.out.println(test.solution(1));
        System.out.println(test.solution(30));
        System.out.println(test.solution(22));
        System.out.println(test.solution(17));
        System.out.println(test.solution(2));

    }

    public int solution(int N) {
        // write your code in Java SE 8
        int result = 0;

        // 최소는 중간에 가장 가까운 공약수
        int sqrt = (int)Math.sqrt(N);

        int A = 0;
        for (int i = 1; i <= sqrt ; i++) {
            if (N % i == 0) {
                if (A < i) {
                    A = i;
                }
            }
        }
        int B = N / A;
        result = 2 * ( A + B );

        return result;
    }
}
