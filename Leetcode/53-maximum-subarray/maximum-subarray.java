class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, curr = 0;
        for(int num:nums){
            curr = Math.max(num,curr+num); // make new or append in previous
            max = Math.max(max,curr);
        }
        return max;
    }
}