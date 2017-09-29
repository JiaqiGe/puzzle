// Maximum Product Subarray
//
// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

public class MaxProductSubArray {
    public int maxProduct(int[] nums){
      if(nums.length == 0){
        return 0;
      }
      int max = nums[0];
      int maxAt = nums[0];
      int minAt = nums[0];

      for(int i = 1; i < nums.length; i++){
        int newMaxAt = Math.max(minAt*nums[i], Math.max(maxAt*nums[i], nums[i]));
        int newMinAt = Math.min(minAt*nums[i], Math.min(maxAt*nums[i], nums[i]));

        maxAt = newMaxAt;
        minAt = newMinAt;

        max = Math.max(max, maxAt);
      }
      return max;
    }
    public static void main(String[] args){
      MaxProductSubArray m = new MaxProductSubArray();
      int[] nums = new int[]{2,-5,-2,-4,3};
      System.out.println(m.maxProduct(nums));
    }
}
