import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Open keyboard
        Scanner sc = new Scanner(System.in);
        //Display the title of the app
        System.out.println("=== TASK TRACKER ===");
        //Display the app options
        System.out.println("""
                1. Add task
                2. Mark task as completed
                3. Show all tasks
                4. Show incomplete tasks
                5. Show HIGH priority tasks
                0. Exit""");
        //Add separator
        System.out.println("--------------------");
        //Declare variable 'option' of type int and initialize it
        int option = 0;
        //Declare variable 'task' of type int and initialize it
        Task task = null;
        //Create a loop for returning to the options menu after each action (except Exit)
        while (option != -1) {
            //Prompt the user to select an option
            System.out.print("Select option: ");
            //Declare variable of type int and read it from the keyboard
            option = sc.nextInt();
            //Call method for selecting the option
            selectOption(option, sc);
        }
    }

    //Add tasks to the list
    static Map<Integer, Task> tasks = new HashMap<>();

    //Add titles to the tasks
    static Set<String> taskTitles = new HashSet<>();

    //Display and filter tasks
    static List<Task> displayTask = new ArrayList<>(tasks.values());


    //Method for processing the option selected by the user
    public static void selectOption(int option, Scanner sc) {
            switch (option) {
                case 1:
                    System.out.println("You chose option #" + option);
                    addTask(sc);
                    break;
                case 2:
                    System.out.println("You chose option #" + option);
                    markTaskCompleted(sc);
                    break;
                case 3:
                    System.out.println("You chose option #" + option);
                    showAllTasks();
                    break;
                case 4:
                    System.out.println("You chose option #" + option);
                    incompleteTasks();
                    break;
                case 5:
                    System.out.println("You chose option #" + option);
                    highPriority();
                    break;
                case 6:
                    System.out.println("You chose option #" + option);
                    deleteTask(sc);
                    break;
                case 7:
                    System.out.println("You chose option #" + option);
    //                sortTasks();
                    break;
                case 8:
                    System.out.println("You chose option #" + option);
    //                completeAndIncomplete();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
    }

    //Method for adding a task (ID + title + priority)
    static void addTask(Scanner sc) {
        //Enter task ID
        System.out.print("Enter task ID: ");
        int taskID = sc.nextInt();
        sc.nextLine();
        //Check if the ID already exists
        if (tasks.containsKey(taskID)) {
            //Display message for the user
            System.out.println("A task with ID #" + taskID + " already exists. Enter a different ID.");
            //Exit the if statement and return to options
            return;
        }
        //Enter task description
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        //Check if the title already exists
        if (taskTitles.contains(title)) {
            //Display message for the user
            System.out.println("A task with this title already exists. Please enter a different title.");
            //Exit the if statement and return to options
            return;
        }
        //Enter task priority
        System.out.print("Enter task priority (LOW, MEDIUM, HIGH): ");
        String setPriority = sc.nextLine().toUpperCase();
        //Get the value from the Enum class
        Priority priority = Priority.valueOf(setPriority);
        //Set the 'completed' status to default value 'false'
        boolean completed = false;
        //Declare new task with parameters ID, title, priority and status
        Task task = new Task(taskID, title, priority, completed);
        //Add task to the map
        tasks.put(taskID, task);
        //Confirm successful 'add task' operation
        System.out.println("Task added successfully: ID: " + taskID + " | Title: " + title + " | Priority: " + priority);
    }

    //Method for marking a task as completed
    static void markTaskCompleted(Scanner sc) {
        //Display prompt for getting a task
        System.out.print("Enter task ID: ");
        int taskID = sc.nextInt();
        sc.nextLine();
        //Retrieve task by ID and display it
        Task task = tasks.get(taskID);
        //Check that the task exists
        if (task == null) {
            //Display notification - task does not exist
            System.out.println("The task with ID #" + taskID + " does not exist!");
            return;
        }
        else {
            //Display the task if the ID exists
            System.out.println(task);
        }
        //Retrieve 'completed' status and display it
        System.out.println("Is task completed? - " + task.isCompleted());
        //Display prompt for changing the task status to 'completed'
        System.out.println("Change task status (true/false): ");
        //Declare variable 'status' of type string and read it from the keyboard
        String status = sc.nextLine();
        //Set the condition for checking if the value entered is "true"
        if (status.equalsIgnoreCase("true")) {
            //Set the status to 'completed' by accessing the setter in the Task class
            task.setCompleted(!task.isCompleted());
            //Display message for the user
            System.out.println("Task marked as completed.");
        }
        else {
            //Set the status to 'not completed' by accessing the setter in the Task class
            task.setCompleted(task.isCompleted());
            //Display message for the user
            System.out.println("Task marked as not completed.");
        }
    }

    //Method for displaying all the tasks
    static void showAllTasks() {
        //Check that there are tasks to display
        if (tasks.isEmpty()) {
            //Display message for the user
            System.out.println("There are no tasks to display.");
        }
        else {
            System.out.println("--- ALL TASKS ---");
            //Loop through the values and display all the existing tasks
            for (Task task : tasks.values()) {
                //Display the tasks(s)
                System.out.println("ID: " + task.getId() + " | Title: " + task.getTitle() +
                        " | Priority: " + task.getPriority() + " | Completed: "+ task.isCompleted());
            }
        }
    }

    //Method for displaying only the tasks that are not completed
    static void incompleteTasks() {
        //Check that there are tasks to display
        if (tasks.isEmpty()) {
            //Display message for the user
            System.out.println("There are no tasks to display.");
        }
        else {
            System.out.println("--- INCOMPLETE TASKS ---");
        }
        //Loop through the values and display all the incomplete tasks
        for (Task task : tasks.values()) {
            if (!task.isCompleted()) {
                //Display the tasks(s)
                System.out.println("ID: " + task.getId() + " | Title: " + task.getTitle() +
                        " | Priority: " + task.getPriority() + " | Completed: "+ task.isCompleted());
            }
//            else {
//                //Display message for the user
//                System.out.println("All the tasks have been completed");
//            }
        }
    }

    //Method for displaying HIGH priority tasks
    static void highPriority() {
        //Check that there are tasks to display
        if (tasks.isEmpty()) {
            //Display message for the user
            System.out.println("There are no tasks to display.");
        }
        else {
            System.out.println("--- HIGH PRIORITY TASKS ---");
        }
        //Loop through the values of the tasks map
        for (Task task : tasks.values()) {
            //Check if the task priority is HIGH
            if (task.getPriority() == Priority.HIGH) {
                //Display the tasks(s)
                System.out.println("ID: " + task.getId() + " | Title: " + task.getTitle() +
                        " | Priority: " + task.getPriority() + " | Completed: "+ task.isCompleted());
            }
        }
        //Display message for the user
//        System.out.println("There are no HIGH priority tasks.");
    }

    //Method for deleting a task
    static void deleteTask(Scanner sc) {
        //Display message for the user
        System.out.print("Enter the ID of the task to be deleted: ");
        //Declare variable of type int and read it from the keyboard
        int taskID = sc.nextInt();
        sc.nextLine();
        //Retrieve task by ID and display it
        Task task = tasks.get(taskID);
        //Check that the task exists
        if (task == null) {
            //Display notification - task does not exist
            System.out.println("The task with ID #" + taskID + " does not exist!");
            return;
        }
        else {
            //Display the task if the ID exists
            System.out.println(task);
        }
        //Delete the task
        tasks.remove(taskID);
        //Display message for the user
        System.out.println("The task has been deleted successfully.");
    }

    //Extra methods:
        //Delete task --> DONE
        //Sort tasks based on priority
        //Completed vs incomplete tasks
        //Input validation --> TO DO for ID, title, priority and status
}