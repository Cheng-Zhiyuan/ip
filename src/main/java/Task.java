public class Task {
    //parameters for checking and unchecking tasks
    public static final String EMPTY_BOX = "[ ]";
    public static final String MARKED_BOX = "[X]";

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }

    public String getTaskString() {
        String statusIcon = isDone ? MARKED_BOX : EMPTY_BOX;
        return statusIcon + " " + description;
    }

    public String getDescription() {
        return description;
    }
}
