package com.example;

import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {

        TestClass test = new TestClass();
        test.test2(null, "");

    }

    public void test(String a, String b){
        assert a != null : "a should not be null";
        assert b != null : "b should not be null";
        System.out.println(a);
        System.out.println(b);
    }

    public void test2(String a, String b){
        if (a == null || b == null) {
            throw new IllegalArgumentException("a or b is not be null");
        }
        System.out.println(a);
        System.out.println(b);
    }

}
