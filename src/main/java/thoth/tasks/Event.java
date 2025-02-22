package thoth.tasks;

public class Event extends Task {

    protected String to;
    protected String from;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTaskString() {
        return "[E]" + super.getTaskString() + " (from: " + from +" to: " + to + ")";
    }
}
