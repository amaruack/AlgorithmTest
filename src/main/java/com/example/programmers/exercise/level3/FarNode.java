package com.example.programmers.exercise.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FarNode {

    public static void main(String[] args) {

        int[][] tmpe= {
            {3, 6},
         {4, 3},
        {3, 2},
        {1, 3},
        {1, 2},
        {2, 4},
        {5, 2}};
        FarNode test = new FarNode();
        test.solution(6, tmpe);
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] flag = new boolean[n];
        int[] distance = new int[n];

        List<int[]> sorted = Arrays.stream(edge).sorted(
                    Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1])
                 ).collect(Collectors.toList());

        return answer;
    }

}
