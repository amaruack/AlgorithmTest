package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {



    public static void main(String[] args) {

        System.out.println((long) 1 << 100000);


//        Subset2.nonDivisibleSubset(3, Arrays.asList(new Integer[]{1, 7, 2, 4}));
//        Subset2.nonDivisibleSubset(1, Arrays.asList(new Integer[]{1,2,3,4,5}));


    }

    private static List<List<Integer>> subsets = new ArrayList<>();
    private static List<List<Integer>> sumSubsets = new ArrayList<>();

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here

        int nonDivisibleSubsetSize = 1;

//        getSubset(s, 1 << s.size());
        getSubset(s, (long) Math.pow(2, 100000));

        // divide 된 애들에 대한 묶음이 있으면 안됨
        List<List<Integer>> divideSubset = new ArrayList<>();
        for (int j = 0; j < sumSubsets.size(); j++) {
            List<Integer> sumSubset = sumSubsets.get(j);
            int sum = sumSubset.stream().mapToInt(subi -> subi).sum();
            if ((sum % k) == 0) {
                divideSubset.add(sumSubset);
            }
        }
        // subset, subset 만들고 size 2인것만
        for (int i = subsets.size()-1 ; i > 0; i--) {
            if (nonDivisibleSubsetSize < subsets.get(i).size()) {
                if (subsets.get(i).size() >= 2){
                    boolean flag = true;
                    for (int j = 0; j < divideSubset.size(); j++) {
                        if (subsets.get(i).containsAll(divideSubset.get(j)) ){
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        nonDivisibleSubsetSize = subsets.get(i).size();
                    }
                }
            }
        }

        return nonDivisibleSubsetSize;
    }


    private static void getSubset(List<Integer> inputs, long cnt) {
        for (int flag = 0; flag < cnt; flag++) {
            List<Integer> subset = new ArrayList<>();
            // 0, 1, 2 ... flag 비트열 별로 원소 수만큼 각 자리 비트를 확인
            for (int i = 0; i < inputs.size(); i++) {
                if ( (flag & (1 << i)) != 0 ) {
                    subset.add(inputs.get(i));
                }
            }
            if (subset.size() == 2){
                sumSubsets.add(subset);
            }
            subsets.add(subset);
        }
    }


}

