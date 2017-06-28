// Given an array of strings, group anagrams together.
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:
//
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.

import java.util.*;

public class GroupAnagram{
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);

            if(map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());

        return result;
    }

    public static void main(String[] args){
        GroupAnagram g = new GroupAnagram();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> r = g.groupAnagrams(strs);

        for(List<String> list : r){
            for(String str : list){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
