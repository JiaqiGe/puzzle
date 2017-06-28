// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.
//
// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
// The number of ways decoding "12" is 2.
//

public class DecodeWays{
  public int numDecodings(String s){
    if(s.isEmpty()){
      return 0;
    }

    //1-d dp
    int length = s.length();
    int[] dp = new int[length+1];

    //initialization
    dp[dp.length - 1] = 1;
    for(int i = dp.length - 2; i >= 0; i--){
      if(s.charAt(i) == '0'){
        dp[i] = 0;
      }else if(s.charAt(i) == '1'){
        if(i+2 >= dp.length){
          dp[i] = dp[i+1];
        }else{
          dp[i] = dp[i+1] + dp[i+2];
        }
      }else if(s.charAt(i) == '2'){
        if(i+1 >= s.length() || s.charAt(i+1) > '6'){
          dp[i] = dp[i+1];
        }else{
          dp[i] = dp[i+1]+dp[i+2];
        }
      }
      else{
        dp[i] = dp[i+1];
      }
    }
    return dp[0];
  }

  public static void main(String[] args){

  }
}
