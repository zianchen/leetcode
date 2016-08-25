public class Solution {
    public String convertToTitle(int n) {
        // 注意n--,因为n == 1对应A而算offset(A + n % 26)的时候n == 0对应A
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
}