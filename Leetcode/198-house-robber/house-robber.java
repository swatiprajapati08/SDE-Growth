class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return Math.max(robbing(0, nums, dp), robbing(1, nums, dp));
    }

    int robbing(int curr, int[] nums, int dp[]) {
        if (curr >= nums.length)
            return 0;

        if (dp[curr] != -1)
            return dp[curr];

        int yes = robbing(curr + 2, nums, dp) + nums[curr];
        int no = robbing(curr + 1, nums, dp);

        return dp[curr] = Math.max(yes, no);
    }
}