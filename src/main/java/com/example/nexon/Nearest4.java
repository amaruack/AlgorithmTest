package com.example.nexon;

import java.util.*;

public class Nearest4 {


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
        Map<Integer, List<Integer[]>> xGroup = new HashMap<>();
        Map<Integer, List<Integer[]>> yGroup = new HashMap<>();

        for (int i = 0; i < c.size(); i++) {
            List<Integer[]> sameX = null;
            if (!xGroup.containsKey(x.get(i))) {
                xGroup.put(x.get(i), new ArrayList<>());
            }
            sameX = xGroup.get(x.get(i));
            sameX.add(new Integer[]{x.get(i), i });

            List<Integer[]> sameY = null;
            if (!yGroup.containsKey(y.get(i))) {
                yGroup.put(y.get(i), new ArrayList<>());
            }
            sameY = yGroup.get(y.get(i));
            sameY.add(new Integer[]{y.get(i), i });

        }

        Iterator<Integer> xGroupKeys = xGroup.keySet().iterator();
        while(xGroupKeys.hasNext()) {
            Integer xGroupKey = xGroupKeys.next();
            List<Integer[]> sameX =  xGroup.get(xGroupKey);
            if (sameX.size() > 1) {
                // city 간 거리 측정
                for (int j = 0; j < sameX.size() ; j++) {
                    Integer[] originData = sameX.get(j);
                    int originCityName= originData[INDEX_INDEX];
                    int dis = 0;

                    int[] closestCityData = closestCityMap[originCityName];
                    if (closestCityData[DIS_INDEX] != 0) {
                        dis = closestCityData[DIS_INDEX];
                    }

                    for (int k = j+1 ; k < sameX.size() ; k++) {
                        Integer[] targetData = sameX.get(k);
                        int targetCityName = targetData[INDEX_INDEX];

                        int originX = x.get(originCityName);
                        int originY = y.get(originCityName);

                        int targetX = x.get(targetCityName);
                        int targetY = y.get(targetCityName);

                        // 같은 x, y 가 있어야 한다.
                        int localDis = Math.abs(originX - targetX) + Math.abs(originY - targetY);

                        if (dis == 0 || localDis <= dis) {
                            dis = localDis;
                            // 가장 작은 거리에 잇는 city 지정해놈
                            closestCityMap[originCityName][CITY_INDEX] = targetCityName;
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
        }

        Iterator<Integer> yGroupKeys = yGroup.keySet().iterator();
        while(yGroupKeys.hasNext()) {
            Integer yGroupKey = yGroupKeys.next();
            List<Integer[]> sameY =  yGroup.get(yGroupKey);
            if (sameY.size() > 1) {
                // city 간 거리 측정
                for (int j = 0; j < sameY.size() ; j++) {
                    Integer[] originData = sameY.get(j);
                    int originCityName= originData[INDEX_INDEX];
                    int dis = 0;
                    int[] closestCityData = closestCityMap[originCityName];
                    if (closestCityData[DIS_INDEX] != 0) {
                        dis = closestCityData[DIS_INDEX];
                    }

                    for (int k = j+1 ; k < sameY.size() ; k++) {
                        Integer[] targetData = sameY.get(k);
                        int targetCityName = targetData[INDEX_INDEX];

                        int originX = x.get(originCityName);
                        int originY = y.get(originCityName);

                        int targetX = x.get(targetCityName);
                        int targetY = y.get(targetCityName);

                        int localDis = Math.abs(originX - targetX) + Math.abs(originY - targetY);

                        if (dis == 0 || localDis <= dis) {
                            dis = localDis;
                            // 가장 작은 거리에 잇는 city 지정해놈
                            closestCityMap[originCityName][CITY_INDEX] = targetCityName;
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
