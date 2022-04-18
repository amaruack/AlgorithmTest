package com.example.programmers.exercise.dfs;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class TripPath {

    public class Path {

        public Path(String start, String end) {
            this.start = start;
            this.end = end;
        }

        private String start;
        private String end;



        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

//        @Override
//        public int hashCode() {
//            return start.hashCode()+end.hashCode();
//        }
    }
//[['ICN','AAA'],['ICN','AAA'],['ICN','AAA'],['AAA','ICN'],['AAA','ICN']]
    public static void main(String[] args) {

//        [[], [], [], [], [], [], [], [], []]
//["ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"]
//        [["ICN", "AOO"], ["AOO", "BOO"], ["BOO", "COO"], ["COO", "DOO"], ["DOO", "EOO"], ["EOO", "DOO"], ["DOO", "COO"], ["COO", "BOO"], ["BOO", "AOO"]]
//["ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"]

        String[][] paths = new String[][]{
                new String[]{"ICN", "AOO"},
                new String[]{"AOO", "BOO"},
                new String[]{"BOO", "COO"},
                new String[]{"COO", "DOO"},
                new String[]{"DOO", "EOO"},

                new String[]{"EOO", "DOO"},
                new String[]{"DOO", "COO"},
                new String[]{"COO", "BOO"},
                new String[]{"BOO", "AOO"}

        };
//                new String[]{"ICN", "SFO"},
//                new String[]{"ICN", "ATL"},
//                new String[]{"SFO", "ATL"},
//                new String[]{"ATL", "ICN"},
//                new String[]{"ATL", "SFO"}};
        TripPath test = new TripPath();
        test.solution(paths);

    }

    private final int START = 0;
    private final int END = 1;
    private final String START_CITY = "ICN";

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        // 데이터 정렬을 먼져 해버리면 ?
        // map queue???

        List<String[]> ticketList = new ArrayList<String[]>();

        for (int i = 0; i < tickets.length ; i++) {
            ticketList.add(tickets[i]);
        }

        Collections.sort(ticketList, (o1, o2) -> {
            int result = o1[START].compareTo(o2[START]);
            if (result == 0) {
                result = o1[END].compareTo(o2[END]);
            }
            return result;
        });

        List<String> path = new ArrayList<>();
        boolean[] check = new boolean[ticketList.size()];
        path.add(START_CITY);

        bfs(ticketList, check, path, 0);

        if (paths.size() > 0) {
            Optional<String> tmp = paths.stream().map(o -> String.join(",",o)).sorted().findFirst();
            answer = tmp.get().split(",");
        }
        return answer;
    }

    private static List<List<String>> paths = new ArrayList<>();

    public void bfs(List<String[]> ticketList, boolean[] check, List<String> path, int index) {
        for (int i = 0; i < ticketList.size() ; i++) {
            if ( !check[i] && ticketList.get(i)[START].equals(path.get(index))) {
                List<String> clonePath = new ArrayList<>(path);
                boolean[] cloneCheck = Arrays.copyOf(check , check.length);

                clonePath.add(index+1, ticketList.get(i)[END]);
                cloneCheck[i] = true;
                bfs(ticketList, cloneCheck, clonePath, index+1);
            }
        }
        if (index == ticketList.size()) {
            paths.add(path);
        }
    }




    // RUNTIME error
//    public String[] solution(String[][] tickets) {
//        String[] answer = {};
//
//        // 데이터 정렬을 먼져 해버리면 ?
//        // map queue???
////        List<List<String>> ticketList = new ArrayList<>();
//        Map<String, PriorityQueue<String>> ticketMap = new HashMap();
//        for (int i = 0; i < tickets.length ; i++) {
//            PriorityQueue<String> tmp = ticketMap.get(tickets[i][START]);
//            if (tmp == null) {
//                tmp = new PriorityQueue<String>();
//                ticketMap.put(tickets[i][START], tmp);
//            }
//            tmp.offer(tickets[i][END]);
//        }
//
//        List<String> path = new ArrayList<>();
//        int count = 0;
//        path.add("ICN");
//        while (count < tickets.length) {
//            PriorityQueue<String> queue = ticketMap.get(path.get(path.size()-1));
//            path.add(queue.poll());
//            count ++;
//        }
//
//        answer = path.toArray(new String[]{});
//
//        return answer;
//    }

}
