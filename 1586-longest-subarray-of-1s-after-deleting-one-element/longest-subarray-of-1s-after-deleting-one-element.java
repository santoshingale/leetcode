class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int count = 0;
        while(r < n){
            if(nums[r] == 0 ){
                count++;
            }
            r++;
            while(count > 1){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }

            result = Math.max(result, r - l - 1);
        }
        return result;
    }
}