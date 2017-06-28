// Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
// For example:
// Given "25525511135",
//
// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
//
// stringbuffer length(), deleteCharAt, delete(start, end), insert(index, value)
import java.util.*;

public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s){
        if (s.isEmpty()){
            return new ArrayList<>();
        }

        //dp
        List<String> addresses  = new ArrayList<>();
        List<String> oneAddress = new ArrayList<>();
        help(s, 4, oneAddress, addresses);

        return addresses;
    }

    private void help(String s, int num, List<String> oneAddress, List<String> addresses){
        if ((num == oneAddress.size()) && s.isEmpty()){
            //reformat and add to addresses
            StringBuffer sb = new StringBuffer();
            for (String str : oneAddress){
                sb.append(str);
                sb.append('.');
            }

            sb.deleteCharAt(sb.length() - 1);
            addresses.add(sb.toString());
            return;
        }

        if (s.isEmpty() || (num == oneAddress.size())){
            return;
        }

        //recursion
        // 0
        // 1, 1[0-9], 1[0-9][0-9]
        // 2, 2[0-9], 2[0-5][0-5]
        // n, n[0-9]
        char c = s.charAt(0);
        if (c == '0'){
            oneAddress.add("0");
            help(s.substring(1), num, oneAddress, addresses);
            oneAddress.remove(oneAddress.size() - 1);
        }else if (c == '1'){
            oneAddress.add(s.substring(0, 1));
            help(s.substring(1), num, oneAddress, addresses);
            oneAddress.remove(oneAddress.size() - 1);

            if (2 <= s.length()){
                oneAddress.add(s.substring(0, 2));
                help(s.substring(2), num, oneAddress, addresses);
                oneAddress.remove(oneAddress.size() - 1);
            }

            if (3 <= s.length()){
                oneAddress.add(s.substring(0, 3));
                help(s.substring(3), num, oneAddress, addresses);
                oneAddress.remove(oneAddress.size() - 1);
            }
        }else if (c == '2'){
            oneAddress.add(s.substring(0, 1));
            help(s.substring(1), num, oneAddress, addresses);
            oneAddress.remove(oneAddress.size() - 1);

            if (2 <= s.length()){
                oneAddress.add(s.substring(0, 2));
                help(s.substring(2), num, oneAddress, addresses);
                oneAddress.remove(oneAddress.size() - 1);
            }

            if ((3 <= s.length()) && (s.charAt(1) <= '5') && (s.charAt(2) <= '5')){
                oneAddress.add(s.substring(0, 3));
                help(s.substring(3), num, oneAddress, addresses);
                oneAddress.remove(oneAddress.size() - 1);
            }
        }else{
            oneAddress.add(s.substring(0, 1));
            help(s.substring(1), num, oneAddress, addresses);
            oneAddress.remove(oneAddress.size() - 1);

            if (2 <= s.length()){
                oneAddress.add(s.substring(0, 2));
                help(s.substring(2), num, oneAddress, addresses);
                oneAddress.remove(oneAddress.size() - 1);
            }
        }
    }

    public static void main(String[] args){
      RestoreIpAddress r = new RestoreIpAddress();
      List<String> results = r.restoreIpAddresses("25525511135");
      for(String str : results){
        System.out.println(str);
      }
    }
}
