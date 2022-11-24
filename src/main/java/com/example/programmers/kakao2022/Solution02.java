package com.example.programmers.kakao2022;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Solution02 {

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        solution02.solution(
                new int[]{180, 5000, 10, 600},
                new String[] {
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"}

        );
//        [14600, 34400, 5000]
    }

    private final int INDEX_IN_OUT_TIME = 0;
    private final int INDEX_CAR_NUMBER = 1;
    private final int INDEX_IN_OUT = 2;

    private final String SPLIT_CHAR = " ";

    private final String IN_CHAR = "IN";
    private final String OUT_CHAR = "OUT";

    enum FeeIndex{
        fixTime, fixFee, unitTime, unitFee
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, List<String>> group = Arrays.stream(records).collect(Collectors.groupingBy(s -> s.split(SPLIT_CHAR)[INDEX_CAR_NUMBER]));
        Iterator<String> carNumbers = group.keySet().stream().sorted().iterator();

        answer = new int[group.keySet().size()];
        int count = 0;

        while (carNumbers.hasNext()) {
            String carNumber = carNumbers.next();
            List<String> inOuts = group.get(carNumber);
            // 누적 주차 시간 계산
            int sumTime = calculateSumTime(inOuts);
            // 누적 주차 시간에 따른 금액 계산
            int fee = calculateFee(fees, sumTime);
//            new int[]{180, 5000, 10, 600},
            answer[count++] = fee;

        }
        return answer;
    }

    public int calculateSumTime(List<String> inOuts){

        int sumTime = 0;

        String inTime = null;
        for (String inOut : inOuts) {
            String[] datas = inOut.split(SPLIT_CHAR);
            if (IN_CHAR.equals(datas[INDEX_IN_OUT])){
                inTime = datas[INDEX_IN_OUT_TIME];
            } else {
                String outTime = datas[INDEX_IN_OUT_TIME];
                LocalTime outLocalTime = LocalTime.parse(outTime);
                LocalTime inLocalTime = LocalTime.parse(inTime);
                sumTime += getDayMinutes(outLocalTime) - getDayMinutes(inLocalTime);
                inTime = null;
            }
        }

        if (inTime != null) {
            String outTime = "23:59";
            LocalTime outLocalTime = LocalTime.parse(outTime);
            LocalTime inLocalTime = LocalTime.parse(inTime);
            sumTime += getDayMinutes(outLocalTime) - getDayMinutes(inLocalTime);
        }
        return sumTime;
    }

    public int getDayMinutes(LocalTime localTime) {
        return localTime.getHour()*60 + localTime.getMinute();
    }

    public int calculateFee(int[] fees, int sumTime){

        int fixTime = fees[FeeIndex.fixTime.ordinal()];
        int fixFee = fees[FeeIndex.fixFee.ordinal()];

        int unitTime = fees[FeeIndex.unitTime.ordinal()];
        int unitFee = fees[FeeIndex.unitFee.ordinal()];

        int calFee = 0;
        if (sumTime <= fixTime) {
            calFee = fixFee;
        } else {
            int calTime = sumTime - fixTime;
            calFee = fixFee + (calTime/unitTime) * unitFee + (calTime%unitTime != 0 ? unitFee : 0) ;
        }

        return calFee;
    }

}
