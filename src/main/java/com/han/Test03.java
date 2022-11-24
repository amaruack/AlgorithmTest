package com.han;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Test03 {

    public static void main(String[] args) {

        Test03 test03 = new Test03();
        String startDate = "05/04 MON";
        String endDate = "05/30";
//        String[] loginDates = new String[] {
//            "05/26", "05/25", "05/27",
//                "05/10", "05/11", "05/23",
//                "05/22", "05/21", "05/06",
//                "05/09", "05/07", "05/08"
//        };
        String[] loginDates = new String[] {
                "05/26"
        };
        int sol = test03.solution(startDate, endDate, loginDates);
        System.out.println(sol);

    }

    // 윤달이 존재하지 않는 년도로 임시 처리 한다.
    private final String SLASH = "/";
    private final String SPLIT_CHAR = " ";
    private final int YEAR = 2022;
    private final int INDEX_DATE = 0;
    private final int INDEX_DAY = 1;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private final String DATE_FORMAT = "%s/%s";

    private enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }


    public int solution(String start_date, String end_date, String[] login_dates){
        int answer = -1;

        String[] startDateAr = start_date.split(SPLIT_CHAR);
        LocalDate startDate = LocalDate.parse(String.format(DATE_FORMAT, YEAR, startDateAr[INDEX_DATE]), formatter);
        LocalDate endDate = LocalDate.parse(String.format(DATE_FORMAT, YEAR, end_date), formatter);

        Arrays.sort(login_dates);

        LocalDate predate = null;
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < login_dates.length; i++) {

            LocalDate date = LocalDate.parse(String.format(DATE_FORMAT, YEAR, login_dates[i]), formatter);
            Day day = getDay(startDate, startDateAr[1], date);
            if(Day.SAT == day || Day.SUN == day) {
                continue;
            }

            if (predate == null) {
                predate = date;
                count ++;
                continue;
            }

            int betweenLength = 1 ;
            if( Day.MON == day ) {
                betweenLength = 3;
            }

            if (date.getDayOfYear() - predate.getDayOfYear() == betweenLength) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            predate = date;
        }

        answer = Math.max(maxCount, count);

        return answer;
    }

    public Day getDay(LocalDate startDate, String startDayString, LocalDate date){

        int between = date.getDayOfYear() - startDate.getDayOfYear();


        Day startDay = Day.valueOf(startDayString);
        Day thisDay = Day.values()[(startDay.ordinal() + between) % Day.values().length];


        return thisDay;
    }


}
