package com.example.programmers.skilltest.level2;

import java.util.Arrays;

public class Test03 {

    public static void main(String[] args) {
        Test03 test= new Test03();
        System.out.println(test.solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(test.solution(new String[] {"12","123","1235","567","88"}));
        System.out.println(test.solution(new String[] {"123","456","789"}));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length ; i++) {
            for (int j = i+1; j < phone_book.length ; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    return answer;
                }
                break;
            }
        }

        return answer;
    }

}
