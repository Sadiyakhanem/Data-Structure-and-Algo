class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int col = matrix[0].length;
        int high =matrix.length-1;
        int res =-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(matrix[mid][0]==target)
            {
                return true;

            }
            else if(matrix[mid][0]<target)
            {
                res = mid;
                low =mid+1;;
            }
            else
            {
                high = mid-1;

            }

        }
if (res == -1)
    return false;


       
       int low1=0;
       int high1 =col-1;
       while(low1<=high1)
       {
        int mid1 = low1+(high1-low1)/2;
        if(matrix[res][mid1]==target)
        {
            return true;
        }
        else if (matrix[res][mid1]<target)
        {
            low1 =mid1+1;
        }
        else
        {
            high1 = mid1-1;
        }
        
       }
       return false;
        
    }
}