package com.example.trip;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 버튼을 눌러 시험을 시작하세요!
 * Reinvent travel by connecting every travel experience 🛫 우리는 모든 경험을 연결하여 여행을 혁신합니다.
 * 마이리얼트립은 여행을 떠나기 위해 필요한 모든 것을 한 곳에서 검색하고 예약할 수 있는 국내 최고의 Travel Super App입니다.
 * 2012년 가이드 투어 서비스를 시작으로 2016년 숙박, 2018년 항공, 2019년 패키지까지 출시하며 여행에 필요한 모든 경험을 고객에게 제공하고 있습니다.
 * 마이리얼트립은 차별화된 기술을 바탕으로 새로운 여행 방식을 만들어가고, 코로나 시대 이후의 여행을 준비하고 있습니다.
 * 마이리얼트립은 2018년 거래액 1,300억 원, 2019년 3,600억 원을 달성해 매년 300%씩 고속 성장을 지속해왔습니다.
 * 또한 이러한 성과를 바탕으로 알토스벤처스,스마일게이트인베스트먼트,IMM인베스트먼트와 같은 국내외 유수의 투자사로부터 누적 총 824억 원의 자금을 유치했습니다.
 * 마이리얼트립은 코로나 19 이후 여행이 멈춘 상황에서도 새로운 기회와 성장을 만들어냈습니다. 모두에게 어려운 시간이었지만, 우리에겐 판을 바꿀 기회가 되었습니다.
 * 여행은 돌아오고 있고, 우리는 폭발적 성장을 앞두고 있습니다. 마이리얼트립은 유례없이 큰 기회를 마주할 준비를 마쳤습니다. 함께 날아오를 당신을 기다립니다. 지금 탑승하세요!
 */
public class Test01 {

    private static final String FORMAT_STR = "%s (%d)";

    public static void main(String[] args) {

//        int n = 0;
//        String[] logs = new String[]{
////               "SMS 010-1234-5678"
//        };
        int n = 6;
        String[] logs = new String[]{
                "CALL 010-5555-5555",
                "CALL 010-5555-5555",
                "CALL 010-5555-5555",
                "CALL 010-5555-5555",
                "CALL 010-5555-5555",
                "CALL 010-5555-5555"
        };

        List<String> result = new LinkedList<>();

        if (n > 0) {
            String pre = logs[0];
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (pre.equals(logs[i])){
                    count++;
                } else {
                    if (count != 1) {
                        result.add(String.format(FORMAT_STR, pre, count));
                    } else {
                        result.add(pre);
                    }
                    pre = logs[i];
                    count = 1;
                }
            }

            // last index
            if (count != 1) {
                result.add(String.format(FORMAT_STR, pre, count));
            } else {
                result.add(pre);
            }
        }

        System.out.println(result.size());
        for(String log : result) {
            System.out.println(log);
        }

    }
}
