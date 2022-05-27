package com.example.yanolja;



import java.util.*;

public class Test01 {

    public static void main(String[] args) {
        Test01 test = new Test01();
//        int result = test.solution(213);
        int result = test.solution(10242);
        System.out.println(result);
    }

    public int solution(int N) {
        int result = 0;

        // list create
        String intString = String.valueOf(N);
        List<String> list = Arrays.asList(intString.split(""));

        // sort
        Collections.sort(list, Collections.reverseOrder());

        // return string 생성
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < list.size() ; i++) {
//            sb.append(list.get(i));
//        }
//        result = Integer.parseInt(sb.toString());

        result = Integer.parseInt(String.join("",list));

        return result;
    }

}
