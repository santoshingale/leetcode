class Solution {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int n = nums.length;
        int curMax = n - 1;
        int leftMin = -1;
        int rightMax = -1; 
        for(int i = n - 2; i >= 0 ; i--){
            if(nums[curMax] < nums[i]){
                curMax = i;
            }else if(nums[curMax] > nums[i]){
                leftMin = curMax;
                rightMax = i;
            }
        }
        if(leftMin != -1){
            char temp = nums[leftMin];
            nums[leftMin] = nums[rightMax];
            nums[rightMax] = temp;
            return Integer.parseInt(new String(nums));
        }
        return num;
    }
}
