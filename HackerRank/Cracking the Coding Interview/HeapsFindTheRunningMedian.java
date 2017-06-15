import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// https://www.hackerrank.com/challenges/ctci-find-the-running-median
// https://leetcode.com/problems/find-median-from-data-stream/#/solutions
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] tmp = new int[n];
        MedianFinder mf = new MedianFinder();
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            mf.addNum(a[a_i]);
            System.out.println(mf.findMedian());
        }
    }
}

class MedianFinder {
    private Queue<Long> small = new PriorityQueue();    // small[0..k/k-1] store negative incoming numbers -> [k..0]
    private Queue<Long> large = new PriorityQueue();    // large[k-1..n]
    // the smallest number always goes to the first in large and small PriorityQueue
    // the only difference is small store negative numbers and the first element in the small PriorityQueue 
    // would become the biggest number in it 
    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
               ? large.peek()
               : (large.peek() - small.peek()) / 2.0;
    }
}
