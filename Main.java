import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        this.isCompleted = true;
    }
}

class ToDoList {
    private Task[] tasks;
    private int taskCount;

    public ToDoList(int size) {
        tasks = new Task[size];
        taskCount = 0;
    }

    public void addTask(String description) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = new Task(description);
            System.out.println("Task added: " + description);
            taskCount++;
        } else {
            System.out.println("Task list is full. Cannot add more tasks.");
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < taskCount) {
            tasks[index].complete();
            System.out.println("Task completed: " + tasks[index].getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void viewTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks available.");
           
        }
        
      else{
		    
        for (int i = 0; i < taskCount; i++) {
            Task task = tasks[i];
            String status;

            if (task.isCompleted()) {
                status = "[C]";
            } else {
                status = "[I]";
            }

            System.out.println(i + ": " + status + " " + task.getDescription());
        }
	  }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList(10); 
        boolean runTime= true;
        while (runTime) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task number to complete: ");
                    int taskNumber = scanner.nextInt();
                    toDoList.completeTask(taskNumber);
                    break;
                case 3:
                    toDoList.viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
					 runTime = false;
                    
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
