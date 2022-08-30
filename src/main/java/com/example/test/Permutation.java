package com.example.test;

public class Permutation {

    public static void main(String[] args) {
        int[] arr = new int[] {2,4,5};
        boolean[] flag = new boolean[arr.length];
        int[] out = new int[arr.length];

        for (int i = 0; i < arr.length ; i++) {
            permutation(arr, flag, out, 0, i+1);
        }
    }

    public static void permutation(int[] arr, boolean[] flag, int[] out, int index, int n) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(out[i]+ " ");
            }
            System.out.println(" ");
            return;
        }

        for (int i = 0; i <  arr.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                out[index] = arr[i];
                permutation(arr, flag, out, index+1, n);
                flag[i] = false;
            }
        }
    }

}
