package org.example.service.operations;


import java.util.*;
import java.util.stream.Collectors;

public class CountingWordsGeneralMethods {

    private List<String> textList = new ArrayList<>();
    private Map<String, String> textAndCountWords = new HashMap<>();
    private int countText = 1;
    private Scanner scanner;


    //подсчет слов в одном тексте
    public String countWords(String text){
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Object::toString)
                .collect(Collectors.joining(",", "{", "}\n"));
    }

    //подсчет слов во всех текстах
    public void countWordsAllText() {
        String textArray[] = textList.toArray(String[]::new);
        String result = Arrays.stream(textArray)
                .collect(Collectors.joining(" "));
        System.out.println(countWords(result));
    }

    //сохранение текста и частоты слов
    public void processSavedTexts(String wordStatistics) {
        String textNumber = countText + " Текст\n";
        textAndCountWords.put(textNumber, wordStatistics);
        countText++;
    }

    //вывод всех текстов и частоты слов
    public void printAllTexts() {
        System.out.println("Все тексты: \n" + textAndCountWords);
    }

    //ввод текста в консоле
    public String inputTextInConsole() {
        scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        return scanner.nextLine();
    }

    public void initMain() {
        CountingWordsGeneralMethods counting = new CountingWordsGeneralMethods();
        scanner  = new Scanner(System.in);
        while (true) {

            System.out.println("Введите команду:\n");
            String str = scanner.nextLine();
            switch (str) {
                case "stat" -> counting.printAllTexts();
                case "all" -> counting.countWordsAllText();
                case "init" -> counting.init();
                case "exit" -> System.exit(0);
            }

        }
    }
    public void init() {
        String text = inputTextInConsole();
        String wordsCount = countWords(text); // анализ и статистика текста
        System.out.println(wordsCount);
        textList.add(text);
        processSavedTexts(wordsCount);
    }


}
