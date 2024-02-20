package Leetcode;
class Missing_Number_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        for(int i=0;i<n;i++){
            sum = sum - nums[i];
        }
        return sum;
    }
}