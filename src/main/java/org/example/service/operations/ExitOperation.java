package org.example.service.operations;

public class ExitOperation implements Command {

    @Override
    public void execute() {
        System.out.println("Bye!");
        System.exit(0);
    }

}
