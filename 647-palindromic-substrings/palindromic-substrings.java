class Solution {
    public int countSubstrings(String s) {
        if(s.length()<2){
            return s.length();
        }
        int ans = 0;
        //traverse
        for(int i=0;i<s.length();i++){
            //for odd
            int left = i, right = i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                ans++;
                left--;
                right++;
            }
            //for even
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}