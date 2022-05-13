package com.example.baekjoon.stack;

public class PrimeNumber {

    public static void main(String[] args) {
        PrimeNumber test = new PrimeNumber();
        System.out.println(test.solution2(10));
    }

    // 소수 인지 확인 ?
    public boolean solution(int a){
        boolean result = true;

        int sqrt = (int)Math.sqrt(a);

        if (a <= 2) {
            return true;
        }

        for (int i = 2; i < sqrt ; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return result;
    }

    // 이하 소수 찾기
    public int[] solution2(int a){
        int[] result = new int[]{};

        int[] allAr = new int[a];
        boolean[] flagAr = new boolean[a];
        // 에라토스테네스 체
        // 순차 array 만듬
        for (int i = 0; i < a; i++) {
            allAr[i] = i+1;
        }

        for (int i = 1; i+i < a ; i++) {
            if ( flagAr[i] == false ) {
                // 여기에서 소수를 구해야하는데 !?
                if (solution (allAr[i])) {
                    for (int j = 2; j * allAr[i] <= a ; j++) {
                        flagAr[(j * allAr[i])-1] = true;
                    }
                }
            }
        }

        return result;
    }

}
