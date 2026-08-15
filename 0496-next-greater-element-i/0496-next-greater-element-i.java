class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int greater = -1;

            // Find target in nums2
            for (int j = 0; j < nums2.length; j++) {
                
                if (nums2[j] == target) {
                    
                    // Search right side
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > target) {
                            greater = nums2[k];
                            break;
                        }
                    }
                    
                    break;
                }
            }

            result[i] = greater;
        }

        return result;
    }
}