import java.util.*;

public class EqualSplit{
  public boolean isSplitable(int[] nums, int k){
    if(nums.length == 0){
      return k == 0;
    }

    if(k <= 0){
      return false;
    }

    int sum = 0;
    for(int v : nums){
      sum += v;
    }

    if(sum % k != 0){
      return false;
    }

    int[] values = new int[k];
    Arrays.fill(values, sum / k);

    for(int v : nums){
      if(v > sum / k){
        return false;
      }
    }
    return help(nums, 0, values, sum / k);
  }

  private boolean help(int[] nums, int lo, int[] values, int target){
    // help function for recursion

    // base
    if(lo >= nums.length){
      for(int v : values){
        if(v != 0){
          return false;
        }
      }
      return true;
    }

    // recursive function
    boolean r = false;
    for(int i = 0; i < values.length; i++){
      if(values[i] >= nums[lo]){
          values[i] -= nums[lo];
          r = r || help(nums, lo+1, values, target);
          values[i] += nums[lo];
      }
    }

    return r;
  }

  public static void main(String[] args){
    EqualSplit e = new EqualSplit();
    int[] nums = new int[]{1,2,3,4};
    System.out.println(e.isSplitable(nums, 2));
  }
}
