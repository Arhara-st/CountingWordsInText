package org.example.service.operations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
import java.util.Scanner;

public class WordCounter {
    private final Map<String, Integer> wordToCount = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void getTextAndUpdateWordCount() {
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        addTextInWordToCountMap(text);
        printOneWordStatistics(text);
    }

    public void init() {
        while (true) {
            System.out.println("Введите команду:\n");
            String str = scanner.nextLine();
            switch (str) {
                case "all" -> printAllStatistics();
                case "init" -> getTextAndUpdateWordCount();
                case "exit" -> {
                    return;
                }
            }
        }
    }

    public void printAllStatistics() {
        getSortedMap(wordToCount);
    }

    public void printOneWordStatistics(String text) {
        Map<String,Integer> wordCountTemp = new HashMap<>();
        textToMap(text, wordCountTemp);
        getSortedMap(wordCountTemp);
    }

    public void addTextInWordToCountMap(String text) {
        textToMap(text, wordToCount);
    }

    public void getSortedMap(Map<String,Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public void textToMap(String text, Map<String,Integer> map) {
        String[] words = text.split(" ");
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

}
