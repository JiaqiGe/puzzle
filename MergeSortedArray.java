// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
// Note:
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
// The number of elements initialized in nums1 and nums2 are m and n respectively.
// [1,2 ,5, 0,0,0]
// [3,4, 6]

// !!!! backwards iteration

public class MergeSortedArray{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       if(n == 0){
           return;
       }

       int i = m-1;
       int j = n-1;

       int idx = m+n-1;
       while(i >= 0 && j >= 0){
           if(nums1[i] > nums2[j]){
               nums1[idx] = nums1[i];
               i--;
               idx--;
           }else{
               nums1[idx] = nums2[j];
               j--;
               idx--;
           }
       }

       while(j >= 0){
           nums1[idx] = nums2[j];
           j--;
           idx--;
       }

       return;
   }

   public static void main(String[] args){
       int[] nums1 = new int[]{1,2 ,7, 0,0,0};
       int[] nums2 = new int[]{3,4, 6};
       MergeSortedArray ma = new MergeSortedArray();
       int m = 3;
       int n = 3;
       ma.merge(nums1, m, nums2, n);
       for(int i = 0; i <  m + n; i++){
           System.out.println(nums1[i]);
       }
   }
}
