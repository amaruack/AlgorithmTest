package com.example.kakao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class Test02 {
    public static void main(String[] args) {

        System.out.println(Test02.solution("1010"));

    }

    public static String solution(String s) {
        // Write your code here

        if (!s.contains("0")){
            return s;
        }

        String[] splitArray = s.split("");
        Arrays.sort(splitArray, Comparator.reverseOrder());
        List<String> list = Arrays.asList(splitArray);

        LinkedBlockingDeque deque = new LinkedBlockingDeque<>(list);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!deque.isEmpty()) {
            if (count % 2 == 0) {
                sb.append(deque.pollFirst());
            } else {
                sb.append(deque.pollLast());
            }
            count++;
        }

        sb.reverse();

        return sb.toString();
    }

}
