package com.example.nexon;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Solution {

    public static void main(String[] args) throws IOException {

        String filePath = "D:\\02.STSWork\\99.TEST\\Algorithm\\AlgorithmTest\\src\\main\\java\\com\\example\\nexon\\input002.txt";
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int cCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> c = IntStream.range(0, cCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(Collectors.toList());

        int xCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> x = IntStream.range(0, xCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int yCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> y = IntStream.range(0, yCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int qCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> q = IntStream.range(0, qCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(Collectors.toList());


        long start = System.currentTimeMillis();

        List<String> result = Nearest6.closestStraightCity(c, x, y, q);

        long end = System.currentTimeMillis();

        System.out.println(end - start);

//        bufferedWriter.write(
//            result.stream()
//                .collect(joining("\n"))
//            + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}