public class Solution {
    
    private List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return res;            
        }
        helper("",num, target, 0,0,0);
        return res;
    }
    
    public void helper(String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path);
            } 
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i+1));
            if (pos == 0) {
                helper(path + cur, num, target, i+1, cur, cur);
            } else {
                helper(path + "+" + cur, num, target, i+1, eval + cur, cur);
                helper(path + "-" + cur, num, target, i+1, eval - cur, -cur);
                helper(path + "*" + cur, num, target, i+1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}