package com.example.programmers.skilltest.level3_2;

import java.util.Arrays;

public class Test02 {

    public static void main(String[] args) {
        Test02 test = new Test02();

        String[] enroll = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = new String[]{"young", "john", "tod", "emily", "mary"};
        int[] amount = new int[]{12, 4, 2, 5, 10};

        test.solution(enroll, referral, seller, amount);
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int sum = 0;
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int sellerMoney = amount[i] * 100;
            sum += rootAmount(enroll, referral, answer, sellerName, sellerMoney );
        }
        return answer;
    }

    final String root = "-";

    public int rootAmount(String[] enroll, String[] referral, int[] answer, String name, int money) {
        int result = 0;
        if (money == 0) {
            return 0;
        }
        if (root.equals(name)) {
            return money;
        }
        int index = getIndex(enroll, name);
        String nextParentName = referral[index];

        int upper = money/10;
        int mine = money - upper;

        answer[index] += mine;

        return rootAmount(enroll, referral, answer, nextParentName, upper);
    }

    public int getIndex(String[] enroll, String name){
        for (int i = 0; i < enroll.length; i++) {
            if (enroll[i].equals(name)){
                return i;
            }
        }
        return 0;
    }

}
