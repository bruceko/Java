import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// https://www.hackerrank.com/challenges/ctci-making-anagrams
public class Solution {
    public static int numberNeeded(String first, String second) {
        // O(first.length() + second.length())
        int[] lettercounts = new int[26];
        int res = 0;
        // Check the first input word, count the frequency of each letter
        for (char c : first.toCharArray()) lettercounts[c - 'a']++;
        // Check the second input word, decrease the frequency of each letter
        for (char c : second.toCharArray()) lettercounts[c - 'a']--;
        // Sum up the absolute value of the frequency of each letter to get the number of letters need to be deleted
        for (int i : lettercounts) res += Math.abs(i);

        return res;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

