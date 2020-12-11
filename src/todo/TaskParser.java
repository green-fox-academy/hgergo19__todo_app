package todo;
import java.util.ArrayList;
import java.util.List;

public class TaskParser {
    private ReadWrite fileIO = new ReadWrite();
    private List<Task> tasks = new ArrayList<>();

    public TaskParser() {
        parseContent();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private void parseContent() {
        fileIO.read();
        for (String content : fileIO.getContentLines()) {
            String[] tmp = content.split(";");
            tasks.add(new Task(tmp[0], Boolean.parseBoolean(tmp[1])));
        }
    }

    public void refillContentLines() {
        fileIO.contentLines = new ArrayList<>();
        for (Task task : tasks) {
            fileIO.contentLines.add(task.getDescription() + ";" + task.isCompleted());
        }
        fileIO.write();
    }
}

