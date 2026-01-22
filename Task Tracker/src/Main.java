import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Open keyboard
        Scanner sc = new Scanner(System.in);
        //Display the title of the app
        System.out.println("=== TASK TRACKER ===");
        //Display the app options
        System.out.println("1. Add task\n2. Mark task as completed\n3. Show all tasks\n4. Show incomplete tasks" +
                "\n5. Show HIGH priority tasks\n0. Exit");
        //Add separator
        System.out.println("--------------------");
        //Prompt the user to select an option
        System.out.print("Choose option: ");
        //Declare variable of type int and read it from the keyboard
        int option = sc.nextInt();
        //Confirm option chosen by user
//        System.out.print("You chose option #" + option);

        //Call method for selecting the option
        selectOption(option);
    }

    //Add tasks to the list
    Map<Integer, Task> tasks = new HashMap<>();

    //Add titles to the tasks
    Set<String> taskTitles = new HashSet<>();


    //Method for processing the option selected by the user
    public static void selectOption(int option) {
            switch (option) {
                case 1:
                    System.out.println("You chose option #" + option);
    //                addTask();
                    break;
                case 2:
                    System.out.println("You chose option #" + option);
    //                markTaskCompleted();
                    break;
                case 3:
                    System.out.println("You chose option #" + option);
    //                showAllTasks();
                    break;
                case 4:
                    System.out.println("You chose option #" + option);
    //                incompleteTasks();
                    break;
                case 5:
                    System.out.println("You chose option #" + option);
    //                highPriority();
                    break;
                case 6:
                    System.out.println("You chose option #" + option);
    //                deleteTask();
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
//                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");

            }
    }

    //Method for adding a task (ID + title + priority)
    public void addTask(int taskID, int priority, String description) {

    }

    //Method for marking a task as completed


    //Method for displaying all the tasks
//    List<Task> displayTask = new ArrayList<>(tasks.values());

    //Method for displaying only the tasks that have not been completed


    //Method for displaying HIGH priority tasks


    //Extra methods:
    //Delete task
    //Sort tasks based on priority
    //Completed vs incomplete tasks
    //Input validation
}