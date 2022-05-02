package com.example.codility.lessons1;

import java.util.Arrays;
import java.util.OptionalInt;

public class Task1 {

    public static void main(String[] args) {
        Task1 test = new Task1();
        System.out.println(test.solution(1041));
    }

    public int solution(int N) {
        // write your code in Java SE 8\
        int result = 0;

        String binaryString = Integer.toBinaryString(N);
        String substring = binaryString.substring(0, binaryString.lastIndexOf("1")+1);

        OptionalInt optionalInt = Arrays.stream(substring.split("1")).mapToInt(s -> s.length()).max();
        if (optionalInt.isPresent()){
            result = optionalInt.getAsInt();
        }

        return result;
    }

}
