class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,0);
        return climbStairs(n,new int[n+1]);
    }

    int climbStairs(int n,int[] dp){
        if(n == 0) return 1;

        if(n < 0 ) return 0;

        // use dp
        if(dp[n] != 0) return dp[n];


        int step1 = climbStairs(n-1,dp);
        int step2 = climbStairs(n-2,dp);


        return dp[n] = step1+step2;

        
    }
}