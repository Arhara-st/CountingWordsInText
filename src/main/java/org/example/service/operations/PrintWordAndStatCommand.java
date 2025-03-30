package org.example.service.operations;


public class PrintWordAndStatCommand implements Command {

    @Override
    public void execute() {
        CountingWordsGeneralMethods.countWordsAllText(InitTextCommand.textList);
    }
}
