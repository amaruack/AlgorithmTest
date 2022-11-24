package com.example.programmers.kakao2022;

import java.util.Arrays;

public class Solution01 {
    public int solution(int n, int k) {
        int answer = -1;

        String parseNumber = Integer.toString(n, k);
        String[] numberAr = parseNumber.split("0");

        long count =Arrays.stream(numberAr)
                .filter(ar -> !ar.equals(""))
                .filter(ar -> !ar.equals("1"))
                .filter(ar -> {
                    double splitNumber = Double.parseDouble(ar);
                    long length = (long)Math.sqrt(splitNumber);
                    for (long i = 2; i < length; i++) {
                        if (splitNumber % i == 0) {
                            return false;
                        }
                    }
                    return true;
                })
                .count();
        answer = (int)count;
        return answer;
    }

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        System.out.println(solution01.solution(437674, 3));
        System.out.println(solution01.solution(110011, 10));
        System.out.println(solution01.solution(100001, 10));
        System.out.println(solution01.solution(4, 3));
        System.out.println(solution01.solution(100000, 10));
        System.out.println(solution01.solution(111111, 10));
        System.out.println(solution01.solution(11012, 10));



    }
}
