import todo.Todo;

public class TodoApp {
    public static void main(String[] args) {
        Todo todo = new Todo();
        todo.checkArgument(args);
    }
}
