public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Arrays.sort(strs);
        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String modify = String.valueOf(tmp); 
            // String modify = Collection.sort(strs[i]);   不能直接sort string，必须是个list  sort(List<T> list)
            if (!map.containsKey(modify)) {
                map.put(modify, new ArrayList<String>());
            } 
            map.get(modify).add(s);
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}