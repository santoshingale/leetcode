class Solution {
    public int findComplement(int num) {
        
        long i=1;
        while(i<=num)
        {
            num^=i;
            i<<=1;
        }
        return num;
    }
}