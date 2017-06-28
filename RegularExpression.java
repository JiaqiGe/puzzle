// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
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
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true

public class RegularExpression {
public boolean isMatch(String s, String p){


        //dp
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        int rows = dp.length;
        int cols = dp[0].length;

        //initialize

        //both s and p are empty
        dp[rows-1][cols-1] = true;

        //s is empty => i = rows-1
        for(int j = cols-2; j >= 0; j--) {
                if(p.charAt(j) == '*') {
                        dp[rows-1][j] = dp[rows-1][j+1];
                }else{
                        if(j+1 < cols-1 && p.charAt(j+1) == '*') {
                                dp[rows-1][j] = dp[rows-1][j+1];
                        }else{
                                dp[rows-1][j] = false;
                        }
                }
        }
        //p is empty
        // dp[i][j]=
        //  if p[j] == '*' => skip
        //  if p[j] != '*':
        //         p[j+1] != '*':
        //                      s[i] == p[j] => dp[i+1][j+1]
        //         p[j+1] == '*':
        //                      dp[i][j] = dp[i][j+2] || s[i]==p[j] && dp[i+1][j+2] || s[i]==p[j]&&s[i+1]==p[j]&&dp[i+2][j+2]||...
        for(int i = rows-2; i >= 0; i--) {
                for(int j = cols-2; j >= 0; j--) {
                        if(p.charAt(j) != '*') {
                                if(j+1 < p.length() && p.charAt(j+1) == '*') {
                                        for(int k = i; k <= rows-1; k++) {
                                                dp[i][j] = dp[i][j] || dp[k][j+2];
                                                if(p.charAt(j) != '.' && p.charAt(j) != s.charAt(i)) {
                                                        break;
                                                }
                                        }
                                }else{
                                        if(p.charAt(j) == '.') {
                                                dp[i][j] = dp[i+1][j+1];
                                        }else{
                                                dp[i][j] = dp[i+1][j+1] && (s.charAt(i) == p.charAt(j));
                                        }
                                }
                        }
                }
        }

        return dp[0][0];
}

public static void main(String[] args){
  RegularExpression r = new RegularExpression();
  System.out.println(r.isMatch("aab","c*a*b"));
}
}
