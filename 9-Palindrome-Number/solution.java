public class Solution {
    public boolean isPalindrome(int x) {
        // best solution. only reversing till half and then compare, no need for overflow check.
        // 一定要有这个sanity check，否则110这样的数字会被return true，但显然是false；
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0; 
        while (x > reverse) {
            reverse = reverse * 10  + x % 10;
            x /= 10;
        }
        return (x == reverse || x == reverse / 10);
    }
}