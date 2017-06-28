// The gray code is a binary numeral system where two successive values differ in only one bit.
//
// Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//
// For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//
// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2
// Note:
// For a given n, a gray code sequence is not uniquely defined.
//
// For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
// 000, 001, 011, 010, 110, 111, 101, 100
// 000, 001, 011, 111, 101, 100, 110, 010
import java.util.*;

public class GrayCode{
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if(n == 0){
            return result;
        }

        if(n == 1){
            result.add(0);
            result.add(1);
        }

        List<Integer> preResults = grayCode(n-1);
        for(int i : preResults){
            result.add(i);
        }

        for(int i = preResults.size()-1; i >= 0; i--){
            int val = preResults.get(i) + (1 << (n-1));
            result.add(val);
        }

        return result;
   }

   public static void main(String[] args){
       GrayCode g = new GrayCode();
       List<Integer> r = g.grayCode(3);
       for(int i : r){
           System.out.println(i);
       }
   }
}
