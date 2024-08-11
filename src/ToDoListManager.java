import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    private static ArrayList<String> ToDoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Commands: LIST, ADD, EDIT, DELETE, EXIT");
            System.out.print("Enter the command: ");
            String command = scanner.next().toLowerCase();

            switch (command) {
                case "list":
                    listItems();
                    break;
                case "add":
                    addItems(scanner);
                    break;
                case "edit":
                    editItems(scanner);
                    break;
                case "delete":
                    deleteItems(scanner);
                    break;
                case "exit:":
                    System.out.println("Exiting");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    private static void deleteItems(Scanner scanner) {
        listItems();
        System.out.print("Enter the number of the task to delete: ");
        try {
            int taskNumber = Integer.parseInt(scanner.next()) - 1;
            if (taskNumber >= 0 && taskNumber < ToDoList.size()) {
                ToDoList.remove(taskNumber);
                System.out.println("Task deleted successfully.");
            } else {
                System.out.println("Invalid task number. Task not deleted.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid task number format. Task not deleted.");
        }
    }

    private static void editItems(Scanner scanner) {
        listItems();
        System.out.print("Enter the number of the task to edit: ");
        try {
            int taskNumber = Integer.parseInt(scanner.next()) - 1;
            if (taskNumber >= 0 && taskNumber < ToDoList.size()) {
                System.out.print("Enter the new task: ");
                String newTask = scanner.nextLine();
                ToDoList.set(taskNumber, newTask);
            } else {
                System.out.println("Invalid task number. Task not edited.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid task number format. Task not edited.");
        }
    }

    private static void addItems(Scanner scanner) {
        System.out.println("enter the task: ");
        String Task = scanner.nextLine();
        System.out.println("enter position(or press enter, to add to the last position)");
        String PositionInput = scanner.nextLine();

        if (PositionInput.isEmpty()) {
            ToDoList.add(Task);
        } else {
            try {
                int position = Integer.parseInt(PositionInput) - 1;
                if (position >= 0 && position <= ToDoList.size()) {
                    ToDoList.add(position, Task);
                } else {
                    System.out.println("Position error");
                }
            } catch (NumberFormatException e) {
                System.out.println("Format Error");
            }
        }

    }

    private static void listItems() {
        if (ToDoList.isEmpty()) {
            System.out.println("List is empty");
        } else {
            System.out.println("List: ");
            for (int i = 0; i < ToDoList.size(); i++) {
                System.out.println(i+1 + ": " + ToDoList.get(i));
            }
        }
    }
}
