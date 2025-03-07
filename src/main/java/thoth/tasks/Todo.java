package thoth.tasks;

public class Todo extends Task {

    protected String by;

    /**
     * constructs a todo tak with the specified description
     *
     * @param description the description of the todo task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the todo task including its type
     *
     * @return a formatted task string with the type
     */
    @Override
    public String getTaskString() {
        return "[T]" + super.getTaskString();
    }
}

