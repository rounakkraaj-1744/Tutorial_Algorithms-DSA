import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    char data;
    int freq;
    Node left, right;

    public Node(char data, int freq) {
        this.data = data;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    public int compareTo(Node newNode) {
        return this.freq - newNode.freq;
    }
}

public class Huffman {
    public static HashMap<Character, String> encode(String msg) {
        HashMap<Character, Integer> freq_Map = new HashMap<>();
        for (char ch : msg.toCharArray())
            freq_Map.put(ch, freq_Map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (char key : freq_Map.keySet())
            queue.offer(new Node(key, freq_Map.get(key)));

        while (queue.size() > 1) {
            Node left = queue.poll(), right = queue.poll();

            Node root = new Node('\0', left.freq + right.freq);
            root.left = left;
            root.right = right;

            queue.offer(root);
        }

        Node root = queue.poll();
        HashMap<Character, String> encoder = new HashMap<>();
        createMap(root, "", encoder);

        return encoder;
    }

    static void createMap(Node node, String code, HashMap<Character, String> encoder) {
        if (node == null) 
            return;

        if (node.left == null && node.right == null) 
            encoder.put(node.data, code);

        createMap(node.left, code + "0", encoder);
        createMap(node.right, code + "1", encoder);
    }

    public static String decode(String encodedString, HashMap<Character, String> encoder) {
        StringBuilder decodedString = new StringBuilder();
        StringBuilder msg = new StringBuilder();

        for (char ch : encodedString.toCharArray()) {
            msg.append(ch);
            for (char key : encoder.keySet())
                if (encoder.get(key).equals(msg.toString ())) {
                    decodedString.append(key);
                    msg.setLength(0);
                    break;
                }
        }
        return decodedString.toString();
    }

    static String encode(String msg, HashMap<Character, String> encoder) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : msg.toCharArray())
            encodedString.append(encoder.get(c));

        return encodedString.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter the String : ");
        String msg = sc.next ();

        HashMap<Character, String> encoder = encode(msg);
        System.out.println("Encoder Map is : " + encoder);

        String encodedString = encode(msg, encoder);
        System.out.println("Encoded String: " + encodedString);

        String decodedString = decode(encodedString, encoder);
        System.out.println("Decoded String: " + decodedString);

        sc.close ();
    }
}