class Solution {
    public int findPeakElement(int[] nums) 
    {
     int max = Integer.MIN_VALUE;
     int max_index = 0;
     for(int i=0;i<nums.length;i++)
     {
      if(nums[i]>max)  
      {
        max = nums[i];
        max_index = i;
      }
     } 
     return max_index;  
    }
}