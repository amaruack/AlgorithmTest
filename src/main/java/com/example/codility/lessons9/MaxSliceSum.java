package com.example.codility.lessons9;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxSliceSum {

    public static void main(String[] args) {

        MaxSliceSum test = new MaxSliceSum();
        int result = test.solution(new int[]{-6,-6,-6,-14,-20});
//        int result = test.solution(new int[]{10});
//        int result = test.solution(new int[]{3,2,-6, 4,0});
//        int result = test.solution(new int[]{3,2,-6, 4,7});
        System.out.println(result);

//        A[0] = 3  A[1] = 2  A[2] = -6
//        A[3] = 4  A[4] = 0

        //N is an integer within the range [1..1,000,000];
        //each element of array A is an integer within the range [−1,000,000..1,000,000];
        //the result will be an integer within the range [−2,147,483,648..2,147,483,647].
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;

        if(A.length == 1) {
            return A[0];
        }

        int localMaxSum = A[0];
        int globalMaxSum = A[0];

        for(int i = 1 ; i < A.length; i++) {
            localMaxSum = Math.max(A[i], localMaxSum + A[i]);
            globalMaxSum = Math.max(globalMaxSum, localMaxSum);
        }

        result = globalMaxSum;
        return result;
    }

}
