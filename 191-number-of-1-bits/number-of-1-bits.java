public class Solution {
    public int hammingWeight(int n) {
        int ones = 0;
    	while(n!=0) {
    		int rmsb = n & (-n);
    		n -= rmsb;
            ones++;
    	}
    	return ones;
    }
}

// note i have use Kernighan's Algorithm
// ex : 11
// binary : 1011
// rmsb : 0001 which is 2s comp of number;
// remove last bit form number and increase the conter