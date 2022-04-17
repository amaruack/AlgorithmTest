package com.example.algorithm;


/**
 * bubble sort
 * 앞에서부터 현재 원소와 다음 원소의 크기를 비교
 * 현재 원소가 다음 원소보다 클 시 교환
 * 다음 원소로 이동하여 1번부터 다시 진행
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.bubblesort(new int[]{9,8,7,6,5,4,3,2,1,10});
    }

    public void bubblesort(int[] arr) {

        int N = arr.length;

        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        // 출력
        System.out.println("오름차순으로 정렬됨");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

}
