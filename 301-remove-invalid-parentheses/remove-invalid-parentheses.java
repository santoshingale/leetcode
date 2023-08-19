class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int minRem = minRemove(s);
        List<String> result = new ArrayList();
        System.out.println(minRem);
        Set<String> visited = new HashSet<>();

        removeInvalidParenthesesHelper(s, minRem, result, visited);
        return result;
    }

    private void removeInvalidParenthesesHelper(String s, int needToRemove, List<String> result, Set<String> visited){
        if(visited.contains(s)) return;
        visited.add(s);

        if(needToRemove == 0){
            if(isValid(s)){
                result.add(s);
                return;
            }
        }
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            removeInvalidParenthesesHelper(left + right, needToRemove - 1, result, visited);
        }
    }

    private boolean isValid(String s){
        int open = 0; 
        int close = 0;
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                continue;
            }
            if(c == '('){
                open++;
            }else{
                close++;
            }
            if(close > open) return false;
        }
        return close == open;
    }

    private int minRemove(String s){
        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.add('(');
            }else if(c == ')'){
                if(stack.isEmpty() || stack.peek() == ')'){
                    stack.add(')');
                }else{
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}