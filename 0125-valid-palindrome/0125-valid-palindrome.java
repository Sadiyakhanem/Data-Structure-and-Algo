class Solution {
    public boolean isPalindrome(String s) {
        int low =0;
        int high = s.length()-1;
        while(low<=high)
        {
            char chlow = s.charAt(low);
            char chhigh=s.charAt(high);
            if (!Character.isLetterOrDigit(chlow)) 
            {
                low++;
                continue;
            }
            if (!Character.isLetterOrDigit(chhigh)) 
            {
                high--;
                continue;
            }
             
          char lowerchar = Character.toLowerCase(chlow);
char highchar = Character.toLowerCase(chhigh);
          
            if(lowerchar!=highchar )
            {
                return false;
            }
            if(lowerchar==highchar )
            {
                low++;
                high--;
                
            }
            
        }
        return true;
        
    }
}