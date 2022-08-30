package com.example.yogiyo;

public class Test01 {
    public static void main(String[] args) {

        Test01 test = new Test01();
        System.out.println(test.solution(125));
        System.out.println(test.solution(525));
        System.out.println(test.solution(625));
        System.out.println(test.solution(725));
        System.out.println(test.solution(1111125));
        System.out.println(test.solution(1000000100));
        System.out.println(test.solution(9));
        System.out.println(test.solution(0));
        System.out.println(test.solution(1));
    }

    private final int MAX = (int)Math.pow(10, 9);

    public int solution(int N) {
        // write your code in Java SE 8
        int result = 0;
        if ( N < 1 || N > MAX) {
            throw new IllegalArgumentException("1 < N < 10^9");
        }
        int exponent = String.valueOf(N).length();

        if (exponent > 1) {
            result = (int)Math.pow(10, exponent-1);
        }
        return result;
    }
}
