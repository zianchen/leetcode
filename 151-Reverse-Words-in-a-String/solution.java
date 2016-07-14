public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >=0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }
        /*
        1. remove the last " "
        2. 当String只有空格的时候，split出来的数组长度为0
        String input = " ";
		String[] array = input.split(" ");
		System.out.println("array length is :" + array.length); 结果是0
        */
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}