package com.example.programmers.exercise;

import com.example.programmers.skilltest.level2.Test02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        Test02 test = new Test02();
//        test.solution("100-200*300-500+20");
//        perm(arr, output, visited, 0, n, 3)
        test.perm(new int[] {1,2,3}, new int[3], new boolean[3], 0,3, 3);
    }

    List<int[]> perm = new LinkedList<>();
    // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
// 사용 예시: perm(arr, output, visited, 0, n, 3);
    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            perm.add(Arrays.copyOf(output, 3));
//            print(output, r);
            return;
        }
        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                output[depth] = 0;
                visited[i] = false;;
            }
        }
    }

}
