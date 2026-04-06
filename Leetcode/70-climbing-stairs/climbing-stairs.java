class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        // Arrays.fill(dp, 0);
        // return climbStairs(n, new int[n + 1]);

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    // using recurision
    int climbStairs(int n, int[] dp) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        // use dp
        if (dp[n] != 0)
            return dp[n];

        int step1 = climbStairs(n - 1, dp);
        int step2 = climbStairs(n - 2, dp);

        return dp[n] = step1 + step2;

    }
}