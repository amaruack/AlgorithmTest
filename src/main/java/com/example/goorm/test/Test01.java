package com.example.goorm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test01 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String vArgs = br.readLine();
        String[] vArr =  vArgs.split(" ");

        int winCount = 0;
        for (String v : vArr) {
            int coins = Integer.parseInt(v);
            int mod = coins % 2;
            if (mod == 1) {
                winCount++;
            }
        }

        int gameCount = Integer.parseInt(t);

        if (gameCount < winCount*2) {
            System.out.println(winCount);
        } else if (gameCount == winCount*2) {
            System.out.println("tie");
        } else {
            System.out.println(gameCount - winCount);
        }

        // 승자는 마지막 가저간사람
        // 구르미 친구 모두 최선의 선택



//        1 개 혹은 3개 가져감

//        System.out.println("Hello Goorm! Your input is " + t + vArgs);
    }

}
