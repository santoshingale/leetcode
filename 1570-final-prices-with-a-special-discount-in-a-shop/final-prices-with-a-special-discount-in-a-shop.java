class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        int i;
        int j;
        for(i = 0; i < n; i++){
            for(j = i + 1; j < n; j++){
                if(prices[i] >= prices[j]){
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
            if(j == n){
                result[i] = prices[i];
            }
        }
        return result;
    }
}