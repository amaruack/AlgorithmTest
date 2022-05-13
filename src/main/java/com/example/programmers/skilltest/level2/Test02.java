package com.example.programmers.skilltest.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Test02 {

    public static void main(String[] args) {
        Test02 test = new Test02();
//        test.solution("100-200*300-500+20");
//        perm(arr, output, visited, 0, n, 3)
        test.perm(new int[] {1,2,3}, new int[3], new boolean[3], 0,3, 3);
        System.out.println("sdf");
    }

    List<int[]> perm = new LinkedList<>();

    private final char PLUS = '+';
    private final char MINUS = '-';
    private final char MULTI = '*';

    public long solution(String expression) {
        long answer = 0;

        // 숫자 분리
        List<Integer> numbers = new LinkedList<>();
        List<String> calExs = new LinkedList<>();

        char[] exAr = expression.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exAr.length; i++) {
            if (exAr[i] == PLUS || exAr[i] == MINUS || exAr[i] == MULTI ) {
                calExs.add(String.valueOf(exAr[i]));
                numbers.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            } else {
                sb.append(exAr[i]);
            }
        }
        numbers.add(Integer.parseInt(sb.toString()));

        // 우선순위 정의
        // 어뜬걸 우선수위 먼저 ?
        List<String> dis= calExs.stream().distinct().collect(Collectors.toList());

        int[][] test = {{1,2,3}};

//        for (int i = 0; i < ; i++) {
//
//        }

        for (int i = 0; i < dis.size(); i++) {
            while (calExs.indexOf(dis.get(i)) >= 0){
                int index = calExs.indexOf(dis.get(i));
                calExs.remove(index);
                if (dis.get(i).equals(PLUS)) {
                    numbers.set(index, numbers.get(index) + numbers.get(index+1));
                } else if (dis.get(i).equals(MINUS)) {
                    numbers.set(index, numbers.get(index) - numbers.get(index+1));
                } else if (dis.get(i).equals(MULTI)) {
                    numbers.set(index, numbers.get(index) * numbers.get(index+1));
                }
                numbers.remove(index+1);
            }
        }


        return answer;
    }



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
