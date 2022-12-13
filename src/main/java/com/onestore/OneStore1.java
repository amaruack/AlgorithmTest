package com.onestore;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class OneStore1 {
    public static void main(String[] args) {
        OneStore1 oneStore1 = new OneStore1();

        System.out.println(oneStore1.solution("execute"));
        System.out.println(oneStore1.solution("cucumber"));
        System.out.println(oneStore1.solution("bbaadb"));
        System.out.println(oneStore1.solution("wetbwteqewbtreertqrwetqbwetwqbetewtb"));

    }

    public String solution(String source) {
        String answer = "";

        StringBuilder destSb = new StringBuilder();
        LinkedList<String> sourceQueue = Arrays.asList(source.split("")).stream().collect(Collectors.toCollection(LinkedList::new));

        while (sourceQueue.size() > 0) {
            int length = sourceQueue.size();
            LinkedList<String> left = new LinkedList<>();
            LinkedList<String> right = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                String pop = sourceQueue.pop();
                if (right.contains(pop)) {
                    left.offer(pop);
                } else {
                    right.offer(pop);
                }
            }
            destSb.append(right.stream().sorted().collect(Collectors.joining()));
            sourceQueue = left;
        }
        answer = destSb.toString();

        return answer;

    }
}
