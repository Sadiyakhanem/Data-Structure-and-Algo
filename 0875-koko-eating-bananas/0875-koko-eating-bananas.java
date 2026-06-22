class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int res=-1;
         int high = Arrays.stream(piles).max().getAsInt();
         while(low<=high)
         {
            int guess = low+(high-low)/2;
           long hours=hours(guess,piles);
            if(hours>h)
            {
                low=guess+1;
            }
            else
            {
                res=guess;
                high =guess-1;
                
            }

         }
         return res;
      

        
    }
    public long hours(int speed,int[] piles)
    {
        long hours =0;
        for(int i=0;i<piles.length;i++)
        {
            hours=hours+piles[i]/speed;
            if(piles[i] %speed !=0)
            {
                hours++;
            }
        }
        return hours;
            
    }
}