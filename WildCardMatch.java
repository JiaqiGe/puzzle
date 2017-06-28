// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
//
// The matching should cover the entire input string (not partial).
//
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

public class WildCardMatch{
    public boolean isMatch(String s, String p){
        //dp
        int rows = s.length()+1;
        int cols = p.length()+1;
        boolean[][] dp = new boolean[rows][cols];

        //initial

        //if both s and p are empty, true!
        dp[rows-1][cols-1] = true;

        //if p is empty and s is not empty, false!

        // if s is empty and p is not empty
        for(int j = cols - 2; j >= 0; j--){
            dp[rows-1][j] = (p.charAt(j) == '*') && dp[rows-1][j+1];
        }

        //optimal structure
        //dp[i][j]=
        //   (1) if p[j] != '*':
        //          if s[i] == p[j] || p[j] == '?'
        //               dp[i][j] = dp[i+1][j+1]
        //          else
        //              dp[i][j] = false
        //   (2) if p[j] == '*':
        //          dp[i][j] = (dp[i][j+1] || dp[i+1][j+1] || ... || dp[rows-1][j+1])
        for(int i = rows-2; i >= 0; i--){
            for(int j = cols-2; j >= 0; j--){
                if(p.charAt(j) != '*'){
                    if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '?'){
                        dp[i][j] = dp[i+1][j+1];
                    }
                }else{
                    for(int k = i; k < rows; k++){
                        dp[i][j] = dp[i][j] || dp[k][j+1];
                    }
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args){
        WildCardMatch w = new WildCardMatch();
        String s = "aab";
        String p = "c*a*b";
        System.out.println(w.isMatch(s, p));
    }
}
