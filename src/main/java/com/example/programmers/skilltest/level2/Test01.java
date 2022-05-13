package com.example.programmers.skilltest.level2;

import java.util.LinkedList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {

        Test01 test = new Test01();
        System.out.println(test.solution("FRANCE", "french"));
        System.out.println(test.solution("aa1+aa2", "AAAA12"));

    }

    final char LOWER_A = 'a';
    final char LOWER_Z = 'z';
    final char UPPER_A = 'A';
    final char UPPER_Z = 'Z';

    public int solution(String str1, String str2) {
        int answer = 0;
        // 우선 분리

        List<String> str1List = split(str1);
        List<String> str2List = split(str2);

        int sumCount = str1List.size() + str2List.size();

        // 비교
        // 교집합 합집합
        List<String> interList = new LinkedList<>();
        for (int i = 0; i < str1List.size(); i++) {
            if (str2List.contains(str1List.get(i)) ){
                interList.add(str1List.get(i));
                str2List.remove(str1List.get(i));
            }
        }
        int interCount = interList.size();

        // 합집합은 전체 - 교집합

        int unionCount = sumCount - interCount;

        if (interCount ==0 && unionCount == 0) {
            return 65536;
        }

        double same =  (double) interCount / unionCount;
        answer =  (int) (same * 65536);
        return answer;
    }

    // lower case
    public List<String> split (String str) {
        List<String> strList = new LinkedList<>();
        for (int i = 0; i < str.length()-1; i++) {
            String tmp = str.substring(i, i+2);
            char[] tmpAr = tmp.toCharArray();
            boolean flag = true;
            for (int j = 0; j < tmpAr.length; j++) {
                if (!( (LOWER_A <= tmpAr[j] && tmpAr[j] <= LOWER_Z)
                        || (UPPER_A <= tmpAr[j] && tmpAr[j] <= UPPER_Z) )
                ) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                strList.add(tmp.toLowerCase());
            }
        }
        return strList;
    }

}
