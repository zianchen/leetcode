public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || numRows == 0) {
            throw new IllegalArgumentException("not valid input");
        }
        if (s.length() == 0 || numRows == 1) {
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int k = 0; k < res.length; k++) {
            res[k] = new StringBuilder();
        }
        int index = 0, i = 0;
        while(i < s.length()) {
            while (index < numRows && i < s.length()) {
                res[index++].append(s.charAt(i++));
            }
            index -= 2;
            while (index >= 0 && i < s.length()) {
                res[index--].append(s.charAt(i++));
            }
            index += 2;
        }
        for (int j = 1; j < res.length; j++) {
            res[0].append(res[j]);
        }
        return res[0].toString();
    }
}