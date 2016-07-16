public class Solution {
    public String countAndSay(int n) {
        String oldString = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder curr = new StringBuilder();
            char[] oldChars = oldString.toCharArray();
            
            for (int j = 0; j < oldChars.length; j++) {
                int count = 1;
                while ((j+1) < oldChars.length && oldChars[j] == oldChars[j+1]) {
                    count++;
                    j++;
                }
                curr.append(count).append(oldChars[j]);
            }
            oldString = curr.toString();
        }
        return oldString;
    }
}