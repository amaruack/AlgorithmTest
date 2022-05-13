package com.example.programmers.exercise.dfs;

public class Ndisplay {

    public static void main(String[] args) {
        Ndisplay test = new Ndisplay();
//        System.out.println(test.solution(5, 12));
//        System.out.println(test.solution(1, 1));
//        System.out.println(test.solution(11, 1));
        System.out.println(test.solution(4, 31));
    }


    int minCount = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        int answer = 0;
        // 처음은 count1
        recursive(1, N, N, number, 0);
        answer = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return answer;
    }

    public void recursive(int count, int pre, int N, int number, int powCount) {
        if (count > 8) {
            return;
        }

        if (pre == number) {
            minCount = Math.min(minCount, count);
            return;
        }


//    4, 31, 3
//    (4+4)*4-(4/4)
        // 아그래서 여기서 for 문이 들어가는구나 !

        count++;
        // +
        recursive(count, pre + N, N, number, 0);
        // -
        recursive(count, pre - N, N, number, 0);
        // *
        recursive(count, pre * N, N, number, 0);
        // /
        recursive(count, (int)(pre / N), N, number, 0);
        // pow
        // 이전이 pow 였나 아니였냐 중요하네
        recursive(count, pre + N * (int)Math.pow(10, powCount+1) , N, number, powCount+1);

    }
}
