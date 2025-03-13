# Thoth User Guide
Thoth Task Manager is a command-line application designed to help you manage your daily tasks efficiently. It supports adding todos, deadlines, and events, as well as marking tasks as done, unmarking them, deleting tasks, and searching for tasks. This README provides an overview of the application, installation instructions, usage details, and troubleshooting tips.

Thoth Task Manager enables you to manage three main types of tasks:

- **Todos:** Simple tasks that need to be done.
- **Deadlines:** Tasks that must be completed by a specific date/time.
- **Events:** Tasks that occur within a specified time range.

Users interact with the application via a command-line interface (CLI) by entering commands that the system parses and executes. Each command is processed through a central parser that maps user input to the corresponding functionality. 

When you start Thoth Task Manager, you will be greeted with a welcome message followed by a prompt where you can enter your commands. The application continuously listens for your input until you choose to exit.

## Available Commands
### Exiting the Application: _bye_

The bye command terminates the application gracefully. It prints a goodbye message to indicate that the session is closing.

Syntax: 
```
    bye
```  
Example code:   
```
    bye
```
Sample output: 
```
    Bye. Hope to see you again soon!
```

### Listing the Task Lists: _list_

The list command prints the list of the users to the screen of the CLI software

Syntax: 
```
    list
```
Example code: 
```
    list
```
Sample output:
```
    1. [T][ ] eat 
    2. [T][ ] sleep 
    3. [T][ ] repeat
``` 
### Adding a todo task : _todo_
The `todo` command adds a new simple task without any associated deadline or time.  

Syntax: 
```
    todo TASK_DESCRIPTION
```  
Example code: 
```
    todo work on CS2113 IP
```
Sample output:
```
    Got it. I've added this task:
    [T][ ] work on CS2113 IP
    Now you have 4 tasks in the list.
```
### Adding a deadline task : _deadline_
The `deadline` command creates a task with a deadline. Both a task description and a deadline time must be specified.

Syntax: 
```
    deadline TASK_DESCRIPTION /by DEADLINE_TIME
```  
Example code: 
```
    deadline work on CS2113 IP /by tody 2359
```
Sample output: 
```
    Got it. I've added this task:
    [D][ ] work on CS2113 IP (by: today 2359)
    Now you have 5 tasks in the list.
```
### Adding a event task : _event_ 
The `event` command schedules a task that occurs during a specified time range. The task description, start and end time of the event must be specified.

Syntax: 
```
    event TASK_DESCRIPTION /from START_TIME /to END_TIME
```  
Example code: 
```
    event work on CS2113 IP /from 13/03/2025 12 noon /to 13/03/2025 4 pm
```
Sample output: 
```
    Got it. I've added this task:
    [E][ ] work on CS2113 IP (from: 13/03/2025 12 noon to: 13/03/2025 4 pm)
    Now you have 6 tasks in the list.
```
### Marking a task as Done: _mark_
The `mark` command sets a task's status to the done state.  

Syntax: 
```
    mark TASK_LIST_INDEX
```
Example code: 
```
    mark 1
```
Sample Output:
```
    Nice! I've marked this task as done:
    [T][X] eat
```
### Marking a task as Not Done: _unmark_
The `unmark` command reverts a task's status back to the not done state.  
Syntax:
```
    unmark TASK_LIST_INDEX
```
Example code:
```
    unmark 1
```
Sample Output:
```
    OK, I've marked this task as not done yet:
    [T][ ] eat
```
### Deleting a task from the task list: _delete_
The `delete` command removes a specified task from your list.   

Syntax:
```
    detele TASK_LIST_INDEX
```
Example code:
```
    delete 2
```
Sample Output:
```
    Noted. I've removed this task:
    [T][ ] sleep
    Now you have 5 tasks in the list.
```
### Finding tasks with a string: _find_ 
The `find` command searches for tasks containing a specified keyword (case-insensitive) and displays the matching tasks.    

Syntax:
```
    find KEYWORD
```
Example code:
```
    find CS2113
```
Sample Output:
```
    Here are the matching tasks:
    1. [T][ ] work on CS2113 IP
    2. [D][ ] work on CS2113 IP (by: today 2359)
    3. [E][ ] work on CS2113 IP (from: 13/03/2025 12 noon to: 13/03/2025 4 pm)
```
