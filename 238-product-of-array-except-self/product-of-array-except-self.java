class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        for(int i =0, temp = 1; i < n; i++){
            sum[i] = temp;
            temp *= nums[i];
        }
        
        for(int i =n-1, temp = 1; i >=0; i--){
            sum[i] *= temp;
            temp *= nums[i];
        }
        return sum;
    }
}
