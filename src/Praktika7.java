import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Praktika7 {

}

//  PART ONE
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("int length: ");
//        int len = scanner.nextInt();
//        scanner.nextLine();
//
//        String ans = GeneratePassword(len);
//        System.out.println("Generated password: \n" + ans);
//
//        scanner.close();
//    }
//
//    public static String GeneratePassword(int Length) {
//        String glyph = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
//
//        SecureRandom random = new SecureRandom();
//        StringBuilder password = new StringBuilder();
//
//        for (int i = 0; i < Length; i++) {
//            int RandomIndex = random.nextInt(glyph.length());
//            char RandomChar = glyph.charAt(RandomIndex);
//            password.append(RandomChar);
//        }
//
//        return password.toString();
//    }

//  PART TWO
//    public static void main(String[] args) {
//        Random random = new Random();
//        int randomNum = random.nextInt(900) + 100;
//
//        System.out.println("Random num: " + randomNum);
//
//        if (randomNum % 2 == 0) {
//            System.out.println("random number is even");
//        } else {
//            System.out.println("random number is odd");
//        }
//    }

//  PART THREE
//public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    Random random = new Random();
//    int i = 0;
//    int randomNum = random.nextInt(100) + 1;
//
//    System.out.println("Guess the number(between 1 and 100): \n");
//    System.out.println("Attempts count: " + i + "\n");
//
//    while (true) {
//        System.out.println("your number: ");
//        int num = scanner.nextInt();
//        i++;
//
//        if (num == randomNum) {
//            System.out.println("Yes, you are right \n");
//            System.out.println("Attempts count: " + i + "\n");
//            break;
//        } else if (num < randomNum) {
//            System.out.println("More \n");
//            System.out.println("Attempts count: " + i + "\n");
//        } else {
//            System.out.println("less \n");
//            System.out.println("Attempts count: " + i + "\n");
//        }
//    }
//}