package org.example.service.operations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
import java.util.Scanner;

public class WordCounter {
    private Map<String, Integer> wordCount = new HashMap<>();
    private Scanner scanner;


    //ввод текста в консоле
    public void init() {
        scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        addText(text);
        printOneWordStatistics(text);
    }

    public void initMain() {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду:\n");
            String str = scanner.nextLine();
            switch (str) {
                case "all" -> printAllStatistics();
                case "init" -> init();
                case "exit" -> System.exit(0);
            }
        }
    }

    public void printAllStatistics() {
        wordCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public void printOneWordStatistics(String text) {
        Map<String,Integer> wordCountTemp = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            wordCountTemp.put(word, wordCountTemp.getOrDefault(word, 0) + 1);
        }
        wordCountTemp.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
    public void addText(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }

}
