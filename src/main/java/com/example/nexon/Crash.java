package com.example.nexon;

import java.util.*;


public class Crash {

    public static void main(String[] args) {

        int result = Crash.lastStoneWeight(Arrays.asList(new Integer[]{1,4,2,3,5}));
    }

    public static int lastStoneWeight(List<Integer> weights) {
        // Write your code here
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> - o1.compareTo(o2));
        queue.addAll(weights);

        while(true) {
            if(queue.size() > 1) {
                int first = queue.poll();
                int second = queue.poll();
                int remain = first - second;
                if (remain > 0) {
                    queue.offer(remain);
                }
            } else {
              break;
            }
        }

        if (queue.size() > 0) {
            result = queue.poll();
        }

        return result;
    }


}
