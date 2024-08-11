import java.io.*;
import java.util.Scanner;

public class Task0001 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("INPUT.TXT");
            Scanner scanner = new Scanner(inputFile);
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            scanner.close();

            int sum = A + B;

            File outputFile = new File("OUTPUT.TXT");
            PrintWriter writer = new PrintWriter(outputFile);
            writer.println(sum);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

