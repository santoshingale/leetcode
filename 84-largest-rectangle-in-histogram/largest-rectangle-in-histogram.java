class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] dp1 = prevSmaller(heights);
        int[] dp2 = nextSmaller(heights);
        // -1 -1 1 2  1  4
        //  1  6 4 4  6  6
        int result = 0;
        for(int i = 0; i < heights.length; i++){
            int curr = (dp2[i] - dp1[i] - 1) * heights[i];
            if(curr > result){
                result = curr;
            }
        }
        return result;
    }
    
    
    public int[] prevSmaller(int[] heights){
        Stack<Integer> stack = new Stack();
        int[] dp = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
             while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                dp[i] = -1;
            }else
                dp[i] = stack.peek();
            
            stack.add(i);
        }
        return dp;
    }
    
    public int[] nextSmaller(int[] heights){
        Stack<Integer> stack = new Stack();
        int[] dp = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                dp[i] = heights.length ;
            }else
                dp[i] = stack.peek();
            
            stack.add(i);
        }
        return dp;
    }
}