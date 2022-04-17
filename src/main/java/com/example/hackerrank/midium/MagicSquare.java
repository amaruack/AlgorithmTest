package com.example.hackerrank.midium;

import java.util.*;

public class MagicSquare {

    public static int formingMagicSquare(List<List<Integer>> s) {

        //절대값
        int abs = 0;
        // 우선 전체 합을 알아야됨

        int maxcount = (int)Math.pow(s.size(), 2);
//        int n = s.size();
        int maxsum = (maxcount * (maxcount+1)) /2 ;
//        Math.
        int sum = maxsum/s.size();

        // 전체 데이터 만듬
        int length = s.size() * s.get(0).size();
        List<Integer> allData = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            allData.add(i+1);
        }

//        0,0 ,0,1 0,2
        
        // sum 이 맞는지 체크
        // 라인별 
        for (int i = 0; i < s.size(); i++) {
            List<Integer> row = s.get(i);
            int rowsum = row.stream().mapToInt(value -> value).sum();
            if (rowsum != sum) {
                // magic row 아님
            }
        }

//        // 없는 숫자 체크
//        // 중복 숫자 체크
//        Map<Integer, Integer> duple = new TreeMap<>();
//        List<Integer> sList = new ArrayList<>();
//        for (int i = 0; i < s.size() ; i++) {
//            for (int j = 0; j < s.get(i).size() ; j++) {
//                // 숫자 삭제
//                if (!allData.remove(s.get(i).get(j))) {
//                    // 기존에 지워졌다면
//                    if (!duple.containsKey(s.get(i).get(j))) {
//                         duple.put(s.get(i).get(j), 0);
//                    }
//                    duple.put(s.get(i).get(j), duple.get(s.get(i).get(j)) + 1);
//                }
//            }
//        }
//
//        allData.removeAll(sList);
//        PriorityQueue<Integer> queue = new PriorityQueue<>(allData);
//

//
//        Iterator<Integer> it = duple.keySet().iterator();
//        while (it.hasNext()) {
//            Integer key = it.next();
//            int count = duple.get(key);
//            for (int i = 0; i < count; i++) {
//                abs += Math.abs(key - queue.poll());
//            }
//        }
        // Write your code here
        return abs;
    }

    public static void main(String[] args) {
        List data = new ArrayList<List<Integer>>();
//        data.add(new ArrayList<>(Arrays.asList(5,5,3,4)));
//        data.add(new ArrayList<>(Arrays.asList(1,5,5,8)));
//        data.add(new ArrayList<>(Arrays.asList(6,5,4,2)));
//        data.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
        data.add(new ArrayList<>(Arrays.asList(5,5,3)));
        data.add(new ArrayList<>(Arrays.asList(1,5,5)));
        data.add(new ArrayList<>(Arrays.asList(6,5,4)));
        int result = MagicSquare.formingMagicSquare(data);
        System.out.println("sdf");
    }
}
