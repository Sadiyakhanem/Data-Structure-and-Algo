class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> dp = new HashMap<>();
        return solve(0,n,dp);
    }
    public int solve(int i,int n, HashMap<Integer,Integer> dp)
    {
        if(i==n)
        {
            return 1;
        }
        if(i>n)
        {
            return 0;

        }
        if(dp.containsKey(i))
        {
            return dp.get(i);
        }
        int a1= solve(i+1,n,dp);
        int a2 =solve(i+2,n,dp);
        int ans = a1+a2;
        dp.put(i,ans);
        return ans;

    }
}