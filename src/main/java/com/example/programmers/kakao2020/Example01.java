package com.example.programmers.kakao2020;

import java.util.LinkedList;
import java.util.List;

public class Example01 {
    /**
     * 문제 설명
     * 데이터 처리 전문가가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
     * 간단한 예로 "aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, "abcabcdede"와 같은 문자열은 전혀 압축되지 않습니다. "어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.
     *
     * 예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.
     *
     * 다른 예로, "abcabcdede"와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 "abcabc2de"가 되지만, 3개 단위로 자른다면 "2abcdede"가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.
     *
     * 압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * s의 길이는 1 이상 1,000 이하입니다.
     * s는 알파벳 소문자로만 이루어져 있습니다.
     * 입출력 예
     * s	result
     * "aabbaccc"	7
     * "ababcdcdababcdcd"	9
     * "abcabcdede"	8
     * "abcabcabcabcdededededede"	14
     * "xababcdcdababcdcd"	17
     * 입출력 예에 대한 설명
     * 입출력 예 #1
     *
     * 문자열을 1개 단위로 잘라 압축했을 때 가장 짧습니다.
     *
     * 입출력 예 #2
     *
     * 문자열을 8개 단위로 잘라 압축했을 때 가장 짧습니다.
     *
     * 입출력 예 #3
     *
     * 문자열을 3개 단위로 잘라 압축했을 때 가장 짧습니다.
     *
     * 입출력 예 #4
     *
     * 문자열을 2개 단위로 자르면 "abcabcabcabc6de" 가 됩니다.
     * 문자열을 3개 단위로 자르면 "4abcdededededede" 가 됩니다.
     * 문자열을 4개 단위로 자르면 "abcabcabcabc3dede" 가 됩니다.
     * 문자열을 6개 단위로 자를 경우 "2abcabc2dedede"가 되며, 이때의 길이가 14로 가장 짧습니다.
     *
     * 입출력 예 #5
     *
     * 문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
     * 따라서 주어진 문자열을 x / ababcdcd / ababcdcd 로 자르는 것은 불가능 합니다.
     * 이 경우 어떻게 문자열을 잘라도 압축되지 않으므로 가장 짧은 길이는 17이 됩니다.
     */

    public static void main(String[] args) {

//        getCount("aaaaaaaaaabababaaaa", 2);

//        "aabbaccc"	7
//        "ababcdcdababcdcd"	9
//        "abcabcdede"	8
//        "abcabcabcabcdededededede"	14
//        "xababcdcdababcdcd"	17

//        String s = "aabbaccc";

        Example01 test = new Example01();

        System.out.println(test.solution("aabbaccc"));
        System.out.println(test.solution("xababcdcdababcdcd"));

    }

    public int solution(String s) {
        int answer = 0;

        // 전체 길이의 절반의 길이 만큼은 가야됨
        int halfCount = s.length()/2;

        if (halfCount == 0){
            return s.length();
        }

        int min = s.length();

        //  index + 1 로  count 처리
        for (int i = 0; i < halfCount ; i++) {
            int count = getCount(s, i+1);
            if (min > count) {
                min = count;
            }
        }
        answer = min;
        return answer;
    }

    public static int getCount(String s, int sCount){
        int result = 0;

        int totalCount = s.length();
        // 압축 길이 만큼 앞의 캐릭터가 반복하는지 본다.
//        if (sCount == 1) {
//            return totalCount;
//        }

        int loof = s.length()/sCount;
        if (s.length()%sCount != 0) {
            loof ++;
        }

        // sub list 만들기
        List<String> subList = new LinkedList<>();
        for (int i = 0; i < loof; i++) {
            int last = (i+1)*sCount;
            if (last > totalCount) {
                subList.add(s.substring(i*sCount, totalCount));
            } else {
                subList.add(s.substring(i*sCount, (i+1)*sCount));
            }
        }

        // 뭉치기

        List<MergeObject> merge = new LinkedList<>();

        for (int i = 0; i < subList.size(); i++) {
            if (i == 0){
                MergeObject tmp = new MergeObject();
                tmp.setS(subList.get(i));
                merge.add(tmp);
            } else {
                MergeObject tmp = merge.get(merge.size()-1);
                if (tmp.getS().equals(subList.get(i))){
                    tmp.plus();
                } else {
                    MergeObject tmp2 = new MergeObject();
                    tmp2.setS(subList.get(i));
                    merge.add(tmp2);
                }
            }
        }

        // count 하기
        int sum = 0;
        for (int i = 0; i < merge.size(); i++) {
            MergeObject mergeObject = merge.get(i);
            if (mergeObject.getC() == 1) {
                sum += mergeObject.getS().length();
            } else {
                sum += String.valueOf(mergeObject.getC()).length();
                sum += mergeObject.getS().length();
            }
        }

        result = sum;
        return result;
    }

    public static class MergeObject {
        public String s ;
        public int c = 1;

        public void plus(){
            c++;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }

}
