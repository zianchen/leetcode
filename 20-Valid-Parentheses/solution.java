public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stk = new Stack();
        for (char c : s.toCharArray()) {
            if ("([{".contains(String.valueOf(c))) {
                stk.push(c);
            } else if (!stk.isEmpty() && isValid(stk.peek(), c)) {
                stk.pop();
            } else {
                return false;
            }
        }
        return stk.isEmpty();
    }
    public boolean isValid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
            || (c1 == '[' && c2 == ']');
    }
}