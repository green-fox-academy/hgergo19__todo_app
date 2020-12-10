package todo;

import java.io.Serializable;

public class Task implements Serializable {
    private String description;
    private boolean isCompleted;

    public Task(String description, boolean isCompleted) {
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public void setCompleted() {
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDescription() {
        return description;
    }



    @Override
    public String toString() {
        return  description + isCompleted;
    }
}
