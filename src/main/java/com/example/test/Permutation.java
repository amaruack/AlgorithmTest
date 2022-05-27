package com.example.test;

public class Permutation {

    public static void main(String[] args) {
        
        int[] ar = new int[] {1,2,5};
        boolean[] flag = new boolean[ar.length];

        int[] output = new int[ar.length];
        for (int i = 0; i < ar.length ; i++) {
            permutation(ar, flag, output,0, i+1);
        }
        
    }
    
    public static void permutation(int[] ar, boolean[] flag, int[] output, int depth, int length){
        if (depth == length) {
            print(output, depth);
            return;
        }

        for (int i = 0; i < ar.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                output[depth] = ar[i];
                permutation(ar, flag, output, depth+1, length);
                flag[i] = false;
            }
        }

    }

    public static void print(int[] output, int length){
        for (int i = 0; i < length; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

}
