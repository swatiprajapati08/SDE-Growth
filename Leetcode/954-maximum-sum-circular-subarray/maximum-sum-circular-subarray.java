class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for (int i : nums)
            totalSum += i;

        int min = KadaneMin(nums, n);
        int max = KadaneMax(nums, n);
        
        //we know if max = totalSum - min , if min is less then max is more
        int circularSum = totalSum - min;

        // why max > 0 for case {-1,-1,-1} totalsum = -3, min -3,max = -1, circularSum = 0, ans = max(-1,0) which is wrong, koi bhi sum 0 ni h
        return max > 0 ? Math.max(circularSum, max) : max;
    }

    int KadaneMax(int[] nums, int n) {
        int result = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            result = Math.max(result, maxSum);
        }
        return result;
    }

    int KadaneMin(int[] nums, int n) {
        int result = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < n; i++) {
            minSum = Math.min(nums[i], minSum + nums[i]);
            result = Math.min(result, minSum);
        }
        return result;
    }
}