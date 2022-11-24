package com.example.programmers.kakao2022;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution03 {

    public static void main(String[] args) {

        Solution03 solution03 = new Solution03();
        solution03.solution(
                new int[][]{ new int[]{5,5,5,5,5},new int[]{5,5,5,5,5},new int[]{5,5,5,5,5},new int[]{5,5,5,5,5}},
                new int[][]{ new int[]{1,0,0,3,4,4},new int[]{1,2,0,2,3,2},new int[]{2,1,0,3,1,2},new int[]{1,0,1,3,3,1}}
        );
//        	[[],[],[],[]]	10

    }

    enum SkillIndex {
        Type, StartRow, StartColumn, EndRow, EndColumn, Degree
    }

    final int ATTACK_TYPE = 1;
    final int DEFEND_TYPE = 2;

    public int solution(int[][] board, int[][] skills) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

//                Arrays.stream(skills).filter(data -> true).collect(Collectors.toList());
//                skills.
            }
        }

//        for (int i = 0; i < skills.length; i++) {
//            int[] skill = skills[i];
//            int type = skill[SkillIndex.Type.ordinal()];
//
//            for (int j = skill[SkillIndex.StartRow.ordinal()]; j <= skill[SkillIndex.EndRow.ordinal()] ; j++) {
//                for (int k = skill[SkillIndex.StartColumn.ordinal()]; k <= skill[SkillIndex.EndColumn.ordinal()] ; k++) {
//                    if ( type == ATTACK_TYPE ){
//                        board[j][k] = board[j][k] - skill[SkillIndex.Degree.ordinal()];
//                    } else {
//                        board[j][k] = board[j][k] + skill[SkillIndex.Degree.ordinal()];
//                    }
//                }
//            }
//        }

        answer = (int)Arrays.stream(board).flatMap(ints -> Arrays.stream(ints).boxed()).filter(data -> data > 0).count();

        return answer;
    }

//    public int solution(int[][] board, int[][] skills) {
//        int answer = 0;
//
//        for (int i = 0; i < skills.length; i++) {
//            int[] skill = skills[i];
//            int type = skill[SkillIndex.Type.ordinal()];
//
//            for (int j = skill[SkillIndex.StartRow.ordinal()]; j <= skill[SkillIndex.EndRow.ordinal()] ; j++) {
//                for (int k = skill[SkillIndex.StartColumn.ordinal()]; k <= skill[SkillIndex.EndColumn.ordinal()] ; k++) {
//                    if ( type == ATTACK_TYPE ){
//                        board[j][k] = board[j][k] - skill[SkillIndex.Degree.ordinal()];
//                    } else {
//                        board[j][k] = board[j][k] + skill[SkillIndex.Degree.ordinal()];
//                    }
//                }
//            }
//        }
//
//        answer = (int)Arrays.stream(board).flatMap(ints -> Arrays.stream(ints).boxed()).filter(data -> data > 0).count();
//
//        return answer;
//    }
}
