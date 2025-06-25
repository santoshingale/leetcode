class Solution {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int n = nums.length;
        int curMax = n - 1;
        int leftMax = -1;
        int rightMin = -1; 
        for(int i = n - 2; i >= 0 ; i--){
            if(nums[curMax] < nums[i]){
                curMax = i;
            }else if(nums[curMax] > nums[i]){
                leftMax = curMax;
                rightMin = i;
            }
        }
        if(leftMax != -1){
            char temp = nums[leftMax];
            nums[leftMax] = nums[rightMin];
            nums[rightMin] = temp;
            return Integer.parseInt(new String(nums));
        }
        return num;
    }
}
