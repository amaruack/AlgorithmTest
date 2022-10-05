package com.example.kakao;

import javax.print.attribute.IntegerSyntax;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test03 {

    public static void main(String[] args) {


        List<Integer> answer = Test03.solution(
                4,
                Arrays.asList(new String[]{"Friend","Friend","Friend","Friend","Total","Total"}),
                Arrays.asList(new Integer[]{1,3,4,4,7,1}),
                Arrays.asList(new Integer[]{2,4,4,4,7,3})
        );


    }


    static Map<Integer, TreeSet<Integer>> index = new ConcurrentHashMap<>();

    static final String FRIEND_QUERY = "Friend";
    static final String TOTAL_QUERY = "Total";

    public static List<Integer> solution(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here

        List<Integer> answer = new LinkedList<>();

        for (int i = 0; i < queryType.size(); i++) {

            Integer student1 = students1.get(i);
            Integer student2 = students2.get(i);

            TreeSet<Integer> student1Group = getGroup(student1);
            TreeSet<Integer> student2Group = getGroup(student2);

            if (FRIEND_QUERY.equals(queryType.get(i))) {
                // 둘다 아닐 경우 새로운 그룹
                if (student1Group.size() == 0 && student2Group.size() == 0) {
                    TreeSet<Integer> newGroup = new TreeSet<>();
                    newGroup.add(student1);
                    newGroup.add(student2);

                    index.put(student1, newGroup);
                    index.put(student2, newGroup);
                // 1개라도 있을 경우 해당 그룹으로 join
                } else if (student1Group.size() == 0 && student2Group.size() != 0 ) {
                    student2Group.add(student1);
                    index.put(student1, student2Group);
                } else if (student1Group.size() != 0 && student2Group.size() == 0 ) {
                    student1Group.add(student2);
                    index.put(student2, student1Group);
                // 둘다 있으면 합
                } else {
                    // 같은 그룹인지 확인
                    if (!student1Group.first().equals(student2Group.first())){
                        student1Group.addAll(student2Group);
                        for (Integer stu : student2Group) {
                            index.put(stu, student1Group);
                        }
                    }
                }

            } else if (TOTAL_QUERY.equals(queryType.get(i))) {

                if (student1Group.size() == 0 && student2Group.size() == 0) {
                    answer.add(2);
                } else if (student1Group.size() == 0 && student2Group.size() != 0 ) {
                    answer.add(student2Group.size() + 1);
                } else if (student1Group.size() != 0 && student2Group.size() == 0 ) {
                    answer.add(student1Group.size() + 1);
                } else {
                    // 같은 그룹인지 판별
                    if (student1Group.first().equals(student2Group.first())){
                        answer.add(student1Group.size());
                    } else {
                        answer.add(student1Group.size() + student2Group.size());
                    }
                }
            }
        }
        return answer;
    }

    private static TreeSet<Integer> getGroup(Integer student){
        return index.getOrDefault(student, new TreeSet<>());
    }

}
