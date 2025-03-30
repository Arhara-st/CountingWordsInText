package org.example.service.operations;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingWordsGeneralMethods {

    private static Map<String, String> textAndCountWords = new HashMap<>();
    private static int countText = 1;

    //подсчет слов в одном тексте
    public static String countWords(String text){
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
    public static void countWordsAllText(List<String> textList) {
        String textArray[] = textList.toArray(String[]::new);
        String result = Arrays.stream(textArray)
                .collect(Collectors.joining(" "));
        System.out.println(countWords(result));
    }

    //сохранение текста и частоты слов
    public static void processSavedTexts(String wordStatistics) {
        String textNumber = countText + " Текст\n";
        textAndCountWords.put(textNumber, wordStatistics);
        countText++;
    }

    //вывод всех текстов и частоты слов
    public static void printAllTexts() {
        System.out.println("Все тексты: \n" + textAndCountWords);
    }



}
