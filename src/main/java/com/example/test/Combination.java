package com.example.test;

public class Combination {

    public static void main(String[] args) {

        int[] arr = new int[] {2,4,5};
        boolean[] flag = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            combination(arr, flag, 0, i+1);
        }
    }

    public static void combination(int[] arr, boolean[] flag, int index, int n){
        if (n == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (flag[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println("");
            return ;
        }
        for (int i = index; i < arr.length; i++) {
            flag[i] = true;
            combination(arr,flag,i+1, n-1);
            flag[i] = false;
        }
    }

}
