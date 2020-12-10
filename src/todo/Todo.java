package todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Todo {
    static final Path path = Paths.get("C:\\Users\\gerik\\Desktop\\greenfox\\hgergo19__todo_app\\src\\todo\\files\\tasks.txt");

    static List<String> listOfTasks = new ArrayList<>();
    static List<Task> tasks = new ArrayList<>();
    static Map<String, String> arguments = new LinkedHashMap(4, .75F);


    public static void checkArgument(String[] args) {
        readFile();
        fillArguments();
        if (args.length == 0) {
            printInstructions();
        } else if (!arguments.containsKey(args[0])) {
            throw new UnsupportedOperationException();
        } else {
            if (args[0].equals("-l")) {
                String tmp = listOfTasks.size() == 0 ? "No todos for today! :)" : printTasks();
                System.out.println(tmp);
            } else if (args[0].equals("-a")) {
                listOfTasks.add(new Task(args[1]).toString());
                writeFile();
            }
        }
    }

    private static void writeFile() {
        try {
            Files.write(path, listOfTasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String printTasks() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < listOfTasks.size(); i++) {
            tmp.append(i).append(" - ").append(listOfTasks.get(i)).append("\n");
        }
        return tmp.toString();
    }

    private static void readFile() {
        try {
            listOfTasks = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
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
