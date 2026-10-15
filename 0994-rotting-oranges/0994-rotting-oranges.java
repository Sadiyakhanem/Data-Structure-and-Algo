class Solution {
      int[] x ={-1,1,0,0};
    int[] y ={0,0,-1,1};
    boolean valid(int i,int j,int n, int m)
    {
        if(i <0|| i >= n || j <0 || j >= m)
        {
            return false;
        }
        return true;
    }
    class pair{
        int first;
        int sec;
        pair(int first,int sec)
        {
            this.first=first;
            this.sec=sec;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        Queue<pair> q = new LinkedList<>();
        if(grid==null || grid.length==0)
        {
            return 0;

        }
        int n = grid.length;
        int m =grid[0].length;
        int fresh=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer( new pair(i,j));
                    grid[i][j]=-2;
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
                else{

                }
            }
        }
        int time=0;
        while(!q.isEmpty() && fresh>0)
        {
         time++;
            int size = q.size();
            while(size>0)
            {
                pair node= q.poll();
                int i =node.first;
                int j =node.sec;
                for(int k=0;k<4 ;k++)
                {
                    int row = i+x[k];
                    int col =j+y[k];
                    if(valid(row,col,n,m) && grid[row][col]==1)
                    {
                        q.offer(new pair(row,col));
                        grid[row][col]=-2;
                        fresh--;
                    }
                }
                size--;
            }

        }
        if(fresh>0)
        {
            return -1;
        }
        else
        {
            return time;
        }

    }
}