package com.example.programmers.skilltest.level3_2;

import java.util.*;
import java.util.stream.Collectors;

public class Test01 {

    public static void main(String[] args) {
        Test01 test = new Test01();
        int[][] ver = new int[][]{
                new int[]{3, 6},
                new int[]{4, 3},
                new int[]{3, 2},
                new int[]{1, 3},
                new int[]{1, 2},
                new int[]{2, 4},
                new int[]{5, 2}}
                ;
        int n = 6;
        System.out.println(test.solution(n, ver));

    }

    final int LEFT_INDEX = 0;
    final int RIGHT_INDEX = 1;
    public int solution(int n, int[][] edge) {
        int answer = 0;

        Map<Integer, List<int[]>> left =
                Arrays.stream(edge).collect(Collectors.groupingBy(ints -> ints[LEFT_INDEX]));

        Map<Integer, List<int[]>> right =
                Arrays.stream(edge).collect(Collectors.groupingBy(ints -> ints[RIGHT_INDEX]));

        // 진행 node
        List<Integer> nodes = new ArrayList<>();
        nodes.add(1);

        int[] stepArray = new int[n];

        route(left, right, nodes, 0, stepArray);

        Arrays.sort(stepArray);

        int count = 0;
        int pre = stepArray[stepArray.length-1];
        for (int i = stepArray.length-1; i > 0 ; i--) {
            if(pre == stepArray[i]){
                count ++;
            }
        }

        return count;
    }

    public void route(Map<Integer, List<int[]>> left, Map<Integer, List<int[]>> right, List<Integer> nodes, int step, int[] stepArray){

        int lastNode = nodes.get(nodes.size()-1);
        List<int[]> leftConnections = left.get(lastNode);
        if (leftConnections != null) {
            for (int[] conn : leftConnections){
                int nextNode = conn[RIGHT_INDEX];
                if (!nodes.contains(nextNode)) {
                    List<Integer> cloneNodes = new ArrayList<>(nodes);
                    cloneNodes.add(conn[RIGHT_INDEX]);
                    route(left, right, cloneNodes, step+1, stepArray);
                }
            }
        }

        List<int[]> rightConnections = right.get(lastNode);
        if (rightConnections != null) {
            for (int[] conn : rightConnections){
                int nextNode = conn[LEFT_INDEX];
                if (!nodes.contains(nextNode)) {
                    List<Integer> cloneNodes = new ArrayList<>(nodes);
                    cloneNodes.add(conn[LEFT_INDEX]);
                    route(left, right, cloneNodes, step+1, stepArray);
                }
            }
        }

        if (stepArray[lastNode-1] == 0 || stepArray[lastNode-1] > step) {
            stepArray[lastNode-1] = step;
        }

    }

}
