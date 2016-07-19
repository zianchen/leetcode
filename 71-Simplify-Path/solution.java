public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        Deque<String> stk = new ArrayDeque();
        Set<String> set = new HashSet<>(Arrays.asList("..",".",""));
        for (String str : path.split("/")) {
            if (!stk.isEmpty() && str.equals("..")) {
                stk.pop();
            }
            if (!set.contains(str)) {
                stk.push(str);
            }
        }
        String res = "";
        for (String s : stk) {
            res = "/" + s + res;
        }
        return res.length() == 0 ? "/" : res; 
    }
}