class Solution {
    public void sortColors(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = 0;

        // Count each color
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }

        int index = 0;

        // Fill 0s
        while (zero-- > 0) {
            nums[index++] = 0;
        }

        // Fill 1s
        while (one-- > 0) {
            nums[index++] = 1;
        }

        // Fill 2s
        while (two-- > 0) {
            nums[index++] = 2;
        }
    }
}