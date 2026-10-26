class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<m;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(board,n,m,0,i);
            }
        }
          for(int i=0;i<m;i++)
        {
            if(board[n-1][i]=='O')
            {
                dfs(board,n,m,n-1,i);
            }
        }
   
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(board,n,m,i,0);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(board[i][m-1]=='O')
            {
                dfs(board,n,m,i,m-1);

            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='#')
                {
                    board[i][j]='O';
                }
                   else if(board[i][j]=='O')
                     board[i][j]='X';
            }
        }

        
    }
    public  boolean valid(int n, int m, int i, int j)
    {
        if(i<0 || i>= n || j<0 || j >=m)
        {
            return false;
        }
        return true;

    }
    int x[]={-1,1,0,0};
    int y[] ={0,0,-1,1};
    
    public void dfs(char[][] board, int n, int m, int i, int j)
    {
       board[i][j]='#';
        for(int k =0;k<4;k++)
        {
            int row = i+x[k];
            int col = j+y[k];
            if(valid(n,m,row,col) && board[row][col]=='O')
            {
                dfs(board,n,m,row,col);
            }
        }
    
    }
}