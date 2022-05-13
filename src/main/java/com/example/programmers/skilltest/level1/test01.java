package com.example.programmers.skilltest.level1;


import java.util.LinkedList;

public class test01 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] arr) {
        int[] answer = {};
        LinkedList<Integer> list = new LinkedList<>();
        // 맨처음 숫자 1개 넣음
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (list.get(list.size()-1) != arr[i]) {
                list.add(arr[i]);
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

}
