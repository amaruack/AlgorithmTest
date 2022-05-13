package com.example.baekjoon.stack;

import java.awt.color.ColorSpace;
import java.util.Stack;

public class WorkReverse {

    public static void main(String[] args) {

        WorkReverse test = new WorkReverse();
        String result = test.solution("test test <start>abcd ef<end>cceedd");
        System.out.println(result);

    }
    char TAG_START = '<';
    char TAG_END = '>';
    char SPACE = ' ';

    public String solution(String s) {
        String result = "";
        
        StringBuilder reverse = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean flag = false;

        StringBuilder subString = new StringBuilder();
        
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i] == TAG_START) {
                flag = true;
                reverse.append(subString.toString());
                subString = new StringBuilder();
                reverse.append(chars[i]);
            } else if (chars[i] == TAG_END) {
                flag = false;
                reverse.append(chars[i]);
            } else if (flag == true) {
                reverse.append(chars[i]);
            } else if (flag == false) {
                subString.append(chars[i]);
            }
        }

        if (subString.length() > 0) {
            reverse.append(subString.toString());
        }
        result = reverse.toString();
        return  result;
    }

    public String reverse(String substring) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] subChars = substring.toCharArray();
        for (int i = 0; i < subChars.length; i++) {
            if (subChars[i] != SPACE) {
                stack.push(subChars[i]);
            } else {
                int length = stack.size();
                for (int j = 0; j < length; j++) {
                    result.append(stack.pop());
                }
                result.append(SPACE);
            }
        }
        if (stack.size() > 0) {
            int length = stack.size();
            for (int j = 0; j < length; j++) {
                result.append(stack.pop());
            }
        }
        return result.toString();
    }
    
    
    



}
