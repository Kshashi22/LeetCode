import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        // 1. Find the maximum element to set the bounds for our sieve arrays
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // Count how many times each number appears in the input 'nums'
        int[] count = new int[maxNum + 1];
        for (int num : nums) {
            count[num]++;
        }

        // countDivisors[d] will store how many numbers in 'nums' are multiples of d
        long[] countDivisors = new long[maxNum + 1];
        for (int d = 1; d <= maxNum; d++) {
            for (int multiple = d; multiple <= maxNum; multiple += d) {
                countDivisors[d] += count[multiple];
            }
        }

        // countGcdPairs[g] will store the EXACT number of pairs whose GCD is exactly g
        long[] countGcdPairs = new long[maxNum + 1];
        
        // Sieve backwards using the inclusion-exclusion principle
        for (int g = maxNum; g >= 1; g--) {
            long totalMultiples = countDivisors[g];
            // Total combinations of pairs that share 'g' as a common factor
            long totalPairs = totalMultiples * (totalMultiples - 1) / 2;

            // Subtract pairs whose actual GCD is a larger multiple of g (e.g., 2g, 3g...)
            for (int largerG = 2 * g; largerG <= maxNum; largerG += g) {
                totalPairs -= countGcdPairs[largerG];
            }
            countGcdPairs[g] = totalPairs;
        }

        // 2. Build cumulative prefix sums of the exact pairs to act as our virtual sorted array
        long[] prefixSums = new long[maxNum + 1];
        for (int i = 1; i <= maxNum; i++) {
            prefixSums[i] = prefixSums[i - 1] + countGcdPairs[i];
        }

        // 3. Match the query indexes using Binary Search
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = binarySearch(prefixSums, queries[i]);
        }

        return answer;
    }

    // Upper bound binary search to locate where the query index falls
    private int binarySearch(long[] prefixSums, long target) {
        int low = 1;
        int high = prefixSums.length - 1;
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] > target) {
                result = mid; // This is a possible answer, look left for a smaller GCD value
                high = mid - 1;
            } else {
                low = mid + 1; // Look right
            }
        }
        return result;
    }
}