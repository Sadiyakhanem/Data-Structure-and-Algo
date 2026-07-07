class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high =0;
        int res =0;

        for(int i=0;i<weights.length;i++)
        {
         low =Math.max(low, weights[i]);
         high+=weights[i];
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
          boolean check=  func(weights,days,mid);
          if(check==true)
          {
            res=mid;
            high =mid-1;

          }
          else
          {
            low =mid+1;
          }

        }
        return res;
    }
    public boolean func(int [] weights, int days, int mid)
    {
        int weght =0;
        int din=1;
        for(int i=0;i<weights.length;i++)
        {
            if(weght+weights[i]<=mid)
            {
             weght+=weights[i];

            }
            else
            {
                din++;
                weght =weights[i];
                if(din>days)
                {
                    return false;
                }
            }
        }
        return true;
    }
}