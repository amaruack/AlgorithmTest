package com.example.hackerrank.midium.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort {


    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList(new String[]{"1", "e"}));
        list.add(Arrays.asList(new String[]{"2", "a"}));
        list.add(Arrays.asList(new String[]{"1", "b"}));
        list.add(Arrays.asList(new String[]{"3", "a"}));
        list.add(Arrays.asList(new String[]{"4", "f"}));
        list.add(Arrays.asList(new String[]{"1", "f"}));
        list.add(Arrays.asList(new String[]{"2", "a"}));
        list.add(Arrays.asList(new String[]{"1", "e"}));
        list.add(Arrays.asList(new String[]{"1", "b"}));
        list.add(Arrays.asList(new String[]{"1", "c"}));
        CountingSort.countSort(list);
    }

    static final int ORDER_INDEX = 0;
    static final int STR_INDEX = 1;
    public static void countSort(List<List<String>> arr) {
        // Write your code here

        List<StringBuilder> sorted = new ArrayList<>(arr.size());

        int half = ((arr.size()-1))/2;
        for (int i = 0; i < arr.size(); i++) {
            List<String> strAr = arr.get(i);
            int order = Integer.parseInt(strAr.get(ORDER_INDEX));
            // list init
            int size = sorted.size();
            if (size <= order+1) {
                for (int j = 0; j <= (order+1 - size); j++) {
                    sorted.add(new StringBuilder());
                }
            }
            StringBuilder inner = sorted.get(order);
            if ( half >= i) {
                inner.append("- ");
            } else {
                inner.append(strAr.get(STR_INDEX) + " ");
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sorted.size() ; i++) {
            sb.append(sorted.get(i));
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}
