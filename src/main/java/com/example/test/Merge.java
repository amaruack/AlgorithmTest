package com.example.test;

import java.util.Arrays;

public class Merge {
	public static int tmp[] = new int[8];

	public static void merge(int arr[], int left, int mid, int right) {
		int i, j, k;
		i = left; // 정렬된 왼쪽 리스트에 대한 인덱스
		j = mid + 1; // 정렬된 오른쪽 리스트에 대한 인덱스
		k = left; // 정렬될 리스트에 대한 인덱스

		// 분할 정렬된 list의 합병
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}

		// 남아있는 값 넣기
		if (i > mid) {
			for (int l = j; l <= right; l++) {
				tmp[k++] = arr[l];
			}
		} else {// (j > right)
			for (int l = i; l <= mid; l++) {
				tmp[k++] = arr[l];
			}
		}

		// 임시배열 tmp를 arr로 복사
		for (int l = left; l <= right; l++) {
			arr[l] = tmp[l];
		}
	}

	public static void mergeSort(int arr[], int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}

	}

	public static void main(String[] args) {

		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4 };

		mergeSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}
}
