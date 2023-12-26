class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for(int num = 1; num <= n; num++){
            int temp = num;
            int count = 0;
            while(temp != 0){
                temp = temp & (temp - 1);
                count++;
            }
            ans[num] = count;
        }
        return ans;
    }
}