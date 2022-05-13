package com.example.programmers.skilltest.level1;

import java.util.Arrays;

public class Test03 {

    public boolean solution(int x) {
        boolean answer = true;

        String strvalue = String.valueOf(x);
        int sum = Arrays.stream(strvalue.split("")).mapToInt(s -> Integer.parseInt(s)).sum();

        if ( x % sum != 0 ) {
            answer = false;
        }
        return answer;
    }

}
