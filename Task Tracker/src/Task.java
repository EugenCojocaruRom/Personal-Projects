public class Task {
    //Declare variable 'id' of type int - for task ID
    private int id;
    //Declare variable 'title' of type String - for task title
    private String title;
    //Declare variable 'priority' of type Priority
    private Priority priority;
    //Declare variable 'completed' of type boolean - returns true/false
    private boolean completed;

    //Add constructor to initialize the variables (and be able to access them from Main)
    public Task(int id, String title, Priority priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        //Set the default value of 'completed' to false
        this.completed = false;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    //Setter for task status
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //Overriding the status, for filtering purposes
    @Override
    public String toString() {
        String status;
        if (completed) {
            status = "COMPLETED";
        }
        else {
            status = "NOT COMPLETED";
        }
        return "Task #" + id + " - " + title + " - " + priority + " - " + status;
    }
}
