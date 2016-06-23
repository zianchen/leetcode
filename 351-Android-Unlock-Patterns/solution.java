public class Solution {

    private boolean[] visited = new boolean[10];
    private int[][] skip = new int[10][10];
    
    public int numberOfPatterns(int m, int n) {
        // sannity check
        if (m > n || n == 0) {
            return 0;
        }
        
        int ret = 0;
        
        // how to deal with the line connecting two consecutive keys in the pattern passes through any other keys? use skip array.
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = 5;
        skip[2][8] = skip[8][2] = 5;
        skip[3][7] = skip[7][3] = 5;
        skip[4][6] = skip[6][4] = 5;
        
        // divide solution space by len of pattern, for loop len i from m to n and generate solution for each len i
        for (int i = m; i <= n; i++) {
            ret += dfs(1, i-1) * 4;
            ret += dfs(2, i-1) * 4;
            ret += dfs(5, i-1);
        }
        return ret;
    }
    
    // backtracking dfs
    public int dfs(int cur, int remain) {
        // termination condition
        if (remain == 0) {
            return 1;
        }
        
        int sum = 0;
        visited[cur] = true; 
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
                sum += dfs(i, remain - 1);        
            }
        }
        // backtracking
        visited[cur] = false;
        return sum;
    }
}