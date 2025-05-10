class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        boolean flag = true;
        while(slow != fast || flag){
            flag = false;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}