class Solution {
    public int rob(int[] nums) {
        HashMap<String,Integer> dp = new HashMap<>();
       return func(nums,0,dp,1);

    }
    public int func(int[] nums, int i, HashMap<String,Integer>dp,int free)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        String key = i+","+free;
        if(dp.containsKey(key))
        {
            return dp.get(key);
        }
        int a=0,b=0;


        if(free==1)
        {
           a=  nums[i] +func(nums,i+1,dp,0);//rob
           b = func(nums,i+1,dp,1);//skip

        }
        else
        {
            //cant rob skip
             a = func(nums,i+1,dp,1);

        }
       int ans= Math.max(a,b);
       dp.put(key,ans);
       return ans;

    


    }
}