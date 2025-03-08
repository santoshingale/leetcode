class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] charArr = blocks.toCharArray();
        int countW = 0;
        for(int i = 0; i < k; i++){
            if(charArr[i] == 'W'){
                countW++;
            }
        }
        int count = countW;

        for(int i = 1; i <= charArr.length - k; i++){
            if(charArr[i - 1] == 'W') countW--;
            if(charArr[i + k - 1] == 'W') countW++;
            count = Math.min(count, countW);
        }
        return count;
    }
}