package com.example.programmers.skilltest.level1;

import java.util.Arrays;

public class Test04 {

    public int solution(int[] numbers) {
        int answer = -1;

        boolean[] flag = new boolean[10];
        for (int i = 0; i < numbers.length ; i++) {
            flag[numbers[i]] = true;
        }

        int sum = 0;
        for (int i = 0; i < flag.length; i++) {
            if(!flag[i]) {
                sum += i;
            }
        }
        answer = sum;

        return answer;
    }

}
