class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack();

        for(int i = nums2.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            int result = -1;
            if(!stack.isEmpty()){
                result = stack.peek();
            }
            if(map.containsKey(nums2[i])){
                nums1[map.get(nums2[i])] = result;
            }
            stack.push(nums2[i]);
        }
        return nums1;
    }
}