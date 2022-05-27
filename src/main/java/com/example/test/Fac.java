package com.example.test;

public class Fac {

    public static void main(String[] args) {
        Fac fac = new Fac();
        System.out.println(fac.factorial(4));
    }

    public int factorial(int num){
        if (num == 1) {
            return num;
        }
        return factorial(num-1)*num;
    }

}
