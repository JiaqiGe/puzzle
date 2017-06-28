// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
// The replacement must be in-place, do not allocate extra memory.
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

public class NextPermutation {
   public void nextPermutation(int[] nums){
      // edge cases
      if (nums.length <= 1){
         return;
      }

      //find the first element which is larger the one right ahead it
      int pos1 = -1;
      for (int i = nums.length - 1; i > 0; i--){
         if (nums[i] > nums[i - 1]){
            pos1 = i;
            break;
         }
      }

      if (pos1 == -1){
         reverse(nums, 0, nums.length - 1);
         return;
      }
      //reverse the numbers from pos1 to end
      reverse(nums, pos1, nums.length - 1);

      //swap pos1 and the first element larger than it
      for (int i = pos1; i < nums.length; i++){
         if (nums[i] > nums[pos1 - 1]){
            //swap
            int tmp = nums[i];
            nums[i]        = nums[pos1 - 1];
            nums[pos1 - 1] = tmp;
            break;
         }
      }
   }

   private void reverse(int[] nums, int lo, int hi){
      while (lo < hi){
         //swap
         int tmp = nums[lo];
         nums[lo] = nums[hi];
         nums[hi] = tmp;

         lo++;
         hi--;
      }
   }

   private void print(int[] nums){
      for (int num : nums){
         System.out.print(num);
      }
      System.out.print('\n');
   }

   public static void main(String[] args){
      int[]           nums = new int[] { 1, 2, 3, 4};
      NextPermutation n    = new NextPermutation();
      n.print(nums);

      int i = 0;
      while (i < 16){
         n.nextPermutation(nums);
         n.print(nums);

         i++;
      }
   }
}
