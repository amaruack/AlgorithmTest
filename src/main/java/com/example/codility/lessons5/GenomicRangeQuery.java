package com.example.codility.lessons5;

import java.util.OptionalInt;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 *
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 *
 * For example, consider string S = CATGCCA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 *
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 *
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 *
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P and Q is an integer within the range [0..N - 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class GenomicRangeQuery {

//    A, C, G and T have impact factors of 1, 2, 3 and 4


    public static void main(String[] args) {
        GenomicRangeQuery test = new GenomicRangeQuery();
        String S = "CAGCCTA";
        int[] P = new int[] {2,5,0};
        int[] Q = new int[] {4,5,6};
        int[] result = test.solution(S, P, Q);
        System.out.println("sdf");
    }

    private char A = 'A';
    private char C = 'C';
    private char G = 'G';
    private char T = 'T';

    private int A_INDEX = 0;
    private int C_INDEX = 1;
    private int G_INDEX = 2;
    private int T_INDEX = 3;

    private int A_IM = 1;
    private int C_IM = 2;
    private int G_IM = 3;
    private int T_IM = 4;


    public int[] solution(String S, int[] P, int[] Q) {

        int[] result = new int[P.length];

        // counting 먼저 !?!?!
        int[][] countTable = new int[4][S.length()+1];
        char[] sChars = S.toCharArray();
        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == A) {
                ++countA;
            } else if (sChars[i] == C) {
                ++countC;
            } else if (sChars[i] == G) {
                ++countG;
            } else if (sChars[i] == T) {
                ++countT;
            }
            countTable[A_INDEX][i+1] = countA;
            countTable[C_INDEX][i+1] = countC;
            countTable[G_INDEX][i+1] = countG;
            countTable[T_INDEX][i+1] = countT;
        }

        for (int i = 0; i < P.length ; i++) {

            if (P[i] == Q[i]) {

                if (sChars[P[i]] == A) {
                    result[i] = A_IM;
                } else if (sChars[P[i]] == C) {
                    result[i] = C_IM;
                } else if (sChars[P[i]] == G) {
                    result[i] = G_IM;
                } else if (sChars[P[i]] == T) {
                    result[i] = T_IM;
                }

            } else {
                if ( (countTable[A_INDEX][Q[i]+1] - countTable[A_INDEX][P[i]]) > 0) {
                    result[i] = A_IM;
                    continue;
                } else if ((countTable[C_INDEX][Q[i]+1] - countTable[C_INDEX][P[i]]) > 0) {
                    result[i] = C_IM;
                    continue;
                } else if ((countTable[G_INDEX][Q[i]+1] - countTable[G_INDEX][P[i]]) > 0) {
                    result[i] = G_IM;
                    continue;
                } else if ((countTable[T_INDEX][Q[i]+1] - countTable[T_INDEX][P[i]]) > 0) {
                    result[i] = T_IM;
                    continue;
                }
            }

        }
        // sub int ar -> sort -> 첫번째꺼 꺼냄
        return result;
    }

    public int[] solution_back(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        for (int i = 0; i < P.length ; i++) {
            String sub = S.substring(P[i], Q[i]+1);
            OptionalInt opInt = sub.chars().distinct().min();
            if (opInt.getAsInt() == A) {
                result[i] = A_IM;
                continue;
            } else if (opInt.getAsInt() == C) {
                result[i] = C_IM;
                continue;
            } else if (opInt.getAsInt() == G) {
                result[i] = G_IM;
                continue;
            } else if (opInt.getAsInt() == T) {
                result[i] = T_IM;
                continue;
            }
        }
        // sub int ar -> sort -> 첫번째꺼 꺼냄
        return result;
    }


}
