package com.example.nexon;

import java.util.*;

public class Nearest5 {


    public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
        // Write your code here
        List<String> result = new ArrayList<>();

        // x, y coord sort 만듬
        Map<Integer, Map<Integer, Integer>> xGroup = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> yGroup = new HashMap<>();

        for (int i = 0; i < c.size(); i++) {
            Map<Integer, Integer> sameX = null;
            if (!xGroup.containsKey(x.get(i))) {
                xGroup.put(x.get(i), new TreeMap<>());  // 정렬 위해 tree map 사용
            }
            sameX = xGroup.get(x.get(i));
            sameX.put(y.get(i), i);

            Map<Integer, Integer> sameY = null;
            if (!yGroup.containsKey(y.get(i))) {
                yGroup.put(y.get(i), new TreeMap<>());  // 정렬 위해 tree map 사용
            }
            sameY = yGroup.get(y.get(i));
            sameY.put(x.get(i), i );
        }

        for (int i = 0; i < q.size() ; i++) {
            String originCity = q.get(i);
            int indexOfOriginCity = c.indexOf(originCity);
            int originX = x.get(indexOfOriginCity);
            int originY = y.get(indexOfOriginCity);

            int dis = 0;
            String targetName = "NONE";
            // 같은 x의 y 위 / 아래
            Map<Integer, Integer> sameX = xGroup.get(originX);
            if (sameX.size() > 1) { // 1보다 클때 처리
                List<Integer> sameXIndexs = new ArrayList<>(sameX.keySet());
                int index = sameXIndexs.indexOf(originY);
                //  위
                if (index+1 < sameX.size()) {
                    int upperY = sameXIndexs.get(index+1);
                    int upperYDis = upperY - originY;
                    if (dis == 0 || upperYDis < dis) {
                        dis = upperYDis;
                        targetName = c.get(sameX.get(upperY).intValue());
                    }
                }
                //  아래
                if (index-1 >= 0) {
                    int lowerY = sameXIndexs.get(index-1);
                    int lowerYDis = originY - lowerY;
                    if (dis == 0 || lowerYDis < dis) {
                        dis = lowerYDis;
                        targetName = c.get(sameX.get(lowerY).intValue());
                    }
                }
            }
            // 같은 y의 x 위 / 아래
            Map<Integer, Integer> sameY = yGroup.get(originY);
            if (sameY.size() > 1) { // 1보다 클때 처리
                List<Integer> sameYIndexs = new ArrayList<>(sameY.keySet());
                int index = sameYIndexs.indexOf(originX);
                //  위
                if (index+1 < sameY.size()) {
                    int upperX = sameYIndexs.get(index+1);
                    int upperXDis = upperX - originX;
                    if (dis == 0 || upperXDis < dis) {
                        dis = upperXDis;
                        targetName = c.get(sameY.get(upperX).intValue());
                    }
                }
                //  아래
                if (index-1 >= 0) {
                    int lowerX = sameYIndexs.get(index-1);
                    int lowerXDis = originX - lowerX;
                    if (dis == 0 || lowerXDis < dis) {
                        dis = lowerXDis;
                        targetName = c.get(sameY.get(lowerX).intValue());
                    }
                }
            }
            if (dis == 0 ) {
                result.add("NONE");
            } else {
                result.add(targetName);
            }
        }

        return result;
    }
}
