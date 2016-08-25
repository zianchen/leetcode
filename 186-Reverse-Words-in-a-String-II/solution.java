public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int i = 0;
        for (int j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j-1);
                i = j + 1;
            }
        }
    }
    
    public void reverse(char[] s, int begin, int end) {
        while (begin < end) {
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }
    }
}