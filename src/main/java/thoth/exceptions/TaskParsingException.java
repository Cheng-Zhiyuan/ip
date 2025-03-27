package thoth.exceptions;

public class TaskParsingException extends RuntimeException {
  public TaskParsingException(String message) {
    super(message);
  }
}
