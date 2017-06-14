import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// https://www.hackerrank.com/challenges/ctci-contacts
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie trie = new Trie();
        for (int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                trie.add(contact);
            } else if (op.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        in.close();
    }
}

class TrieNode {
    int cnt;    // Counter to count the number of current letter
    boolean isEnd;  // Mark the last letter
    TrieNode[] children;    // Children node to keep the following letter
    // Initialize data structure through constructor
    public TrieNode() {
        this.cnt = 0;
        this.children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;
 
    public Trie() {
        this.root = new TrieNode();
    }

    // Add a contact into the trie
    public void add(String str) {
        TrieNode head = root;
        for (int i = 0; i < str.length(); i++) {
            // Create a children node if the current letter is not exist
            int index = str.charAt(i) - 'a';
            // Create a new node for the letter not exist in the trie
            if (head.children[index] == null) head.children[index] = new TrieNode();
            head.children[index].cnt++;
            head = head.children[index];    // Move to next letter
        }
        head.isEnd = true;
    }
    // Return the frequency of the input word in the trie
    public int find(String str) {
        TrieNode head = root;
        int numberOfContacts = 0;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            // If one letter of the input is not exist, return 0
            if (head.children[index] == null) return 0;
            numberOfContacts = head.children[index].cnt;
            head = head.children[index];
        }
        return numberOfContacts;
    }
}
