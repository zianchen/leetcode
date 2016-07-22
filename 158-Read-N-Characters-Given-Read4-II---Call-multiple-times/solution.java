/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    private Queue<Character> remains = new LinkedList(); 
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n && !remains.isEmpty()) {
            buf[i++] = remains.poll();
        }
        
        char[] tmp = new char[4];
        for (; i < n; i += 4) {
            int len = read4(tmp);
            if (len + i > n) {
                System.arraycopy(tmp, 0, buf, i, n-i);
                for (int j = n-i; j < len; j++) {
                    remains.offer(tmp[j]);
                }
            } else {
                System.arraycopy(tmp, 0, buf, i, len);
            }
            
            if (len < 4) {
                return Math.min(len + i, n);
            }
        }
        return n;
    }
}