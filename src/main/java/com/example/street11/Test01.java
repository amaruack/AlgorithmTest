package com.example.street11;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        Test01 test = new Test01();
        System.out.println(test.solution(-1));
        System.out.println(test.solution(40000));
        System.out.println(test.solution(40010));
        System.out.println(test.solution(40002));
        System.out.println(test.solution(40003));
        System.out.println(test.solution(50000));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        if ( N < 1  || 50000 < N ) {
            throw new IllegalArgumentException(" 1 <= N <= 50000");
        }
        int result = N ;
        int sum = Arrays.stream(String.valueOf(N).split("")).mapToInt(s->Integer.parseInt(s)).sum();
        while (true) {
            result ++;
            if (Arrays.stream(String.valueOf(result).split("")).mapToInt(s->Integer.parseInt(s)).sum() == sum) {
                break;
            }
        }
        return result;
    }

}
