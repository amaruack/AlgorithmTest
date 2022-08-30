package com.example.emart;

public class Emart1 {
    public static void main(String[] args) {

        Emart1 emart1 = new Emart1();
        System.out.println(emart1.solution("3(hi)"));
        System.out.println(emart1.solution("aaaz3(hi)bbbb"));
        System.out.println(emart1.solution("2(3(hi)co)"));
//        System.out.println(emart1.solution("2(2(hi)2(co))x111(bo)"));

    }

    private final String BRACKET_START = "(";
    private final String BRACKET_END = ")";

    private final char NUMBER_CHAR_START = '0';
    private final char NUMBER_CHAR_END = '9';

    public String solution(String compressed) {
        String answer = compressed;

        while (answer.contains(BRACKET_START)) {

            int bracketEnd = answer.indexOf(BRACKET_END);
            int bracketStart = answer.substring(0, bracketEnd).lastIndexOf(BRACKET_START);

            String start = answer.substring(0, bracketStart);
            // count 를 처리해야됨
            String length = "";
            for (int i = start.length()-1; i >= 0; i--) {
                if (NUMBER_CHAR_START <= start.charAt(i) && start.charAt(i) <= NUMBER_CHAR_END ) {
                    length = start.charAt(i) + length;
                } else {
                    break;
                }
            }
            start = start.substring(0, start.length() - length.length());
            String middle = answer.substring(bracketStart + 1, bracketEnd);
            String end = answer.substring(bracketEnd + 1);

            StringBuilder sb = new StringBuilder();
            sb.append(start);
            for (int i = 0; i < Integer.parseInt(length) ; i++) {
                sb.append(middle);
            }
            sb.append(end);

            answer = sb.toString();

        }


        return answer;
    }


//    public String solution(String compressed) {
//        String answer = "";
//        char[] chars = compressed.toCharArray();
//
//        StringBuilder front = new StringBuilder();
//        StringBuilder middle = new StringBuilder();
//        StringBuilder end = new StringBuilder();
//
//        compressed.substring()
//
//        int flag = 0;
//
//        int bracket = 0;
//
//        for (int i = 0 ; i < chars.length ; i++ ) {
//
//            if (flag == 0) {
//                front.append(chars[i]);
//            } else if (flag == 1) {
//                middle.append(chars[i]);
//            } else if (flag == 2) {
//                end.append(chars[i]);
//            }
//
//            if ('0' <= chars[i] && chars[i] <= '9' && ) {
//
//            }
////
////            } else if ('(' == chars[i] ){
////                flag++; // start
////            } else if (')' == chars[i] ){
////
////            } else {
////                front.append(chars[i]);
////            }
//        }
//        return answer;
//    }
//
//    public String decompressed(int count, String compressed, String front, String end) {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(front);
//        for (int i = 0 ; i < count ; i++) {
//            sb.append(compressed);
//        }
//        sb.append(end);
//
//        if (compressed.contains("(")){
//
//        }
//
//        return "";
//    }

}
