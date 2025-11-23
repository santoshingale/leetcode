class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int max = 0;
        while(r < n){
            while(k == 0 && nums[r] == 0){
                k += nums[l] == 0 ? 1 : 0;
                l++;
            }

            if(nums[r] == 0){
                k--;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}