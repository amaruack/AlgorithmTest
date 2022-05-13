package com.example.codility;

public class Factor {
    public static void main(String[] args) {

        Factor test = new Factor();
//        int result = test.solution(24);
//        int result = test.solution(24);
//        int result = test.solution(27);
//        int result = test.solution(17);
        int result = test.solution(1);
        System.out.println(result);

    }
    public int solution(int N) {
        // write your code in Java SE 8
        int result = 0;
        // 공약수 구하기
        int count = 0;
        int lenth = (int)Math.sqrt(N);
        for (int i = 1; i <= lenth ; i++) {
            if (N % i == 0) {
                count++;
                if (N/i != i) {
                    count++;
                }
            }
        }
        result = count;

        return result;
    }
}
