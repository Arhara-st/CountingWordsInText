package org.example.service;

import org.example.service.operations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandProcessor {
    private Scanner scanner;
    private Map<String, Command> commands = new HashMap<>();

    public CommandProcessor() {
        commands.put("all", new PrintAllTextCommand());
        commands.put("stat", new PrintWordAndStatCommand());
        commands.put("exit", new ExitOperation());
        commands.put("init", new InitTextCommand());
        commands.put("help", new HelpCommand());
        scanner = new Scanner(System.in);
    }

    public void init() {
        while (true) {
            System.out.println("Введите команду:\n");
            Command command = commands.get(scanner.nextLine());
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Команда не найдена, попробуйте help - список команд");
            }
        }
    }
}
