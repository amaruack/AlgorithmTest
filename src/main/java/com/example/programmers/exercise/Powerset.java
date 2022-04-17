package com.example.programmers.exercise;

import java.util.List;

public class Powerset {


    public static void main(String[] args) {
        String[] arr = new String[]{"a","b","c","d"};
        boolean[] state = new boolean[arr.length];

        // 부분 집합 구하고
        powerset(arr,state,0, arr.length);

        // 조건 체크 하고

        // 유일성 체크 하고



    }

    public static void powerset(String[] arr, boolean[] state, int index, int length) {

        if (index == length) {
            for (int i=0 ; i < length ; i++){
                if (state[i]) {
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
            return;
        }

         ;
        powerset(arr, state, index+1, length);

        state[index] = true;
        powerset(arr, state, index+1, length);

    }




















//    public static void powerSet(String[] arr, boolean[] state, int index, int length) {
//
//        if (index == length) {
//            for (int i = 0 ; i < arr.length ; i++) {
//                if (state[i]) {
//                    System.out.print(arr[i]);
//                }
//            }
//            System.out.println();
//            return;
//        }
//
//        //
//        state[index] = false;
//        powerSet(arr, state, index+1, length);
//
//        state[index] = true;
//        powerSet(arr, state, index+1, length);
//
//    }


}
