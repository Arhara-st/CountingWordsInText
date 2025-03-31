package org.example.service.operations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnotherMethod {
    private Map<String, Map<String, Integer>> textAndStat = new HashMap<>(); // {text 1, {word1 = 1}}
    private Scanner scanner;
    private int count = 1;

    public void init() {
        String text = inputTextInConsole();
        countWordsWithoutSum(text);
    }

    //ввод текста в консоле
    public String inputTextInConsole() {
        scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        return scanner.nextLine();
    }

    //всех текстов
    public void countWordsAllTextSum() {

        Map<String, Integer> flatMap = textAndStat.values().stream()
                .flatMap(innerMap -> innerMap.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println(flatMap);
    }

    public void countWordsWithoutSum(String text) {
        String[] words = text.split(" ");
        String countText = "Текст " + count;
        count++;
        textAndStat.putIfAbsent(countText, new HashMap<>());
        Map<String, Integer> wordCountMap = textAndStat.get(countText);

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        textAndStat.replaceAll((text1, wordMap) ->
                wordMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ))
        );
        System.out.println(textAndStat);
    }

    public void initMain() {
        AnotherMethod another = new AnotherMethod();
        scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Введите команду:\n");
            String str = scanner.nextLine();
            switch (str) {
                case "all" -> another.countWordsAllTextSum();
                case "init" -> another.init();
                case "exit" -> System.exit(0);
            }
        }
    }
}
