class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public void bfs(int ro,int co,int[][] visited,char[][] grid){
        visited[ro][co]=1;
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(ro,co));
        int m=grid.length;
        int n=grid[0].length;

        while(!q.isEmpty()){
            Pair val=q.poll();
            int row=val.first;
            int col=val.second;
            int[] drow={-1,0,1,0};
            int[] dcol={0,1,0,-1};
            for(int i=0;i<4;i++){
                    int nrow=row+drow[i];
                    int ncol=col+dcol[i];

                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                        visited[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        int count=0;

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(visited[row][col]==0 && grid[row][col]=='1'){
                    count++;
                    bfs(row,col,visited,grid);
                }
            }
        }
        return count;
    }
}