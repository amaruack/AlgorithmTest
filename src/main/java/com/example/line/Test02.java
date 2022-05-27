package com.example.line;

import java.util.*;

public class Test02 {

    static List<Set<Integer>> cluster = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        List<int[]> relations = new LinkedList<>();
        for (int i = 0; i < size ; i++) {
            relations.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

//        int size = 6;
//        List<int[]> relations = new LinkedList<>();
//        relations.add(new int[]{1,3});
//        relations.add(new int[]{3,4});
//        relations.add(new int[]{5,6});
//        relations.add(new int[]{11,15});
//        relations.add(new int[]{12,17});
//        relations.add(new int[]{12,15});

        int[] peoples = relations.stream().flatMapToInt(m -> Arrays.stream(m)).distinct().toArray();
        Arrays.sort(peoples);
        for (int i = 0; i < peoples.length ; i++) {
            if (contains(peoples[i]) < 0) {
                Set<Integer> set = new HashSet<>();
                cluster.add(set);
                set.add(peoples[i]);
                search(relations, peoples[i], contains(peoples[i]));
            }
        }
        System.out.println(cluster.size());
    }

    public static void search(List<int[]> relations, int targetPeople, int clusterIndex){
        for (int i = 0; i < relations.size() ; i++) {

            // 양쪽다 존재하면
            if (relations.get(i)[0] == targetPeople) {
                if (!cluster.get(clusterIndex).contains(relations.get(i)[1])){
                    cluster.get(clusterIndex).add(relations.get(i)[1]);
                    search(relations, relations.get(i)[1], clusterIndex);
                }
            } else if (relations.get(i)[1] == targetPeople) {
                if (!cluster.get(clusterIndex).contains(relations.get(i)[0])){
                    cluster.get(clusterIndex).add(relations.get(i)[0]);
                    search(relations, relations.get(i)[0], clusterIndex);
                }
            }
        }
    }

    public static int contains(int people){
        for (int i = 0; i < cluster.size(); i++) {
            if (cluster.get(i).contains(people)){
                return i;
            }
        }
        return -1;
    }

}
