import java.util.*;
// https://www.hackerrank.com/challenges/ctci-ransom-note/submissions/code/46441113
public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        int cnt = 1;
        
        for (String word : magazine.split("\\s+")) {
            cnt = (magazineMap.containsKey(word)) ? magazineMap.get(word) + 1 : 1;
            magazineMap.put(word, cnt);
        }
        noteMap = new HashMap<String, Integer>();
        for (String word : note.split(" ")) {
            cnt = (noteMap.containsKey(word)) ? cnt = noteMap.get(word) + 1 : 1;
            noteMap.put(word, cnt);
        }
    }
    
    public boolean solve() {
        boolean res = false;
        
        for (String word : noteMap.keySet()) {
            int temp = magazineMap.get(word);
            if (magazineMap.containsKey(word) && noteMap.get(word) <= temp) {
                res = true;
            } else {
                res = false;
                break;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
