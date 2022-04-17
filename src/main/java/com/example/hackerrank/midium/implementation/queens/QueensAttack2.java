package com.example.hackerrank.midium.implementation.queens;

import java.util.*;
import java.util.stream.Collectors;

public class QueensAttack2 {


    public static void main(String[] args) {

        List<List<Integer>> obs = new ArrayList<>();
        obs.add(Arrays.asList(new Integer[]{5,3}));
        obs.add(Arrays.asList(new Integer[]{5,4}));
        obs.add(Arrays.asList(new Integer[]{4,4}));
        obs.add(Arrays.asList(new Integer[]{3,4}));
        obs.add(Arrays.asList(new Integer[]{3,3}));
        obs.add(Arrays.asList(new Integer[]{3,2}));
        obs.add(Arrays.asList(new Integer[]{4,2}));
        obs.add(Arrays.asList(new Integer[]{5,2}));

        int result = QueensAttack2.queensAttack(5, 7, 4, 3, obs);
        System.out.println("asdf");

    }

    static final int INDEX_ROW = 0;
    static final int INDEX_COLUMN = 1;

    static final int[] N = new int[] {1, 0};
    static final int[] E = new int[] {0, 1};
    static final int[] S = new int[] {-1, 0};
    static final int[] W = new int[] {0, -1};

    static final int[] NE = new int[] {1, 1};
    static final int[] SE = new int[] {-1, 1};
    static final int[] SW = new int[] {-1, -1};
    static final int[] NW = new int[] {1, -1};

    static final int[][] DIRECTION= new int[][]{N, E, S, W, NE, SE, SW, NW};

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < DIRECTION.length; i++) {
            int[] d = DIRECTION[i];
            List<List<Integer>> filteredObstacles = obstacles.parallelStream().filter(obstacle -> {
                if (d == N) {
                    if (obstacle.get(INDEX_ROW) > r_q && obstacle.get(INDEX_COLUMN) == c_q) {
                        return true;
                    }
                } else if (d == E) {
                    if (obstacle.get(INDEX_COLUMN) > c_q && obstacle.get(INDEX_ROW) == r_q) {
                        return true;
                    }
                } else if (d == S) {
                    if (obstacle.get(INDEX_ROW) < r_q && obstacle.get(INDEX_COLUMN) == c_q) {
                        return true;
                    }
                } else if (d == W) {
                    if (obstacle.get(INDEX_COLUMN) < c_q && obstacle.get(INDEX_ROW) == r_q) {
                        return true;
                    }
                } else if (d == NE) {
                    if (obstacle.get(INDEX_ROW) > r_q && obstacle.get(INDEX_COLUMN) > c_q) {
                        if (obstacle.get(INDEX_ROW) - r_q == obstacle.get(INDEX_COLUMN) - c_q) {
                            return true;
                        }
                    }
                } else if (d == SE) {
                    if (obstacle.get(INDEX_ROW) < r_q && obstacle.get(INDEX_COLUMN) > c_q) {
                        if (obstacle.get(INDEX_ROW) - r_q == -(obstacle.get(INDEX_COLUMN) - c_q)) {
                            return true;
                        }
                    }
                } else if (d == SW) {
                    if (obstacle.get(INDEX_ROW) < r_q && obstacle.get(INDEX_COLUMN) < c_q) {
                        if (obstacle.get(INDEX_ROW) - r_q == obstacle.get(INDEX_COLUMN) - c_q) {
                            return true;
                        }
                    }
                } else if (d == NW) {
                    if (obstacle.get(INDEX_ROW) > r_q && obstacle.get(INDEX_COLUMN) < c_q) {
                        if (obstacle.get(INDEX_ROW) - r_q == -(obstacle.get(INDEX_COLUMN) - c_q)) {
                            return true;
                        }
                    }
                }
                return false;

            }).collect(Collectors.toList());

            List<Integer> queen = Arrays.asList(new Integer[] {r_q, c_q});
            while (true) {
                if (canMove(queen, d, n, filteredObstacles)){
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static boolean canMove(List<Integer> queen, int[] d, int n, List<List<Integer>> obstacles) {
        boolean result = true;
        move(queen, d);

        if (queen.get(INDEX_ROW) <= 0 || queen.get(INDEX_ROW) > n) {
            result = false;
        } else if (queen.get(INDEX_COLUMN) <= 0 || queen.get(INDEX_COLUMN) > n){
            result = false;
        } else {
            result = !contains(obstacles, queen.get(INDEX_ROW), queen.get(INDEX_COLUMN), d);
        }
        return result;
    }

    public static List<Integer> move(List<Integer> queen, int[] d) {
        queen.set(INDEX_ROW, queen.get(INDEX_ROW) + d[INDEX_ROW]);
        queen.set(INDEX_COLUMN, queen.get(INDEX_COLUMN) + d[INDEX_COLUMN]);
        return queen;
    }

    public static boolean contains(List<List<Integer>> obstacles, int r_q, int c_q, int[] d){

        long count = obstacles.parallelStream().filter(obstacle -> {
            if (obstacle.get(INDEX_ROW) == r_q && obstacle.get(INDEX_COLUMN) == c_q){
                return true;
            } else {
                return false;
            }
        }).count();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

//    public static boolean contains(List<List<Integer>> obstacles, int r_q, int c_q){
//        for (int i = 0; i < obstacles.size(); i++) {
//            List<Integer> obstacle = obstacles.get(i);
//            if (obstacle.get(INDEX_ROW) == r_q && obstacle.get(INDEX_COLUMN) == c_q){
//                return true;
//            }
//        }
//        return false;
//    }


}
