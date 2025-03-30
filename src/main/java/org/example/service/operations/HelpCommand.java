package org.example.service.operations;

public class HelpCommand implements Command {

    @Override
    public void execute() {
        System.out.println("**********************************");
        System.out.println("Список команд:");
        System.out.println("1. Ввести текст - init");
        System.out.println("2. Печать всех текстов - all");
        System.out.println("3. Печать статистики по всем текстам - stat");
        System.out.println("4. Выход - exit");
        System.out.println("**********************************");
    }
}
