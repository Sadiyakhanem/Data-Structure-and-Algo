class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
      int high = s.length()-1;
       return func(s,0,high);
    
        
    }
        boolean func(String s, int low,int high)
        {
            if(low>=high)
            {
                return true;

            }

            if(s.charAt(low)!=s.charAt(high))
            {
                return false;
            }
        //    int len = high-low+1;
        //     if(len==0 || len ==1)
        //     {
        //         return true;
        //     }
            return func(s,low+1,high-1);

        }
}