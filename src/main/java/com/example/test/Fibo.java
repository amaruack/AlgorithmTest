package com.example.test;

public class Fibo {


    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        System.out.println(fibo.fibonacci(5));
        System.out.println(fibo.fibonacci(6));
    }

    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci( n-2);
    }

}
