package com.example.programmers.kakao2018;

import java.util.*;

public class Example04 {

    /*

    프렌즈4블록
블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 "프렌즈4블록".
같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.

board map
만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다. 같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.

board map

블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.

board map

만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.
board map

위 초기 배치를 문자로 표시하면 아래와 같다.

TTTANT
RRFACC
RRRFCC
TRRRAA
TTMMMF
TMMTTJ
각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다

입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.

입력 형식
입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
2 ≦ n, m ≦ 30
board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.
출력 형식
입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.

입출력 예제
m	n	board	answer
4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]	14
6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15
예제에 대한 설명
입출력 예제 1의 경우, 첫 번째에는 A 블록 6개가 지워지고, 두 번째에는 B 블록 4개와 C 블록 4개가 지워져, 모두 14개의 블록이 지워진다.
입출력 예제 2는 본문 설명에 있는 그림을 옮긴 것이다. 11개와 4개의 블록이 차례로 지워지며, 모두 15개의 블록이 지워진다.

     */

    public static void main(String[] args) {

        Example04 test = new Example04();

        System.out.println(test.solution(4,5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));

    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // space char 선언 // 제거된 곳을 해당 char로 처리
        char spaceChar = ' ';
        // spring -> char array 로 변환
        char[][] changeBoard = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length ; i++) {
            changeBoard[i] = board[i].toCharArray();

        }

        // 복제
        char[][] copied = changeBoard.clone();

        // 반복
        while (true) {

            // 매칭 큐생성
            LinkedList<Integer[]> matchs = new LinkedList<>();

            // 4개가 매칭 되는거를 찾는다. , 연속된 케릭터 있는 경우 아래와 비교
            for (int i = 0; i < copied.length - 1  ; i++) {

                char[] row = copied[i];

                for (int j = 0; j < row.length - 1 ; j++) {

                    char st = row[j];
                    char next = row[j+1];
                    // 여기서 연속인거 조사
                    if (st == next && st != spaceChar ) {
                        // 같다면 아래쪽도 같은지 조사해야됨
                        char[] downRow = copied[i+1];
                        char downSt = downRow[j];
                        char downNext = downRow[j+1];
                        if (st == downSt && next == downNext ) {
                            // 여기서 매칭 되는 좌표 저장 i , j
                            matchs.offer(new Integer[]{i,j});
                        }
                    }
                }
            }

            // 매칭된 거 제거 .. 빈값 ? 이던지 아니면 따로 처리
            if (matchs.size() > 0) {

                // 매칭 케릭터 삭제
                while (true) {
                    Integer[] match = matchs.poll();

                    if (match == null) {
                        break;
                    }

                    int mr = match[0];
                    int mc = match[1];
                    // 매칭 char -> space char 로 변환
                    copied[mr][mc] = spaceChar;
                    copied[mr][mc+1] = spaceChar;
                    copied[mr+1][mc] = spaceChar;
                    copied[mr+1][mc+1] = spaceChar;
                }

                // 삭제되면 내리기 // 내리기는 아래부터 진행 한다.
                for (int i = copied.length - 1; i >= 0 ; i--) {

                    char[] row = copied[i];

                    for (int j = 0; j < row.length; j++) {
                        // 아래쪽이 spaceChar일 경우 내리기
                        if (row[j] == spaceChar) {
                            for (int k = i ; k >= 0; k--) {
                                if (copied[k][j] != spaceChar) {
                                    // 아래 쪽으로 싹 내리기
                                    row[j] = copied[k][j];
                                    copied[k][j] = spaceChar;
                                    break;
                                }
                            }
                        }
                    }
                }

            } else {

                // 삭제된 거 count
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n ; j++) {
                        if (copied[i][j] == spaceChar) {
                            answer++;
                        }
                    }
                }

                // 매칭된거가 없다면 break
                break;
            }
        }
        return answer;
    }
}
