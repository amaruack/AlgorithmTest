package com.example.line;

import java.util.HashSet;

public class Test04 {
    public static void main(String[] args) {
//        Test04 test = new Test04();

        HashSet<Integer> test = new HashSet<>();

        Integer tmp1 = 24;
        Integer tmp2 = 24;
        Integer tmp3 = 24;
        Integer tmp4 = 24;
        test.add(tmp1);
        test.add(tmp2);
        test.add(tmp3);
        test.add(tmp4);
        test.add(25);
        test.add(25);
        test.add(25);
        System.out.println();
    }
}
