import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}

public class HuffmanCoding {

    public static Node buildHuffmanTree(String text) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char ch : text.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();

            Node merged = new Node('\0', left.freq + right.freq);
            merged.left = left;
            merged.right = right;

            priorityQueue.add(merged);
        }

        return priorityQueue.poll();
    }

    public static Map<Character, String> buildHuffmanCodes(Node node) {
        Map<Character, String> codebook = new HashMap<>();
        buildHuffmanCodesHelper(node, "", codebook);
        return codebook;
    }

    private static void buildHuffmanCodesHelper(Node node, String prefix, Map<Character, String> codebook) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            codebook.put(node.ch, prefix);
            return;
        }

        buildHuffmanCodesHelper(node.left, prefix + "0", codebook);
        buildHuffmanCodesHelper(node.right, prefix + "1", codebook);
    }

    public static String encode(String text, Map<Character, String> codebook) {
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(codebook.get(ch));
        }
        return encodedText.toString();
    }

    public static String decode(String encodedText, Node root) {
        StringBuilder decodedText = new StringBuilder();
        Node current = root;
        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                decodedText.append(current.ch);
                current = root;
            }
        }
        return decodedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encode: ");
        String text = scanner.nextLine();

        Node huffmanTree = buildHuffmanTree(text);
        Map<Character, String> codebook = buildHuffmanCodes(huffmanTree);

        System.out.println("\nHuffman Codes for each character:");
        for (Map.Entry<Character, String> entry : codebook.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }

        String encodedText = encode(text, codebook);
        System.out.println("\nEncoded Text: " + encodedText);

        String decodedText = decode(encodedText, huffmanTree);
        System.out.println("Decoded Text: " + decodedText);

        scanner.close();
    }
}
