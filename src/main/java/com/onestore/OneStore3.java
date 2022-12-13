package com.onestore;

public class OneStore3 {
    public static void main(String[] args) {
        OneStore3 oneStore3 = new OneStore3();
        System.out.println(oneStore3.solution(new int[][]{new int[]{1,2}, new int[]{3,4}}));
        System.out.println(oneStore3.solution(new int[][]{new int[]{1,8,3,2}, new int[]{7,4,6,5}}));
        System.out.println(oneStore3.solution(
                new int[][]{
                    new int[]{5000, 500, 5000, 5000, 5000, 5000, 5000},
                    new int[]{5000, 500, 5000, 5000, 5000, 5000, 5000},
                    new int[]{5000, 500, 500, 500, 500, 5000, 5000},
                    new int[]{5000, 5000, 5000, 5000, 500, 5000, 5000},
                    new int[]{5000, 5000, 5000, 5000, 500, 5000, 5000},
                    new int[]{5000, 5000, 5000, 5000, 500, 5000, 5000},
                    new int[]{5000, 5000, 5000, 5000, 500, 500, 500},
                    new int[]{5000, 5000, 5000, 5000, 5000, 1, 5000},
                }
        ));
    }

    public int solution(int[][] grid) {
        int answer = 0;
        answer = next(grid,0, 0, 0);
        return answer;
    }

    public int next(int[][] grid, int sum, int row, int column) {

        if (row > grid.length-1 || column > grid[0].length-1) {
            return Integer.MAX_VALUE;
        }
        sum += grid[row][column];
        if (row == grid.length-1 && column == grid[0].length-1) {
            return sum;
        } else {
            return Math.min(
                    next(grid, sum, row+1, column),
                    next(grid, sum, row, column+1)
            );
        }
    }

}
