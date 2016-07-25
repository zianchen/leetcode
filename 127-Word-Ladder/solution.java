public class Solution {
    
    private Queue<String> toVisit = new LinkedList();
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        int dist = 2;
        addNextWords(beginWord, wordList);
        while (!toVisit.isEmpty()) {
            int num = toVisit.size();
            for (int i = 0; i < num; i++) {
                String candidate = toVisit.poll();
                if (candidate.equals(endWord)) {
                    return dist;
                }
                wordList.remove(candidate);
                addNextWords(candidate, wordList);
            }
            dist++;
        }
        return 0;
    }
    
    public void addNextWords(String candidate, Set<String> wordList) {
        char[] str = candidate.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char letter = str[i];
            for (int j = 0; j < 26; j++) {
                str[i] = (char)(j + 'a');
                String nextStr = String.valueOf(str);
                if (wordList.contains(nextStr)) {
                    toVisit.add(nextStr);
                    wordList.remove(nextStr);
                }
            }
            str[i] = letter;
        }
    }
}