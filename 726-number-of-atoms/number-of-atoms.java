class Solution {
    public String countOfAtoms(String formula) {
        //stores -> pair(symbol, count)
        Stack<Pair<String, Integer>> solve = new Stack<>();
        int len = formula.length();


        for(int i = 0; i < len;) {

            //if character is open bracket "("
            if(formula.charAt(i) == '(') {
                solve.push(new Pair<String, Integer>("(", 0));
                i++;

            } else if(formula.charAt(i) == ')') {
                //here we are solving for when we encounter ")" close bracket
                //1. store the integer after ")" as we will have to multiply this number with the count of symbols's count inside "(X2Y3)5"
                i++;
                StringBuilder sec = new StringBuilder("0");
                while(i<len && Character.isDigit(formula.charAt(i))) {
                    sec.append(formula.charAt(i));
                    i++;
                }
                Integer inte = Integer.parseInt(sec.toString());
                inte = inte == 0 ? 1 : inte;

                //popping elements until we encounter open brack -> now stack will contain element within the brackets "(X2Y3)"
                Stack<Pair<String, Integer>> stack = new Stack<>();
                while( !(solve.peek().getKey()).equals("(")) {
                    stack.push(solve.pop());
                }
                //popping "(" open bracket from "solution"
                solve.pop();

                //popping stored element from stack and adding them to store by multiplying the count "inte" Ex: (X2Y3)5 -> inte=5  stack = (X,2), (Y,3)
                //storing in "solve" -> (X,2*5), (Y,3*5)
                while(!stack.isEmpty()) {
                    Pair<String, Integer> p = stack.pop();
                    solve.push(new Pair<String, Integer>(p.getKey(), p.getValue()*inte));
                }

            } else if(Character.isUpperCase(formula.charAt(i))) {
                //encounterd a upper case element that will be stores in solve as a particular element
                //"sym" stores symbl name
                StringBuilder sym = new StringBuilder(formula.charAt(i)+"");
                i++;
                while(i < len && Character.isLowerCase(formula.charAt(i))) {
                    sym.append(formula.charAt(i)+"");
                    i++;
                }

                //"sec" stores string form integer count
                StringBuilder sec = new StringBuilder("0");
                while(i < len && Character.isDigit(formula.charAt(i))) {
                    sec.append(formula.charAt(i));
                    i++;
                }
                Integer inte = Integer.parseInt(sec.toString());
                inte = inte == 0 ? 1 : inte;
                solve.push(new Pair<String, Integer>(sym.toString(), inte));
            }
        }


        //combining the repeated elements using map
        //Ex -> (O2X2O5) -> (O7X2)
        Map<String, Integer> map = new HashMap<>();
        Stack<String> dummy = new Stack<>();
        while(!solve.isEmpty()) {
            Pair<String, Integer> p = solve.pop();
            if(!map.containsKey(p.getKey())) dummy.add(p.getKey());
            map.put(p.getKey(), map.getOrDefault(p.getKey(), 0)+p.getValue());
        }

        //sorting according to the names of unique elements
        Collections.sort(dummy, Collections.reverseOrder());

        //storing concatenated answer in StringBuilder ans
        StringBuilder ans = new StringBuilder();
        while(!dummy.isEmpty()) {
            String s = dummy.pop();
            ans.append(s);
            if(map.get(s) != 1) ans.append(map.get(s)+"");
        }

        return ans.toString();
    }
}