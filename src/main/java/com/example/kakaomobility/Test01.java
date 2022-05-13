package com.example.kakaomobility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("s-s-s".replace("-", ""));
        System.out.println("s-s-s".replaceAll("-", ""));
        Test01 test = new Test01();
        System.out.println(test.solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, s na-m-estest", "Example"));
    }

    private final String PREFIX = "<";
    private final String SUFFIX = ">";
    private final String SPACE = " ";
    private final String DASH = "-";
    private final String SPLIT = ", ";

    public String solution(String S, String C) {
        // write your code in Java SE 8
        String result = "";
        String[] names = S.split(SPLIT);

        Map<String, Integer> nameCountMap= new HashMap<>();

        // make domain
        String domain = new StringBuilder()
                .append("@")
                .append(C.toLowerCase())
                .append(".com").toString();

        List<String> mails = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {

            StringBuilder sb = new StringBuilder();

            // name
            String name = names[i];
            sb.append(name);
            sb.append(SPACE);
            sb.append(PREFIX);

            // email id
            String emailId = makeEmailId(name);
            sb.append(emailId);

            // email id count
            int nameCount = nameCountMap.getOrDefault(emailId, 0);
            nameCount++;
            nameCountMap.put(emailId, nameCount);
            if (nameCount > 1) {
                sb.append(nameCount);
            }

            //add domain
            sb.append(domain);
            sb.append(SUFFIX);

            mails.add(sb.toString());
        }

        //split join
        result = String.join(SPLIT, mails);
        return result;
    }

    public String makeEmailId (String name) {
        // make email id
        StringBuilder emailIdSb= new StringBuilder();
        String[] nmAr = name.split(SPACE);
        String firstName = null;
        String middleName = null;
        String lastName = null;
        // size 2 // 중간 이름 없음
        if (nmAr.length == 2) {
            firstName = nmAr[0];
            lastName = nmAr[1];
            // size 3 // 중간 이름 있음
        } else if (nmAr.length == 3) {
            firstName = nmAr[0];
            middleName = nmAr[1];
            lastName = nmAr[2];
        }
        emailIdSb.append(firstName.substring(0,1).toLowerCase());
        if (middleName != null) {
            emailIdSb.append(middleName.substring(0,1).toLowerCase());
        }
        if (lastName.toLowerCase().replace(DASH, "").length() > 8){
            emailIdSb.append(lastName.toLowerCase().replace(DASH, "").substring(0, 8));
        } else {
            emailIdSb.append(lastName.toLowerCase().replace(DASH, ""));
        }

        return emailIdSb.toString();
    }

//    public String makeEmailName()


}
