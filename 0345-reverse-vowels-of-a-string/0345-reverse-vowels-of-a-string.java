class Solution {
    public String reverseVowels(String s) {
        int low=0;
        int high =s.length()-1;
        char[] arr=s.toCharArray();
        
        while(low<=high)
        {
            
           if(isVowel(arr[low]) &&isVowel(arr[high]))
            {
               
                char temp = arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
                low++;
                high--;

            }
            else if(!isVowel(arr[low]))
            {
                low++;
                continue;
            }

            else
            // (!isVowel(arr[high]))
            {
                high--;
                continue;

            }
           




        }
        return new String(arr);
        
    }
     private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}