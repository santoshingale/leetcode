class Solution {
    public boolean makesquare(int[] m) {
        int n=m.length;
        if(n<4)return false;
        int sum=0;
        for(int i:m)sum+=i;
        if(sum%4!=0)return false;
        sum/=4;
        Arrays.sort(m);
        reverse(m,n);
        return backtrack(new int[4],m,0,n,sum);
    }
    private boolean backtrack(int[] arr,int[] m,int idx,int n,int target) {
        if(idx==n){
            return arr[0]==target && arr[1]==target && arr[2]==target && arr[3]==target;
        }
        for(int i=0;i<4;i++){
            if(arr[i]>target)return false;
            arr[i]+=m[idx];
            if(backtrack(arr,m,idx+1,n,target))return true;
            arr[i]-=m[idx];
            if(arr[i]==0)break;// reduces the efficiency from 2020ms to 50ms
        }
        return false;
    }
    public void reverse(int[] arr,int n){
        for(int i=0;i<n/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }
}