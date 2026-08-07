class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        int open =0;
        int close =0;
     func(open,close,n,temp,ans);
       return ans; 
    }
    public void func(int open,int close,int n,StringBuilder temp, ArrayList ans)
    {
       
        if(open==n && close==n)
        {
             ans.add(temp.toString());
             return;
        }
        // openings
        if(open<n)
        {
            temp.append('(');
            func(open+1,close,n,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
        //closes
        if(close<open)
        {
            temp.append(')');
            func(open,close+1,n,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
     

    }
}