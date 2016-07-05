public class Solution {
    
    private int[] dx = new int[]{-1,0,0,1};
    private int[] dy = new int[]{0,1,-1,0};
    public int shortestDistance(int[][] grid) {
        //BFS 应该从1开始，每一个1都辐射一遍所有能走到的0。 
        if (grid == null || grid[0].length == 0) return 0;
        final int[] shift = new int[] {0, 1, 0, -1, 0};
        
        int row  = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    Queue<Integer> myQueue = new LinkedList<Integer>();
                    myQueue.offer(i * col + j);
                    bfs(myQueue, grid, row, col, distance, reach);
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
    
    public void bfs(Queue<Integer> myQueue, int[][] grid, int row, int col, int[][] distance, int[][] reach) {
        boolean[][] isVisited = new boolean[row][col];
        int level = 1;
        
        while (!myQueue.isEmpty()) {
            int qSize = myQueue.size();
            for (int q = 0; q < qSize; q++) {
                int index = myQueue.poll();
                int x = index / col;
                int y = index % col;
                for (int k = 0; k < dx.length; k++) {
                    int nextRow = x + dx[k];
                    int nextCol = y + dy[k];
                    
                    if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
                        && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
                            //The shortest distance from [nextRow][nextCol] to thic building
                            // is 'level'.
                            distance[nextRow][nextCol] += level;
                            reach[nextRow][nextCol]++;
                            
                            isVisited[nextRow][nextCol] = true;
                            myQueue.offer(nextRow * col + nextCol);
                        }
                }
            }
            level++;
        }
    }
}