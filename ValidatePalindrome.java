// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
//
// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.
//
// For the purpose of this problem, we define empty string as valid palindrome.
//

// bug at 25/26: toLowerCase!

public class ValidatePalindrome {
    public boolean isPalindrome(String s){
      if(s.isEmpty()){
        return true;
      }

      int lo = 0;
      int hi = s.length() - 1;

      while(lo < hi){
        char c1 = Character.toLowerCase(s.charAt(lo));
        char c2 = Character.toLowerCase(s.charAt(hi));

        if(!Character.isLetterOrDigit(c1)){
          lo ++;
        }else if (!Character.isLetterOrDigit(c2)){
          hi --;
        }else{
          if(c1 != c2){
            return false;
          }else{
            lo++;
            hi--;
          }
        }
      }

      return true;
    }

    public static void main(String[] args){
      ValidatePalindrome v = new ValidatePalindrome();
      System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
