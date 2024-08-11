import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DigitalSignature {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        // Генерируем ключи для подписи и проверки
        KeyPair keyPair = generateECKeyPair();

        // Создаем объект подписи с использованием алгоритма ECDSA
        Signature ecdsaSign = Signature.getInstance("SHA256withECDSA");

        // Инициализируем объект подписи на подпись с использованием приватного ключа
        ecdsaSign.initSign(keyPair.getPrivate());

        // Данные для подписи
        String data = "Berdibek Nurzhan";
        byte[] dataBytes = data.getBytes();

        // Обновляем данные для подписи
        ecdsaSign.update(dataBytes);

        // Выполняем подпись
        byte[] signatureBytes = ecdsaSign.sign();

        System.out.println("ЭЦП (Base64): " + Base64.getEncoder().encodeToString(signatureBytes));

        // Проверка подписи
        Signature ecdsaVerify = Signature.getInstance("SHA256withECDSA");

        // Инициализируем объект подписи на проверку с использованием открытого ключа
        ecdsaVerify.initVerify(keyPair.getPublic());

        // Обновляем данные для проверки
        ecdsaVerify.update(dataBytes);

        // Проверяем подпись
        boolean verified = ecdsaVerify.verify(signatureBytes);

        System.out.println("Проверка подписи: " + verified);
    }

    public static KeyPair generateECKeyPair() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        // Создаем генератор ключей для алгоритма ECDSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");

        // Задаем параметры кривой для генерации ключей
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1");

        // Инициализируем генератор ключей с заданными параметрами
        keyGen.initialize(ecSpec);

        // Генерируем ключевую пару
        return keyGen.generateKeyPair();
    }
}
