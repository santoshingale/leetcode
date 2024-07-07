class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int rem = 0;
        while(numBottles/numExchange != 0) {
            count += numBottles / numExchange;
            rem = numBottles % numExchange;            
            numBottles /= numExchange;
            numBottles += rem;
        }
        return count;
    }
}