package todo;

public class Task {
    protected String description;
    protected boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
