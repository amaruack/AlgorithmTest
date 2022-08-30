package com.example.programmers.skilltest.level3_3.level3_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

public class Test02 {

    public static void main(String[] args) {

        Test02 test = new Test02();
        test.solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});

    }

    final int START_INDEX = 0;
    final int END_INDEX = 1;

    public int[] solution(String[] gems) {
        int[] answer = {};

        List<String> distinctGems = Arrays.stream(gems).distinct().collect(Collectors.toList());
        int distinctGemSize = distinctGems.size();

        if (distinctGemSize == 1 || distinctGemSize == gems.length) {
            return new int[] {1, distinctGemSize};
        }

        int index = 0;
        int startIndex = 0;
        int endIndex = 0;
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Set<String> insertGems = new HashSet<>();

        int resultStartIndex = 0;
        int resultEndIndex = 0;
        int resultLength = gems.length;

        while (true) {
            if (insertGems.size() < distinctGemSize) {
                String currentGem = gems[endIndex];
                queue.offer(currentGem);
                insertGems.add(currentGem);
                endIndex++;
            } else {
                int length = endIndex - startIndex;
                if (resultLength > length) {
                    resultStartIndex = startIndex;
                    resultEndIndex = endIndex;
                }

                String leftData = queue.peek();

                while (leftData.equals(queue.peek())) {
                    queue.poll();
                    startIndex++;
                }
            }
            if (endIndex == gems.length) {
                break;
            }
        }

        return answer;
    }

}
