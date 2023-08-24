class Solution {
    public int nextGreaterElement(int n) {
        //1.convert integer into array
        String s=Integer.toString(n);
        int[] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=(int)(s.charAt(i)-'0');
        }
        
        //2. first job is to find the value with smaller value than of its right
        int idx=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx=i;
                break;
            }
        }
        
        //3.It means that next greater doesn't exist eg:21
        if(idx==-1) return -1;
        
        int val=arr[idx];
        int j=idx+1;
        int jm=arr[idx+1]; //just max
        
        //4. find just greater value in right most (<=jm 444 will choose rightmost 4) 
        for(int i=idx+1;i<arr.length;i++){
            if(arr[i]>val && arr[i]<=jm){
                jm=arr[i];
                j=i;
            }
        }
         
        
        swap(arr,idx,j);
        //5. number from idx+1 are in increasing order reverse them
        reverse(arr,idx+1,arr.length-1);
        
        int ans=0;
    
        long a=0;
        int mult=1;
        for(int i=arr.length-1;i>=0;i--){
            a+=(long)arr[i]*mult;
            mult=mult*10;
        }
        
         //6.final check have we croosed the integer max value or not
          return a>Integer.MAX_VALUE?-1:(int)a;
    }
    
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    public static void reverse(int[] arr,int l,int r){
        while(l<r){
            swap(arr,l,r);
            l++;
            r--;
        }
    }
}