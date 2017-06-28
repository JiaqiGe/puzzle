// Given two binary strings, return their sum (also a binary string).
//
// For example,
// a = "11"
// b = "1"
// Return "100".
import java.util.*;

public class AddBinary{
    public String addBinary(String a, String b){
        if(a.isEmpty()){
            return new String(b);
        }

        if(b.isEmpty()){
            return new String(a);
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        List<Integer> list = new ArrayList<>();

        int digit = 0;
        while(i >= 0 && j >= 0){
            int n1 = a.charAt(i) == '0' ? 0 : 1;
            int n2 = b.charAt(j) == '0' ? 0 : 1;

            int v = n1 + n2 + digit;
            list.add(v % 2);
            digit = v / 2;

            i --;
            j --;
        }

        while(i >= 0){
            int n1 = a.charAt(i) == '0' ? 0 : 1;
            int v = n1 + digit;

            list.add(v % 2);
            digit = v / 2;

            i--;
        }

        while(j >= 0){
            int n2 = b.charAt(j) == '0' ? 0 : 1;
            int v = n2 + digit;

            list.add(v % 2);
            digit = v / 2;

            j--;
        }

        if(digit > 0){
            list.add(digit);
        }

        StringBuffer sb = new StringBuffer();
        for(int k : list){
            sb.insert(0,k);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        AddBinary ab = new AddBinary();
        String a = "111";
        String b = "101";

        System.out.println(ab.addBinary(a,b));
    }
}
