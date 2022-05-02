package com.example.yanolja;

public class Test02 {

    public static void main(String[] args) {
        Test02 test = new Test02();
//        int result = test.solution(213);
        int result = test.solution(0);
        System.out.println(result);
    }

    private int MAX_NUM = 9;

    public int solution(int N) {
        // write your code in Java SE 8
        int result = 0 ;

        int quotient = N / MAX_NUM;
        int remain =  N % MAX_NUM;

        StringBuilder sb = new StringBuilder();
        // 나머지 우선 append
        sb.append(remain);
        // 몫 만큼 append
        for (int i = 0; i < quotient; i++) {
            sb.append(MAX_NUM);
        }
        result = Integer.parseInt(sb.toString());
        return result;
    }

}
