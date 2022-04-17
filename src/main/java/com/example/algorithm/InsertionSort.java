package com.example.algorithm;

/**
 * 삽입 정렬은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치에 삽입하는 정렬입니다.
 *
 * 시간 복잡도는 최선의 경우엔 n, 최악의 경우엔 n²
 * 알고리즘 자체가 간단하며 안정 정렬(Stable Sort) 임
 * 배열이 거의 정렬되어 있는 경우엔 효율적
 * 비교적 많은 배열 값들의 이동을 포함하므로 배열 길이가 길어질수록 비효율적
 */
public class InsertionSort {

    public static void sort(int[] num){

        int N = num.length;
        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int target = num[i];
            int j = i - 1;
            while (j >= 0 && target < num[j]) {
                num[j+1] = num[j];
                j--;
            }
            num[j+1] = target;
        }

    }

}
