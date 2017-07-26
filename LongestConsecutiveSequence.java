//
// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
// Your algorithm should run in O(n) complexity.

import java.util.*;

public class LongestConsecutiveSequence{
  public int longestConsecutive(int[] nums) {
      if(nums.length == 0){
        return 0;
      }

      Set<Integer> set = new HashSet<>();
      Set<Integer> isVisited = new HashSet<>();

      for(int i : nums){
          set.add(i);
      }

      int maxLength = 0;

      for(int i = 0; i < nums.length; i++){
        if(!isVisited.contains(nums[i])){
          int lo = nums[i] - 1;
          int hi = nums[i] + 1;
          isVisited.add(nums[i]);

          while(set.contains(hi)){
            isVisited.add(hi);
            hi ++;
          }

          while(set.contains(lo)){
            isVisited.add(lo);
            lo--;
          }
          maxLength = Math.max(maxLength, hi - lo - 1);
        }
      }

      return maxLength;
  }

  public static void main(String[] args){
    int[] nums = new int[]{100, 4, 200, 1, 3, 2};
    LongestConsecutiveSequence l = new LongestConsecutiveSequence();
    System.out.println(l.longestConsecutive(nums));
  }
}
