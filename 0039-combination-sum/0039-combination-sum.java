class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
      int n = candidates.length;
      int sum=0;
       
      ArrayList< Integer >diary = new ArrayList<>();
      ArrayList< List<Integer>> res = new ArrayList<>();
      func(candidates, n,target, 0, diary, sum, res);
      return res;
    }
    void func(int[] candidates,int n, int target, int idx, ArrayList diary, int sum,ArrayList<List<Integer>>res)
    {
        if(idx==n)
        {
            if(sum==target)
            {
                res.add(new ArrayList<>(diary));
                
            }
            return;
            
        }
            // nhi lena hai
            func(candidates,n,target, idx+1, diary, sum, res);
            // lena hai
            if(candidates[idx]+sum<=target)
            {
                diary.add(candidates[idx]);
                sum=sum+candidates[idx];
            func(candidates,n, target, idx, diary, sum, res);
            diary.remove(diary.size()-1);
            sum=sum-candidates[idx];

            }
            return;
    }
}