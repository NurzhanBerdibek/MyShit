import java.util.HashMap;

public class AffineCipherDecryption {

    public static void main(String[] args) {
        String alphabet = "_абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        int a = 5;
        int b = 30;
        int m = alphabet.length();

        HashMap<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            charToIndex.put(alphabet.charAt(i), i);
        }

        int aInverse = modInverse(a, m);

        String ciphertext = "фшвояряьнъжьхяюсаъдшьжекъатыкшьйьайхъращккьбкйяъьжвкьлршкюяышхъйшввжьваьлжржхцкзьърайжпьрайвквазьаьъафбшьваьхязкзьжъфрдъдзьлржхъравхъйазькёйшхъвдзьфафьфяхъарвкфжйдшьёаржхщкькщкьеяцьлкъатъхчьфшвояряьърайжпькьуряожпьрахъкъшщивжхъитьлшршуйкоатъхчьжвкьоряллаюкьлрдоачьваьхйжкзьоржюаувдзьюжывдзьёаувкзьвжоазькзьущкввдшьзйжхъдьлжюжоатъькюьхжзравчъиьрайвжйшхкшьхяышхъйяшъьювжбшхъйжьйкужйьфшвояряьхаюдшьфрялвдшьрдбкпьфшвояряькьхшрдпьфшвояряьшхщкьйёржхщдпьрдбкпьфшвояряьхъжкъьваьфжвскфазьлащимшйьжвьюжбшъьедъиьйдцшьйёржхщжожьсшщжйшфа";
        StringBuilder plaintext = new StringBuilder();

        for (char ch : ciphertext.toCharArray()) {
            if (charToIndex.containsKey(ch)) {
                int idx = charToIndex.get(ch);
                int decryptedIdx = (aInverse * (idx - b + m)) % m;
                plaintext.append(alphabet.charAt(decryptedIdx));
            } else {
                plaintext.append(ch);
            }
        }

        System.out.println("Decrypted Text:");
        System.out.println(plaintext.toString());
    }

    public static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1; // No mod inverse exists
    }
}
