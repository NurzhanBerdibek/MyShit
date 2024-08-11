import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class sheno {

    static class Node implements Comparable<Node> {
        char character;
        int frequency;
        Node left, right;

        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        Node(char character, int frequency, Node left, Node right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }

    public static Map<Character, String> shannonFanoEncoding(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.offer(new Node('\0', left.frequency + right.frequency, left, right));
        }

        Node root = pq.poll();
        Map<Character, String> encodedMap = new HashMap<>();
        generateCodes(root, "", encodedMap);
        return encodedMap;
    }

    private static void generateCodes(Node node, String code, Map<Character, String> encodedMap) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            encodedMap.put(node.character, code);
            return;
        }
        generateCodes(node.left, code + "0", encodedMap);
        generateCodes(node.right, code + "1", encodedMap);
    }

    public static String shannonFanoDecoding(String encodedText, Map<Character, String> encodedDict) {
        Map<String, Character> decodedDict = new HashMap<>();
        for (Map.Entry<Character, String> entry : encodedDict.entrySet()) {
            decodedDict.put(entry.getValue(), entry.getKey());
        }

        StringBuilder decodedText = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();
        for (char bit : encodedText.toCharArray()) {
            currentCode.append(bit);
            if (decodedDict.containsKey(currentCode.toString())) {
                decodedText.append(decodedDict.get(currentCode.toString()));
                currentCode.setLength(0);
            }
        }
        return decodedText.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text ;
        text = in.next();
        Map<Character, String> encodedDict = shannonFanoEncoding(text);
        System.out.println("Encoded dictionary: " + encodedDict);

        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(encodedDict.get(c));
        }
        System.out.println("Encoded text: " + encodedText);

        String decodedText = shannonFanoDecoding(encodedText.toString(), encodedDict);
        System.out.println("Decoded text: " + decodedText);
    }
}