package com.example.trip;

import java.util.Stack;

public class Test02 {

//    private static final char BIG_OPEN = '[';
//    private static final char BIG_CLOSE = ']';
//    private static final char MIDDLE_OPEN = '{';
//    private static final char MIDDLE_CLOSE = '}';
//    private static final char SMALL_OPEN = '(';
//    private static final char SMALL_CLOSE = ')';

    enum Bracket {
        BIG_OPEN('['), BIG_CLOSE(']'),
        MIDDLE_OPEN('{'), MIDDLE_CLOSE('}'),
        SMALL_OPEN('('), SMALL_CLOSE(')')
        ;
        private char value;
        Bracket(char value){
            this.value = value;
        }
        public char getValue() {
            return value;
        }
    }

    enum Result {
        True, False;
    }

    public static void main(String[] args) {

//        String input = "()((({}})({}[]]";
//        String input = "(()){[]}";
//        String input = "((";
        String input = "(((({}))))";
//        String input = "))";

        Result result = Result.True;

        Stack<Character> stack = new Stack<>();
        char[] inputAr = input.toCharArray();
        for (char ch : inputAr) {
            if (ch == Bracket.BIG_OPEN.getValue() || ch == Bracket.MIDDLE_OPEN.getValue() || ch == Bracket.SMALL_OPEN.getValue())  {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                   result = Result.False;
                   break;
                } else {
                    if (ch == Bracket.BIG_CLOSE.getValue()) {
                        if (stack.pop() != Bracket.BIG_OPEN.getValue()) {
                            result = Result.False;
                            break;
                        }
                    }
                    if (ch == Bracket.MIDDLE_CLOSE.getValue()) {
                        if (stack.pop() != Bracket.MIDDLE_OPEN.getValue()) {
                            result = Result.False;
                            break;
                        }
                    }
                    if (ch == Bracket.SMALL_CLOSE.getValue()) {
                        if (stack.pop() != Bracket.SMALL_OPEN.getValue()) {
                            result = Result.False;
                            break;
                        }
                    }
                }
            }
        }

        if (!stack.isEmpty()){
            result = Result.False;
        }

        System.out.println(result);


    }
}
