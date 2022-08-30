package com.example.goorm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test02 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 1의 자리 2의 자리 3의 자리 ....
//        StringBuilder sb = new StringBuilder(input);
//        String[] reverseAr = sb.reverse().toString().split("");

        int number = Integer.parseInt(input);
        int max = multiExec(number);

        if (input.length() > 1) {
            for (int i = 1; i < input.length(); i++) {
                int pow = (int)Math.pow(10, i);
                int makeValue = number % pow + 1;

                int currentValue = number - makeValue;
                int current = multiExec(currentValue);

                if (max < current) {
                    max = current;
                }
            }
        }
        System.out.println(max);
    }

    public static int multiExec(int number) {
        int multi = 1;
        String[] numbers = String.valueOf(number).split("");
        for(String nm : numbers) {
            multi = multi * Integer.parseInt(nm);
        }
        return multi;
    }

}
