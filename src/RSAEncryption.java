import java.math.BigInteger;
import java.util.Scanner;

public class RSAEncryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста сообщения для шифрования
        System.out.println("Введите текст сообщения для шифрования:");
        String message = scanner.nextLine();

        // Ввод простых чисел p и q
        System.out.println("Введите простое число p:");
        BigInteger p = new BigInteger(scanner.nextLine());
        System.out.println("Введите простое число q:");
        BigInteger q = new BigInteger(scanner.nextLine());

        // Вычисление n и φ(n)
        BigInteger n = p.multiply(q);
        BigInteger phi = calculatePhi(p, q);

        // Вычисление открытой экспоненты e (1 < e < φ(n))
        BigInteger e = generateE(phi);

        // Генерация ключей
        BigInteger d = generateD(e, phi);

        // Вывод открытого и закрытого ключей
        System.out.println("Открытый ключ (e, n): (" + e + ", " + n + ")");
        System.out.println("Закрытый ключ (d, n): (" + d + ", " + n + ")");

        // Шифрование сообщения
        BigInteger[] encrypted = encrypt(message, e, n);
        System.out.println("Зашифрованное сообщение:");
        for (BigInteger cipher : encrypted) {
            System.out.print(cipher + " ");
        }
        System.out.println();

        // Расшифровка сообщения
        String decrypted = decrypt(encrypted, d, n);
        System.out.println("Расшифрованное сообщение:");
        System.out.println(decrypted);
    }

    // Вычисление φ(n)
    public static BigInteger calculatePhi(BigInteger p, BigInteger q) {
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }

    // Генерация открытой экспоненты e (1 < e < φ(n))
    public static BigInteger generateE(BigInteger phi) {
        BigInteger e;
        do {
            e = BigInteger.probablePrime(phi.bitLength() - 1, new java.util.Random());
        } while (phi.gcd(e).intValue() != 1 && e.compareTo(phi) < 0);
        return e;
    }

    // Генерация закрытой экспоненты d
    public static BigInteger generateD(BigInteger e, BigInteger phi) {
        return e.modInverse(phi);
    }

    // Шифрование сообщения
    public static BigInteger[] encrypt(String message, BigInteger e, BigInteger n) {
        byte[] bytes = message.getBytes();
        BigInteger[] encrypted = new BigInteger[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encrypted[i] = BigInteger.valueOf(bytes[i]).modPow(e, n);
        }
        return encrypted;
    }

    // Расшифровка сообщения
    public static String decrypt(BigInteger[] encrypted, BigInteger d, BigInteger n) {
        StringBuilder decrypted = new StringBuilder();
        for (BigInteger cipher : encrypted) {
            BigInteger decryptedByte = cipher.modPow(d, n);
            decrypted.append((char) decryptedByte.intValue());
        }
        return decrypted.toString();
    }
}
