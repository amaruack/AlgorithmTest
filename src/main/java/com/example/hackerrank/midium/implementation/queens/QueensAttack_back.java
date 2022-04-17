package com.example.hackerrank.midium.implementation.queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class QueensAttack_back {


    public static void main(String[] args) {

        List<List<Integer>> obs = new ArrayList<>();
        obs.add(Arrays.asList(new Integer[]{5,3}));
        obs.add(Arrays.asList(new Integer[]{3,8}));
        obs.add(Arrays.asList(new Integer[]{2,3}));

        QueensAttack_back.queensAttack(8, 3, 2, 2, obs);

    }

    static final int INDEX_ROW = 0;
    static final int INDEX_COLUMN = 1;

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int answer = 0;

        // 8 direction

        // up
        // cloumn 같고 row가 queen 보다 큰거 중에 젤작은거
        OptionalInt opup = obstacles.stream().filter(obstacle -> {
            if (obstacle.get(INDEX_COLUMN) == c_q){
                if (obstacle.get(INDEX_ROW) > r_q) {
                    return true;
                }
            }
            return  false;
        }).mapToInt(obstacle -> obstacle.get(INDEX_ROW)).min();
        int up = r_q;
        int upLimit = n;
        if (opup.isPresent()) {
            upLimit = opup.getAsInt() - 1;
        }
        int upCnt = upLimit - up;

        // down
        // cloumn 같고 row 작은거
        OptionalInt opdown = obstacles.stream().filter(obstacle -> {
            if (obstacle.get(INDEX_COLUMN) == c_q){
                if (obstacle.get(INDEX_ROW) < r_q) {
                    return true;
                }
            }
            return  false;
        }).mapToInt(obstacle -> obstacle.get(INDEX_ROW)).max();
        int down = r_q;
        int downLimit = 1;
        if (opdown.isPresent()) {
            downLimit = opdown.getAsInt() + 1;
        }
        int downCnt = down - downLimit ;

        // right
        // row 같고 cloumn 큰거
        OptionalInt opRight = obstacles.stream().filter(obstacle -> {
            if (obstacle.get(INDEX_ROW) == r_q){
                if (obstacle.get(INDEX_COLUMN) > c_q) {
                    return true;
                }
            }
            return  false;
        }).mapToInt(obstacle -> obstacle.get(INDEX_COLUMN)).min();
        int right = c_q;
        int rightLimit = n;
        if (opRight.isPresent()) {
            rightLimit = opRight.getAsInt() - 1;
        }
        int rightCnt = rightLimit - right;

        // leff
        // row 같고 cloumn 작은거
        OptionalInt opLeft = obstacles.stream().filter(obstacle -> {
            if (obstacle.get(INDEX_ROW) == r_q){
                if (obstacle.get(INDEX_COLUMN) < c_q) {
                    return true;
                }
            }
            return  false;
        }).mapToInt(obstacle -> obstacle.get(INDEX_COLUMN)).max();
        int left = c_q;
        int leftLimit = 1;
        if (opLeft.isPresent()) {
            leftLimit = opLeft.getAsInt() + 1;
        }
        int leftCnt = left - leftLimit ;

        // upright
        // 둘다 큰거 중에 비율이 같은거 중에 젤 작은거
        OptionalInt opupright = obstacles.stream().filter(obstacle -> {
            if (obstacle.get(INDEX_COLUMN) > c_q){
                if (obstacle.get(INDEX_ROW) > r_q) {
                    if ( (r_q - obstacle.get(INDEX_ROW)) == ( c_q - obstacle.get(INDEX_COLUMN))){
                        return true;
                    }
                }
            }
            return  false;
        }).mapToInt(obstacle -> obstacle.get(INDEX_COLUMN)).min();
        int upright = c_q;
        int upRightLimit = n;
        if (opupright.isPresent()) {
            upRightLimit = opupright.getAsInt() - 1;
        } else {
            if (n - r_q < n - c_q){
                upright = r_q;
            }
        }
        int upRightCnt = upRightLimit - upright;

        // downright
        OptionalInt opdownright = obstacles.stream().filter(obstacle -> {
            if (obstacle.get(INDEX_COLUMN) > c_q){
                if (obstacle.get(INDEX_ROW) < r_q) {
                    if ( (r_q - obstacle.get(INDEX_ROW)) ==  (obstacle.get(INDEX_COLUMN) - c_q ) ){
                        return true;
                    }
                }
            }
            return  false;
        }).mapToInt(obstacle -> obstacle.get(INDEX_COLUMN)).max();
        int downRightCnt = 0;
        if (opdownright.isPresent()) {
            downRightCnt = opdownright.getAsInt() - r_q - 1;
        } else {
//            if (n - r_q > n - c_q){
//                downright = r_q;
//                downRightLimit = 1;
//            }
        }

        // downleft
//        OptionalInt opdownleft = obstacles.stream().filter(obstacle -> {
//            if (obstacle.get(INDEX_COLUMN) < c_q){
//                if (obstacle.get(INDEX_ROW) < r_q) {
//                    if ( (r_q - obstacle.get(INDEX_ROW)) == ( c_q - obstacle.get(INDEX_COLUMN))){
//                        return true;
//                    }
//                }
//            }
//            return  false;
//        }).mapToInt(obstacle -> obstacle.get(INDEX_COLUMN)).min();
//        int upright = c_q;
//        int upRightLimit = n;
//        if (opupright.isPresent()) {
//            upRightLimit = opupright.getAsInt() - 1;
//        }
//        int upRightCnt = upRightLimit - upright;

        // upleft


        return answer;
    }


}
