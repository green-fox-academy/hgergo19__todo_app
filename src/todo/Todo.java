package todo;

import java.util.*;

public abstract class Todo {
    static Map<String, String> arguments = new LinkedHashMap(4, .75F);
    static TaskParser parser = new TaskParser();
    private static final List<String> longCommands = new ArrayList<>(Arrays.asList("-list", "-listAll", "-add", "-remove", "-complete"));

    public static void checkArgument(String[] args) {
        fillArguments();
        if (args.length == 0) {
            Printer.printInstructions(arguments);
        } else if (!arguments.containsKey(args[0]) && (!longCommands.contains(args[0]))) {
            System.out.println("Unsupported Argument: " + args[0]);
        } else {
            if (args[0].equals("-l") || args[0].equals("-list")) {
                Printer.printUndone(parser);
            } else if (args[0].equals("-la") || args[0].equals("-listAll")) {
                Printer.printInfo(parser);
            } else if (args[0].equals("-a") || args[0].equals("-add")) {
                ArgumentOperations.addTask(args, parser);
            } else if (args[0].equals("-r") || args[0].equals("-remove")) {
                ArgumentOperations.removeTask(args, parser);
            } else {
                ArgumentOperations.completeTask(args, parser);
            }
        }
    }

    private static void fillArguments() {
        arguments.put("-l", "(-list) Lists the undone tasks");
        arguments.put("-la", "(-listAll) Lists all tasks");
        arguments.put("-a", "(-add) Adds a new task");
        arguments.put("-r", "(-remove) Removes a task");
        arguments.put("-c", "(-complete) Completes a task");
    }


}
