package org.example.service.operations;

/*
Печать всех текстов
 */

public class PrintAllTextCommand extends CountingWordsGeneralMethods implements Command {

    @Override
    public void execute() {
        CountingWordsGeneralMethods.printAllTexts();

    }


}
