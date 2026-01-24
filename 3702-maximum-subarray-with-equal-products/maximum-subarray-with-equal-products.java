class Solution {
    public int maxLength(int[] nums) {
            int ans=0,max=1;
        for(int j=0;j<nums.length;j++){
            
            int g=0;
            int l=1;
            int p=1;
            for(int i=j;i<nums.length;i++){
                g=gcd(g,nums[i]);
                l=(l/gcd(l,nums[i]))*nums[i];
                p=p*nums[i];
                if(g*l==p)
                    ans=Math.max(ans,i-j+1);
            }
        }
        return ans;
    }
    int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}