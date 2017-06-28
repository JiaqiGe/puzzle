// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
// You have the following 3 operations permitted on a word:
//
// a) Insert a character
// b) Delete a character
// c) Replace a character
public class EditDistance{
    public int minDistance(String word1, String word2) {
        //dp
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int rows = dp.length;
        int cols = dp[0].length;
        //initialize
        dp[rows-1][cols-1] = 0;

        //when word1 is empty
        for(int j = cols - 2; j >= 0; j--){
            dp[rows-1][j] = dp[rows-1][j+1] + 1;
        }

        //when word2 is empty
        for(int i = rows - 2; i >= 0; i--){
            dp[i][cols-1] = dp[i+1][cols-1] + 1;
        }

        //dp => minmal of three possible operations
        for(int i = rows - 2; i >= 0; i--){
            for(int j = cols - 2; j >= 0; j--){
                int insertDist = dp[i][j+1] + 1;
                int deleteDist = dp[i+1][j] + 1;
                int replaceDist = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
                replaceDist += dp[i+1][j+1];

                dp[i][j] = min(insertDist, deleteDist, replaceDist);
            }
        }
        return dp[0][0];
    }

    private int min(int a, int b, int c){
        int result = Math.min(a, b);
        result = Math.min(result, c);
        return result;
    }

    public static void main(String[] args){
        String word1 = "113";
        String word2 = "253";

        EditDistance e = new EditDistance();
        System.out.println(e.minDistance(word1, word2));
    }
}
