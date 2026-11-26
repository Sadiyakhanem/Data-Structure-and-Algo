class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }

        if(Math.abs(target)>sum)
        {
          return 0;  
        }
        if((target+sum)%2!=0)
        {
            return 0;
        }
        int n =nums.length;
        int newsum = (target+sum)/2;
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
                    dp[i][j]+=dp[i+1][j-nums[i]];
                }
            }
        }
        return dp[0][newsum];
        
    }
}