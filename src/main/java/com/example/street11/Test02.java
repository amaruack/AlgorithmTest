package com.example.street11;

public class Test02 {
    public static void main(String[] args) {
        Test02 test = new Test02();
        System.out.println(test.solution(new int[]{1,1,2,3,3},3 ));
        System.out.println(test.solution(new int[]{2,3,3},3 ));
        System.out.println(test.solution(new int[]{1},3 ));
        System.out.println(test.solution(new int[]{2},3 ));
        System.out.println(test.solution(new int[]{},3 ));
    }

    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }
}
