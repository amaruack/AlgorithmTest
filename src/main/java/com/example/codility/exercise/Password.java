package com.example.codility.exercise;

public class Password {

    public static void main(String[] args) {

        Password test = new Password();
        int result = test.solution("#");
        System.out.println(result);
    }

    public final String SPLIT = " ";
    public final char LOWER_A = 'a';
    public final char LOWER_Z = 'z';
    public final char UPPER_A = 'A';
    public final char UPPER_Z = 'Z';
    public final char NUMBER_0 = '0';
    public final char NUMBER_9 = '9';

    public int solution(String S) {
        // write your code in Java SE 8
        int result = -1;

        String[] splitedAr = S.split(SPLIT);
        int maxLength = 0;
        parentLoop : for (int i = 0; i < splitedAr.length; i++) {
            String passwd = splitedAr[i];

            if (passwd.length() % 2 != 1) {
                continue;
            }
            int letterCount = 0;
            char[] passAr= passwd.toCharArray();
            for (int j = 0; j < passAr.length; j++) {
                if ( LOWER_A <= passAr[j] && passAr[j] <= LOWER_Z
                    || UPPER_A <= passAr[j] && passAr[j] <= UPPER_Z) {
                    letterCount ++;
                } else if (NUMBER_0 <= passAr[j] && passAr[j] <= NUMBER_9){

                } else {
                    continue parentLoop;
                }
            }

            if (letterCount % 2 != 0) {
                continue;
            }

            if ( maxLength < passwd.length()) {
                maxLength = passwd.length();
            }
        }

        if (maxLength != 0) {
            result = maxLength;
        }

        return result;
    }

}
