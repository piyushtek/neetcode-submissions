class Solution {
    class Node{
        int x;
        int y;
        Node(int i,int j){
            x=i;
            y=j;
        }
        
    }
    public void islandsAndTreasure(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Queue<Node> q = new LinkedList<>();
    
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            if (grid[i][j] == 0)
                q.add(new Node(i, j));
    
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    while (!q.isEmpty()) {
        Node node = q.poll();
        for (int d = 0; d < 4; d++) {
            int nx = node.x + dx[d], ny = node.y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == Integer.MAX_VALUE) {
                grid[nx][ny] = grid[node.x][node.y] + 1;
                q.add(new Node(nx, ny));
            }
        }
    }
}
}
