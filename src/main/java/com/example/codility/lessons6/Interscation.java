package com.example.codility.lessons6;

import java.util.HashSet;
import java.util.Set;

public class Interscation {
    public static void main(String[] args) {


//        4+4+2+1
//        양 끝점 중 하나가 지름 안에 있어야 한다.
//        계산을 계속 해야됨 ???
        // 0,2 / 0,4                    2
        // 1,0, / 1,2 / 1,3 / 1,4 / 1,5 5
        // 2,3                          1
        //
        // 4,2 / 4,3 / 4,5              3
        //

        // 앞뒤로 체크 하면 뒤에 가서 체크할 필요가 없다 ?
        // 이중 포문은 돌아야함
//          ( O * M )

//        A[0] = 1
//        A[1] = 5
//        A[2] = 2
//        A[3] = 1
//        A[4] = 4
//        A[5] = 0

        Interscation test = new Interscation();
        int result = test.solution(new int[] {1,5,2,1,4,0});
//        int result = test.solution(new int[] {1,1,1});
        System.out.println(result);

    }
    int salt = 100000;
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0 ;

        //서로 체크 이후
//        center at (J, 0)
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length-1 ; i++) {
            for (int j = i+1; j < A.length ; j++) {
                // 중심점 차이보다 // 반지름의 합이 크면
                if ( (j-i) <= (A[j] + A[i])) {
                    set.add( i * salt + j );
                }
            }
        }

        result = set.size();
        return result;
    }

}
