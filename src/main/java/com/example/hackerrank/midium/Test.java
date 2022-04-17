package com.example.hackerrank.midium;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

//        7
//        100 100 50 40 40 20 10
//        4
//        5 25 50 120
//        Test.extraLongFactorials(25);
        List<Integer> result =Test.climbingLeaderboard(
                new ArrayList<>(Arrays.asList(100, 100, 50, 40, 40, 20, 10)) ,
                new ArrayList<>(Arrays.asList(5, 25, 50, 50, 100))
        );
        System.out.println("asdf");
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        int[] ar = new int[player.size()];

        List<Integer> distinkedRank = new ArrayList<>(new TreeSet<Integer>(ranked));
        Collections.sort(distinkedRank, Collections.reverseOrder());

        for (int i = player.size()-1; i >= 0; i--) {
            int rank = distinkedRank.size()+1;

            int start = 0;
            if (i != player.size()-1) {
                start = ar[i+1] - 1;
            }

            for (int j = start ; j < distinkedRank.size() ; j++) {
                if (distinkedRank.get(j) <= player.get(i)){
                    rank = j + 1;
                    break;
                }
            }

            ar[i] = rank;
//            playerRank.set(i,rank);
        }

        List<Integer> playerRank = Arrays.stream(ar).boxed().collect(Collectors.toList());

        return playerRank;
    }

    static int N; // 원소의 개수
    static int[] inputs;

    private static void getSubset(int cnt) {
        for (int flag = 0; flag < cnt; flag++) {
            // 0, 1, 2 ... flag 비트열 별로 원소 수만큼 각 자리 비트를 확인
            for (int i = 0; i < N; i++) {
                System.out.print((((flag & (1 << i)) != 0) ? inputs[i] : "X") + "\t");
            }
            System.out.println();
        }
    }


    public static void extraLongFactorials(int n) {
        // Write your code here

        BigInteger result = new BigInteger(String.valueOf(1));

        for (long i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(result);
    }


}

