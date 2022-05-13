package com.example.programmers.skilltest.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test02 {

    public static void main(String[] args) {
        Test02 test = new Test02();
        test.solution("1D2S#10S");
    }


    private final char SINGLE = 'S';
    private final char DOUBLE = 'D';
    private final char TRIPLE = 'T';

    private final char STAR = '*';
    private final char SHARP = '#';

    public int solution(String dartResult) {
        int answer = 0;

        char[] dartCharArray = dartResult.toCharArray();

        //우선 분리 ?
        LinkedList<Integer> game = new LinkedList<>();

        int[] lastindex = new int[3];
        int count = 0;
        for (int i = 0; i < dartCharArray.length ; i++) {
            if (dartCharArray[i] == SINGLE || dartCharArray[i] == DOUBLE || dartCharArray[i] == TRIPLE) {

                int lastIndex = i ;
                for (int j = i; j < dartCharArray.length; j++) {
                    if ( dartCharArray[j] == STAR || dartCharArray[j] == SHARP ){
                        lastIndex++;
                    }
                    if (dartCharArray[j] >= '0' && dartCharArray[j] <= '9' ){
                        break;
                    }
                }
                lastindex[count] = lastIndex;
                count++;
            }
        }

        int[] gamescore = new int[3];

//        for (int i = 0; i < gamescore.length ; i++) {
//
//            String game = "";
//            if (i != 0) {
//                game = dartResult.substring(lastindex[i-1] +1, lastindex[i]+1);
//            } else {
//                game = dartResult.substring(0, lastindex[i]+1);
//            }
//        }


        return answer;
    }

}
