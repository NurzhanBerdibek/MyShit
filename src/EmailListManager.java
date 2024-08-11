import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailListManager {
    private static ArrayList<String> emailList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Available commands: ADD, LIST, EXIT");
            System.out.print("Enter command: ");
            String command = scanner.next().toUpperCase();

            switch (command) {
                case "ADD":
                    addEmail(scanner);
                    break;
                case "LIST":
                    listEmails();
                    break;
                case "EXIT":
                    System.out.println("Exiting Email List Manager. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    private static void addEmail(Scanner scanner) {
        System.out.print("Enter email address: ");
        String email = scanner.next();

        if (isValidEmail(email)) {
            emailList.add(email);
            System.out.println("Email added successfully.");
        } else {
            System.out.println("Invalid email address. Please enter a valid email.");
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static void listEmails() {
        if (emailList.isEmpty()) {
            System.out.println("Email list is empty.");
        } else {
            System.out.println("Email List:");
            for (String email : emailList) {
                System.out.println(email);
            }
        }
    }
}
