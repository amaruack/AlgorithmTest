package com.example.emart;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Emart2 {
    /*



     */

    public static void main(String[] args) {
        List<Tv> tvs = new ArrayList<>();
        List<Electronics> electronics = tvs.stream().collect(Collectors.toList());
        electronics.add(new Tv());
        electronics.add(new Radio());

    }
}