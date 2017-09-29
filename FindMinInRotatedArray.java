// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.

public class FindMinInRotatedArray {
    public int findMin(int[] nums){
        if (nums.length == 0){
            return 0;
        }

        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
          int mid = (lo + hi) / 2;

          if(mid == 0){
            return Math.min(nums[0], nums[1]);
          }else if(mid == nums.length - 1){
            return Math.min(nums[nums.length - 1], nums[nums.length - 2]);
          }

          if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]){
            return nums[mid];
          }

          if(nums[lo] <= nums[mid] && nums[mid] > nums[hi]){
            lo = mid + 1;
          }else if(nums[mid] <= nums[hi] && nums[mid] < nums[lo]){
            hi = mid - 1;
          }else{
            return nums[lo];
          }
        }
        return nums[lo];
    }
    public static void main(String[] args){
      int[] nums = new int[]{3,1,2};
      FindMinInRotatedArray f = new FindMinInRotatedArray();
      System.out.println(f.findMin(nums));
    }
}
