class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high =0;
        int res =0;
        for(int i =0;i<nums.length;i++)
        {
            low =Math.max(low, nums[i]);
            high +=nums[i];
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            boolean check =func(nums,k,mid);
            if(check)
            {
                res = mid;
                high =mid-1;

            }
            else
            {
                low =mid+1;
            }
        }
        return res;

        
    }
    public boolean func(int[] nums, int k, int mid)
    {
        int subarr=1;
        int sum=0;
        for(int i =0;i<nums.length;i++)
        {
            if(sum+nums[i]<=mid)
            {
                sum+=nums[i];
            }
            else
            {
                subarr++;
                sum =nums[i];
                if(subarr>k)
                {
                    return false;
                }
            }
        }
        return true;
    }
}