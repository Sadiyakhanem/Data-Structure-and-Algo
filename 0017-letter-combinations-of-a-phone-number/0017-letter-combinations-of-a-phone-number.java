class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        String[] map =
        {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };
        int n = digits.length();
        if(n==0)
        {
            return res;
        }
        StringBuilder diary = new StringBuilder();
        fun(digits,n,0,diary,res,map);
        return res;


        
        
    }
    void fun(String digits,  int n ,int idx, StringBuilder diary, ArrayList res,String[] map )
    {
        if(idx==n)
        {
            res.add(diary.toString());
            return;

        }
        String letters = map[digits.charAt(idx)-'0'];
        for(int i =0;i<letters.length();i++)
        {
            char ch = letters.charAt(i);
            diary.append(ch);
            fun(digits, n, idx+1, diary, res,map);
            diary.deleteCharAt(diary.length() - 1); 
        }


    }
}