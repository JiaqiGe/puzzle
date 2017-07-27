// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
//

// pay attention to the 1-d dynamic programming:
//  in order to find minimum, it use a for-loop

import java.util.*;

public class PalindromePartitionII {
    // dfs + memorization
    public int minCut(String s){
        if (s.isEmpty()){
            return 0;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);
        return help(s, isPalindrome);
    }

    private boolean[][] getIsPalindrome(String s){
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        // initialization
        for (int i = 0; i < isPalindrome.length; i++){
            isPalindrome[i][i] = true;
            if (i + 1 < isPalindrome.length){
                isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            }
        }

        for (int i = isPalindrome.length - 1; i >= 0; i--){
            for (int j = i + 2; j < isPalindrome.length; j++){
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
            }
        }
        return isPalindrome;
    }

    private int help(String s, boolean[][] isPalindrome){
        int[] count = new int[s.length()+1];
        count[count.length - 1] = 0;

        for (int i = count.length - 2; i >= 0; i--){
          int cut = Integer.MAX_VALUE;
          for(int j = i; j <= s.length()-1; j++){
            if(isPalindrome[i][j]){
              cut = Math.min(cut, 1 + count[j+1]);
            }
          }
          count[i] = cut;
        }
        return count[0] - 1;
    }

    public static void main(String[] args){
        PalindromePartitionII p = new PalindromePartitionII();

        System.out.println(p.minCut("aab"));
    }
}
