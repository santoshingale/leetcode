class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] result = new int[n];
        int index = n - 1;
        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                result[index] = nums[left] * nums[left];
                left++;
            }else{
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }
}