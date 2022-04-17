package com.example.nexon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nearest4_back {


    static final int CITY_INDEX = 0;
    static final int DIS_INDEX = 1;

    static final int NONE_CITY = -1;


    static final int COORD_INDEX = 0;
    static final int INDEX_INDEX = 1;



    public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
        // Write your code here
        List<String> result = new ArrayList<>();

        int[][] closestCityMap= new int[c.size()][2];

        // x, y coord sort 만듬
        ArrayList<Integer[]> xSorted = new ArrayList<>();
        ArrayList<Integer[]> ySorted = new ArrayList<>();
        for (int i = 0; i < c.size(); i++) {
            xSorted.add(new Integer[]{x.get(i), i });
            ySorted.add(new Integer[]{y.get(i), i });
        }
        // 오름차순 정렬
        Collections.sort(xSorted, Comparator.comparing(o -> o[COORD_INDEX]));
        Collections.sort(ySorted, Comparator.comparing(o -> o[COORD_INDEX]));

        // city 간 거리 측정
        for (int i = 0; i < c.size() ; i++) {

            ///

//            xSorted.get(i)



            int originCityName= i;
            int dis = 0;
//            int closestCityName = -1;

            int[] closestCityData = closestCityMap[i];

            if (closestCityData[DIS_INDEX] != 0) {
                dis = closestCityData[DIS_INDEX];
//                closestCityName = closestCityData[CITY_INDEX];
            }

            for (int j = originCityName+1 ; j < c.size() ; j++) {
                int targetCityName = j;

                int originX = x.get(originCityName);
                int originY = y.get(originCityName);

                int targetX = x.get(targetCityName);
                int targetY = y.get(targetCityName);
                // 같은 x, y 가 있어야 한다.
                if (originX == targetX || originY == targetY) {

                    int localDis = Math.abs(originX - targetX) + Math.abs(originY - targetY);

                    if (dis == 0 || localDis <= dis) {
//                        closestCityName = j;
                        dis = localDis;
                        // 가장 작은 거리에 잇는 city 지정해놈
                        closestCityMap[originCityName][CITY_INDEX] = j;
                        closestCityMap[originCityName][DIS_INDEX] = dis;

                        if (closestCityMap[targetCityName][DIS_INDEX] == 0) {
                            closestCityMap[targetCityName][DIS_INDEX] = dis;
                            closestCityMap[targetCityName][CITY_INDEX] = originCityName;
                        } else {
                            if (closestCityMap[targetCityName][DIS_INDEX] > dis) {
                                closestCityMap[targetCityName][DIS_INDEX] = dis;
                                closestCityMap[targetCityName][CITY_INDEX] = originCityName;
                            }
                        }
                    } else {
                        if ( closestCityMap[targetCityName][DIS_INDEX] == 0 || closestCityMap[targetCityName][DIS_INDEX] > localDis) {
                            closestCityMap[targetCityName][DIS_INDEX] = localDis;
                            closestCityMap[targetCityName][CITY_INDEX] = originCityName;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < q.size() ; i++) {
            int[] closestCity = closestCityMap[c.indexOf(q.get(i))];
            if (closestCity[DIS_INDEX] == 0 ) {
                result.add("NONE");
            } else {
                result.add(c.get(closestCity[CITY_INDEX]));
            }
        }

        return result;
    }
}
