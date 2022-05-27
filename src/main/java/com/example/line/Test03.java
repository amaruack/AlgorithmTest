package com.example.line;

import java.util.*;
import java.util.stream.Collectors;

public class Test03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        String a = sc.next();
        String a = "180888";

        search(a, 0, new LinkedList<>());

        Collections.sort(ipv4s, Comparator.comparing((List<String> o) -> o.get(0))
                .thenComparing(o -> o.get(1))
                .thenComparing(o -> o.get(2))
                .thenComparing(o -> o.get(3))
        );

        System.out.println(ipv4s.size());
        for (int i = 0; i < ipv4s.size(); i++) {
            System.out.println(String.join(".", ipv4s.get(i)));
        }

    }
    public static int ipv4 = 4;
    //
    public static int length = 3;
    public static int IP_MAX = 255;

    public static List<List<String>> ipv4s = new LinkedList<>();

    public static void search(String ipstr, int index, List<String> ip) {


        if (ip.size() == ipv4 ) {
            if(ipstr.length() > index) {
                // 남아잇으므로 무시
            } else {
                ipv4s.add(ip);
            }
            return;
        }



        for (int i = 1; i <= length; i++) {

            List<String> clone = new ArrayList<>(ip);

            if (index + i  > ipstr.length()) {
                return;
            }

            String tmpNumber = ipstr.substring(index, index+i);
            if (tmpNumber.startsWith("0") && tmpNumber.length() > 1 ) {
                return;
            }
            if (Integer.parseInt(tmpNumber) > IP_MAX ){
                return;
            }

            clone.add(tmpNumber);
            search( ipstr, index + i, clone);
        }
    }

}
