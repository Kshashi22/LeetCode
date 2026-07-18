class Solution {
    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum values
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Find GCD by checking all divisors
        for (int i = min; i >= 1; i--) {
            if (min % i == 0 && max % i == 0) {
                return i;
            }
        }

        return 1;
    }
}