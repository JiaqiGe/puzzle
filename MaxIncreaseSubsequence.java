// Given an array of integers, find the maximun length of the increasing sequence.
// E.g., nums = [1,4,6,2,7,8], the maximun subsequence is [1,4,6,7,8]

public class MaxIncreaseSubsequence{
  public int getMaxLength(int[] nums){
    if(nums.length == 0){
      return 0;
    }

    //dp
    int[] maxLengthAt = new int[nums.length];
    // initialize
    maxLengthAt[nums.length-1] = 1;

    //iteration
    for(int i = nums.length - 2; i >= 0; i--){
      maxLengthAt[i] = 1;
      for(int j = i + 1; j < nums.length; j++){
        if(nums[j] > nums[i]){
          maxLengthAt[i] = Math.max(maxLengthAt[i], maxLengthAt[j]+1);
        }
      }
    }

    int maxLength = 1;
    for(int i = 0; i < nums.length; i++){
      maxLength = Math.max(maxLength, maxLengthAt[i]);
    }

    return maxLength;
  }

  public static void main(String[] args){
    MaxIncreaseSubsequence m = new MaxIncreaseSubsequence();
    int[] nums = {9,8,7};
    System.out.println(m.getMaxLength(nums));
  }
}
