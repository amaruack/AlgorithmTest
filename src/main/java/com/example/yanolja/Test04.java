package com.example.yanolja;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Test04 {

    public static void main(String[] args) {

//        ConcurrentHashMap

//        ConcurrentHashMap<String, Object> tmp = new ConcurrentHashMap<>();
//        tmp.put()

        Test04 test = new Test04();
//        int result = test.solution(new int[]{5,3,6,1,3},2);
//        int result = test.solution(new int[]{13,7,2,8,3});
        int result = test.solution(new int[]{13,13,7,2,8,3});
        System.out.println(result);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;

        // group 처리
        Map<Integer, Long> groupMap = Arrays.stream(A).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        // 최대 값 구하기
        int maxNum = groupMap.keySet().stream().max(Integer::compareTo).get();
        int exponent = 0;
        while (true) {
            if (maxNum < Math.pow(2, exponent)){
                break;
            }
            exponent ++;
        }

        int[] countTable = new int[exponent];
        Iterator<Integer> keyit = groupMap.keySet().iterator();
        while (keyit.hasNext()) {
            int key = keyit.next();
            for (int j = 0; j < exponent; j++) {
                int powData = (int) Math.pow(2, j);
                if ( key < powData) {
                    break;
                }
                if ((key & powData) == powData) {
                    countTable[j] = countTable[j] + groupMap.get(key).intValue();
                }
            }
        }
        result = Arrays.stream(countTable).max().getAsInt();
        return result;
    }
}
