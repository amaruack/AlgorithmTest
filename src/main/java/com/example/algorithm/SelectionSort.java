package com.example.algorithm;


/**
 * 주어진 리스트 중에서 최소값을 찾는다.
 * 그 최솟값을 맨 앞 값과 교체한다.
 * 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
 */
public class SelectionSort {

    public static void selectionSort(int a[]) {
        int size = a.length;

        for (int i = 0; i < size; i++) {
            int idx = i;
            for (int j = i; j < size; j++) {
                if(a[idx] > a[j]) {
                    idx = j;
                }
            }
            int tmp = a[idx];
            a[idx] = a[i];
            a[i] = tmp;
        }
    }

}
