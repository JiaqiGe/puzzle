// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",
//
// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.
//
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3){
        //dp
        if (s3.length() != (s1.length() + s2.length())){
            return false;
        }

        int rows = s1.length() + 1;
        int cols = s2.length() + 1;

        boolean[][] dp = new boolean[rows][cols];

        // initialization
        // if both s1 and s2 are already matched => true (Given len(s1)+len(s2) == len(s3))

        dp[rows - 1][cols - 1] = true;

        // if all of s1 is matched => row-1
        for (int j = cols - 2; j >= 0; j--){
            dp[rows - 1][j] = (s2.charAt(j) == s3.charAt(rows-1+j)) && dp[rows - 1][j + 1];
        }

        // if all of s2 is matched => col: col-1
        for (int i = rows - 2; i >= 0; i--){
            dp[i][cols - 1] = (s1.charAt(i) == s3.charAt(cols-1+i)) && dp[i + 1][cols - 1];
        }

        //dp
        // dp[i][j] => examine s1[i], s2[j] and s3[i+j]

        for (int i = rows - 2; i >= 0; i--){
            for (int j = cols - 2; j >= 0; j--){
                char c3 = s3.charAt(i + j);
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if ((c3 != c1) && (c3 != c2)){
                    dp[i][j] = false;
                }else if ((c3 == c1) && (c3 != c2)){
                    dp[i][j] = dp[i + 1][j];
                }else if ((c3 == c2) && (c3 != c1)){
                    dp[i][j] = dp[i][j + 1];
                }else{
                    dp[i][j] = dp[i][j + 1] || dp[i+1][j] ;
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args){
      InterleavingString i = new InterleavingString();
      String s1 = "aabcc";
      String s2 = "dbbca";
      String s3 = "aadbbcbcac";

      System.out.println(i.isInterleave(s1,s2,s3));
    }
}
