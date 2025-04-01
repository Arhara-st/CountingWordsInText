package org.example;

import org.example.service.operations.WordCounter;

public class Main {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();
        counter.init();
    }

}