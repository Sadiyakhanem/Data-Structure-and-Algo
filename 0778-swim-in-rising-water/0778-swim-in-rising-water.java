class Solution {
    class pair
    {
        int money;
        int first;
        int second;
        pair(int money,int first,int second)
        {
            this.money=money;
            this.first=first;
            this.second=second;
        }
        
    }
    int[] x={-1,1,0,0};
    int[] y ={0,0,-1,1};
    
    public int swimInWater(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        PriorityQueue<pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.money,b.money));
       
        int[][] res = new int[n][m];
        for(int[] row: res)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        pq.offer(new pair(grid[0][0],0,0));
        res[0][0]=grid[0][0];
        while(!pq.isEmpty())
        {
            pair curr = pq.poll();
            int money = curr.money;
            int first=curr.first;
            int second=curr.second;
            if(money>res[first][second])
            {
                continue;
            }
            for(int k=0;k<4;k++)
            {
                int r =first+x[k];
                int c =second+y[k];
                if(!valid(r,c,n,m))
                continue;
                int newmoney= Math.max(money,grid[r][c]);
                if(newmoney<res[r][c])
                {
                    res[r][c]=newmoney;
                    pq.offer(new pair(newmoney,r,c));
                }
            }
        }
        return res[n-1][m-1];







        
        
    }
    public boolean valid(int i, int j,int n,int m)
    {
        if(i<0|| i>=n || j<0||j>=m )
        {
            return false;
        }
        return true;
    }
}