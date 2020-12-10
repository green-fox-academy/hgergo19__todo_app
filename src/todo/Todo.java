package todo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Todo {
    List<Task> listOfTasks;
    static Map<String, String> arguments = new LinkedHashMap(4, .75F);


    public static void checkArgument(String[] args) {
        fillArguments();
        if (args.length == 0) {
            printInstructions();
        } else if (!arguments.containsKey(args[0])) {
            throw new UnsupportedOperationException();
        }

    }

    private static void printInstructions() {
        System.out.println("Command Line Todo application " +
                "\n============================= \n" +
                "\nCommand line arguments:");
        for (Map.Entry<String, String> entry : arguments.entrySet()) {
            System.out.println("\t" + entry.getKey() + "\t" + entry.getValue());
        }
    }

    private static void fillArguments() {
        arguments.put("-l", "Lists all the tasks");
        arguments.put("-a", "Adds a new task");
        arguments.put("-r", "Removes a task");
        arguments.put("-c", "Completes a task");
    }

}
