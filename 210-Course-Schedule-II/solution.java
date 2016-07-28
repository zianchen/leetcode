public class Solution {
    // topological sort 的思路这个解释的比较清楚，但是双指针的实现太难记忆  https://discuss.leetcode.com/topic/36577/java-6ms-topological-sort-solution-with-explanation
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adjLists = new ArrayList<Set<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjLists.add(new HashSet<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {  
            for (int x : adjLists.get(i)) {  
                indegrees[x]++;  
            }  
        }  
          
        Queue<Integer> queue = new LinkedList<Integer>();  
        for (int i = 0; i < numCourses; i++) {  
            if (indegrees[i] == 0) {  
                queue.offer(i);  
            }  
        }  
          
        int[] res = new int[numCourses];  
        int count = 0;  
        while (!queue.isEmpty()) {  
            int cur = queue.poll();  
            for (int x : adjLists.get(cur)) {  
                indegrees[x]--;  
                if (indegrees[x] == 0) {  
                    queue.offer(x);  
                }  
            }  
            res[count++] = cur;  
        }  
          
        if (count == numCourses) return res;  
        return new int[0];  
    }
}