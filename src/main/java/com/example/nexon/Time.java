package com.example.nexon;

public class Time {

    public static void main(String[] args) {

        int n = 100;
        int tmpe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < i; k++) {
//                    for (int l = 0; l < i; l++) {
                    for (int l = i; l > ~l; l -= 1) {
                        tmpe++;
                    }
                }
            }
        }
        System.out.println(tmpe);
    }

}
