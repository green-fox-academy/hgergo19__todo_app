package todo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Todo {


    Map<String, String> arguments = new LinkedHashMap(4, .75F);
    TaskParser parser = new TaskParser();
    String checkBox = "";


    public void checkArgument(String[] args) {
        fillArguments();
        if (args.length == 0) {
            printInstructions();
        } else if (!arguments.containsKey(args[0])) {
            throw new UnsupportedOperationException();
        } else {
            if (args[0].equals("-l")) {
                listTasks();
            } else if (args[0].equals("-a")) {
                if (args.length == 1) {
                    System.out.println("Unable to add: no task provided");
                } else {
                    addTask(args[1]);
                }//TODO : Exception handling
            } else if (args[0].equals("-r")) {
                removeTask(args[1]);
            } else if (args[0].equals("-c")) {
                completeTask(args[1]);
            }
        }
    }

    private void completeTask(String arg) {
        parser.getTasks().get(Integer.parseInt(arg) - 1).setCompleted();
        parser.refillContentLines();
        successfulOperation();
    }

    private void addTask(String arg) {
        parser.getTasks().add(new Task(arg, false));
        parser.refillContentLines();
        successfulOperation();
    }

    private void removeTask(String arg) {
        parser.getTasks().remove(Integer.parseInt(arg) - 1);
        parser.refillContentLines();
        successfulOperation();
    }

    private void listTasks() {
        List<Task> tasks = parser.getTasks();
        if (tasks.size() == 0) {
            System.out.println("No todos for today! :)");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isCompleted()) {
                checkBox = "[X]";
            } else {
                checkBox = "[ ]";
            }
            stringBuilder.append(i + 1).append(" - ").append(checkBox).append(" ").append(tasks.get(i).getDescription()).append("\n");

        }
        System.out.println("\n" + stringBuilder);
    }

    private void successfulOperation() {
        System.out.println("Operation finished successfully!");
    }

    private void printInstructions() {
        System.out.println();
        System.out.println();
        System.out.println("Command Line Todo application " +
                "\n============================= \n" +
                "\nCommand line arguments:");
        for (Map.Entry<String, String> entry : arguments.entrySet()) {
            System.out.println("\t" + entry.getKey() + "\t" + entry.getValue());
        }
    }

    private void fillArguments() {
        arguments.put("-l", "Lists all the tasks");
        arguments.put("-a", "Adds a new task");
        arguments.put("-r", "Removes a task");
        arguments.put("-c", "Completes a task");
    }


}
