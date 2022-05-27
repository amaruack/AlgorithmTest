package com.example.test;

public class Combination {

    public static void main(String[] args) {
        
        int[] ar = new int[] {1,2,5};
        boolean[] flag = new boolean[ar.length];

        for (int i = 0; i < ar.length ; i++) {
            combination(ar, flag,0, i+1);
        }
        
    }
    
    public static void combination(int[] ar, boolean[] flag, int start, int length){
        if (length == 0) {
            print(ar, flag);
            return;
        }

        for (int i = start; i < ar.length; i++) {
            flag[i] = true;
            combination(ar, flag, i+1, length-1);
            flag[i] = false;
        }

    }

    public static void print(int[] ar, boolean[] flag){
        for (int i = 0; i < ar.length; i++) {
            if (flag[i]) {
                System.out.print(ar[i] + " ");
            }
        }
        System.out.println();
    }

}
