package com.example.hackerrank.midium.implementation.queens;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ContainerBall {

//    public static void main(String[] args) {
//
////        2
////        2
////        1 1
////        1 1
////        2
////        0 2
////        1 1
////        999336263 998799923
////        998799923 999763019
//        List<List<Integer>> list = new LinkedList<>();
//        list.add(Arrays.asList(new Integer[]{999336263, 998799923}));
//        list.add(Arrays.asList(new Integer[]{998799923, 999763019}));
//        System.out.println(ContainerBall.organizingContainers(list));
//
//    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here

        int n = container.size();

        int dis = 0;

        List<Long> inconballList = new ArrayList<>();
        List<Long> typeballList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> con = container.get(i);
            long inconball = 0;
            for (int j = 0; j < con.size(); j++) {
                inconball += (long)con.get(j);
            }
            inconballList.add(inconball);

            int finalI = i;
            long typeball = container.stream().mapToLong(incon -> {
                return (long)incon.get(finalI);
            }).sum();
            typeballList.add(typeball);
        }

        Collections.sort(inconballList);
        Collections.sort(typeballList);

        for (int i = 0; i < inconballList.size(); i++) {
            if (inconballList.get(i).longValue() != typeballList.get(i).longValue()) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}

