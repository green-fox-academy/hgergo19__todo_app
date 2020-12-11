package todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite {
    static final Path path = Paths.get("C:\\Users\\gerik\\Desktop\\greenfox\\hgergo19__todo_app\\src\\todo\\files\\tasks.txt");
    protected List<String> contentLines;

    public ReadWrite() {
        contentLines = new ArrayList<>();
    }

    public List<String> getContentLines() {
        return contentLines;
    }

    public void read() {
        try {
            contentLines.addAll(Files.readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            Files.write(path, contentLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
