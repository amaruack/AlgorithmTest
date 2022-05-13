package com.example.kakaomobility;

public class Test02 {
    public static void main(String[] args) {

        Test02 test = new Test02();
//        test.solution(new int[]{0,3,0,0,5,0,5}, new int[]{4,6});
        System.out.println(test.solution(new int[]{0,3,0,0,5,0,5}, new int[]{4,2,6,1,0}));
    }

    public int solution(int[] T, int[] A) {
        // write your code in Java SE 8
        int result = 0;
        boolean[] flag = new boolean[T.length];
        for (int i = 0; i < A.length; i++) {
            int skill = A[i];
            int skillCount = getSkillCount(T, flag, skill, 0);
            result += skillCount;
        }
        return result ;
    }

    public int getSkillCount(int[] T, boolean[] flag, int skill, int count){

        int preSkill = T[skill];
        // 배움
        if (flag[preSkill]) {
            if (preSkill == skill) {
                return count;
            }
        // 안배움
        } else {
            if (preSkill == skill) {
                flag[preSkill] = true;
                return ++count;
            }
            count = getSkillCount(T, flag, preSkill, count);
        }
        flag[skill] = true;
        return ++count;
    }


}
