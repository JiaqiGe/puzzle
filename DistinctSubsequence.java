// Given a string S and a string T, count the number of distinct subsequences of S which equals T.
//
// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
// Here is an example:
// S = "rabbbit", T = "rabbit"
//
// Return 3.

public class DistinctSubsequence {
    public int numDistinct(String s, String t){

        int[][] dp = new int[s.length()+1][t.length()+1];

        //initialization
        int rows = dp.length;
        int cols = dp[0].length;

        // s and t are empty
        dp[rows-1][cols-1] = 1;

        // s is empty; t is not
        for(int j = cols - 2; j >= 0; j--){
          dp[rows-1][j] = 0;
        }

        // t is empty s is not
        for(int i = rows - 2; i >= 0; i--){
          dp[i][cols-1] = 1;
        }

        //dp
        // dp[i][j] =
        //          (1) s[i] == s[j]
        //                dp[i+1]dp[j+1] + dp[i+1][j]
        //          (2) s[i] != s[j]
        //                dp[i+1][j]

        for(int i = rows-2; i >= 0; i--){
          for(int j = cols-2; j >= 0; j--){
            if(s.charAt(i) == t.charAt(j)){
              dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
            }else{
              dp[i][j] = dp[i+1][j];
            }
          }
        }

        return dp[0][0];
    }
}
