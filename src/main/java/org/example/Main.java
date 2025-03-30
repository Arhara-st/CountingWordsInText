package org.example;

import org.example.service.CommandProcessor;

public class Main {
    public static void main(String[] args) {
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.init();
    }
}