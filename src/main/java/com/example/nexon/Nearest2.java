package com.example.nexon;

import java.util.*;

public class Nearest2 {


    static final int CITY_INDEX = 0;
    static final int DIS_INDEX = 1;

    static final String NONE_CITY = "NONE";

    public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
        // Write your code here
        List<String> result = new ArrayList<>();
        Map<String, List<String>> closestCityMap= new HashMap<>();



        for (int i = 0; i < q.size() ; i++) {

            String originCityName = q.get(i);
            int originCityIndex = c.indexOf(originCityName);

            int originCityX = x.get(originCityIndex) ;
            int originCityY = y.get(originCityIndex) ;

            int dis = 0;
            String resultCity = NONE_CITY;

            for (int j = 0; j < c.size(); j++) {
                if (originCityIndex != j) {
                    int targetCityX = x.get(j);
                    int targetCityY = y.get(j);
                    if (originCityX == targetCityX || originCityY == targetCityY) {
                        int localDis = Math.abs(targetCityX - originCityX) + Math.abs(targetCityY - originCityY);
                        if (dis == 0 || localDis < dis) {
                            dis = localDis;
                            resultCity = c.get(j);
                        }
                    }
                }
            }
            result.add(resultCity);

        }

        return result;
    }
}
