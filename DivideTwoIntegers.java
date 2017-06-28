// Divide two integers without using multiplication, division and mod operator.
//
// If it is overflow, return MAX_INT.

public class DivideTwoIntegers {
   public int divide(int dividend, int divisor){
      if (divisor == 0){
         return Integer.MAX_VALUE;
      }

      if(dividend > 0 && divisor < 0){
          return - divide(dividend, -divisor);
      }

      if(dividend < 0 && divisor > 0){
          return - divide(-dividend, divisor);
      }

      // both dividend and divisor are positive
      // base 2 divide

      // divisor * (2^x) <= dividend
      // divisor * (2^(x+1)) > dividend
      int result = 0;

      while (dividend > 0){
         int x = 0;
         while (true){
            if (((divisor << x) <= dividend) && (divisor << (x + 1) > dividend)){
               result += (1 << x);
               break;
            }else if (divisor > dividend){
               break;
            }else{
               x++;
            }
         }

         dividend = dividend - (divisor << x);
      }
      return result;
   }

   public static void main(String[] args){
      int               dividend = -14;
      int               divisor  = 3;
      DivideTwoIntegers d        = new DivideTwoIntegers();

      System.out.println(d.divide(dividend, divisor));
   }
}
