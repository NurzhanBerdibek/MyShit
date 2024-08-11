import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя или номер телефона (или LIST для вывода списка, EXIT для выхода): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("EXIT")) {
                break;
            } else if (input.equalsIgnoreCase("LIST")) {
                printPhoneBook(phoneBook);
            } else {
                handleInput(input, phoneBook);
            }
        }
    }

    private static void printPhoneBook(Map<String, String> phoneBook) {
        if (phoneBook.isEmpty()) {
            System.out.println("PhoneBook contains no data");
        } else
            System.out.println("PhoneBook:");
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
    }

    private static void handleInput(String input, Map<String, String> phoneBook) {
        Scanner scanner = new Scanner(System.in);

        String name = null;
        String number = null;

        if (input.matches(".*\\d*.")) {
            number = input;
        } else {
            name = input;
        }

        if (phoneBook.containsKey(name)) {
            number = phoneBook.get(name);
            System.out.println("name: " + name + ", phoneNumber: " + number);
        } else if (phoneBook.containsValue(number)) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (entry.getValue().equals(number)) {
                    name = entry.getKey();
                    System.out.println("name: " + name + ", phoneNumber: " + number);
                    break;
                }
            }

        } else {
            // Добавляем новый контакт
            System.out.println("enter number " + name + ": ");
            number = scanner.nextLine().trim();
            phoneBook.put(name, number);
            System.out.println("contact entered: " + name + ", phoneNumber: " + number);
        }

    }
}
