class Solution {
    public int maximumCandies(int[] candies, long k) {
        int start = 0;
        int end = candies[0];
        // find max candy
        for(int c: candies) {
            if(end < c) {
                end = c;
            }
        }
        
        // Binary search
        while(start < end) {
            int mid = start + ((end - start + 1) / 2);
            if(helper(candies, k, mid)) {
                start = mid; 
            }
            else {
                end = mid - 1;
            }
        }
        return start;
    }

    // actual logic to find 
    private boolean helper(int[] candies, long k, int numberOfCandies) {
        long currentCount = 0;

        for( int i = 0; i < candies.length; i++) {
           currentCount += candies[i] / numberOfCandies;
        }
        return currentCount >= k;
    }
}