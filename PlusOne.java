// Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
//
// You may assume the integer do not contain any leading zero, except the number 0 itself.
//
// The digits are stored such that the most significant digit is at the head of the list.
import java.util.*;

public class PlusOne{
    public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return new int[]{1};
        }

        int digit = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = digits.length - 1; i >= 0; i--){
            int v = 0;
            if(i == digits.length - 1){
                v = digits[i] + digit + 1;
            }else{
                v = digits[i] + digit;
            }
            digit = v / 10;
            list.add(v % 10);
        }

        if(digit != 0){
            list.add(digit);
        }

        int[] result = new int[list.size()];
        for(int i = list.size()-1; i >= 0; i--){
            result[list.size()-1 - i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args){
        PlusOne p = new PlusOne();
        int[] digits = new int[]{2,2};
        int[] result = p.plusOne(digits);
        for(int i : result){
            System.out.print(i);
        }
    }
}
