import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// https://www.hackerrank.com/challenges/ctci-coin-change/problem
public class Solution {
    public static long makeChange(int[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long) 1; 	// n == 0 case.
        for(int coin : coins) {
            for(int j = coin; j < DP.length; j++) {
            // The only tricky step.
                DP[j] += DP[j - coin];
            }
        }       
        return DP[money];
        /*
            ex: makeChange({1 2 3}, 4) 
            long[] DP = new long[4 + 1];
            DP[0] = 1; // money is 0, only 1 way
            coin = 1; loop: 1-4, DP[1] = DP[1]+DP[0] = 0+1 = 1; {1}
                                 DP[2] = DP[2]+DP[1] = 0+1 = 1; {1,1}
                                 DP[3] = DP[3]+DP[2] = 0+1 = 1; {1,1,1}
                                 DP[4] = DP[4]+DP[3] = 0+1 = 1; {1,1,1,1}
            coin = 2; loop: 2-4, DP[2] = DP[2]+DP[0] = 1+1 = 2; {1,1}{2}
                                 DP[3] = DP[3]+DP[1] = 1+1 = 2; {1,1,1}{1,2}
                                 DP[4] = DP[4]+DP[2] = 1+2 = 3; {1,1,1,1}{1,1,2}{2,2}
            coin = 3; loop: 3-4, DP[3] = DP[3]+DP[0] = 2+1 = 3; {1,1,1}{1,2}{3}
                                 DP[4] = DP[4]+DP[1] = 3+1 = 4; {1,1,1,1}{1,1,2}{1,3}{2,2}
         */
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}

