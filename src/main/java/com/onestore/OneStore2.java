package com.onestore;


public class OneStore2 {
    public static void main(String[] args) {

        long t1 = 500000000;
        long t2 = 10000000000L;
        long t3 = t1 * t2;
        System.out.println(t3);
        OneStore2 oneStore2 = new OneStore2();
        System.out.println(oneStore2.solution(new int[]{1000000000,0,1000000000,0,1000000000,0,1000000000,0,1000000000,0,1000000000,0,1000000000,0}));

    }

    public long solution(int[] goal) {
        long answer = 0;
        long left = 0;
        long sum = 0;
        for (int i = 0; i < goal.length; i++) {
            long right = goal[i];
            sum += Math.abs(left-right);
            left = right;
        }
        answer = sum;
        return answer;
    }


}
