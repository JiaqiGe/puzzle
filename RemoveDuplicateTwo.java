// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
//
// For example,
// Given sorted array nums = [1,1,1,2,2,3],
//
// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
//  bug, line 21, nums[next] != nums[current]

public class RemoveDuplicateTwo{
    public int removeDuplicates(int[] nums){
        if(nums.length <= 2){
            return nums.length;
        }

        int toInsert = 0;
        int current = 0;

        while(current < nums.length){
            int next = current + 1;
            while(next < nums.length && nums[next] == nums[current]){
                next ++;
            }

            if(next - current == 1){
                //move one
                nums[toInsert] = nums[current];
                current ++;
                toInsert++;
            }else{
                nums[toInsert] = nums[current];
                nums[toInsert+1] = nums[current+1];
                toInsert += 2;
                current = next;
            }
        }

        return toInsert;
    }

    public static void main(String[] args){
        RemoveDuplicateTwo r = new RemoveDuplicateTwo();
        int[] nums = new int[]{1,1,1,2,2,3};
        int length = r.removeDuplicates(nums);
        // System.out.println(length);
        for(int i = 0; i < length; i++){
            System.out.print(nums[i]+" ");
        }
    }
}
