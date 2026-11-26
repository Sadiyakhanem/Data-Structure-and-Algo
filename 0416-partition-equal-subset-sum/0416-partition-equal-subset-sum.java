class Solution {
    public boolean canPartition(int[] nums) {
      int sum=0;
      for(int i=0;i<nums.length;i++)
      {
        sum+=nums[i];
      }
      int newsum=sum/2;
      if(sum%2!=0)
      {
        return false;
      }
      int n =nums.length;
      int [][] dp = new int[n+1][newsum+1];
      for(int i=0;i<=newsum;i++)
      {
        dp[n][i]=0;
      }
      dp[n][0]=1;

      for(int i=n-1;i>=0;i--)
      {
        for(int j=0;j<=newsum;j++)
        {
            //not take
         dp[i][j]=dp[i+1][j];
            //take
            if(j>=nums[i])
            {
              dp[i][j]=(dp[i+1][j-nums[i]] ==1 || dp[i+1][j]==1)?1:0;
            }
            

        }
      }
      return dp[0][newsum]==1;

        
    }
}