package thoth.tasks;

public class Todo extends Task {

    protected String by;

    public Todo(String description) {
        super(description);
    }

    @Override
    public String getTaskString() {
        return "[T]" + super.getTaskString();
    }
}

