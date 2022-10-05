package com.example.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {


    public static void main(String[] args) {
        System.out.println(Test01.solution(
                Arrays.asList(new String[]{"l", "p", "k", "m"})
                ,1
                , "m"
        ));
    }

    public static int solution(List<String> ingredients, int startIndex, String target) {
        int answer = 0;

//        right
        int right = 0;
        for (int i = startIndex; i < ingredients.size()+startIndex ; i++) {
            int index = i % ingredients.size();
            if (ingredients.get(index).equals(target)){
                break;
            }
            right ++;
        }

//        left
        int left = 0;
        for (int i = startIndex; i < ingredients.size()+startIndex ; i--) {
            int index = i % ingredients.size();
            if (i < 0){
                index = ingredients.size() + i;
            }
            if (ingredients.get(index).equals(target)){
                break;
            }
            left ++;
        }

        answer = Math.min(right, left);

        return answer;
    }

//    public static int solution(List<String> ingredients, int startIndex, String target) {
//        int answer = 0;
//
//        List<String> left = ingredients.subList(0, startIndex);
//        int leftTargetIndex = ingredients.lastIndexOf(target);
//        // 사이 값
//        int leftInterval = Math.abs(leftTargetIndex - startIndex);
//        // 역 사이 값
//        int leftReverse = ingredients.size() - leftInterval;
//
//
//        List<String> right = ingredients.subList(startIndex, ingredients.size());
//        int rightTargetIndex = right.indexOf(target);
//        // 사이 값
//        int rightInterval = Math.abs(rightTargetIndex - startIndex);
//        // 역 사이 값
//        int rightReverse = ingredients.size() - rightInterval;
//
//        answer = Math.min(Math.min(rightInterval, rightReverse), Math.min(leftInterval, leftReverse));
//
//        return answer;
//    }

//    public static int solution(List<String> ingredients, int startIndex, String target) {
//        // Write your code here
//        int answer = 0;
//        // target index
//        int targetIndex = ingredients.indexOf(target);
//        // 사이 값
//        int interval = Math.abs(targetIndex - startIndex);
//        // 역 사이 값
//        int reverse = ingredients.size() - interval;
//
//        int targetLastIndex = ingredients.lastIndexOf(target);
//        // 사이 값
//        int lastInterval = Math.abs(targetLastIndex - startIndex);
//        // 역 사이 값
//        int lastReverse = ingredients.size() - lastInterval;
//
//        ingredients.
//
//        // 더 작은거
//        answer = Math.min(Math.min(interval, reverse), Math.min(lastInterval, lastReverse));;
//
//        return answer;
//    }


}
