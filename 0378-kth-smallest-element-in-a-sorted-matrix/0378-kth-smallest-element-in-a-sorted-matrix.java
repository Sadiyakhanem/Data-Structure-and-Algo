class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length-1;
        int m = matrix[0].length-1;
        int res =-1;



        int low =matrix[0][0];
        int high = matrix[n][m];
        while(low<=high)
        {
            int mid= low+(high -low)/2;
            int count=func(matrix , mid);
            if( count >=k)
          
            {
                res = mid;
                high = mid-1;

            }
            else
            {
                low = mid+1;

            }
        }
        return res;

        
    }

    public int func( int [][]matrix, int mid)
    {
        int n= matrix.length-1;
        int m = matrix[0].length-1;
        int row = n;
        int col = 0;
        int count =0;
        while(row>=0 && col <=m)
        {
            if(matrix[row][col]<= mid)
            {
                count+=row+1;
                col++;
            }
            else
            {
                row--;
            }

        }
        return count;

    }
}