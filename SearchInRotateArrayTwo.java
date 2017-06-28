// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Write a function to determine if a given target is in the array.
//
// The array may contain duplicates.
public class SearchInRotateArrayTwo{
    public boolean search(int[] nums, int target) {
            if(nums.length == 0){
                return false;
            }

            int lo = 0;
            int hi = nums.length - 1;

            while(lo <= hi){
                int mid = (lo + hi) / 2;

                if(nums[mid] == target){
                    return true;
                }else if(nums[mid] < target){
                    if(nums[mid] >= nums[lo] && nums[mid] >= nums[hi]){
                        lo = mid + 1;
                        while(lo <= hi && nums[lo] == nums[lo-1]){ lo ++; }
                    }else{
                        if(target <= nums[hi]){
                            lo = mid + 1;
                            while(lo <= hi && nums[lo] == nums[lo-1]){ lo++; }
                        }else{
                            hi = mid - 1;
                            while(hi >= lo && nums[hi] == nums[hi+1]){hi++;}
                        }
                    }
                }else{
                    if(nums[mid] <= nums[lo] && nums[mid] <= nums[hi]){
                        hi = mid - 1;
                        while(hi >= lo && nums[hi] == nums[hi+1]){hi --;}
                    }else{
                        if(target >= nums[lo]){
                            hi = mid - 1;
                            while(hi >= lo && nums[hi] == nums[hi-1]){hi --;}
                        }else{
                            lo = mid + 1;
                            while(lo <= hi && nums[lo] == nums[lo-1]){lo ++;}
                        }
                    }
                }
            }
            return false;
    }

    public static void main(String[] args){
        SearchInRotateArrayTwo s = new SearchInRotateArrayTwo();
        int[] nums = new int[]{4};
        System.out.println(s.search(nums, 4));
    }
}
