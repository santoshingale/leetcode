class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] countN = count(n);
        for(int i = 0; i < 31; i++){
            if(Arrays.equals(countN, count(1 << i)))
                return true;
        }
        return false;

    }
    
    public int[] count(int n){
        int[] ans = new int[10];
        while(n > 0){
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
}