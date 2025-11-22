class Solution {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() -1;
        char[] ca = s.toCharArray();
        while(l < r){
            if(!isVowel(ca[l])){
                l++;
            }else if(!isVowel(ca[r])){
                r--;
            }
            else{
                char temp = ca[l];
                ca[l] = ca[r];
                ca[r] = temp;
                l++;
                r--;
            }
        }
        return new String(ca);
    }

    public boolean isVowel(char x){
        if (x == 'a' || x == 'e' || x == 'i' ||
            x == 'o' || x == 'u' || x == 'A' ||
            x == 'E' || x == 'I' || x == 'O' || x == 'U')
            return true;
        else
            return false;
    }
}