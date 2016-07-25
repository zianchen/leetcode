public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList();
        if (s == null) {
            return res;
        }
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        
        queue.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while (!queue.isEmpty()) {
            s = queue.poll();
            
            if (isValid(s)) {
                res.add(s);
                found = true;
            }
            // 注意，这里跟上面的if绝对不是一回事，这里是为了skip duplicate s
            if (found) {
                continue;
            }
            
            //generate all possible states
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }
                String t = s.substring(0, i) + s.substring(i + 1);
                
                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }
    
    boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            if (c == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    } 
}