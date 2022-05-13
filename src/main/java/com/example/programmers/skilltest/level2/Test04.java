package com.example.programmers.skilltest.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test04 {

    public static void main(String[] args) {
        Test04 test = new Test04();
        System.out.println(test.solution("1 2 3 4"));
        System.out.println(test.solution("-1 -2 -3 -4"));
    }

    public String solution(String s) {
        String answer = "";

        int max = Arrays.stream(s.split(" ")).mapToInt(str -> Integer.parseInt(str)).max().getAsInt();
        int min = Arrays.stream(s.split(" ")).mapToInt(str -> Integer.parseInt(str)).min().getAsInt();

        List<String> resultList = new ArrayList<>();
        resultList.add(String.valueOf(min));
        resultList.add(String.valueOf(max));

        answer = String.join(" ", resultList);

        return answer;
    }
}
