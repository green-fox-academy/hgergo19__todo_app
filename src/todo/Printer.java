package todo;

import java.util.List;
import java.util.Map;

public abstract class Printer {
    static private String checkBox;

    public static void printInfo(TaskParser parser) {

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

    public static void printUndone(TaskParser parser) {
        System.out.println("Undone tasks: ");
        List<Task> tasks = parser.getTasks();
        if (tasks.size() == 0) {
            System.out.println("No todos for today! :)");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            if (!tasks.get(i).isCompleted()) {
                checkBox = "[ ]";
                stringBuilder.append(i + 1).append(" - ").append(checkBox).append(" ").append(tasks.get(i).getDescription()).append("\n");
            }

        }
        System.out.println("\n" + stringBuilder);
    }

    public static void successfulOperation(String operation) {
        System.out.println(operation + " operation finished successfully!");
    }

    public static void printInstructions(Map<String, String> arguments) {
        System.out.println();
        System.out.println();
        System.out.println("Command Line Todo application " +
                "\n============================= \n" +
                "\nCommand line arguments:");
        for (Map.Entry<String, String> entry : arguments.entrySet()) {
            System.out.println("\t" + entry.getKey() + "\t" + entry.getValue());
        }
    }

}
