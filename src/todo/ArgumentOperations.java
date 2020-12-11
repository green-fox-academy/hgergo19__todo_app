package todo;

public abstract class ArgumentOperations {

    public static void addTask(String[] args, TaskParser parser) {
        if (args.length == 1) {
            System.out.println("Unable to add: no task provided");
        } else {
            parser.getTasks().add(new Task(args[1], false));
            parser.refillContentLines();
            Printer.successfulOperation("Add task");
        }
    }

    public static void completeTask(String[] arg, TaskParser parser) {
        if (arg.length == 1) {
            System.out.println("Unable to check: no index provided");
        } else if (isNumber(arg[1])) {
            System.out.println("Unable to remove: index is not a number");
        } else if (Integer.parseInt(arg[1]) > parser.getTasks().size()) {
            System.out.println("Unable to remove: index is out of bound");
        } else {
            parser.getTasks().get(Integer.parseInt(arg[1]) - 1).setCompleted();
            parser.refillContentLines();
            Printer.successfulOperation("Complete task " + (Integer.parseInt(arg[1])) + "; ");
        }
    }

    public static void removeTask(String[] args, TaskParser parser) {
        if (args.length == 1) {
            System.out.println("Unable to remove: no index provided!");
        } else if (isNumber(args[1])) {
            System.out.println("Unable to remove: index is not a number");
        } else if (Integer.parseInt(args[1]) > parser.getTasks().size()) {
            System.out.println("Unable to remove: index is out of bound");
        } else {
            parser.getTasks().remove(Integer.parseInt(args[1]) - 1);
            parser.refillContentLines();
            Printer.successfulOperation("Remove task " + (Integer.parseInt(args[1])) + "; ");
        }
    }

    public static boolean isNumber(String arg) {
        try {
            Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

}
