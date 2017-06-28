import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note: The solution set must not contain duplicate triplets.
//
// For example, given array S = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

public class ThreeSum {
   public List<List<Integer> > threeSum(int[] nums)
   {
      List<List<Integer> > result = new ArrayList<>();
      if (nums.length < 3)
      {
         return result;
      }

      Arrays.sort(nums);

      for (int i = 0; i < nums.length - 2; i++)
      {
         if ((i > 0) && (nums[i] == nums[i - 1]))
         {
            continue;
         }
         Set<List<Integer> > twoSum = findTwoSum(nums, i + 1, -nums[i]);
         for (List<Integer> twoNums : twoSum)
         {
            List<Integer> oneList = new ArrayList<>();
            oneList.add(nums[i]);
            oneList.addAll(twoNums);
            result.add(oneList);
         }
      }

      return result;
   }

   // find two integers whose summation equals to target in a sorted array
   private Set<List<Integer> > findTwoSum(int[] nums, int start, int target)
   {
      Set<List<Integer> > result = new HashSet<>();
      int                 lo     = start;
      int                 hi     = nums.length - 1;

      while (lo < hi)
      {
         int sum = nums[lo] + nums[hi];
         if (sum == target)
         {
            List<Integer> oneList = new ArrayList<>();
            oneList.add(nums[lo]);
            oneList.add(nums[hi]);
            result.add(oneList);
            lo++;
            hi--;
         }
         else if (sum < target)
         {
            lo++;
         }
         else
         {
            hi--;
         }
      }
      return result;
   }

   public static void main(String[] args)
   {
      int[]    nums = { -1, 0, 1, 2, -1, -4 };
      ThreeSum t    = new ThreeSum();
      System.out.println(t.threeSum(nums));
   }
}
