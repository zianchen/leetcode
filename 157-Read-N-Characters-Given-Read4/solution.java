/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        for (int i = 0; i < n; i += 4) {
            int len = read4(tmp);
            System.arraycopy(tmp, 0, buf, i, Math.min(len, n-i));
            if (len < 4) {
                return Math.min(i + len, n);   //这里非常tricky，就算len<4(也即文件被读完)，仍有可能这时候n - i < len，比如剩下的n-i只有2个了，然后这时候len读出了3个，这时候i+len仍然是比n大的。
            }
        }
        return n;
    }
}