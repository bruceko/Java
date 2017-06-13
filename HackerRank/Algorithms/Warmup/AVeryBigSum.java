import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// https://www.hackerrank.com/challenges/a-very-big-sum/submissions/code/46398366
public class Solution {
    static long aVeryBigSum(int n, long[] ar) {
        // Complete this function
        long res = 0;
        
        for (long i : ar) res += i;
        
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        long result = aVeryBigSum(n, ar);
        System.out.println(result);
    }
}
