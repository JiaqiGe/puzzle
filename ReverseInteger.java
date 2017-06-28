public class ReverseInteger{
  public static int reverse(int x){
    //get the last digit and append it to the end of the new value
    if(x == Integer.MIN_VALUE){
      //overflow
      return 0;
    }

    if( x < 0){
      return - reverse(-x);
    }

    int result = 0;

    while(x > 0){
      int lastDigit = x % 10;

      if(result <= Integer.MAX_VALUE / 10){
        result = result * 10 + lastDigit;
      }else{
        return 0;
      }


      x = x / 10;
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println(ReverseInteger.reverse(100));
  }
}
