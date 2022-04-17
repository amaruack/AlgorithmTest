package com.example.nexon;

import java.util.*;

public class Nearest {


    static final int CITY_INDEX = 0;
    static final int DIS_INDEX = 1;

    static final String NONE_CITY = "NONE";

    public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
        // Write your code here
        List<String> result = new ArrayList<>();
        Map<String, List<String>> closestCityMap= new HashMap<>();

        // city 간 거리 측정
        for (int i = 0; i < c.size() ; i++) {
            String originCityName= c.get(i);
            int dis = 0;
            String closestCityName = NONE_CITY;
            if (closestCityMap.containsKey(originCityName)) {
                List<String> closestCityData = closestCityMap.get(originCityName);
                closestCityName = closestCityData.get(CITY_INDEX);
                dis = Integer.parseInt(closestCityData.get(DIS_INDEX));
            }
            for (int j = i+1 ; j < c.size() ; j++) {
                // 자기 건너띔
                    int originX = x.get(i);
                    int originY = y.get(i);

                    int targetX = x.get(j);
                    int targetY = y.get(j);
                    // 같은 x, y 가 있어야 한다.
                    if (originX == targetX || originY == targetY) {
                        int localDis = Math.abs(originX - targetX) + Math.abs(originY - targetY);
                        closestCityName = c.get(j);
                        if (dis == 0 || localDis <= dis) {
                            dis = localDis;
                            // 가장 작은 거리에 잇는 city 지정해놈
                            closestCityMap.put(originCityName, Arrays.asList(new String[] {closestCityName, String.valueOf(dis)}));
                        }

                        if (closestCityMap.containsKey(closestCityName)) {
                            int predis = Integer.parseInt(closestCityMap.get(closestCityName).get(DIS_INDEX));
                            if (predis == 0 || predis > localDis) {
                                closestCityMap.put(closestCityName, Arrays.asList(new String[] {originCityName, String.valueOf(localDis)}));
                            }
                        } else {
                            closestCityMap.put(closestCityName, Arrays.asList(new String[] {originCityName, String.valueOf(localDis)}));
                        }
                    }
                }
                // NONE 처리
                if (NONE_CITY.equals(closestCityName)){
                    closestCityMap.put(originCityName, Arrays.asList(new String[] {closestCityName, String.valueOf(dis)}));
                }
        }

        for (int i = 0; i < q.size() ; i++) {
            result.add(closestCityMap.get(q.get(i)).get(CITY_INDEX));
        }

        return result;
    }
}
