class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(! (str1+str2).equals(str2+str1)){
            return "";
        }
        int n = getGCD(str1.length(), str2.length());
        return str2.substring(0, n);
    }

    private int getGCD(int x, int y){
        if(y == 0){
            return x;
        }
        return getGCD(y, x % y);
    }
}