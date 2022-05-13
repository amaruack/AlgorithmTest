package com.example.codility;

import java.util.ArrayList;
import java.util.List;

public class PeekFlag {
    public static void main(String[] args) {
        PeekFlag test = new PeekFlag();
//        System.out.println(test.solution(new int[] {1,5,3,4,3,4,1,2,3,4,6,2}));
        System.out.println(test.solution(new int[] {3, 2, 1}));
//        System.out.println(test.solution(new int[] {1,5,3}));[3, 2, 1]
//        System.out.println(test.solution(new int[] {1,5,3,4,2,4,5,7,2,4,2}));
    }

    public int solution(int[] A) {
        int result = 0;
        // 우선 피크 찾고
        List<Integer> peeks = new ArrayList<>();

        if (A.length <= 2) {
            return 0;
        }
//        A[P − 1] < A[P] > A[P + 1]
        for (int i = 1; i < A.length-1 ; i++) {
            if (A[i-1] < A[i] && A[i] > A[i+1]) {
                peeks.add(i);
            }
        }

        if (peeks.size() <= 1) {
            return peeks.size();
        }

        // 중요 !!
        // max flag ???
        int maxflag = (int)(Math.sqrt(peeks.get(peeks.size()-1) - peeks.get(0)))+1;

        // 찾은 피크에서 가능한 flag 찾음
        for (int i = maxflag; i > 0 ; i--) {

            int count=1;
            int flagIndex = 0;

            for (int j = 1; j < peeks.size(); j++) {
                if (peeks.size() - j < i - count ) {
                    break;
                }
                if (peeks.get(j) - peeks.get(flagIndex) >= i){
                    count ++;
                    flagIndex = j;
                }
            }
            if (i <= count) {
                result = i;
                break;
            }
        }

        return result;
    }
}
