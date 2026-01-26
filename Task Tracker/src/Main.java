import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Open keyboard
        Scanner sc = new Scanner(System.in);
        //Display the title of the app
        System.out.println("========================== TASK TRACKER ==========================");
        //Display the app options
        System.out.println("| 1. Add task                   5. Show HIGH priority tasks      |");
        System.out.println("| 2. Mark task as completed     6. Delete task                   |");
        System.out.println("| 3. Show all tasks             7. Sort tasks by priority        |");
        System.out.println("| 4. Show incomplete tasks      8. Completed vs Incomplete tasks |");
        System.out.println("|                           0. Exit                              |");
        System.out.println("==================================================================");

        //Declare variable 'option' of type int and initialize it
        int option = 0;
        //Create a loop for returning to the options menu after each action (except Exit)
        while (option >= 0) {
            //Prompt the user to select an option
            System.out.print(" >> Select option: ");
            //Validate that the input is a number
            while(!sc.hasNextInt()) {
                System.out.println("Invalid input. Please try again.");
                sc.next();
                System.out.print("Select option: ");
            }
            //Read the value of the 'option' variable from the keyboard
            option = sc.nextInt();

            //Call method for selecting the option
            selectOption(option, sc);
        }
    }

    //Add tasks to the list
    static Map<Integer, Task> tasks = new HashMap<>();

    //Add titles to the tasks
    static Set<String> taskTitles = new HashSet<>();

    //Method for processing the option selected by the user
    public static void selectOption(int option, Scanner sc) {
            switch (option) {
                case 1:
                    System.out.println("You selected option #" + option);
                    addTask(sc);
                    break;
                case 2:
                    System.out.println("You selected option #" + option);
                    markTaskCompleted(sc);
                    break;
                case 3:
                    System.out.println("You selected option #" + option);
                    showAllTasks();
                    break;
                case 4:
                    System.out.println("You selected option #" + option);
                    incompleteTasks();
                    break;
                case 5:
                    System.out.println("You selected option #" + option);
                    highPriority();
                    break;
                case 6:
                    System.out.println("You selected option #" + option);
                    deleteTask(sc);
                    break;
                case 7:
                    System.out.println("You selected option #" + option);
                    sortTasksByPriority();
                    break;
                case 8:
                    System.out.println("You selected option #" + option);
                    completeAndIncomplete();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
    }

    //Method for adding a task (ID + title + priority)
    static void addTask(Scanner sc) {
        //Enter task ID
        System.out.print("Enter task ID: ");
        //Validate that the input is a number
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please try again.");
            sc.next();
            //Prompt the user to enter an ID
            System.out.print("Enter task ID: ");
        }
        //Declare variable of type int
        int taskID;
        //Start while loop for checking ID uniqueness
        while (true) {
            //Read the value of the variable from the keyboard
            taskID = sc.nextInt();
            sc.nextLine();
            //Check if the ID already exists
            if (tasks.containsKey(taskID)) {
                //Display message for the user and continue the loop until a valid value is entered
                System.out.println("A task with ID #" + taskID + " already exists. Enter a different ID.");
            }
            else {
                //Exit the loop when a valid value is entered
                break;
            }
        }
        //Enter task title
        System.out.print("Enter task title: ");
        //Validate that the title is a string
        while (!sc.hasNextLine()) {
            System.out.println("Invalid input. Please try again.");
            sc.next();
            //Prompt the user to enter a title for the task
            System.out.print("Enter task title: ");
        }
        //Declare variable of type string
        String title;
        //Start while loop for checking ID uniqueness
        while (true) {
            //Read the value of the variable from the keyboard
            title = sc.nextLine();
            //Check if the title already exists
            if (taskTitles.contains(title)) {
                //Display message for the user and continue the loop until a valid title is entered
                System.out.println("A task with this title already exists. Please enter a different title.");
            }
            else {
                //Exit the loop when a valid title is entered
                break;
            }
        }
            //Validating that the value of the priority is entered correctly
        //Declare variable 'priority' and set it to null
        Priority priority = null;
        //Enter the while loop
        while (priority == null) {
            //Display prompt for the user
            System.out.print("Enter task priority (LOW, MEDIUM, HIGH): ");
            //Declare variable of type string and read it from the keyboard, and convert all its characters to uppercase
            String inputPriority = sc.nextLine().toUpperCase();
            //Loop through the values of priority (as defined in the Priority class)
            for (Priority prio : Priority.values()) {
                //Set the condition to check the value entered by the user against all of the values from Priority, disregarding case
                if (prio.name().equalsIgnoreCase(inputPriority)) {
                    //The value entered is validated
                    priority = prio;
                    break;
                }
            }
            //Set condition for entered value not matching any of the values from the Priority class
            if (priority == null) {
                //Display message for the user
                System.out.println("Invalid input. Please enter LOW, MEDIUM or HIGH.");
            }
        }
        //Set the 'completed' status to default value 'false'
        boolean completed = false;
        //Declare new task with parameters ID, title, priority and status
        Task task = new Task(taskID, title, priority, completed);
        //Add task to the map
        tasks.put(taskID, task);
        //Add title to the set
        taskTitles.add(title);
        //Confirm successful 'add task' operation
        System.out.println("Task added successfully: ID: " + taskID + " | Title: " + title + " | Priority: " + priority);
    }

    //Method for marking a task as completed
    static void markTaskCompleted(Scanner sc) {
        //Display prompt for getting a task
        System.out.print("Enter task ID: ");
        //Validate that the input is a number
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please try again.");
            sc.next();
            System.out.print("Enter task ID: ");
        }
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
        //Validate that the value entered is "true" or "false"
        while (!status.equalsIgnoreCase("true") && !status.equalsIgnoreCase("false")) {
            //Display message for the user
            System.out.println("Invalid input. Please use only 'true' / 'false'.");
            //Display prompt for the user
            System.out.println("Change task status (true/false): ");
            //Read the value from the keyboard
            status = sc.next();
        }
        //Set the condition for the behavior when the value entered is 'true'
        if (status.equalsIgnoreCase("true")) {
            //Set the status to 'completed' by accessing the setter in the Task class
            task.setCompleted(true);
            //Display message for the user
            System.out.println("Task marked as completed.");
        }
        //Set the condition for the behavior when the value entered is 'false'
        else if  (status.equalsIgnoreCase("false")) {
            //Set the status to 'not completed' by accessing the setter in the Task class
            task.setCompleted(false);
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
    }

    //Method for deleting a task
    static void deleteTask(Scanner sc) {
        //Check that there are tasks to display
        if (tasks.isEmpty()) {
            //Display message for the user
            System.out.println("There are no tasks to display.");
            return;
        }
        else {
            //Display message for the user
            System.out.print("Enter the ID of the task to be deleted: ");
        }
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

    //Method for sorting the tasks based on priority
    static void sortTasksByPriority() {
        //Create a list that stores the tasks
        List<Task> displayTask = new ArrayList<>(tasks.values());
        //Check if there are values in the list
        if (displayTask.isEmpty()) {
            //Display message for the user
            System.out.println("The task list is empty!");
            return;
        }
        //Sort the tasks by priority using a Comparator
        displayTask.sort(Comparator.comparingInt(task -> task.getPriority().getLevel()));
        //Display label
        System.out.println("=== Tasks sorted by priority ===");
        //Loop through the tasks in the list
        for  (Task task : displayTask) {
            //Print the task
            System.out.println(task);
        }
    }

    //Method for sorting and displaying the number of completed vs incomplete tasks
    static void completeAndIncomplete() {
        //Create the list that stores the tasks
        List<Task> displayTask = new ArrayList<>(tasks.values());
        //Check if there are values in the list
        if (displayTask.isEmpty()) {
            //Display message for the user
            System.out.println("The task list is empty!");
            return;
        }
        //Display label
        System.out.println("=== Number of completed vs not completed tasks ===");
        //Declare list of integers and initialize it -> counter for completed tasks
        List<Integer> completedTasks = new ArrayList<>();
        //Declare list of integers and initialize it -> counter for not completed tasks
        List<Integer> incompleteTasks = new ArrayList<>();
        //Loop through the task list
        for (Task task : displayTask) {
            //Check if the task is completed
            if (task.isCompleted()) {
                //Add to the list the ID of each completed task found
                completedTasks.add(task.getId());
            }
            else  {
                //Add to the list the ID of each not completed task found
                incompleteTasks.add(task.getId());
            }
        }
        //Display the number and IDs of completed and not completed tasks
        System.out.println(completedTasks.size() + " tasks have been completed. IDs: " + completedTasks);
        System.out.println(incompleteTasks.size() + " tasks are not yet completed. IDs: " + incompleteTasks);
    }

    //-------------------------------------------
    //Extra methods:
        //Delete task --> DONE
        //Sort tasks based on priority --> DONE
        //Completed vs incomplete tasks --> DONE
        //Input validation --> DONE
}