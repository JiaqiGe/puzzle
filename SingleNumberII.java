// Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
public class SingleNumberII {
    public int singleNumber(int[] nums){
        if (nums.length == 0){
            return 0;
        }

        int[] v = new int[32];
        for(int i = 0; i < nums.length; i++){
          int mask = 1;
          for(int j = 0; j < 32; j++){
            // get the value at jth bit, either 0 or 1
            int bit = nums[i] & mask;
            mask = mask << 1;
            v[j] += bit;
          }
        }
        int result = 0;
        int exp = 1;

        for(int i = 0; i < v.length; i++){
          result += (v[i] % 3) * exp;
          exp = exp << 1;
        }
        return result;
    }

    public static void main(String[] args){
      int[] nums = new int[]{7,7,7,6,6,6,4};
      SingleNumberII s = new SingleNumberII();

      System.out.println(s.singleNumber(nums));
    }
}
