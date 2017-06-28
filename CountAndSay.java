// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...
//
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.
//
// Note: The sequence of integers will be represented as a string.
import java.util.*;

public class CountAndSay{
    public String countAndSay(int n){
        if(n <= 0){
            return "";
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i = 2;
        while(i++ <= n){
            list = generate(list);
        }

        return toString(list);
    }

    private List<Integer> generate(List<Integer> list){
        List<Integer> nList = new ArrayList<>();
        int lo = 0;
        int hi = 1;
        int count = 0;

        while(hi < list.size()){
            if(list.get(hi) == list.get(lo)){
                hi++;
            }else{
                count = hi - lo;
                nList.add(count);
                nList.add(list.get(lo));

                lo = hi;
                hi++;
                count = 0;
            }
        }
        count = hi - lo;
        nList.add(count);
        nList.add(list.get(lo));
        return nList;
    }

    private String toString(List<Integer> list){
        StringBuffer sb = new StringBuffer();
        for(int i : list){
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(5));
    }
}
