package com.example.programmers.kakao2021_dev;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {

    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};

        List<Integer> winList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int matchCount = 0;
        int zeroCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount ++;
                continue;
            }
            if (winList.contains(lotto)){
                matchCount ++;
            }
        }

        answer = new int[]{getMax(matchCount, zeroCount), getMin(matchCount)};

        return answer;
    }

    public int getMax(int matchCount, int zeroCount) {
        if (matchCount == 0 && zeroCount == 0) {
            return 6;
        }
        return 7 - (matchCount + zeroCount);
    }

    public int getMin(int matchCount){
        if (matchCount == 0) {
            return 6;
        }
        return 7 - (matchCount);
    }

}