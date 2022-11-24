package com.han;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test02 {

    public static void main(String[] args) {


        Test02 test02 = new Test02();
        System.out.println(test02.solution(new int[] {1,3,7,8,10,15}, 3));
        System.out.println(test02.solution(new int[] {1,2,12,14,15}, 2));


    }

    public int solution(int[] scores, int k) {
        int answer = -1;

        // 가장 차이가 큰거 로 나눔
        // index 와 비교값 넣어 놔야 됨
        PriorityQueue<Data> queue = new PriorityQueue<>();

        if (scores.length <= 1 ){
            return 0;
        }
        // queue에 넣기
        for (int i = 0; i < scores.length-1; i++) {
            int between = scores[i+1] - scores[i];
            queue.offer(new Data(i, between));
        }

        int[] splitIndexs = new int[k-1];
        for (int i = 0; i < splitIndexs.length; i++) {
            Data data = queue.poll();
            splitIndexs[i] = data.getIndex();
        }

        Arrays.sort(splitIndexs);

        int startIndex = 0;
        int sum = 0;
        for (int i = 0; i < splitIndexs.length; i++) {
            int between = scores[splitIndexs[i]] - scores[startIndex];
            sum += between;
            startIndex = splitIndexs[i]+1;
        }
        // 마지막 넣어줘야하나 ?
        sum += scores[scores.length-1] - scores[startIndex];
        answer = sum;
        return answer;
    }

}

class Data implements Comparable<Data> {

    public Data(int index, int between) {
        this.index = index;
        this.between = between;
    }

    private int between;
    private int index;

    public int getBetween() {
        return between;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Data o) {
        int result = Integer.compare(o.between, this.between);
        if (result == 0) {
            result = Integer.compare(this.index, o.index);
        }
        return result;
    }
}

