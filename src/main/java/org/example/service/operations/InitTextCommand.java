package org.example.service.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.service.operations.CountingWordsGeneralMethods.*;

public class InitTextCommand implements Command {
    static List<String> textList = new ArrayList<>();

    @Override
    public void execute() {
        String text = inputTextInConsole();
        String wordsCount = countWords(text); // анализ и статистика текста
        System.out.println(wordsCount);
        textList.add(text);
        processSavedTexts(wordsCount);
    }

    //ввод текста в консоле
    public static String inputTextInConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String str = scanner.nextLine();
        return str;
    }
}
