package com.example.test;

public class Quick {
	public static void main(String[] args) {

		int arr[] = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2 };

		System.out.println("정렬 전");
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();

		quickSort(arr, 0, arr.length-1);
		
		System.out.println("정렬 후");
		for (int value : arr) {
			System.out.print(value + " ");
		}

	}

	public static void quickSort(int[] array, int left, int right) {
		if (left >= right)
			return;

		// 분할
		int pivot = partition(array, left, right);

		// 피벗은 제외한 2개의 부분 배열을 대상으로 순환 호출
		quickSort(array, left, pivot - 1); // 정복(Conquer)
		quickSort(array, pivot + 1, right); // 정복(Conquer)
	}
	
	public static int partition(int[] array, int left, int right) {
		
		int pivot = array[left]; // 가장 왼쪽값을 피벗으로 설정
		int i = left, j = right;

		while (i < j) {
			while (pivot < array[j]) {
				j--;
			}
			while (i < j && pivot >= array[i]) {
				i++;
			}
			swap(array, i, j);
		}

		array[left] = array[i];
		array[i] = pivot;

		return i;
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}