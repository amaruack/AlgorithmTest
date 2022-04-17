package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {



    public static void main(String[] args) {


        Subset.nonDivisibleSubset(3, Arrays.asList(new Integer[]{1, 7, 2, 4}));


    }


    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here

        int nonDivisibleSubsetSize = 0;

        List<List<Integer>> subsets = getSubset(s, 1 << s.size());
        for (int i = subsets.size() - 1; i > 0; i--) {
            List<Integer> subset = subsets.get(i);
            // 더 높은게 있으면 패스
            if (nonDivisibleSubsetSize < subset.size() ) {
                // 기본적으로 2 개 이상 서브셋만
                if (subset.size() >= 2) {
                    List<List<Integer>> sumSubsets = getSubsetSizeTwo(subset, 1 << subset.size());

                    boolean flag = true;
                    for (int j = 0; j < sumSubsets.size(); j++) {
                        List<Integer> sumSubset = sumSubsets.get(j);
                        int sum = sumSubset.stream().mapToInt(subi -> subi).sum();
                        if ((sum % k) == 0) {
                            flag = false;
                            break ;
                        }
                    }
                    if (flag) {
                        nonDivisibleSubsetSize = subset.size();
                    }
                }
            }
        }

        // subset, subset 만들고 size 2인것만

        return nonDivisibleSubsetSize;
    }


    private static  List<List<Integer>> getSubset(List<Integer> inputs, int cnt) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int flag = 0; flag < cnt; flag++) {
            List<Integer> subset = new ArrayList<>();
            // 0, 1, 2 ... flag 비트열 별로 원소 수만큼 각 자리 비트를 확인
            for (int i = 0; i < inputs.size(); i++) {
                if ( (flag & (1 << i)) != 0 ) {
                    subset.add(inputs.get(i));
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }

    private static  List<List<Integer>> getSubsetSizeTwo(List<Integer> inputs, int cnt) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int flag = 0; flag < cnt; flag++) {
            List<Integer> subset = new ArrayList<>();
            // 0, 1, 2 ... flag 비트열 별로 원소 수만큼 각 자리 비트를 확인
            for (int i = 0; i < inputs.size(); i++) {
                if ( (flag & (1 << i)) != 0 ) {
                    subset.add(inputs.get(i));
                }
            }
            if (subset.size() == 2){
                subsets.add(subset);
            }
        }
        return subsets;
    }

}

