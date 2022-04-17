package com.example.methodreference.instancemethod;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String args[]) {
        List<Company> companies = Arrays.asList(new Company("google"),
                new Company("apple"), new Company("samsung"));
        companies.stream().forEach(company -> company.printName());


//  Runnable
//  @FunctionalInterface

        List<Company> companies1 = Arrays.asList(new Company("google"), new Company("apple"), new Company("samsung"));
        companies1.stream().forEach(Company::printName);


        List<String> companies2 = Arrays.asList("google", "apple", "google", "apple", "samsung");
        companies2.stream()
                .mapToInt(String::length) // 람다식: company -> company.length()
                .forEach(System.out::println);
    }
}
