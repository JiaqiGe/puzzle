public class PalindromeNumber {
public boolean isPalindrome(int x) {
    if(x < 0){
      return false;
    }
    System.out.println(x);
    if(x < 10){
      return true;
    }



    int k = 1;
    while(x/k > 0){
      k *= 10;
    }

    k /= 10;

    while(x >= 10){
      int lastDigit = x % 10;
      int firstDigit = x / k;

      if(lastDigit != firstDigit){
        return false;
      }

      x = (x - lastDigit - k*firstDigit) / 10;
      k /= 100;
    }

    return true;
}

public static void main(String[] args){
  PalindromeNumber p = new PalindromeNumber();
  System.out.println(p.isPalindrome(010));
}
}
