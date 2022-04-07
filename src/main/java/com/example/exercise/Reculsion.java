package com.example.exercise;

import java.util.*;

public class Reculsion {


    public static void main(String[] args) {


        List<String> arr = new ArrayList<>(Arrays.asList(new String[]{"a","b","C"}));
        List<String> result = new ArrayList<>();

        reculsion(arr, result, arr.size(), 2);


    }

    private static void reculsion(List<String> arr, List<String> result, int n, int r) {

        if (r == 0) {

            System.out.println(result.toString());
            return;
        }

        for (int i = 0; i < n; i++) {

            result.add(arr.remove(i));
            reculsion(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }
    }

}
