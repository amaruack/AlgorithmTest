package com.example.methodreference.staticmethod;


import java.util.function.Consumer;

class TestPrivate {

    public static final String TEST = "";
    Consumer<String> consumer = Printer::printSomething;
}


