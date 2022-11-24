package com.han;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test01 {

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        int[] test = test01.sol(4, 5);
        System.out.println(":sdf");
    }

    public int[] sol(int n, int m){
        int[] answer = new int[n-1];

        Queue<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toCollection(LinkedList::new));

        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < m-1; j++) {
                list.offer(list.poll());
            }
            answer[i] = (int)list.poll();
        }



        return answer;
    }

//    public int[] sol2(int n, int m){
//        int[] answer = new int[n];
//
//        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
//        int remain = 0;
//        for (int i = n; i > 0; i--) {
//
//            int index = (m + remain) % n ;
//
//            if (remain > m) {
//                index = remain % m;
//            }
//
//
//            remain = n - index;
//            int getNum = list.remove(index - 1 );
//            answer[n - i] = getNum;
//        }
//        return answer;
//    }

}
