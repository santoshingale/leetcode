class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=0, y=nums.length-1 ; i<y ;){
            if(nums[i]+nums[y]==k){
                ans++;
                i++;
                y--;
            }
            else if(nums[i]+nums[y]<k){
                i++;
            }
            else{
                y--;
            }
        }
        return ans;
    }
}