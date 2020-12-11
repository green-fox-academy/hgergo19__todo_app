package todo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Todo {


    Map<String, String> arguments = new LinkedHashMap(4, .75F);
    TaskParser parser = new TaskParser();


    public void checkArgument(String[] args) {
        fillArguments();
        if (args.length == 0) {
            Printer.printInstructions(arguments);
        } else if (!arguments.containsKey(args[0])) {
            System.out.println("Unsupported Argument: " + args[0]);
        } else {
            if (args[0].equals("-l")) {
                Printer.printInfo(parser);
            } else if (args[0].equals("-a")) {
                addTask(args);
            } else if (args[0].equals("-r")) {
                removeTask(args);
            } else if (args[0].equals("-c")) {
                completeTask(args);
            }
        }
    }

    private void completeTask(String[] arg) {
        if (arg.length == 1) {
            System.out.println("Unable to check: no index provided");
        } else if (isNumber(arg[1])) {
            System.out.println("Unable to remove: index is not a number");
        } else if (Integer.parseInt(arg[1]) > parser.getTasks().size()) {
            System.out.println("Unable to remove: index is out of bound");
        } else {
            parser.getTasks().get(Integer.parseInt(arg[1]) - 1).setCompleted();
            parser.refillContentLines();
            Printer.successfulOperation();
        }
    }

    private void addTask(String[] args) {
        if (args.length == 1) {
            System.out.println("Unable to add: no task provided");
        } else {
            parser.getTasks().add(new Task(args[1], false));
            parser.refillContentLines();
            Printer.successfulOperation();
        }
    }

    private void removeTask(String[] args) {
        if (args.length == 1) {
            System.out.println("Unable to remove: no index provided!");
        } else if (isNumber(args[1])) {
            System.out.println("Unable to remove: index is not a number");
        } else if (Integer.parseInt(args[1]) > parser.getTasks().size()) {
            System.out.println("Unable to remove: index is out of bound");
        } else {
            parser.getTasks().remove(Integer.parseInt(args[1]) - 1);
            parser.refillContentLines();
            Printer.successfulOperation();
        }
    }

    private boolean isNumber(String arg) {
        try {
            Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private void fillArguments() {
        arguments.put("-l", "Lists all the tasks");
        arguments.put("-a", "Adds a new task");
        arguments.put("-r", "Removes a task");
        arguments.put("-c", "Completes a task");
    }


}
