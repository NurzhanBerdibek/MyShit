import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task0108 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("INPUT.TXT");
            Scanner scanner = new Scanner(inputFile);
            int A = scanner.nextInt();
            scanner.close();

            File outputFile = new File("OUTPUT.TXT");
            PrintWriter writer = new PrintWriter(outputFile);
            writer.println(A);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
