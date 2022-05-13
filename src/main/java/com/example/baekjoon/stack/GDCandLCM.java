package com.example.baekjoon.stack;

public class GDCandLCM {

    public static void main(String[] args) {

//        System.out.println(13%23);
//        System.out.println(23%13);

        GDCandLCM test = new GDCandLCM();

        System.out.println(test.gdc(15,25));
        System.out.println(test.gdc(25,15));
        System.out.println(test.lmc(25,15));

    }

    public int gdc(int a, int b){
        if ( a % b != 0 ) {
            return gdc(b , a%b);
        } else {
            return b;
        }
    }
    public int lmc(int a, int b) {
        int gdc = gdc(a,b);
        return a * b / gdc;
    }
}
