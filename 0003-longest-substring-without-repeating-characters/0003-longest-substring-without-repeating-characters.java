class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        int res=0;
        for(int high=0;high<s.length();high++)
        {
            char ch =s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()<high-low+1)
            {
                char leftch = s.charAt(low);
                map.put(leftch,map.get(leftch)-1);
                if(map.get(leftch)==0)
                {
                    map.remove(leftch);
                }
                low++;

            }
           
            int len =high-low+1;
            res =Math.max(res,len);
           

            
        }
   return res;
        
    }
}