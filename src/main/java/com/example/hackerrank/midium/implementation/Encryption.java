package com.example.hackerrank.midium.implementation;

public class Encryption {

    public static void main(String[] args) {

        Encryption.encryption("haveaniceday");
    }

    public static String encryption(String s) {
        // Write your code here

        int length = s.length();

        double sqrt = Math.sqrt(length);

        int min = (int)Math.floor(sqrt);
        int max = (int)Math.ceil(sqrt);

        int row = 0;
        int column = 0;

        //table setting
        outer: for (int i = min; i <= max ; i++) {
            for (int j = i; j <= max; j++) {
                if (i*j >= length) {
                    row = i;
                    column = j;
                    break outer;
                }
            }
        }

        char[][] table = new char[row][column];
        char[] chars = s.toCharArray();

        outer: for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i * column + j >= length) {
                    break outer;
                }
                table[i][j] = chars[i * column + j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (table[j][i] != '\0') {
                    sb.append(table[j][i]);
                }
            }
            if (i != column-1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }



}
