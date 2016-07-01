public class Solution {
    
    public List<String> findStrobogrammatic(int n) {
        return dfs(n,n);
    }
    
    List<String> dfs(int curLen, int n) {
        if (curLen == 0) return new ArrayList<String>(Arrays.asList(""));
        if (curLen == 1) return new ArrayList<String>(Arrays.asList("1","8","0"));
        
        List<String> list = dfs(curLen - 2, n);
        List<String> ret = new ArrayList();
        
        for (int i = 0; i < list.size(); i++) {
            if (curLen != n) {
                ret.add("0" + list.get(i) + "0");
            }
            ret.add("1" + list.get(i) + "1");
            ret.add("8" + list.get(i) + "8");
            ret.add("6" + list.get(i) + "9");
            ret.add("9" + list.get(i) + "6");
        }
        return ret;
    }
}