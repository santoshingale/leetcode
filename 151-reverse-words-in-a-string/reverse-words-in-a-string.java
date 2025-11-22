public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        
        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;
        int j = s.length() - 1;
        
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            
            j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(s.substring(i + 1, j + 1));
        }
        

        return result.toString();
    }
}